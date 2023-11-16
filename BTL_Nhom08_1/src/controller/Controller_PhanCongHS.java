/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Chitiethocsinh;
import models.HocSinh;
import models.ThucDon;

/**
 *
 * @author Duc
 */
public class Controller_PhanCongHS extends ConnectDB {
    
    public List<HocSinh> listHSPC(String namHoc){
         List<HocSinh> hocSinhList = new ArrayList<>();
         String sqlQuery = "SELECT Hocsinh.maHS, Hocsinh.hoTen, Hocsinh.ngaySinh, Hocsinh.gioiTinh " +
                          "FROM Hocsinh " +
                          "LEFT JOIN Chitiethocsinh ON Hocsinh.maHS = Chitiethocsinh.maHS " +
                          "AND Chitiethocsinh.maLop IN (SELECT Lophoc.maLop FROM Lophoc WHERE Lophoc.maNienKhoa IN (SELECT maNienKhoa FROM Nienkhoa WHERE namHoc = ?)) " +
                          "WHERE Chitiethocsinh.maHS IS NULL";
        try {
             PreparedStatement statement = conn.prepareStatement(sqlQuery);
            statement.setString(1, namHoc);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HocSinh hs = new HocSinh();
                hs.setMaHS(resultSet.getString("maHS"));
                hs.setHoTen(resultSet.getString("hoTen"));
                hs.setNgaySinh(resultSet.getDate("ngaySinh"));
                //hs.setGioiTinh(true);

                hocSinhList.add(hs);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
             ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi không lấy được danh sách Học Sinh !");
        }
        return hocSinhList;
    }
    public List<HocSinh> listHSLH(String tenLop, String namHoc){
         List<HocSinh> hocSinhList = new ArrayList<>();
         String sqlQuery = "SELECT Hocsinh.maHS, Hocsinh.hoTen, Hocsinh.ngaySinh " +
                          "FROM Hocsinh " +
                          "INNER JOIN Chitiethocsinh ON Hocsinh.maHS = Chitiethocsinh.maHS " +
                          "INNER JOIN Lophoc ON Chitiethocsinh.maLop = Lophoc.maLop " +
                           "INNER JOIN NienKhoa nk ON nk.maNienKhoa = Lophoc.maNienKhoa "+
                          "WHERE Lophoc.tenLop = ? AND nk.namHoc = ? ";
        try {
             PreparedStatement statement = conn.prepareStatement(sqlQuery);
            statement.setString(1,tenLop);
            statement.setString(2,namHoc);
          
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HocSinh hs = new HocSinh();
                hs.setMaHS(resultSet.getString("maHS"));
                hs.setHoTen(resultSet.getString("hoTen"));
                hs.setNgaySinh(resultSet.getDate("ngaySinh"));
                //hs.setGioiTinh(true);

                hocSinhList.add(hs);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
             ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi không lấy được danh sách Học Sinh !");
        }
        return hocSinhList;
    }
    
    public void addChiTietHocSinh(Chitiethocsinh ct){
        
        String query =" INSERT INTO CHitiethocsinh(maHS,maLop) VALUES (?,?)";
            try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, ct.getMaHS());
            statement.setString(2, ct.getMaLop());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, " Phân công thành công");
            statement.close();

        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    public void deletephanCong(Chitiethocsinh ct){
        new Controller_DiemDanh().deleteDiemDanh(ct);
        new Controller_HocPhi().deleteHP1(ct);
                  String deleteQuery = "DELETE FROM Chitiethocsinh WHERE maLop = ? AND maHS = ?";
                try {
            PreparedStatement statement = conn.prepareStatement(deleteQuery);
            statement.setString(1,ct.getMaLop() );
            statement.setString(2,ct.getMaHS() );

            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa Phân công thành công ");
            statement.close();
                    
        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi xóa dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
