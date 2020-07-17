/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author Ahmed Hafez
 */
@Configuration
@ComponentScan(basePackages = { "net.ahmed.app" }, excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
@PropertySource("classpath:application.properties")
public class AppConfig {
    
}
