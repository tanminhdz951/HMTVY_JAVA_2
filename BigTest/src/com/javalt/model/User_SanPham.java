/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javalt.model;

/**
 *
 * @author hoava
 */
public class User_SanPham {
    private String maSP, tenSP;
    private long donGiaBan;
    private int soLuongCon;

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public long getDonGiaBan() {
        return donGiaBan;
    }

    public int getSoLuongCon() {
        return soLuongCon;
    }
    
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setDonGiaBan(long donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public void setSoLuongCon(int soLuongCon) {
        this.soLuongCon = soLuongCon;
    }   
}
