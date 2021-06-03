/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javalt.service;

import java.util.List;

import com.javalt.dao.*;
import com.javalt.model.*;
import java.sql.Date;



public class userService_thongkexuat {
    private  UserDao_ThongKeXuat userDao;

    public userService_thongkexuat() {
        userDao = new UserDao_ThongKeXuat();
    }
    
    
    public List<User_thongkexuat> getAllUsers(){
        return userDao.getAllUsers();
    }
    public List<User_thongkexuat> getAllUsers_SP(String maPX) {
        return userDao.getAllUsers_SP(maPX);
    }
    
    public User_thongkexuat getUserTongTien(User_thongkexuat user) {
        return userDao.getUserTongTien(user);
    }
    public User_thongkexuat getUserThanhTien(String maPX) {
        return userDao.getUserThanhTien(maPX);
    }
    
    public List<User_thongkexuat> getAllUsers_date(Date ngaydau ,Date ngaycuoi) {
        return userDao.getAllUsers_date(ngaydau, ngaycuoi);
    }
    public User_thongkexuat getUserTongTien_date(Date ngaydau, Date ngaycuoi) {
        return userDao.getUserTongTien_date(ngaydau, ngaycuoi);
    }
}
