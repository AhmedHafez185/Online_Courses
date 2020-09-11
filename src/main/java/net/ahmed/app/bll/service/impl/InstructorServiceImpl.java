/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service.impl;

import java.util.List;
import net.ahmed.app.bll.service.InstructorService;
import net.ahmed.app.dal.entity.Instructor;
import net.ahmed.app.dal.repository.impl.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ahmed Hafez
 */
@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    InstructorRepo instructorRepo;

    @Transactional
    @Override
    public Instructor addInstructor(Instructor instructor) throws Exception {
        try {
            Instructor resultInstructor = instructorRepo.add(instructor);
            return resultInstructor;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public List<Instructor> findAllInstructor() throws Exception {

        try {
            List<Instructor> instructors = instructorRepo.findList();
            return instructors;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Instructor editInstructor(Instructor instructor) throws Exception {
        try {
            Instructor updatedInstructor = instructorRepo.update(instructor);
            return updatedInstructor;
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Transactional
    @Override
    public void removeInstructor(int instructorId) throws Exception {
        try {
            instructorRepo.remove(instructorId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Instructor getInstructor(Integer id) throws Exception {
        try {
            Instructor instructor = instructorRepo.findById(id);
            return instructor;
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Override
    public Instructor loadInstructor(Integer id) throws Exception {
        try {
            Instructor instructor = instructorRepo.loadInstructor(id);
            return instructor;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
