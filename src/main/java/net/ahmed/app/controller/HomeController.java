/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ahmed.app.bll.service.LookupsService;
import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.entity.Instructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @GetMapping
    public ModelAndView home() {
        List<Category> categories = getCategoroies();
        ModelAndView model = new ModelAndView("index");
        model.addObject("categories", categories);
        return model;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        List<Category> categories = getCategoroies();
        ModelAndView model = new ModelAndView("index");
        model.addObject("categories", categories);
        return model;
    }

    public List<Category> getCategoroies() {
        try {
            List<Category> categoroies = categoryService.findAllCategory();
            return categoroies;
        } catch (Exception ex) {

            return null;
        }
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {    	
       System.out.println("Passwod : "+passwordEncoder.encode("admin"));
        return "login";
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String authError() {    	
        return "error/403";
    }
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String NotFoundPageError() {    	
        return "error/404";
    }
}
