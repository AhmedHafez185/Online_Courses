/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service;

import java.util.List;
import net.ahmed.app.dal.entity.User;

/**
 *
 * @author Ahmed Hafez
 */
public interface UserService {
    public User addUser(User user)throws Exception;
    public List<User> findAllUser()throws Exception;
    public User editUser(User user)throws Exception;
    public void removeUser(int userId)throws Exception;
    public User getUser(Integer id)throws Exception;
    public boolean checkEmail(String email)throws Exception;
    public User findUserByEmail(String email)throws Exception;
}
