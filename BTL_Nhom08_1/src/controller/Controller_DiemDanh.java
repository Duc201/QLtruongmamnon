/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.Chitiethocsinh;
import models.HocSinh;
import models.diemDanh;
import models.hocPhi;


/**
 *
 * @author Duc
 */
public class Controller_DiemDanh extends ConnectDB{
    public void Listdiemdanh(String tenLop, Date ngay, List<HocSinh> listHocSinh, List<diemDanh> listDiemDanh) {

        String querysql = "SELECT H.maHS, H.hoTen, H.ngaySinh, D.trangThai " +
                "FROM Hocsinh H " +
                "INNER JOIN Chitiethocsinh ct ON ct.maHS = H.maHS " +
                "INNER JOIN Lophoc lh ON lh.maLop = ct.maLop " +
                "LEFT JOIN Diemdanh D ON D.maHS = ct.maHS AND D.maLop = ct.maLop AND D.ngayHoc = ? " +
                "WHERE lh.tenLop = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(querysql);
            statement.setString(2, tenLop);

            if (ngay != null) {
                java.sql.Date sqlDate = new java.sql.Date(ngay.getTime());
                statement.setDate(1, sqlDate);
            } else {
                statement.setNull(1, java.sql.Types.DATE);
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                HocSinh hs = new HocSinh();
                diemDanh dd = new diemDanh();
                hs.setMaHS(resultSet.getString("maHS"));
                hs.setHoTen(resultSet.getString("hoTen"));
                hs.setNgaySinh(resultSet.getDate("ngaySinh"));
                dd.setTrangThai(resultSet.getBoolean("trangThai"));
                listHocSinh.add(hs);
                listDiemDanh.add(dd);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi lấy danh sách điểm danh từ cơ sở dữ liệu!");
        }
    }


    public void capNhatDiemDanh(diemDanh dd){
                String query = "UPDATE Diemdanh SET trangThai = ? WHERE maHS = ? AND ngayHoc = ? AND maLop = ? ";
                //String query = " INSERT INTO Diemdanh(trangThai,maLop, maHS,ngayHoc ) VALUES (?,?,?,?) ";
        try {

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setBoolean(1, dd.isTrangThai());
            statement.setString(4, dd.getMaLop());
            statement.setString(2, dd.getMaHS());
           // statement.setDate(4, (java.sql.Date) dd.getNgayHoc());
      statement.setDate(3, dd.getNgayHoc() != null ? new java.sql.Date(dd.getNgayHoc().getTime()) : null);

            statement.executeUpdate();

          //  JOptionPane.showMessageDialog(null, "Cập nhật thông tin điểm dang thành công!");

            statement.close();
        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi cập nhật dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    public void creatDiemDanh(diemDanh td){
             String query = " INSERT INTO Diemdanh(trangThai,ngayHoc,maHS,maLop ) VALUES (?,?,?,?) ";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            //statement.setString(1, nk.getMaNienKhoa());
            statement.setBoolean(1, td.isTrangThai());
             statement.setDate(2, td.getNgayHoc() != null ? new java.sql.Date(td.getNgayHoc().getTime()) : null);
             statement.setString(3, td.getMaHS());
             statement.setString(4, td.getMaLop());
            statement.executeUpdate();
            //JOptionPane.showMessageDialog(null, " Tạo Điểm Danh ");
            statement.close();

        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    public boolean isNgayHocExists(Date ngayHoc , String maLop){
        String query = "SELECT COUNT(*) FROM Diemdanh WHERE ngayHoc = ? AND maLop = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
//             java.sql.Date sqlDate = new java.sql.Date(ngayHoc.getTime());
//            statement.setDate(1, sqlDate);
               if (ngayHoc != null) {
                java.sql.Date sqlDate = new java.sql.Date(ngayHoc.getTime());
                statement.setDate(1, sqlDate);
            } else {
                statement.setNull(1, java.sql.Types.DATE);
            }
               statement.setString(2, maLop);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
             String errorMessage = "Lỗi khi Kiểm tra ngayHoc : " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
        return false;
    }
    
        public int countTrueDD(Chitiethocsinh ct , hocPhi hp){
       int count = 0;
     String sql = "SELECT COUNT(*) AS toTal " +
             "FROM Diemdanh " +
             "WHERE trangThai = 1 AND ngayHoc BETWEEN ? AND ?  AND maHS = ? AND maLop = ?";

        try {
            
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            // Tạo PreparedStatement để thực hiện truy vấn
            
          
           
            preparedStatement.setDate(1, new java.sql.Date(hp.getNgayBatDau().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(hp.getNgayKetThuc().getTime()));

           // preparedStatement.setDate(2, ngayKT != null ? new java.sql.Date(ngayKT.getTime()) : null);

            preparedStatement.setString(3, ct.getMaHS());
          
            preparedStatement.setString(4, ct.getMaLop());
            
            
            // Thực hiện truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                 count = resultSet.getInt("toTal");
                 System.out.println("Giá trị " + count);
                
            }
            resultSet.close();
            preparedStatement.close();
            
            

            
        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi lấy dữ liệu số buổi đi học : " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
       return count;
    }
    public void deleteDiemDanh(Chitiethocsinh ct){
                  String deleteQuery = "DELETE FROM Diemdanh WHERE maLop = ? AND maHS = ?";
                try {
            PreparedStatement statement = conn.prepareStatement(deleteQuery);
            statement.setString(1,ct.getMaLop() );
            statement.setString(2,ct.getMaHS() );

            statement.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Xóa Phân công thành công ");
            statement.close();
                    
        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi xóa dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
