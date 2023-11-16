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
import models.Chitiethocsinh;
import models.HocSinh;

/**
 *
 * @author Duc
 */
public class Controller_QLLop_DanhGia extends ConnectDB{

    public void layDachSachHocSinh1Lop(String maLop, List<HocSinh> listHocSinh, List<Chitiethocsinh> listChiTiet) {
        String query = "SELECT hs.maHS, hs.hoTen, lh.maLop, cth.danhGia "
                + "FROM Hocsinh hs "
                + "INNER JOIN Chitiethocsinh cth ON hs.maHS = cth.maHS "
                + "INNER JOIN Lophoc lh ON cth.maLop = lh.maLop "
                + "WHERE lh.maLop = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, maLop);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                HocSinh hs = new HocSinh();
                Chitiethocsinh ct = new Chitiethocsinh();
                hs.setMaHS(resultSet.getString("maHS"));
                ct.setMaHS(resultSet.getString("maHS"));
                hs.setHoTen(resultSet.getString("hoTen"));
                ct.setMaLop(resultSet.getString("maLop"));
                ct.setDanhGia(resultSet.getString("danhGia"));
                listHocSinh.add(hs);
                listChiTiet.add(ct);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi lấy danh sách đánh giá từ cơ sở dữ liệu!");
        }
    }

    public void updateDanhGiaDB(Chitiethocsinh hs) {
        String sqlUpdate = "UPDATE Chitiethocsinh SET danhGia = ? WHERE maHS = ? AND maLop = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sqlUpdate);

            statement.setString(1, hs.getDanhGia());
            statement.setString(2, hs.getMaHS());
            statement.setString(3, hs.getMaLop());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật thông tin đánh giá thành công!");

            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật thông tin thực đơn!");
        }
    }
}
    
//    public String layMaLop(String tenLop){
//        String maLop = " ";
//        
//        String query = " SELECT maLop FROM Lophoc WHERE tenLop = ? ";
//            try {
//            PreparedStatement statement = conn.prepareStatement(query);
//            statement.setString(1, tenLop);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {           
//                maLop = resultSet.getString("maLop");
//            }
//
//            resultSet.close();
//            statement.close();
//           
//            
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Lỗi khi lấy Mã Lớp từ cơ sở dữ liệu!");
//        }
//                
//                
//        return maLop;
//    }
 

//neu su dung removeItem cho cmb lớp học thì nó xóa hết tất cả các item mỗi lần mình chọn vào 1 mục trên cmbNiên khóa -> dẫn đến cái bảng nó bị NULL
// CÒn nếu chọn cái kia thì cứ mỗi lần trỏ vào đấy nó sẽ tạo một mô hình mới cho mình 
