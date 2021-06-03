/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javalt.model;

/**
 *
 * @author ACER
 */
public class sanpham {
    private String maSP;
    private String tenSP;
    private long donGia;
    private int soLuongCon;
    
    public sanpham() {
       
    }

    public sanpham(String maSP, String tenSP, long donGia, int soLuongCon) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuongCon = soLuongCon;
    }

    /*public String getMaSP() {
        return maSP;
    }

    /**
     * @param maSP the maSP to set
     */
    public String getMaSP() {
        return maSP;
    }

    /* public void setMaSP(String maSP) {
    this.maSP = maSP;
    }
    /**
     * @return the tenSP
     */
    public String getTenSP() {
        return tenSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    /**
     * @param tenSP the tenSP to set
     */
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    /**
     * @return the donGia
     */
    public long getDonGia() {
        return donGia;
    }

    /**
     * @param donGia the donGia to set
     */
    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    /**
     * @return the soLuongCon
     */
    public int getSoLuongCon() {
        return soLuongCon;
    }

    /**
     * @param soLuongCon the soLuongCon to set
     */
    public void setSoLuongCon(int soLuongCon) {
        this.soLuongCon = soLuongCon;
    }
    
}
