/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service.impl;

import java.util.List;
import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.repository.impl.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.ahmed.app.bll.service.LookupsService;
import net.ahmed.app.dal.entity.InstructorField;
import net.ahmed.app.dal.repository.impl.InstructorFieldsRepo;

/**
 *
 * @author Ahmed Hafez
 */
@Service
public class LookupsServiceImpl implements LookupsService {

    @Autowired
    CategoryRepo categoryRepo;
    
   @Autowired
    InstructorFieldsRepo instructorFieldsRepo;

    @Transactional
    @Override
    public Category addCategory(Category category) throws Exception {
        try {
            Category resultCategory = categoryRepo.add(category);
            return resultCategory;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public List<Category> findAllCategory() throws Exception {

        try {
            List<Category> categories = categoryRepo.findList();
            return categories;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Category editCategory(Category category) throws Exception {
        try {
            Category updatedCategory = categoryRepo.update(category);
            return updatedCategory;
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Transactional
    @Override
    public void removeCategory(int categoryId) throws Exception {
        try {
            categoryRepo.remove(categoryId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Category getCategory(Integer id) throws Exception {
        try {
            Category category = categoryRepo.findById(id);
            return category;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public InstructorField addInstructorField(InstructorField instructorField) throws Exception {
        try {
            InstructorField savedInstructorField = instructorFieldsRepo.add(instructorField);
            return savedInstructorField;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public List<InstructorField> findAllInstructorField() throws Exception {
        try {
            List<InstructorField> instructorFields = instructorFieldsRepo.findList();
            return instructorFields;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public InstructorField editInstructorField(InstructorField instructorField) throws Exception {
        try {
            InstructorField updatedInsField = instructorFieldsRepo.update(instructorField);
            return updatedInsField;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public void removeInstructorField(int instructorFieldId) throws Exception {
        try {
            instructorFieldsRepo.remove(instructorFieldId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public InstructorField getInstructorField(Integer id) throws Exception {
        try {
        InstructorField instructorField = instructorFieldsRepo.findById(id);
        return instructorField;
        } catch (Exception ex) {
            throw ex;
        }
    }

   

}
