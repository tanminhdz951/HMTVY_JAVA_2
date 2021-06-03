/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javalt.service;

import java.util.List;
import com.javalt.dao.*;
import com.javalt.model.*;

public class userService_NhanVien {
    private  UserDao_NhanVien userDao;

    public userService_NhanVien() {
        userDao = new UserDao_NhanVien();
    }
    
    
    public List<User_NhanVien> getAllUsers(){
        return userDao.getAllUsers();
    }
    public void addUser(User_NhanVien user){
        userDao.addUser(user);
    }
    public User_NhanVien getUserBymaNV(String maNV){
        return userDao.getUserByMaNV(maNV);
    }
          
  public void updateUser(User_NhanVien user){
      userDao.updateUser(user);
    }
}
