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
import com.javalt.model.chiTietPhieuNhap;

/**
 *
 * @author PC
 */
public class UserDao_CTPhieuNhap {
      static Connection con = ConnectSQLServer.getConnection();

    public List<chiTietPhieuNhap> getListchiTietPhieuXuat() {
        ArrayList<chiTietPhieuNhap> list = new ArrayList<>();
        String sql = "select * from tblChiTietPhieuNhap";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                chiTietPhieuNhap ct = new chiTietPhieuNhap();

                ct.setMaPN(rs.getString("maPX"));
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

    public List<chiTietPhieuNhap> getUserByMaPN(String maPN) {
        ArrayList<chiTietPhieuNhap> list = new ArrayList<>();
        String sql = "select * from tblChiTietPhieuNhap where maPN = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPN);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                chiTietPhieuNhap ct = new chiTietPhieuNhap();
                ct.setMaPN(rs.getString("maPN"));
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

    public List<chiTietPhieuNhap> getUserByMaSP(String maSP) {
        ArrayList<chiTietPhieuNhap> list = new ArrayList<>();
        String sql = "select * from tblChiTietPhieuNhap where maSP = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                chiTietPhieuNhap ct = new chiTietPhieuNhap();

                ct.setMaPN(rs.getString("maPN"));
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

    public chiTietPhieuNhap deleteSanPham(String maPN, String maSP) {
        String sql = "delete from tblChiTietPhieuNhap where maSP = ? and maPN = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.setString(2, maPN);
            int rs = ps.executeUpdate();
            System.out.println("" + rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean addchiTietPhieuNhap(chiTietPhieuNhap ct) {
        String sql = "insert into tblChiTietPhieuXuat(maPX, masP, giaTien, soLuong) values(?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ct.getMaPN());
            ps.setString(2, ct.getMaSP());
            ps.setLong(3, ct.getGiaTien());
            ps.setInt(4, ct.getSoLuong());
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
        return false;
    }
}
