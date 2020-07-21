/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.dal.repository.impl;

import java.util.Locale;
import net.ahmed.app.AppConfig;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author Ahmed Hafez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@WebAppConfiguration
public class CategoryRepoTest {
    @Autowired
   // CategoryService categoryService;
    public CategoryRepoTest() {
    }
    @Test
    @Ignore
    public void addCategory() {
       //categoryService.addCategory();
    }
    
    @Test
    public void findAll() {
       //categoryService.findAll();
    }
    
}
