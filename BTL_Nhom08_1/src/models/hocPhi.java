/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author Duc
 */
public class hocPhi {
    int maHocPhi;
    String tenHocPhi;
    Date ngayBatDau;
    Date ngayKetThuc;
    double hocPhi1Bua;
    String maNienKhoa;

    public void setMaNienKhoa(String maNienKhoa) {
        this.maNienKhoa = maNienKhoa;
    }

    public String getMaNienKhoa() {
        return maNienKhoa;
    }
    

    public hocPhi() {
        this.maHocPhi = 1;
        this.tenHocPhi = "NULL";
        this.ngayBatDau = new Date();
        this.ngayKetThuc = new Date();
        this.hocPhi1Bua = 0;
        this.maNienKhoa = "NULL";
    }

    public hocPhi(int maHocPhi, String tenHocPhi, Date ngayBatDau, Date ngayKetThuc, double hocPhi1Bua, String maNienKhoa) {
        this.maHocPhi = maHocPhi;
        this.tenHocPhi = tenHocPhi;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.hocPhi1Bua = hocPhi1Bua;
        this.maNienKhoa = maNienKhoa;
    }

    public int getMaHocPhi() {
        return maHocPhi;
    }

    public String getTenHocPhi() {
        return tenHocPhi;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public double getHocPhi1Bua() {
        return hocPhi1Bua;
    }

    public void setMaHocPhi(int maHocPhi) {
        this.maHocPhi = maHocPhi;
    }

    public void setTenHocPhi(String tenHocPhi) {
        this.tenHocPhi = tenHocPhi;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public void setHocPhi1Bua(double hocPhi1Bua) {
        this.hocPhi1Bua = hocPhi1Bua;
    }
    
    
    
}
