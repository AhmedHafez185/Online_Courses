/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service.impl;

import java.util.List;
import net.ahmed.app.bll.service.UserService;
import net.ahmed.app.dal.entity.User;
import net.ahmed.app.dal.repository.impl.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ahmed Hafez
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public User addUser(User user) throws Exception {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User resultUser = userRepo.add(user);
            return resultUser;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public List<User> findAllUser() throws Exception {

        try {
            List<User> users = userRepo.findList();
            return users;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public User editUser(User user) throws Exception {
        try {
            User updatedUser = userRepo.update(user);
            return updatedUser;
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Transactional
    @Override
    public void removeUser(int userId) throws Exception {
        try {
            userRepo.remove(userId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public User getUser(Integer id) throws Exception {
        try {
            User user = userRepo.findById(id);
            return user;
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Transactional
    @Override
    public boolean checkEmail(String email) throws Exception {
        try {
            return (userRepo.checkUserEmail(email) > 0);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public User findUserByEmail(String email) throws Exception {
        try {
            User user = userRepo.findUserByEmail(email);
            return user;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
