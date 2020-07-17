/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.utils;

import net.ahmed.app.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 *
 * @author Ahmed Hafez
 */
public class UtilTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Services test = context.getBean("testServiceDAL",Services.class);
        test.testAdd(context);
    }

}
