package com.javalt.dao;

import com.javalt.model.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao_ThongKeNhap {

    static Connection con = ConnectSQLServer.getConnection();

    public List<User_thongkenhap> getAllUsers() {
        List<User_thongkenhap> users_thongkeNhap = new ArrayList<User_thongkenhap>();
        String sql = "select PN.maPN, Pn.ngayNhap,PN.maNV1,NV.tenNV,PN.maNV2,tenNV2.tenNV as tenNV2\n" +
                    "from tblPhieuNhap as PN,tblNhanVien as NV,(select maNV,tenNV  from tblPhieuNhap,tblNhanVien where tblPhieuNhap.maNV2 = tblNhanvien.maNV) as tenNV2\n" +
                    "where PN.maNV1 = NV.maNV and PN.maNV2 = tenNV2.maNV\n" +
                    "Group by PN.maPN, PN.ngayNhap,PN.maNV1,NV.tenNV,PN.maNV2,tenNV2.tenNV";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User_thongkenhap user = new User_thongkenhap();

                user.setMaPN(rs.getString("maPN"));
                user.setMaNV1(rs.getString("maNV1"));
                user.setTenNV1(rs.getString("tenNV"));
                user.setMaNV2(rs.getString("maNV2"));
                user.setTenNV2(rs.getString("tenNV2"));
                user.setNgayNhap(rs.getDate("ngayNhap"));

                users_thongkeNhap.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_ThongKeNhap.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users_thongkeNhap;
    }

    public List<User_thongkenhap> getAllUsers_SP(String maPN){
        List<User_thongkenhap> users_Donhang = new ArrayList<User_thongkenhap>();
        String sql  = "select CTPN.maPN,SP.maSP, SP.tenSP,CTPN.soLuong,Sp.donGia\n" +
                    "from tblChiTietPhieuNhap as CTPN , tblSanPham as SP\n" +
                    "where CTPN.maSP = SP.maSP and CTPN.maPN = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPN);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User_thongkenhap user  = new User_thongkenhap();
                user.setMaPN(rs.getString("maPN"));
                user.setMaSP(rs.getString("maSP"));
                user.setTenSP(rs.getString("tenSP"));
                user.setSoluong(rs.getInt("soLuong"));
                user.setGiatien(rs.getDouble("donGia"));
                users_Donhang.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_ThongKeNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users_Donhang;
    }
    
    public User_thongkenhap getUserTongTien(User_thongkenhap user) {
        String sql = "select Sum(soLuong*giaTien) as Tongtien\n" +
                        "from tblChiTietPhieuNhap ";
               
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user.setTongtien(rs.getDouble("tongtien"));

                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_ThongKeNhap.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    public User_thongkenhap getUserThanhTien(String maPN) {
        String sql = "select Sum(soLuong*giaTien) as Thanhtien\n" +
                "from tblChiTietPhieuNhap \n" +
                "where maPN = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPN);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User_thongkenhap user = new User_thongkenhap();
                user.setThanhtien(rs.getDouble("Thanhtien"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_ThongKeNhap.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    
    
    public List<User_thongkenhap> getAllUsers_date(Date ngaydau, Date ngaycuoi) {
        List<User_thongkenhap> users_thongkeXuat = new ArrayList<User_thongkenhap>();
        String sql = "select PN.maPN, Pn.ngayNhap,PN.maNV1,NV.tenNV,PN.maNV2,tenNV2.tenNV as tenNV2\n" +
            "from tblPhieuNhap as PN,tblNhanVien as NV,(select maNV,tenNV  from tblPhieuNhap,tblNhanVien where tblPhieuNhap.maNV2 = tblNhanvien.maNV) as tenNV2\n" +
            "where PN.maNV1 = NV.maNV and PN.maNV2 = tenNV2.maNV and ngayNhap >= ? and ngaynhap <= ?\n" +
            "Group by PN.maPN, Pn.ngayNhap,PN.maNV1,NV.tenNV,PN.maNV2,tenNV2.tenNV";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, ngaydau);
            ps.setDate(2, ngaycuoi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User_thongkenhap user = new User_thongkenhap();

                user.setMaPN(rs.getString("maPN"));
                user.setMaNV1(rs.getString("maNV1"));
                user.setTenNV1(rs.getString("tenNV"));
                user.setMaNV2(rs.getString("maNV2"));
                user.setTenNV2(rs.getString("tenNV2"));
                user.setNgayNhap(rs.getDate("ngayNhap"));

                users_thongkeXuat.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_ThongKeNhap.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users_thongkeXuat;
    }

    public User_thongkenhap getUserTongTien_date(Date ngaydau, Date ngaycuoi) {
        String sql = "select Sum(soLuong*giaTien) as Tongtiendate\n" +
                    "from tblChiTietPhieuNhap as CTPN, tblPhieuNhap as PN\n" +
                    " where CTPN.maPN = PN.maPN and ngayNhap >= ? and ngayNhap <= ? ";
               
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, ngaydau);
            ps.setDate(2, ngaycuoi);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User_thongkenhap user = new User_thongkenhap();
                user.setTongtien_date(rs.getDouble("Tongtiendate"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_ThongKeNhap.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
