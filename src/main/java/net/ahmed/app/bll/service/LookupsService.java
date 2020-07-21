/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service;

import java.util.List;
import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.entity.InstructorField;

/**
 *
 * @author Ahmed Hafez
 */
public interface LookupsService {
    public Category addCategory(Category category)throws Exception;
    public List<Category> findAllCategory()throws Exception;
    public Category editCategory(Category category)throws Exception;
    public void removeCategory(int categoryId)throws Exception;
    public Category getCategory(Integer id)throws Exception;

    public InstructorField addInstructorField(InstructorField instructorField)throws Exception;
    public List<InstructorField> findAllInstructorField()throws Exception;
    public InstructorField editInstructorField(InstructorField instructorField)throws Exception;
    public void removeInstructorField(int instructorFieldId)throws Exception;
    public InstructorField getInstructorField(Integer id)throws Exception;
}
