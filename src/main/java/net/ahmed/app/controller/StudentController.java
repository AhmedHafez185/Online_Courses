/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import net.ahmed.app.bll.service.LookupsService;
import net.ahmed.app.bll.service.StudentService;
import net.ahmed.app.bll.service.UserService;
import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.entity.InstructorField;
import net.ahmed.app.dal.entity.Student;
import net.ahmed.app.dal.entity.User;
import net.ahmed.app.utils.UploadUtils;
import net.ahmed.app.validator.studentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
    @ModelAttribute
    public void commonData(Model model) {
        ArrayList<String> genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        model.addAttribute("genderList", genderList);
        try {
            List<Category> categories = lookupsService.findAllCategory();
            model.addAttribute("categories", categories);

        } catch (Exception e) {
            
        }

    }
    @GetMapping("/student-profile")
    public String showProfile() {
        return "student-profile";
    }
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("student", new Student());
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
}
