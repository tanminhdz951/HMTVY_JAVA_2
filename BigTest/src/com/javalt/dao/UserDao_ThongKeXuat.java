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

public class UserDao_ThongKeXuat {

    static Connection con = ConnectSQLServer.getConnection();

    public List<User_thongkexuat> getAllUsers() {
        List<User_thongkexuat> users_thongkeXuat = new ArrayList<User_thongkexuat>();
        String sql = "select PX.maPX, PX.ngayXuat, PX.lyDo, NV.tenNV,KH.tenKH,PX.diaChi\n" +
                "from tblPhieuXuat as PX, tblNhanVien as NV, tblKhachHang as KH\n" +
                "where PX.maNV = NV.maNV and PX.maKH = Kh.maKH";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User_thongkexuat user = new User_thongkexuat();
                
                user.setMaPX(rs.getString("maPX"));
                user.setNgayXuat(rs.getDate("ngayXuat"));
                user.setLyDo(rs.getString("lyDo"));
                user.setTenNV(rs.getString("tenNV"));
                user.setTenKH(rs.getString("tenKH"));
                user.setDiaChi(rs.getString("diaChi"));
                
                users_thongkeXuat.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_ThongKeXuat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users_thongkeXuat;
    }

    public List<User_thongkexuat> getAllUsers_SP(String maPX) {
        List<User_thongkexuat> users_thongkexuat = new ArrayList<User_thongkexuat>();
        String sql = "select CTPX.maPX,SP.maSP, SP.tenSP,CTPX.soLuong, CTPX.giaTien\n" +
                    "from tblChiTietPhieuXuat as CTPX, tblSanPham as SP\n" +
                    "where CTPX.maSP = Sp.maSP and CTPX.maPX = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPX);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User_thongkexuat user = new User_thongkexuat();

                user.setMaPX(rs.getString("maPX"));
                user.setMaSP(rs.getString("maSP"));
                user.setTenSP(rs.getString("TenSP"));
                user.setSoluong(rs.getInt("soLuong"));
                user.setGiaTien(rs.getDouble("giatien"));

                users_thongkexuat.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_ThongKeXuat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users_thongkexuat;
    }
    
    public User_thongkexuat getUserTongTien(User_thongkexuat user) {
        String sql = "select sum(soLuong*giaTien)as tongtien from tblChiTietPhieuXuat";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user.setTongtien(rs.getDouble("tongtien"));

                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_ThongKeXuat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public User_thongkexuat getUserThanhTien(String maPX) {
        String sql = "select sum(soLuong*giaTien) as Thanhtien\n" +
                    "from tblChiTietPhieuXuat\n" +
                    "where maPX = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPX);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User_thongkexuat user = new User_thongkexuat();
                user.setThanhtien(rs.getDouble("Thanhtien"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_ThongKeXuat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    
    public User_thongkexuat getUserTongTien_date(Date ngaydau, Date ngaycuoi) {
        String sql = "select sum(CTPN.soluong*CTPN.giaTien) as tongtien\n" +
                "from tblChiTietPhieuxuat as CTPN, tblPhieuXuat PN\n" +
                "where CTPN.maPX = PN.maPX and PN.ngayXuat >= ? and PN.ngayXuat <= ?";
               
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, ngaydau);
            ps.setDate(2, ngaycuoi);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User_thongkexuat user = new User_thongkexuat();
                
                user.setTongtien(rs.getDouble("Tongtien"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_ThongKeXuat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public List<User_thongkexuat> getAllUsers_date(Date ngaydau ,Date ngaycuoi) {
        List<User_thongkexuat> users_thongkeXuat = new ArrayList<User_thongkexuat>();
        String sql = "select PX.maPX, PX.ngayXuat, PX.lyDo, NV.tenNV,KH.tenKH,PX.diaChi\n" +
                    "from tblPhieuXuat as PX, tblNhanVien as NV, tblKhachHang as KH\n" +
                    "where PX.maNV = NV.maNV and PX.maKH = Kh.maKH and PX.ngayXuat >= ? and PX.ngayXuat <= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, ngaydau);
            ps.setDate(2, ngaycuoi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User_thongkexuat user = new User_thongkexuat();

                user.setMaPX(rs.getString("maPX"));
                user.setNgayXuat(rs.getDate("ngayXuat"));
                user.setLyDo(rs.getString("lyDo"));
                user.setTenNV(rs.getString("tenNV"));
                user.setTenKH(rs.getString("tenKH"));
                user.setDiaChi(rs.getString("diaChi"));

                users_thongkeXuat.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao_ThongKeXuat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users_thongkeXuat;
    }
    
    
}
