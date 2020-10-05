/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ahmed.app.bll.service.CourseService;
import net.ahmed.app.bll.service.EnrollmentService;
import net.ahmed.app.bll.service.ReviewService;
import net.ahmed.app.bll.service.StudentService;
import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.dal.entity.Enrollment;
import net.ahmed.app.dal.entity.Review;
import net.ahmed.app.dal.entity.Student;
import net.ahmed.app.dal.entity.User;
import net.ahmed.app.security.AppUserDetails;
import net.ahmed.app.utils.MessageNotification;
import net.ahmed.app.utils.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    EnrollmentService enrollmentService;

    @RequestMapping(value = "addNewComment", method = RequestMethod.POST)
    public @ResponseBody
    ReviewResponse add(@RequestParam(value = "comment", required = true) String comment,
            @RequestParam(value = "courseId", required = true) Integer courseId, ModelMap model) {
        Review review = new Review();
        review.setDate(new Date());
        review.setComment(comment);
        review.setRate(0);
        ReviewResponse response = new ReviewResponse();
        try {
            Student student = getStudent();
            review.setCourse(courseService.getCourse(courseId));
            review.setStudent(student);
            response.setStudentName(student.getFirstName() + " " + student.getLastName());
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

    @RequestMapping(value = "deleteCardItem/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    MessageNotification add(@PathVariable(value = "id", required = true) Integer id, ModelMap model) {
        MessageNotification messageNotification = new MessageNotification();
        try {
            if (!Objects.equals(getStudent().getId(), enrollmentService.getEnrollment(id).getStudent().getId())) {
                messageNotification.setMessage("Oops");
                messageNotification.setMessageTitle("You Don't have the permission to delete");
                messageNotification.setMessageType("error");
                return messageNotification;
            }
            enrollmentService.removeEnrollment(id);
            messageNotification.setMessage("Successfully");
            messageNotification.setMessageTitle("Course Deleted");
            messageNotification.setMessageType("success");
        } catch (Exception ex) {
            messageNotification.setMessage("Error");
            messageNotification.setMessageTitle("Course Deleted");
            messageNotification.setMessageType("error");
        }
        return messageNotification;
    }

    @RequestMapping(value = "addToCard", method = RequestMethod.POST)
    public @ResponseBody
    MessageNotification addToCard(@RequestParam(value = "courseId", required = true) Integer courseId, ModelMap model) {
        String Status = "CARD";
        MessageNotification messageNotification = new MessageNotification();
        AppUserDetails principal = (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principal.getUser();
        if (user != null) {
            if (!"Student".equals(user.getUserType())) {
                messageNotification.setMessage("Oops");
                messageNotification.setMessageTitle("You Don't have the permission to Add this to Cart");
                messageNotification.setMessageType("error");
                return messageNotification;
            }
        } else {
            System.out.println("need login");
            messageNotification.setMessage("Oops");
            messageNotification.setMessageTitle("You Must Login to Add this course to cart");
            messageNotification.setMessageType("error");
            return messageNotification;
        }

        try {
            Student student = studentService.getStudent(user.getUserId());
            Course course = courseService.getCourse(courseId);
            Enrollment enrollment = new Enrollment();
            if (enrollmentService.checkStudentCourseEnrollment(course, student)) {
                messageNotification.setMessage("Oops");
                messageNotification.setMessageTitle("This Course is actually Added to your Cart");
                messageNotification.setMessageType("error");
                return messageNotification;
            }
            enrollment.setCourse(course);
            enrollment.setStatus(Status);
            enrollment.setEnrollDate(new Date());
            enrollment.setStudent(student);
            enrollmentService.addEnrollment(enrollment);
            messageNotification.setMessage("Successfully");
            messageNotification.setMessageTitle("You Add this Course to  Cart");
            messageNotification.setMessageType("success");
            return messageNotification;
        } catch (Exception ex) {
            messageNotification.setMessage("Oops");
            messageNotification.setMessageTitle("You not Able to Add this Course to  Cart : " + ex.getMessage());
            messageNotification.setMessageType("error");
            return messageNotification;
        }
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
