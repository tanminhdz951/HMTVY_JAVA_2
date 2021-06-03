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
public class UserDao_CTPhieuXuat {

    static Connection con = ConnectSQLServer.getConnection();

    public List<chiTietPhieuXuat> getListchiTietPhieuXuat() {
        ArrayList<chiTietPhieuXuat> list = new ArrayList<>();
        String sql = "select * from tblChiTietPhieuXuat";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                chiTietPhieuXuat ct = new chiTietPhieuXuat();

                ct.setMaPX(rs.getString("maPX"));
                ct.setMaSP(rs.getString("maSP"));
                ct.setSoLuong(rs.getInt("soLuong"));
                ct.setGiaTien(rs.getLong("giaTien"));
                list.add(ct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<chiTietPhieuXuat> getUserByMaPX(String maPX) {
        ArrayList<chiTietPhieuXuat> list = new ArrayList<>();
        String sql = "select * from tblChiTietPhieuXuat where maPX = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPX);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                chiTietPhieuXuat ct = new chiTietPhieuXuat();
                ct.setMaPX(rs.getString("maPX"));
                ct.setMaSP(rs.getString("maSP"));
                ct.setSoLuong(rs.getInt("soLuong"));
                ct.setGiaTien(rs.getLong("giaTien"));
                list.add(ct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<chiTietPhieuXuat> getUserByMaSP(String maSP) {
        ArrayList<chiTietPhieuXuat> list = new ArrayList<>();
        String sql = "select * from tblChiTietPhieuXuat where maSP = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                chiTietPhieuXuat ct = new chiTietPhieuXuat();

                ct.setMaPX(rs.getString("maPX"));
                ct.setMaSP(rs.getString("maSP"));
                ct.setSoLuong(rs.getInt("soLuong"));
                ct.setGiaTien(rs.getLong("giaTien"));
                list.add(ct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public chiTietPhieuXuat deleteSanPham(String maPX, String maSP) {
        String sql = "delete from tblChiTietPhieuXuat where maSP = ? and maPX = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.setString(2, maPX);
            int rs = ps.executeUpdate();
            System.out.println("" + rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean addchiTietPhieuXuat(chiTietPhieuXuat ct) {
        String sql = "insert into tblChiTietPhieuXuat(maPX, masP, giaTien, soLuong) values(?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ct.getMaPX());
            ps.setString(2, ct.getMaSP());
            ps.setLong(3, ct.getGiaTien());
            ps.setInt(4, ct.getSoLuong());
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
        return false;
    }
    /*public  void updateUser(chiTietPhieuXuat ct){
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
            Logger.getLogger(UserDao_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/

}
