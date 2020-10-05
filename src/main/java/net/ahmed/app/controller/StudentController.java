/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import net.ahmed.app.bll.service.CourseService;
import net.ahmed.app.bll.service.EnrollmentService;
import net.ahmed.app.bll.service.LookupsService;
import net.ahmed.app.bll.service.StudentService;
import net.ahmed.app.bll.service.UserService;
import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.dal.entity.Enrollment;
import net.ahmed.app.dal.entity.Instructor;
import net.ahmed.app.dal.entity.InstructorField;
import net.ahmed.app.dal.entity.Student;
import net.ahmed.app.dal.entity.User;
import net.ahmed.app.security.AppUserDetails;
import net.ahmed.app.utils.UploadUtils;
import net.ahmed.app.validator.studentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ahmed Hafez
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    LookupsService lookupsService;
    @Autowired
    StudentService studentService;
    @Autowired
    ServletContext servletContext;
    @Autowired
    studentValidator studentValidator;
    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;
    @Autowired
    EnrollmentService enrollmentService;
    
    
    @ModelAttribute
    public void commonData(Model model) {
       
        try {
            List<Category> categories = lookupsService.findAllCategory();
            model.addAttribute("categories", categories);

        } catch (Exception e) {
            List<Category> categories = null;
        }

    }
    
    @GetMapping("/student-profile")
    public ModelAndView showProfile(Model model) {
        ModelAndView mav = new ModelAndView();
        AppUserDetails principal = (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principal.getUser();
        if ("Student".equals(user.getUserType())) {
            mav.addObject("user", user);
            mav.addObject("student", getStudent(user.getUserId()));
            List<Enrollment> cardEnrollment = new ArrayList<>();
            List<Enrollment> buyedEnrollment = new ArrayList<>();
            for(Enrollment enroll : getStudent(user.getUserId()).getEnrollments()){
                
                if("CARD".equals(enroll.getStatus())){
                    cardEnrollment.add(enroll);
                }else if ("ENROLL".equals(enroll.getStatus())){
                    buyedEnrollment.add(enroll);
                }
            }
            mav.addObject("cardEnrollment", cardEnrollment);
            mav.addObject("buyedEnrollment", buyedEnrollment);
            mav.setViewName("student-profile");
        } else {
            mav.setViewName("403");
        }

        return mav;
    }
     @GetMapping("/deleteCardItem/{id}")
      public String deleteCardItem(@PathVariable("id") Integer id) {
        try {
            enrollmentService.removeEnrollment(id);
            return "redirect:/student/student-profile";
        } catch (Exception ex) {
            return "redirect:/student/student-profile";
        }
      }

    

    @GetMapping("/register")
    public String registerPage(Model model) {
        ArrayList<String> genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        model.addAttribute("student", new Student());
        model.addAttribute("genderList",genderList);
        return "register";
    }

    @PostMapping("registerProcess")
    public String registerProcess(@ModelAttribute("student") Student student, BindingResult result) {
        studentValidator.validate(student, result);
        UploadUtils uploadUtils = new UploadUtils(servletContext.getRealPath("/"));
        if (result.hasErrors()) {
            return "register";
        } else {

            MultipartFile multipartImage = student.getProfileImage();

            if (multipartImage != null || !multipartImage.isEmpty()) {
                try {
                    uploadUtils.uploadFile("images\\users", multipartImage);
                    student.setPhoto(multipartImage.getOriginalFilename());
                    studentService.addStudent(student);
                    User user = new User();
                    user.setEmail(student.getEmail());
                    user.setPassword(student.getPassword());
                    user.setUserType("Student");
                    user.setUserId(student.getId());
                    user.setFullName(student.getFirstName() + " " + student.getLastName());
                    user.setPicture(multipartImage.getOriginalFilename());
                    userService.addUser(user);
                    return "login";
                } catch (Exception e) {
                    result.rejectValue("photo", e.getMessage());
                    return "register";
                }
            }
            result.rejectValue("profileImage", "Errors !!!");
            return "register";
        }
    }

    private Student getStudent(Integer id) {
        try {
            return studentService.getStudent(id);
        } catch (Exception ex) {
            return new Student();
        }
    }

}
