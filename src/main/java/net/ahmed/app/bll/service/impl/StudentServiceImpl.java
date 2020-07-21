/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service.impl;

import java.util.List;
import net.ahmed.app.bll.service.StudentService;
import net.ahmed.app.dal.entity.Student;
import net.ahmed.app.dal.repository.impl.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Ahmed Hafez
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Transactional
    @Override
    public Student addStudent(Student student) throws Exception {
        try {
            Student resultStudent = studentRepo.add(student);
            return resultStudent;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public List<Student> findAllStudent() throws Exception {

        try {
            List<Student> students = studentRepo.findList();
            return students;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Student editStudent(Student student) throws Exception {
        try {
            Student updatedStudent = studentRepo.update(student);
            return updatedStudent;
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Transactional
    @Override
    public void removeStudent(int studentId) throws Exception {
        try {
            studentRepo.remove(studentId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Student getStudent(Integer id) throws Exception {
        try {
            Student student = studentRepo.findById(id);
            return student;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
