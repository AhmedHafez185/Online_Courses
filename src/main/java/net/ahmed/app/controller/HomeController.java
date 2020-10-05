/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.ahmed.app.bll.service.CourseService;
import net.ahmed.app.bll.service.LookupsService;
import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.entity.Content;
import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.dal.entity.CourseOutlines;
import net.ahmed.app.dal.repository.impl.CourseRepo;
import net.ahmed.app.utils.UploadUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Ahmed Hafez
 */
@Controller
public class HomeController {
    
    @Autowired
    LookupsService categoryService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CourseService courseService;
    @GetMapping
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        
        return "index";
    }
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect() {
        
        return "redirect";
    }
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String showCourses(@RequestParam("cat_id") String catId) {
        Integer id = Integer.parseInt(catId);
        return "courses";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchForCourses(@RequestParam("q") String name) {
        String message = "";
        Integer test = 0;
        ModelAndView mav = new ModelAndView("search");
        if(name != null && !name.isEmpty()) {
             try {
                List<Course> courses = courseService.getCoursesByName(name.toLowerCase());
                mav.addObject("courses",courses);
                mav.addObject("coursePeriod",coursePeriod(courses));
                message = (courses.size() > 0)?  "Number of Results is "+courses.size() :  "Not Result Matches \""+name+"\"";
                mav.addObject("message",message);
                mav.addObject("test",test);
                return mav;
            } catch (Exception ex) {
                mav.addObject("message","Errors : "+ex.getMessage());
                mav.addObject("courses",new ArrayList<>());
                mav.addObject("test",test);
                return mav;
            }
        } else {
            test = 1;
             message="No Words Enters , Please Put it";
             mav.addObject("message",message);
             mav.addObject("test",test);
             return mav;
        }
        
    }
    @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
    public String aboutUs() {
        return "about-us";
    }
    @RequestMapping(value = "/contactUs", method = RequestMethod.GET)
    public String contactUs() {
        return "contact-us";
    }
    @ModelAttribute
    public void getCategoroies(Model model) {
        try {
            List<Category> categories = categoryService.findAllCategory();
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("categories",categories);
            model.addAttribute("courses",courses);
            model.addAttribute("categoryPrograms", categoryPrograms(categories));
            model.addAttribute("courseDuration",coursePeriod(courses));
            
        } catch (Exception ex) {
        }
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {    	
        return "login";
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String authError() {    	
        return "error/403";
    }
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String notFound() {    	
        return "error/404";
    }
    @RequestMapping(value = "/400", method = RequestMethod.GET)
    public String recordNotFound() { 
        return "error/400";
    }
   
   @GetMapping("/studnetProfile")
   public String studentProfile() {
	   return "student-profile";
   }
    private HashMap<Integer,Integer> categoryPrograms(List<Category> categories){
        HashMap<Integer,Integer> programs = new HashMap<>();
        for(Category category : categories){
          int nums =0;
          for(Course course : category.getCourses()){
              nums++;
          }
          programs.put(category.getId(), nums);
        }
        return programs;
    }
    private HashMap<Integer,String> coursePeriod(List<Course> courses){
        HashMap<Integer,String> courseDuration = new HashMap<>();
        for(Course course : courses){
          int nums =0;
          for(CourseOutlines outline : course.getOutlines()){
              for(Content content : outline.getContents()){
                nums+=content.getPeriod();
              }
          }
          courseDuration.put(course.getId(), convertSeconds(nums));
        }
        return courseDuration;
    }
     public String convertSeconds(Integer seconds){
        int hours = seconds / 3600; 
        int minutes = (seconds - hours * 3600)/60;
        
         return hours+"h "+minutes+"min";
    }
   
}
