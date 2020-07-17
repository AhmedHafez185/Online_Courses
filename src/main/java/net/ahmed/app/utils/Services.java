/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.utils;

import net.ahmed.app.dal.entity.Category;
import net.ahmed.app.dal.repository.impl.CategoryRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ahmed Hafez
 */
@Service
public class Services {
    @Transactional
    public void testAdd(ApplicationContext context){
        try{
            CategoryRepo cityRepo = context.getBean("categoryRepo",CategoryRepo.class);
            Category city = new Category("Databases");
            Category returnedCity = cityRepo.add(city);
            System.out.println("Added : "+returnedCity.getId());
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
