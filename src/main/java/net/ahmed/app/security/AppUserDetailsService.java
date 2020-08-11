/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.security;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ahmed.app.bll.service.UserService;
import net.ahmed.app.dal.entity.User;
import net.ahmed.app.dal.repository.impl.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ahmed Hafez
 */
@Service
public class AppUserDetailsService implements UserDetailsService{
    
    @Autowired
    UserService userService ;
    @Override    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try {
            System.out.println("Username : "+username);
            user = userService.findUserByEmail(username);
            return new AppUserDetails(user);
        } catch (Exception ex) {
            return null;
        }
        
    }
    
}
