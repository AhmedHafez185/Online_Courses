/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.security;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ServletContext servletContext;
    @Autowired
    AppUserDetailsService appUserDetailsService;
    private final String[] url = {
        "/instructor/register",
        "/instructor/registerProcess",
        "/logout",
        "/index",
        "/login",};

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**",servletContext.getRealPath("/")+"**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/", "/index", "/login", "/instructor/registerProcess", "/aboutUs", "/contactUs", "/logout","/instructor/register", "/403", "/404").permitAll()
                .antMatchers("/student/student-profile").hasAnyAuthority("Student")
                .antMatchers("/courses/addCourse").hasAnyAuthority("Instructor")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/index")
                .and()
                .logout().logoutUrl("/logout")
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .userDetailsService(appUserDetailsService);

    }

}
