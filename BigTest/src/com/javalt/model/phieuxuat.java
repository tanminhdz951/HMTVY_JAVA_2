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
public class phieuxuat {
    private String maPX;
    private String ngayXuat;
    private String lyDo;
    private String maNV;
    private String maKH;
    private String diaChi;
    
    public phieuxuat(){
        
    }
    public phieuxuat(String maPX, String ngayXuat, String lyDo, String maNV, String maKH, String diaChi){
        this.maPX = maPX;
        this.ngayXuat = ngayXuat;
        this.lyDo = lyDo;
        this.maNV = maNV;
        this.maKH = maKH;
        this.diaChi = diaChi;
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
     * @return the ngayXuat
     */
    public String getNgayXuat() {
        return ngayXuat;
    }

    /**
     * @param ngayXuat the ngayXuat to set
     */
    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    /**
     * @return the lyDo
     */
    public String getLyDo() {
        return lyDo;
    }

    /**
     * @param lyDo the lyDo to set
     */
    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    /**
     * @return the maNV
     */
    public String getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    /**
     * @return the maKH
     */
    public String getMaKH() {
        return maKH;
    }

    /**
     * @param maKH the maKH to set
     */
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
}
