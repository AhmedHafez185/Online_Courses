/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Ahmed Hafez
 */
@Controller
public class HomeController {
  

@GetMapping
   public static String home(){
       return "index";
   }
  @RequestMapping(value = "/index", method = RequestMethod.GET)
   public String index() {
      return "index";
   }
}
