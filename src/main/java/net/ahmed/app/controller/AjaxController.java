/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ahmed.app.bll.service.CourseService;
import net.ahmed.app.bll.service.ReviewService;
import net.ahmed.app.bll.service.StudentService;
import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.dal.entity.Review;
import net.ahmed.app.dal.entity.Student;
import net.ahmed.app.dal.entity.User;
import net.ahmed.app.security.AppUserDetails;
import net.ahmed.app.utils.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ahmed Hafez
 */
@Controller
@RequestMapping(value = "/ajaxController")
public class AjaxController {

    @Autowired
    ReviewService reviewService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "addNewComment", method = RequestMethod.POST)
    public @ResponseBody
    ReviewResponse add(@RequestParam(value = "comment", required = true) String comment,
            @RequestParam(value = "courseId", required = true) Integer courseId, ModelMap model){
        Review review = new Review();
        review.setDate(new Date());
        review.setComment(comment);
        review.setRate(0);
         ReviewResponse response = new ReviewResponse();
        try {
            Student student = getStudent();
            review.setCourse(courseService.getCourse(courseId));
            review.setStudent(student);
            response.setStudentName(student.getFirstName()+" "+student.getLastName());
            response.setPicture(student.getPhoto());
            reviewService.addReview(review);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        response.setComment(comment);
        response.setDate(review.getDate());
        response.setRate(0);        
        return response;
    }


    public Student getStudent() throws Exception {
        AppUserDetails principal = (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principal.getUser();
        return studentService.getStudent(user.getUserId());
    }

    public User getUser() throws Exception {
        AppUserDetails principal = (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principal.getUser();
        return user;
    }

}
