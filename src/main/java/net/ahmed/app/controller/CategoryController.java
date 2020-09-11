/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import java.util.List;
import net.ahmed.app.bll.service.LookupsService;
import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.entity.InstructorField;
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
     public ModelAndView coursePage(@RequestParam("cat_id") Integer id) throws Exception{
         ModelAndView mav = new ModelAndView("courses");
         mav.addObject("categoryDetails",categoryService.getCategory(id));
         return mav;
     }
     @ModelAttribute
    public void commonData(Model model) {
        try {
            
            List<Category> categories = categoryService.findAllCategory();
            model.addAttribute("categories", categories);
        } catch (Exception e) {
        }

    }
}
