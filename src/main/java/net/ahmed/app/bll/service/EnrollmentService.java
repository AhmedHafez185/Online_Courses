/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service;

import java.util.List;
import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.dal.entity.Enrollment;
import net.ahmed.app.dal.entity.Student;

/**
 *
 * @author Ahmed Hafez
 */
public interface EnrollmentService {
    public Enrollment addEnrollment(Enrollment enrollment)throws Exception;
    public List<Enrollment> findAllEnrollment()throws Exception;
    public Enrollment editEnrollment(Enrollment enrollment)throws Exception;
    public void removeEnrollment(int enrollmentId)throws Exception;
    public Enrollment getEnrollment(Integer id)throws Exception;
    public boolean checkStudentCourseEnrollment(Course course,Student student)throws Exception;
}
