/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import net.ahmed.app.bll.service.CourseOutlineService;
import net.ahmed.app.bll.service.CourseService;
import net.ahmed.app.bll.service.InstructorService;
import net.ahmed.app.bll.service.LookupsService;
import net.ahmed.app.bll.service.impl.CourseOutlinesServiceImpl;
import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.dal.entity.CourseOutlines;
import net.ahmed.app.dal.entity.Instructor;
import net.ahmed.app.dal.entity.InstructorField;
import net.ahmed.app.dal.entity.User;
import net.ahmed.app.security.AppUserDetails;
import net.ahmed.app.utils.UploadUtils;
import net.ahmed.app.validator.CourseValidator;
import net.ahmed.app.validator.InstructorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ahmed Hafez
 */
@Controller
@RequestMapping(value = "/courses")
public class CoursesController {

    @Autowired
    LookupsService categoryService;
    @Autowired
    CourseService courseService;
    @Autowired
    InstructorService instructorService;
    @Autowired
    CourseValidator courseValidator;
    @Autowired
    ServletContext servletContext;
    @Autowired
    CourseOutlineService courseOutlineService;

    @GetMapping("/addCourse")
    public String addCoursePage(Model model) {
        Course course = new Course();
        model.addAttribute("course", new Course());
        return "add-course";
    }
    @ModelAttribute
    public void commonData(Model model) {
        try {
            
            List<Category> categories = categoryService.findAllCategory();
            model.addAttribute("categories", categories);
        } catch (Exception e) {
            List<InstructorField> instructorsFields = null;
        }

    }
    public Category populateCategory(Category category) throws Exception {
        Integer id = Integer.parseInt(category.getName().trim());
        return categoryService.getCategory(id);
    }
    public Instructor getInstructor() throws Exception{
        AppUserDetails principal = (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = principal.getUser();
            return instructorService.getInstructor(user.getUserId());
    } 
    @PostMapping("/saveCourse")
    public String saveCourseProcess(@ModelAttribute("course") Course course, BindingResult result) {
        courseValidator.validate(course, result);
        UploadUtils uploadUtils = new UploadUtils(servletContext.getRealPath("/"));
        if (result.hasErrors()) {
            return "add-course";
        } else {
            MultipartFile multipartImage = course.getCoursePic();
            try {
                uploadUtils.uploadFile("images\\courses", multipartImage);
                Category category = populateCategory(course.getCategory());
                course.setCategory(category);
                course.setPicture(multipartImage.getOriginalFilename());
                course.setInstructor(getInstructor());
                System.out.println("listOfOutlines : "+course.getListOfOutlines());
                String [] outlines = course.getListOfOutlines().split(",");
                Set<CourseOutlines> courseOutlines = new HashSet<>();  
                for(String outline : outlines){
                      CourseOutlines newOutlines = new CourseOutlines();
                      newOutlines.setOutline(outline);
                      newOutlines.setCourse(course);
                      courseOutlines.add(newOutlines);
                    System.out.println(outline);
                }
                course.setOutlines(courseOutlines);
                courseService.addCourse(course);
                return "redirect:/addLesson?course="+course;
            } catch (Exception ex) {
                result.reject("picture", "Error in Uploading Picture , "+ex.getMessage());
                return "add-course";
            }
        }
    }
    @GetMapping("addLesson")
    public String addLesson(@RequestParam("course") Course course){
        return "add-lesson";
    }
     @GetMapping("course-details")
     public ModelAndView coursePage(@RequestParam("courseId") Integer id) throws Exception{
         ModelAndView mav = new ModelAndView("course-details");
         mav.addObject(courseService.getCourse(id));
         return mav;
     }
    
}
