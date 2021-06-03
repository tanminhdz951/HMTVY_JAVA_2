/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javalt.service;

import java.util.List;
import com.javalt.dao.*;
import com.javalt.model.*;

public class userService_SanPham {
    private  UserDao_SanPham userDao;

    public userService_SanPham() {
        userDao = new UserDao_SanPham();
    }
    
    public List<User_SanPham> getAllUsers(){
        return userDao.getAllUsers();
    }
    public void addUser(User_SanPham user){
        userDao.addUser(user);
    }
    public User_SanPham getUserBymaSP(String maSP){
        return userDao.getUserByMaSP(maSP);
    }
          
  public void updateUser(User_SanPham user){
      userDao.updateUser(user);
    }
}
