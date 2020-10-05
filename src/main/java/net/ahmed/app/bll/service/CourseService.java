/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service;

import java.util.List;
import net.ahmed.app.dal.entity.Course;

/**
 *
 * @author Ahmed Hafez
 */
public interface CourseService {
    public Course addCourse(Course course)throws Exception;
    public List<Course> findAllCourse()throws Exception;
    public Course editCourse(Course course)throws Exception;
    public void removeCourse(int courseId)throws Exception;
    public Course getCourse(Integer id)throws Exception;
    public List<Course> getCoursesByName(String name) throws Exception ;
}
