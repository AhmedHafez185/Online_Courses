/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ahmed Hafez
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @GetMapping("/student-profile")
    public String showProfile() {
        return "student-profile";
    }

}
