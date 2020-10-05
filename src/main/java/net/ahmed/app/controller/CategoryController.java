/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import java.util.HashMap;
import java.util.List;
import net.ahmed.app.bll.service.LookupsService;
import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.entity.Content;
import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.dal.entity.CourseOutlines;
import net.ahmed.app.dal.entity.InstructorField;
import net.ahmed.app.utils.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ahmed Hafez
 */
@Controller
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    LookupsService categoryService;
    @GetMapping("category-details")
     public ModelAndView coursePage(@RequestParam(name = "cat_id",required = false) Integer id) throws RecordNotFoundException{
            if(id == null || id == 0) throw new RecordNotFoundException("Category Id is NULL");
         ModelAndView mav = new ModelAndView("courses");
         Category category = categoryService.getCategory(id);
         if(category == null) throw new RecordNotFoundException("Category is NULL");
         mav.addObject("categoryDetails",category);
         return mav;
         
     }
     @ModelAttribute
    public void commonData(Model model) {
        try {
            List<Category> categories = categoryService.findAllCategory();
            model.addAttribute("categories", categories);
            model.addAttribute("courseDuration", coursePeriod(categories));
        } catch (Exception e) {
        }

    }
    private HashMap<Integer,String> coursePeriod(List<Category> categories){
        HashMap<Integer,String> courseDuration = new HashMap<>();
        for(Category cat : categories){
        for(Course course : cat.getCourses()){
          int nums =0;
          for(CourseOutlines outline : course.getOutlines()){
              for(Content content : outline.getContents()){
                nums+=content.getPeriod();
              }
          }
          courseDuration.put(course.getId(), convertSeconds(nums));
         }
        }
        return courseDuration;
    }
     public String convertSeconds(Integer seconds){
        int hours = seconds / 3600; 
        int minutes = (seconds - hours * 3600)/60;
        
         return hours+"h "+minutes+"min";
    }
}
