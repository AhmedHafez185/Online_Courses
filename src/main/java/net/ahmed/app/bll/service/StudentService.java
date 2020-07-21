/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service;

import java.util.List;
import net.ahmed.app.dal.entity.Student;

/**
 *
 * @author Ahmed Hafez
 */
public interface StudentService {
    public Student addStudent(Student student)throws Exception;
    public List<Student> findAllStudent()throws Exception;
    public Student editStudent(Student student)throws Exception;
    public void removeStudent(int studentId)throws Exception;
    public Student getStudent(Integer id)throws Exception;
}
