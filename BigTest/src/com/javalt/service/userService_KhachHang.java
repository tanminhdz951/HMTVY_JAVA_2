/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javalt.service;

import java.util.List;
import com.javalt.dao.*;
import com.javalt.model.*;

public class userService_KhachHang {
    private  UserDao_KhachHang userDao;

    public userService_KhachHang() {
        userDao = new UserDao_KhachHang();
    }
    
    
    public List<User_KhachHang> getAllUsers(){
        return userDao.getAllUsers();
    }
    public void addUser(User_KhachHang user){
        userDao.addUser(user);
    }
    public User_KhachHang getUserBymaKH(String maKH){
        return userDao.getUserByMaKH(maKH);
    }
          
  public void updateUser(User_KhachHang user){
      userDao.updateUser(user);
    }
}
