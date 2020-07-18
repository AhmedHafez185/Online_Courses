/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service;

import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.repository.impl.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ahmed Hafez
 */
@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Transactional
    public void addCategory() {
        Category cat1 = new Category("Human Resources");
       cat1 = categoryRepo.add(cat1);
        System.out.println("Added Category Id : "+cat1.getId());
    }
}
