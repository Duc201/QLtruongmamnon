/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import models.LopHoc;
import models.NienKhoa;
import models.chiTietGV;

/**
 *
 * @author Duc
 */
public class Controller_PhanCongGV extends ConnectDB {
   
    
    public void AddchitietGiaoVien(chiTietGV ct){
        
         String query =" INSERT INTO CHitietgiaovien(maGV,maLop) VALUES (?,?)";
            try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, ct.getMaGV());
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
    
    public void listLopHocForGV(String maGV, List<LopHoc> listLH , List<NienKhoa> listNK){
        String query = "SELECT Lophoc.tenLop, Nienkhoa.namHoc, LopHoc.maNienKhoa " +
                          "FROM Lophoc " +
                          "INNER JOIN Nienkhoa ON Lophoc.maNienKhoa = Nienkhoa.maNienKhoa " +
                          "INNER JOIN Chitietgiaovien ON Lophoc.maLop = Chitietgiaovien.maLop " +
                         // "INNER JOIN Giaovien ON Chitietgiaovien.maGV = Giaovien.maGV " +
                         
                           "WHERE CHitietgiaovien.maGV = ?";
                         // "WHERE Giaovien.maGV = ?";
        try {
             PreparedStatement statement = conn.prepareStatement(query);
              statement.setString(1, maGV);
             ResultSet rel = statement.executeQuery();

            while (rel.next()) {
                
                LopHoc lh = new LopHoc();
                NienKhoa nk = new NienKhoa();
                lh.setTenLop(rel.getString("tenLop"));
                nk.setNamHoc(rel.getString("namHoc"));
                lh.setMaNienKhoa("maNienKhoa");
                nk.setMaNienKhoa("maNienKhoa");
                listLH.add(lh);
                listNK.add(nk);
            }
             rel.close();
            statement.close();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void Deletephancong(String maLop ,String maGV){
                String deleteQuery = "DELETE FROM Chitietgiaovien WHERE maLop = ? AND maGV = ?";
                try {
            PreparedStatement statement = conn.prepareStatement(deleteQuery);
            statement.setString(1,maLop );
            statement.setString(2,maGV );

            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa Phân công thành công ");
            statement.close();
                    
        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }
}
