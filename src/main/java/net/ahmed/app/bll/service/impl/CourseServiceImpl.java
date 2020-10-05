/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service.impl;

import java.util.List;
import net.ahmed.app.bll.service.CourseService;
import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.dal.repository.impl.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Ahmed Hafez
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepo courseRepo;
    @Transactional
    @Override
    public Course addCourse(Course course) throws Exception {
        try {
            Course resultCourse = courseRepo.add(course);
            return resultCourse;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public List<Course> findAllCourse() throws Exception {

        try {
            List<Course> courses = courseRepo.findList();
            return courses;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Course editCourse(Course course) throws Exception {
        try {
            Course updatedCourse = courseRepo.update(course);
            return updatedCourse;
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Transactional
    @Override
    public void removeCourse(int courseId) throws Exception {
        try {
            courseRepo.remove(courseId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Course getCourse(Integer id) throws Exception {
        try {
            Course course = courseRepo.findById(id);
            return course;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    @Transactional
    @Override
    public List<Course> getCoursesByName(String name) throws Exception {
        try {
            List<Course> courses = courseRepo.getCoursesByName(name);
            return courses;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
