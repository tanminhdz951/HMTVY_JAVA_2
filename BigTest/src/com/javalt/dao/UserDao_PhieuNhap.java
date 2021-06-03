/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javalt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.javalt.model.*;

/**
 *
 * @author PC
 */
public class UserDao_PhieuNhap {
    static Connection con = ConnectSQLServer.getConnection();
    public List<User_PhieuNhap> getListPhieuNhap(){
        ArrayList<User_PhieuNhap> list = new ArrayList<>();
        String sql  = "select * from tblPhieuNhap";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User_PhieuNhap user  = new User_PhieuNhap();
                
                user.setMaPN(rs.getString("maPN"));
                user.setNgayNhap(rs.getString("ngayNhap"));
                user.setNv1(rs.getString("maNV1"));
                user.setNv2(rs.getString("maNV2"));
                
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    public User_PhieuNhap getUserByMaPN(String maPN){
        String sql  = "select * from tblPhieuNhap where maPN = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPN);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                User_PhieuNhap user  = new User_PhieuNhap();
                
                user.setMaPN(rs.getString("maPN"));
                user.setNgayNhap(rs.getString("ngayNhap"));
                user.setNv1(rs.getString("Nv1"));
                user.setNv2(rs.getString("nv2"));
                
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public boolean addUser_PhieuNhap (User_PhieuNhap user){
        String sql = "insert into tblPhieuNhap( ngayNhap,maNV1,maNV2) values(?,?,?)";
       
        try {
             PreparedStatement ps = con.prepareStatement(sql);
          
             ps.setString(1, user.getNgayNhap());
            ps.setString(2,user.getNv1());
              ps.setString(3,user.getNv2());
             int  rs = ps.executeUpdate();
             System.out.println(rs);
        } catch (SQLException e) {  
        }
        return false;
    }
    public  void updateUser(User_PhieuNhap user){
        String sql = "update tblPhieuNhap set ngayNhap = ? where maPN = ?,maNV1 = ?,maNV2 = ?";
        try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(2, user.getMaPN());
             ps.setString(1, user.getNgayNhap());
             ps.setString(3, user.getNv1());
             ps.setString(4,user.getNv2());
             
             int  rs = ps.executeUpdate();
             System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

  public  void deleteUser(User_PhieuNhap user){
        String sql = "delete tblPhieuNhap set ngayNhap = ? where maPN = ?,maNV1 = ?,maNV2 = ?";
        try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(2, user.getMaPN());
             ps.setString(1, user.getNgayNhap());
             ps.setString(3, user.getNv1());
             ps.setString(4,user.getNv2());
             
             int  rs = ps.executeUpdate();
             System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }

