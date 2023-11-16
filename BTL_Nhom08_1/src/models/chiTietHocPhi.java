/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Duc
 */
public class chiTietHocPhi {
    private int maHocPhi1;
    private String maHS;
    private String maLop;
    private int maHP;
    private int soBua;
    private double tong;

    public chiTietHocPhi(int maHocPhi1, String maHS, String maLop, int maHP, int soBua, double tong) {
        this.maHocPhi1 = maHocPhi1;
        this.maHS = maHS;
        this.maLop = maLop;
        this.maHP = maHP;
        this.soBua = soBua;
        this.tong = tong;
    }
     public chiTietHocPhi() {
        this.maHocPhi1 = 0;
        this.maHS = "NULL";
        this.maLop = "NULL";
        this.maHP = 0;
        this.soBua = 0;
        this.tong = 0;
    }

    public int getMaHocPhi1() {
        return maHocPhi1;
    }

    public String getMaHS() {
        return maHS;
    }

    public String getMaLop() {
        return maLop;
    }

    public int getMaHP() {
        return maHP;
    }

    public int getSoBua() {
        return soBua;
    }

    public double getTong() {
        return tong;
    }

    public void setMaHocPhi1(int maHocPhi1) {
        this.maHocPhi1 = maHocPhi1;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public void setMaHP(int maHP) {
        this.maHP = maHP;
    }

    public void setSoBua(int soBua) {
        this.soBua = soBua;
    }

    public void setTong(double tong) {
        this.tong = tong;
    }
    
}
