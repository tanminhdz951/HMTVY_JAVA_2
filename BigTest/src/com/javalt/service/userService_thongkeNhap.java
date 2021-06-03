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



public class userService_thongkeNhap {
    private  UserDao_ThongKeNhap userDao;

    public userService_thongkeNhap() {
        userDao = new UserDao_ThongKeNhap();
    }
    
    
    public List<User_thongkenhap> getAllUsers(){
        return userDao.getAllUsers();
    }
    public List<User_thongkenhap> getAllUsers_SP(String maPN){
        return userDao.getAllUsers_SP(maPN);
    }
    public User_thongkenhap getUserTongTien(User_thongkenhap user){
        return userDao.getUserTongTien(user);
    }
    
    public User_thongkenhap getUserThanhTien(String maDH){
        return userDao.getUserThanhTien(maDH);
    }
    public List<User_thongkenhap> getAllUsers_date(Date ngaydau,Date ngaycuoi) {
        return userDao.getAllUsers_date(ngaydau,ngaycuoi);
        
    }
    public User_thongkenhap getUserTongTien_date(Date ngaydau, Date ngaycuoi){
        return userDao.getUserTongTien_date(ngaydau,ngaycuoi);
    }

}
