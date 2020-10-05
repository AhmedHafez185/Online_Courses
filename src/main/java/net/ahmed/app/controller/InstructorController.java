package net.ahmed.app.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import net.ahmed.app.bll.service.InstructorService;
import net.ahmed.app.bll.service.LookupsService;
import net.ahmed.app.bll.service.UserService;
import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.dal.entity.Enrollment;
import net.ahmed.app.dal.entity.Instructor;
import net.ahmed.app.dal.entity.InstructorField;
import net.ahmed.app.dal.entity.User;
import net.ahmed.app.security.AppUserDetails;
import net.ahmed.app.utils.UploadUtils;
import net.ahmed.app.validator.InstructorValidator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/instructor")
public class InstructorController {

    @Autowired
    LookupsService lookupsService;
    @Autowired
    InstructorService instructorService;
    @Autowired
    InstructorValidator instructorValidator;
    @Autowired
    UserService userService;
    @Autowired
    ServletContext servletContext;

    @GetMapping("/register")
    public String registerPage(Model model) {
        try {
            model.addAttribute("instructor", new Instructor());
            return "instructor_register";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            model.addAttribute("errors", "Error : " + e.getMessage());
            return "instructor_register";
        }

    }

    @ModelAttribute
    public void commonData(Model model) {
        ArrayList<String> genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        model.addAttribute("genderList", genderList);
        try {
            List<InstructorField> instructorsFields = lookupsService.findAllInstructorField();
            List<Category> categories = lookupsService.findAllCategory();
            model.addAttribute("instrFields", instructorsFields);
            model.addAttribute("categories", categories);

        } catch (Exception e) {
            List<InstructorField> instructorsFields = null;
        }

    }

    public InstructorField populateInstructorField(InstructorField instructorField) throws Exception {
        Integer fieldId = Integer.parseInt(instructorField.getName().trim());
        for (InstructorField instField : lookupsService.findAllInstructorField()) {
            if (instField.getId() == fieldId) {
                return instField;
            }
        }
        return null;
    }

    @SuppressWarnings("null")
    @PostMapping("/registerProcess")
    public String registerProcess(@ModelAttribute("instructor") Instructor instructor, BindingResult result) {
        instructorValidator.validate(instructor, result);
        UploadUtils uploadUtils = new UploadUtils(servletContext.getRealPath("/"));
        if (result.hasErrors()) {
            return "instructor_register";
        } else {
            
            MultipartFile multipartImage = instructor.getProfileImage();
            MultipartFile multipartCVFile = instructor.getUserCV();
            
            if (multipartImage != null || !multipartImage.isEmpty() || multipartCVFile != null || !multipartCVFile.isEmpty()) {
                try {
                    
                    uploadUtils.uploadFile("images\\users", multipartImage);
                    uploadUtils.uploadFile("cv_file", multipartCVFile);
                    
                    InstructorField instrField = populateInstructorField(instructor.getInstructorField());
                    instructor.setInstructorField(instrField);
                    instructor.setPhoto(multipartImage.getOriginalFilename());
                    instructor.setCvFile(multipartCVFile.getOriginalFilename());
                    
                    instructorService.addInstructor(instructor);
                    User user = new User();
                    user.setEmail(instructor.getEmail());
                    user.setPassword(instructor.getPassword());
                    user.setUserType("Instructor");
                    user.setFullName(instructor.getFirstName()+" "+instructor.getLastName());
                    user.setPicture(multipartImage.getOriginalFilename());
                    user.setUserId(instructor.getId());
                    userService.addUser(user);
                    return "login";
                } catch (Exception e) {
                    result.rejectValue("photo", e.getMessage());
                    return "instructor_register";
                }
            }
            result.rejectValue("profileImage", "Errors !!!");
            return "instructor_register";
        }

    }

    @GetMapping("/myProfile")
    public ModelAndView showProfile(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("teacher-profile");
        AppUserDetails principal = (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principal.getUser();
        mav.addObject("user", user);
        mav.addObject("instructor", getInstructor(user.getUserId()));
        Instructor inst = getInstructor(user.getUserId());
        Integer noOfCourses = 0;
        Integer noOfStudents = 0;
        for(Course course:inst.getCourses()){
            noOfCourses++;
            for(Enrollment student : course.getEnrollments()){
                noOfStudents++;
            }
            
        }
        mav.addObject("noOfCourses", noOfCourses);
        mav.addObject("noOfStudents", noOfStudents);
        
        return mav;

    }

    private Instructor getInstructor(Integer id) {
        try {
            Instructor instructor = instructorService.getInstructor(id);
            return instructor;
        } catch (Exception ex) {
            return null;
        }
    }

}
