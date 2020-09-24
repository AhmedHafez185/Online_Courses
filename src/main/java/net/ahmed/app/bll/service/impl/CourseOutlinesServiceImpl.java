/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service.impl;

import java.util.List;
import net.ahmed.app.bll.service.CourseOutlineService;
import net.ahmed.app.dal.entity.CourseOutlines;
import net.ahmed.app.dal.repository.impl.CourseOutlinesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Ahmed Hafez
 */
@Service
public class CourseOutlinesServiceImpl implements CourseOutlineService {
    @Autowired
    CourseOutlinesRepo outlineRepo;
    @Transactional
    @Override
    public CourseOutlines addCourseOutlines(CourseOutlines outline) throws Exception {
        try {
            CourseOutlines resultCourseOutlines = outlineRepo.add(outline);
            return resultCourseOutlines;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public List<CourseOutlines> findAllCourseOutlines() throws Exception {

        try {
            List<CourseOutlines> outlines = outlineRepo.findList();
            return outlines;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public CourseOutlines editCourseOutlines(CourseOutlines outline) throws Exception {
        try {
            CourseOutlines updatedCourseOutlines = outlineRepo.update(outline);
            return updatedCourseOutlines;
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Transactional
    @Override
    public void removeCourseOutlines(int outlineId) throws Exception {
        try {
            outlineRepo.remove(outlineId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public CourseOutlines getCourseOutlines(Integer id) throws Exception {
        try {
            CourseOutlines outline = outlineRepo.findById(id);
            return outline;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    @Transactional
    @Override
    public List<CourseOutlines> getOutlinesOfCourse(Integer id) throws Exception {
        try {
            List<CourseOutlines> outlines = outlineRepo.getOutlinesOfCourse(id);
            return outlines;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
