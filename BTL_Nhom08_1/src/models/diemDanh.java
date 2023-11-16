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
public class diemDanh {
    int maDD;
    boolean trangThai;
    Date ngayHoc;
    String maHS;
    String maLop;

    public diemDanh(int maDD, boolean trangThai, Date ngayHoc, String maHS, String maLop) {
        this.maDD = maDD;
        this.trangThai = trangThai;
        this.ngayHoc = ngayHoc;
        this.maHS = maHS;
        this.maLop = maLop;
    }
    public diemDanh(){
        this.maDD = 0;
        this.trangThai = true;
        this.ngayHoc = new Date();
        this.maHS = "NULL";
        this.maLop = "NULL";
    }
    public int getMaDD() {
        return maDD;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public Date getNgayHoc() {
        return ngayHoc;
    }

    public String getMaHS() {
        return maHS;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaDD(int maDD) {
        this.maDD = maDD;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public void setNgayHoc(Date ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
    
}
