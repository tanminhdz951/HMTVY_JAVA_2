
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

public class UserDao_SanPham {
    static Connection con = ConnectSQLServer.getConnection();
    public List<User_SanPham> getListsanpham(){
        ArrayList<User_SanPham> list = new ArrayList<>();
        String sql  = "select * from tblSanPham";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User_SanPham user  = new User_SanPham();
                
                user.setMaSP(rs.getString("maSP"));
                user.setTenSP(rs.getString("tenSP"));
                user.setDonGiaBan(rs.getLong("donGia"));
                user.setSoLuongCon(rs.getInt("soLuongCon"));
                
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    public boolean addUser_SanPham (User_SanPham user){
        String sql = "insert into tblSanPham( tenSP, donGia, soLuongCon) values(?,?,?)";
       
        try {
             PreparedStatement ps = con.prepareStatement(sql);
          
             ps.setString(1, user.getTenSP());
             ps.setDouble(2, user.getDonGiaBan());
             ps.setInt(3, user.getSoLuongCon());
             
             int  rs = ps.executeUpdate();
             System.out.println(rs);
        } catch (SQLException e) {  
        }
        return false;
    }
    public List<User_SanPham> getAllUsers(){
        List<User_SanPham> users_SanPham = new ArrayList<User_SanPham>();
        String sql  = "select * from tblSanPham";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User_SanPham user  = new User_SanPham();
                
                user.setMaSP(rs.getString("maSP"));
                user.setTenSP(rs.getString("tenSP"));
                user.setDonGiaBan(rs.getLong("donGia"));
                user.setSoLuongCon(rs.getInt("soLuongCon"));
                
                users_SanPham.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users_SanPham;
    }
    public User_SanPham getUserByMaSP(String maSP){
        String sql  = "select * from tblSanPham where maSP = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                User_SanPham user  = new User_SanPham();
                
                user.setMaSP(rs.getString("maSP"));
                user.setTenSP(rs.getString("tenSP"));
                user.setDonGiaBan(rs.getLong("donGia"));
                user.setSoLuongCon(rs.getInt("soLuongCon"));
                
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public void addUser (User_SanPham user){
        String sql = "insert into tblSanPham( tenSP, donGia, soLuongCon) values(?,?,?)";
       
        try {
             PreparedStatement ps = con.prepareStatement(sql);
          
             ps.setString(1, user.getTenSP());
             ps.setDouble(2, user.getDonGiaBan());
             ps.setInt(3, user.getSoLuongCon());
             
             int  rs = ps.executeUpdate();
             System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void updateUser(User_SanPham user){
        String sql = "update tblSanPham set tenSP = ?, donGia = ?,soLuongCon = ? where maSP = ?";
        try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(4, user.getMaSP());
             ps.setString(1, user.getTenSP());
             ps.setDouble(2, user.getDonGiaBan());
             ps.setInt(3,user.getSoLuongCon());
             
             int  rs = ps.executeUpdate();
             System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
