/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javalt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class UserDao_PhieuXuat {

   /* public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     private Connection con;
    public UserDao_PhieuXuat() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://LAPTOP-RHJ3HAF2:1433;databasename=QuanLyKhoHang;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    //static Connection con = connectDataBase.getJDBCConnection();
    /*public boolean addphieuxuat(phieuxuat p) {
        String sql = "INSERT INTO tblPhieuXuat(maPX,ngayXuat,lyDo,maNV,maKH,diaChi) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getMaPX());
            ps.setString(2, p.getNgayXuat());
            ps.setString(3, p.getLyDo());
            ps.setString(4, p.getMaNV());
            ps.setString(5, p.getMaKH());
            ps.setString(6, p.getDiaChi());
            int row = ps.executeUpdate();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    } */
    static Connection con = ConnectSQLServer.getConnection();
    public ArrayList<phieuxuat> getListphieuxuat() {
        ArrayList<phieuxuat> list = new ArrayList<>();
        String sql = "SELECT * FROM tblPhieuXuat";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                phieuxuat p = new phieuxuat();
                p.setMaPX(rs.getString("maPX"));
                p.setNgayXuat(rs.getString("ngayXuat"));
                p.setLyDo(rs.getString("lyDo"));
                p.setMaNV(rs.getString("maNV"));
                p.setMaKH(rs.getString("maKH"));
                p.setDiaChi(rs.getString("diaChi"));
                list.add(p);
            }
         } catch (SQLException ex) {
            Logger.getLogger(UserDao_PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public phieuxuat getUserByMaPX(String maPX){
        String sql  = "select * from tblPhieuXuat where maPX = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPX);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                phieuxuat x  = new phieuxuat();
                
                 x.setMaPX(rs.getString("maPN"));
                x.setNgayXuat(rs.getString("ngayXuat"));
                x.setLyDo(rs.getString("lyDo"));
                x.setMaNV(rs.getString("maNV"));
                x.setMaKH(rs.getString("maKH"));
                x.setDiaChi(rs.getString("diaChi"));
               
                
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
   public boolean addphieuxuat (phieuxuat x){
        String sql = "insert into tblPhieuXuat( ngayXuat,lyDo,maNV,maKH,diaChi) values(?,?,?,?,?)";
       
        try {
             PreparedStatement ps = con.prepareStatement(sql);
          
             ps.setString(1, x.getNgayXuat());
              ps.setString(2, x.getLyDo());
             ps.setString(3,x.getMaNV());
             ps.setString(4,x.getMaKH());
             ps.setString(5,x.getDiaChi());
            //chưa có đây nè sao nó thêm
             
             int  rs = ps.executeUpdate();
             System.out.println(rs);
        } catch (SQLException e) {  
        }
        return false;
    }
    public  void updateUser(phieuxuat x){
        String sql = "update tblPhieuXuat set ngayXuat = ? where maPX = ?,lyDo = ?,maNV = ?,maKH = ?,diaChi = ?";
        try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(2, x.getMaPX());
             ps.setString(1, x.getNgayXuat());
             ps.setString(3, x.getLyDo());
             ps.setString(4,x.getMaNV());
             ps.setString(5,x.getMaKH());
             ps.setString(6,x.getDiaChi());
             
             int  rs = ps.executeUpdate();
             System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

  
    }

