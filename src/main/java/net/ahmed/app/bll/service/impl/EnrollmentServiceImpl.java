/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service.impl;

import java.util.List;
import net.ahmed.app.bll.service.EnrollmentService;
import net.ahmed.app.dal.entity.Enrollment;
import net.ahmed.app.dal.repository.impl.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Ahmed Hafez
 */
@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    EnrollmentRepo enrollmentRepo;
    @Transactional
    @Override
    public Enrollment addEnrollment(Enrollment enrollment) throws Exception {
        try {
            Enrollment resultEnrollment = enrollmentRepo.add(enrollment);
            return resultEnrollment;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public List<Enrollment> findAllEnrollment() throws Exception {

        try {
            List<Enrollment> enrollments = enrollmentRepo.findList();
            return enrollments;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Enrollment editEnrollment(Enrollment enrollment) throws Exception {
        try {
            Enrollment updatedEnrollment = enrollmentRepo.update(enrollment);
            return updatedEnrollment;
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Transactional
    @Override
    public void removeEnrollment(int enrollmentId) throws Exception {
        try {
            enrollmentRepo.remove(enrollmentId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Enrollment getEnrollment(Integer id) throws Exception {
        try {
            Enrollment enrollment = enrollmentRepo.findById(id);
            return enrollment;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
