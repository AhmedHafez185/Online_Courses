/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service;

import java.util.List;
import net.ahmed.app.dal.entity.CourseOutlines;

/**
 *
 * @author Ahmed Hafez
 */
public interface CourseOutlineService {
    public CourseOutlines addCourseOutlines(CourseOutlines outline)throws Exception;
    public List<CourseOutlines> findAllCourseOutlines()throws Exception;
    public CourseOutlines editCourseOutlines(CourseOutlines outline)throws Exception;
    public void removeCourseOutlines(int outlineId)throws Exception;
    public CourseOutlines getCourseOutlines(Integer id)throws Exception;
    public List<CourseOutlines> getOutlinesOfCourse(Integer id)throws Exception;
}
