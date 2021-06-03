/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javalt.model;

/**
 *
 * @author PC
 */
public class chiTietPhieuNhap {
    private String maPN;
    private String maSP;
    private int soLuong;
    private long giaTien;
    
    public chiTietPhieuNhap(){
        
    }
public chiTietPhieuNhap(String maPN, String maSP, int soLuong, long giaTien){
        this.maPN = maPN;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }
    /**
     * @return the maPX
     */
    public String getMaPN() {
        return maPN;
    }

    /**
     * @param maPN the maPX to set
     */
    public void setMaPN(String maPN) {
        this.maPN = maPN;
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
