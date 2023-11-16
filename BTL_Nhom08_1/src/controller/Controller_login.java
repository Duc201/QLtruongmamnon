/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.NguoiDung;

/**
 *
 * @author Duc
 */
public class Controller_login extends ConnectDB{
  public  ArrayList<NguoiDung> getlistND() {
         ArrayList<NguoiDung> list = new ArrayList<>();
         String query = "SELECT maND, tenDN, matKhau , vaiTro FROM Nguoidung";
         
           try{
                PreparedStatement statement = conn.prepareStatement(query);
              ResultSet resultSet = statement.executeQuery();
              while (resultSet.next()) {
              NguoiDung nd = new NguoiDung();
                nd.setMaND(resultSet.getString("maND"));
                nd.setTenDN( resultSet.getString("tenDN"));
                nd.setMatKhau(resultSet.getString("matKhau"));
                nd.setVaiTro(resultSet.getString("vaiTro"));
                   
                list.add(nd);
            }
         }
         catch(SQLException ex){
             ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi lấy từ CSDL!");
         }
         
     return list ;   
    }
  public void updatePass(NguoiDung nd){
        String sql = "UPDATE Nguoidung SET matKhau=?"
                + " WHERE maND=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nd.getMatKhau());
            ps.setString(2, nd.getMaND());
           
             ps.executeUpdate();
             JOptionPane.showMessageDialog( null, " Cập nhật thành công");
             ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
     
  }
   
}
