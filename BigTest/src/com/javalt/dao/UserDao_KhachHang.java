
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

public class UserDao_KhachHang {
    static Connection con = ConnectSQLServer.getConnection();
    public List<User_KhachHang> getAllUsers(){
        List<User_KhachHang> users_KhachHang = new ArrayList<User_KhachHang>();
        String sql  = "select * from tblKhachHang";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User_KhachHang user  = new User_KhachHang();
                
                user.setMaKH(rs.getString("maKH"));
                user.setTenKH(rs.getString("tenKH"));
                user.setSDT(rs.getString("soDienThoai"));
                user.setDiaChi(rs.getString("diaChi"));
                
                
                users_KhachHang.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users_KhachHang;
    }
    public User_KhachHang getUserByMaKH(String maKH){
        String sql  = "select * from tblKhachHang where maKH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maKH);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                User_KhachHang user  = new User_KhachHang();
                
                user.setMaKH(rs.getString("maKH"));
                user.setTenKH(rs.getString("tenKH"));
                user.setSDT(rs.getString("soDienThoai"));
                user.setDiaChi(rs.getString("diaChi"));
                
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public void addUser (User_KhachHang user){
        String sql = "insert into tblKhachHang(TenKH, soDienThoai, diaChi) values(?,?,?)";
       
        try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, user.getTenKH());
             ps.setString(2, user.getSDT());
             ps.setString(3, user.getDiaChi());
             
             int  rs = ps.executeUpdate();
             System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void updateUser(User_KhachHang user){
        String sql = "update tblKhachHang set TenKH = ?, soDienThoai = ?,diaChi = ?  where maKH = ?";
        try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(4, user.getMaKH());
             ps.setString(1, user.getTenKH());
             ps.setString(2, user.getSDT());
             ps.setString(3, user.getDiaChi());
             
             int  rs = ps.executeUpdate();
             System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
