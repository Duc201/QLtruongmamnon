/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Duc
 */
public class chiTietGV {
    private String maLop;
    private String maGV;

    public chiTietGV(){
        this.maLop = " ";
        this.maGV =  " ";
    }
    public chiTietGV(String maLop, String maGV) {
        this.maLop = maLop;
        this.maGV = maGV;
    }

    public String getMaLop() {
        return maLop;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }
    
    
    
}
