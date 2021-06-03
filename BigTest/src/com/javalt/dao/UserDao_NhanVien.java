package com.javalt.dao;

import com.javalt.model.User_NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import JavaSwing.Model.User_NhanVien;

public class UserDao_NhanVien {

    static Connection con = ConnectSQLServer.getConnection();

    public List<User_NhanVien> getAllUsers() {
        List<User_NhanVien> users_NhanVien = new ArrayList<User_NhanVien>();
        String sql = "select * from tblNhanVien";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User_NhanVien user = new User_NhanVien();

                user.setMaNV(rs.getString("maNV"));
                user.setTenNV(rs.getString("tenNV"));
                user.setSDT(rs.getString("soDienthoai"));
                user.setDiaChi(rs.getString("diaChi"));
                user.setMatKhau(rs.getString("matKhau"));

                users_NhanVien.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users_NhanVien;
    }

    public User_NhanVien getUserByMaNV(String maNV) {
        String sql = "select * from tblNhanVien where maNV = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User_NhanVien user = new User_NhanVien();

                user.setMaNV(rs.getString("maNV"));
                user.setTenNV(rs.getString("tenNV"));
                user.setSDT(rs.getString("soDienthoai"));
                user.setDiaChi(rs.getString("diaChi"));
                user.setMatKhau(rs.getString("matKhau"));

                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void addUser(User_NhanVien user) {
        String sql = "insert into tblNhanVien(tenNV, soDienThoai, diaChi, matKhau) values(?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setString(1, user.getTenNV());
            ps.setString(2, user.getSDT());
            ps.setString(3, user.getDiaChi());
            ps.setString(4, user.getMatKhau());

            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
//            Logger.getLogger(UserDao_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUser(User_NhanVien user) {
        String sql = "update tblNhanVien set tenNV = ?, soDienThoai = ?,diaChi = ?,matKhau = ? where maNV = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(5, user.getMaNV());
            ps.setString(1, user.getTenNV());
            ps.setString(2, user.getSDT());
            ps.setString(3, user.getDiaChi());
            ps.setString(4, user.getMatKhau());

            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
