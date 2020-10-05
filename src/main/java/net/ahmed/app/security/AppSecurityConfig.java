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
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    ServletContext servletContext;
    @Autowired
    AppUserDetailsService appUserDetailsService;
    private final String[] url = {"/", "/index",
        "/login", "/instructor/registerProcess","/student/registerProcess",
        "/aboutUs", "/contactUs", "/logout",
        "/instructor/register","/student/register","/403", "/404","/400",
        "/categories/category-details","/courses/course-details"};

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
                .antMatchers(url).permitAll()
                .antMatchers("/student/student-profile").hasAnyAuthority("Student")
                .antMatchers("/courses/addCourse").hasAnyAuthority("Instructor")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login")
                .permitAll().successHandler(authenticationSuccessHandler)
                .defaultSuccessUrl("/index")
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
        http.headers().frameOptions().disable();

    }

}
