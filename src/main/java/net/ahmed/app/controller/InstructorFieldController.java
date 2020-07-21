/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import net.ahmed.app.bll.service.impl.LookupsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Ahmed Hafez
 */
@Controller
public class InstructorFieldController {
    @Autowired
    LookupsServiceImpl instructorFieldService; 
}
