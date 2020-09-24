/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import net.ahmed.app.bll.service.ContentService;
import net.ahmed.app.bll.service.CourseOutlineService;
import net.ahmed.app.bll.service.CourseService;
import net.ahmed.app.bll.service.InstructorService;
import net.ahmed.app.bll.service.LookupsService;
import net.ahmed.app.bll.service.ReviewService;
import net.ahmed.app.bll.service.impl.CourseOutlinesServiceImpl;
import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.entity.Content;
import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.dal.entity.CourseOutlines;
import net.ahmed.app.dal.entity.Instructor;
import net.ahmed.app.dal.entity.InstructorField;
import net.ahmed.app.dal.entity.Review;
import net.ahmed.app.dal.entity.User;
import net.ahmed.app.security.AppUserDetails;
import net.ahmed.app.utils.DateUtils;
import net.ahmed.app.utils.RecordNotFoundException;
import net.ahmed.app.utils.UploadUtils;
import net.ahmed.app.validator.ContentValidator;
import net.ahmed.app.validator.CourseValidator;
import net.ahmed.app.validator.InstructorValidator;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ahmed Hafez
 */
@Controller
@RequestMapping(value = "/courses")
public class CoursesController {

    @Autowired
    LookupsService categoryService;
    @Autowired
    CourseService courseService;
    @Autowired
    InstructorService instructorService;
    @Autowired
    CourseValidator courseValidator;
    @Autowired
    ServletContext servletContext;
    @Autowired
    CourseOutlineService courseOutlineService;
    @Autowired
    ContentValidator contentValidator;
    @Autowired
    ContentService contentService;
    @Autowired
    ReviewService reviewService;

    @GetMapping("/addCourse")
    public String addCoursePage(Model model) {
        Course course = new Course();
        model.addAttribute("course", new Course());
        return "add-course";
    }

    @ModelAttribute
    public void commonData(Model model) {
        try {
            List<Category> categories = categoryService.findAllCategory();
            model.addAttribute("categories", categories);
            model.addAttribute("instructor", getInstructor());
        } catch (Exception e) {
            List<InstructorField> instructorsFields = null;
        }

    }

    public Category populateCategory(Category category) throws Exception {
        Integer id = Integer.parseInt(category.getName().trim());
        return categoryService.getCategory(id);
    }

    public Instructor getInstructor() throws Exception {
        AppUserDetails principal = (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principal.getUser();
        if (user == null) return null;
        return instructorService.getInstructor(user.getUserId());
    }

    @PostMapping("/saveCourse")
    public String saveCourseProcess(@ModelAttribute("course") Course course, BindingResult result) {
        courseValidator.validate(course, result);
        UploadUtils uploadUtils = new UploadUtils(servletContext.getRealPath("/"));
        if (result.hasErrors()) {
            return "add-course";
        } else {
            MultipartFile multipartImage = course.getCoursePic();
            try {
                uploadUtils.uploadFile("images\\courses", multipartImage);
                Category category = populateCategory(course.getCategory());
                course.setCategory(category);
                course.setPicture(multipartImage.getOriginalFilename());
                course.setInstructor(getInstructor());
                System.out.println("listOfOutlines : " + course.getListOfOutlines());
                String[] outlines = course.getListOfOutlines().split(",");
                Set<CourseOutlines> courseOutlines = new HashSet<>();
                for (String outline : outlines) {
                    CourseOutlines newOutlines = new CourseOutlines();
                    newOutlines.setOutline(outline);
                    newOutlines.setCourse(course);
                    courseOutlines.add(newOutlines);
                    System.out.println(outline);
                }
                course.setOutlines(courseOutlines);
                courseService.addCourse(course);
                return "redirect:/courses/addLesson?courseId=" + course;
            } catch (Exception ex) {
                result.reject("picture", "Error in Uploading Picture , " + ex.getMessage());
                return "add-course";
            }
        }
    }

    @GetMapping("addLesson")
    public String addLesson(@RequestParam(name = "courseId", required = false) Integer courseId, Model model) throws RecordNotFoundException {
        if (courseId == null) {
            throw new RecordNotFoundException();
        }
        try {
            Course course = courseService.getCourse(courseId);
            if (course == null) {
                throw new RecordNotFoundException();
            }
            model.addAttribute("course", course);
            model.addAttribute("content", new Content());
        } catch (Exception ex) {

        }

        return "add-lesson";
    }

    @PostMapping("saveLesson")
    public String saveLesson(@ModelAttribute("content") Content content, BindingResult result, Model model) {
        int courseId = content.getCourseId();
        System.out.println("Lesson length  : " + content.getPeriod());
        System.out.println("topic : " + content.getTopicId());
        contentValidator.validate(content, result);
        Course course;
        UploadUtils uploadUtils = new UploadUtils(servletContext.getRealPath("/"));
        if (result.hasErrors()) {
            try {
                course = courseService.getCourse(content.getCourseId());
                model.addAttribute("course",course );
            } catch (Exception ex) {
                 return "error/400";
            }
                return "add-lesson";
            }
        MultipartFile multipartVideo = content.getLessonVideo();
        try {
            content.setTopic(courseOutlineService.getCourseOutlines(Integer.parseInt(content.getTopicId())));
            content.setVideo(multipartVideo.getOriginalFilename());
            content.setUploadDate(new Date());
            uploadUtils.uploadFile("courses\\"+courseService.getCourse(content.getCourseId()).getTitle()+"\\lessons", multipartVideo);
            contentService.addContent(content);
            course = courseService.getCourse(content.getCourseId());
            //model.addAttribute("course",course );
            return "redirect:/courses/course-details?courseId="+courseId;
        } catch (Exception ex) {
            return "add-lesson";
        }
    }

    @GetMapping("course-details")
    public ModelAndView coursePage(@RequestParam(name = "courseId", required = false) Integer id,Model model) throws Exception {
        if (id == null || id == 0) {
            throw new RecordNotFoundException("Course Id is NULL");
        }
        FilenameUtils utils = new FilenameUtils();
        ModelAndView mav = new ModelAndView("course-details");
        Course course = courseService.getCourse(id);
        List<CourseOutlines> outlines =courseOutlineService.getOutlinesOfCourse(id);
        if (course == null) {
            throw new RecordNotFoundException("Course Id is NULL");
        }
         Integer noOfLessons = 0;
        Integer noOfSeconds = 0;
        String firstContent = "";
        int first = 0;
        for(CourseOutlines outline:outlines){
            for(Content content : outline.getContents()){
                noOfLessons++;
                if(noOfLessons == 1) firstContent = content.getVideo();
                content.setExtension(FilenameUtils.getExtension(content.getVideo()));
                noOfSeconds+=content.getPeriod();
                content.setDuration(convertSeconds(content.getPeriod()));
            }       
        }
        String totalDuration = convertSeconds(noOfSeconds);
        mav.addObject("course", course);
        mav.addObject("reviews", reviewService.findAllReviewByCourse(course.getId()));
        mav.addObject("outlines", outlines);
        mav.addObject("totalDuration", totalDuration);
        mav.addObject("noOfLessons", noOfLessons);
        mav.addObject("firstContent", firstContent);
        model.addAttribute("newReview", new Review());
        return mav;
    }
    public String convertSeconds(Integer seconds){
        int hours = seconds / 3600; 
        int minutes = (seconds - hours * 3600)/60;
         seconds = seconds%60;
         String duration="";
         duration+=(hours<10)?"0":"";
         duration+= hours+":";
         duration+=(minutes<10)?"0":"";
         duration+= minutes+":";
         duration+=(seconds<10)?"0":"";
         duration+= seconds;
         return duration;
    }
  
}
