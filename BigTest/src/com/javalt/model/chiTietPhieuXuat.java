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
public class chiTietPhieuXuat {
    private String maPX;
    private String maSP;
    private int soLuong;
    private long giaTien;
    
    public chiTietPhieuXuat(){
        
    }
    public chiTietPhieuXuat(String maPX, String maSP, int soLuong, long giaTien){
        this.maPX = maPX;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }
    /**
     * @return the maPX
     */
    public String getMaPX() {
        return maPX;
    }

    /**
     * @param maPX the maPX to set
     */
    public void setMaPX(String maPX) {
        this.maPX = maPX;
    }

    /**
     * @return the maSP
     */
    public String getMaSP() {
        return maSP;
    }

    /**
     * @param maSP the maSP to set
     */
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @return the giaTien
     */
    public long getGiaTien() {
        return giaTien;
    }

    /**
     * @param giaTien the giaTien to set
     */
    public void setGiaTien(long giaTien) {
        this.giaTien = giaTien;
    }
         
}
