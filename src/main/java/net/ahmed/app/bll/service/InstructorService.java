/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service;

import java.util.List;
import net.ahmed.app.dal.entity.Instructor;

/**
 *
 * @author Ahmed Hafez
 */
public interface InstructorService {
    public Instructor addInstructor(Instructor instructor)throws Exception;
    public List<Instructor> findAllInstructor()throws Exception;
    public Instructor editInstructor(Instructor instructor)throws Exception;
    public void removeInstructor(int instructorId)throws Exception;
    public Instructor getInstructor(Integer id)throws Exception;
    public Instructor loadInstructor(Integer id)throws Exception;
}
