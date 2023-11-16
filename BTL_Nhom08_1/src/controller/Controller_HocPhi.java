/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import models.Chitiethocsinh;
import models.HocSinh;
import models.chiTietHocPhi;
import models.hocPhi;

/**
 *
 * @author Duc
 */
public class Controller_HocPhi extends ConnectDB{
    
    public ArrayList<hocPhi> getListHocPhiFollowNamHoc( String namHoc){
        
        ArrayList<hocPhi> list = new ArrayList<>();
        String query = "SELECT * "+
                        "FROM HocPhi hp "+
                        "INNER JOIN  Nienkhoa nk ON hp.maNienKhoa = nk.maNienKhoa " +
                        "WHERE nk.namHoc = ? ";
                            
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, namHoc);
            ResultSet rel = statement.executeQuery();
            
            while(rel.next()){
                hocPhi hp = new hocPhi();
                hp.setMaHocPhi(rel.getInt("maHP"));
                hp.setTenHocPhi(rel.getString("tenHP"));
                hp.setNgayBatDau(rel.getDate("ngayBatDau"));
                hp.setNgayKetThuc(rel.getDate("ngayKetThuc"));
                hp.setHocPhi1Bua(rel.getFloat("hocPhi1Bua"));
                hp.setMaNienKhoa(rel.getString("maNienKhoa"));
                list.add(hp);
            }
            statement.close();
            rel.close();
        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi lấy dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return list;
        
        
    }
    
       public void themHocPhi(hocPhi hp){
      
           String query = " INSERT INTO HocPhi(tenHP,ngayBatDau,ngayKetThuc,hocPhi1Bua,maNienKhoa ) VALUES (?,?,?,?,?) ";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            //statement.setString(1, nk.getMaNienKhoa());
            statement.setString(1, hp.getTenHocPhi());
            statement.setDate(2, new Date(hp.getNgayBatDau().getTime()));
            statement.setDate(3, new Date(hp.getNgayKetThuc().getTime()));
            statement.setDouble(4, hp.getHocPhi1Bua());
            statement.setString(5, hp.getMaNienKhoa());
            statement.executeUpdate();
            //JOptionPane.showMessageDialog(null, " Tạo Điểm Danh ");
            statement.close();

        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
        public void capNhatHocPhi(hocPhi hp){
        String query = " UPDATE HocPhi SET tenHP = ? , ngayBatDau = ?, ngayKetThuc = ? , hocPhi1Bua = ? ,maNienKhoa = ? WHERE maHP = ?  ";
        
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setString(1, hp.getTenHocPhi());
            statement.setDate(2, new Date(hp.getNgayBatDau().getTime()));
            statement.setDate(3, new Date(hp.getNgayKetThuc().getTime()));
            statement.setDouble(4, hp.getHocPhi1Bua());
            statement.setString(5, hp.getMaNienKhoa());
            statement.setInt(6, hp.getMaHocPhi());

            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            statement.close();
        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
        public void deleteHocPhi( String maHocPhi) {
       String query = " DELETE FROM HocPhi WHERE maHP = ? ";
       
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,maHocPhi );
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa Học Phí thành công ");
            statement.close();
            
        } catch (SQLException ex) {
             ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa Học Phí!");
        }
    }
        
        public void layDanhSachHocPhi(String namHoc, JComboBox<String> cmbHocPhi) {
        String query = "SELECT HocPhi.tenHP FROM HocPhi "
                + "INNER JOIN Nienkhoa ON HocPhi.maNienKhoa = Nienkhoa.maNienKhoa "
                + "WHERE Nienkhoa.namHoc = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, namHoc);
            ResultSet resultSet = statement.executeQuery();

            // Tạo một model mới cho combobox và thiết lập cho combobox , giúp tách biệt truy vấn và giao diện
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
            cmbHocPhi.setModel(comboBoxModel);

            while (resultSet.next()) {
                String tenHocPhi = resultSet.getString("tenHP");
                comboBoxModel.addElement(tenHocPhi);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi lấy danh sách học phí từ cơ sở dữ liệu!");
        }
    }
        
        
        
     public int layMaHocPhichung( String tenHocPhi , String tenNamHoc){
          String query = "SELECT hp.maHP " + 
                  "FROM HocPhi hp " +
                  "INNER JOIN NienKhoa nk ON nk.maNienKhoa = hp.maNienKhoa "+
                  "WHERE hp.tenHP = ? AND nk.namHoc = ? ";
          
        int maHocPhi = 0;
          try{
              PreparedStatement statement = conn.prepareStatement(query);
              statement.setString(1, tenHocPhi);
               statement.setString(2, tenNamHoc);
              
              ResultSet resultSet = statement.executeQuery();
              
                while (resultSet.next()) {
                maHocPhi = resultSet.getInt("maHP");
            }
                
          }
          catch(SQLException ex){
              String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
          }
          
          return maHocPhi;
      }

    public void getHocPhi(int maHPChung, hocPhi hp) {
       String query = "SELECT * "+
               "FROM HocPhi " +
               "WHERE maHP = ? ";
       
                 try{
              PreparedStatement statement = conn.prepareStatement(query);
              statement.setInt(1, maHPChung);
               
              
              ResultSet resultSet = statement.executeQuery();
            
                while (resultSet.next()) {
                    
                hp.setMaHocPhi(resultSet.getInt("maHP"));
                hp.setTenHocPhi(resultSet.getString("tenHP"));
                hp.setNgayBatDau(resultSet.getDate("ngayBatDau"));
                hp.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
                hp.setHocPhi1Bua(resultSet.getDouble("hocPhi1Bua"));
                hp.setMaNienKhoa(resultSet.getString("maNienKhoa"));
            }
                
          }
          catch(SQLException ex){
              String errorMessage = "Lỗi khi lấy dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
          }
               
    }

    public void addHP1(chiTietHocPhi cthp) {
            String query = " INSERT INTO Chitiethocphi(maHS,maLop,maHP,soBua,tong ) VALUES (?,?,?,?,?)";
         //  System.out.println(" MaHocSinh: " + cthp.getMaHS() + " Ma Lop " + cthp.getMaLop() + " Ma Hoc Phi " + cthp.getMaHP() + " So Bua " + cthp.getSoBua() + " Tong " + cthp.getTong());

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, cthp.getMaHS());
            statement.setString(2, cthp.getMaLop());
            statement.setInt(3, cthp.getMaHP());
            statement.setInt(4, cthp.getSoBua());
            statement.setDouble(5, cthp.getTong());
            statement.executeUpdate();
        
            statement.close();

        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
        public boolean isHocPhiExists(int maHP , String maLop){
        String query = "SELECT COUNT(*) FROM Chitiethocphi WHERE maHP = ? AND maLop = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);

               
                statement.setInt(1, maHP);
            
               statement.setString(2, maLop);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
             String errorMessage = "Lỗi khi Kiểm tra Học Phí : " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
        return false;
    }

    public void getListHocPhi1Lop(List<HocSinh> listHS, List<hocPhi> listHP, List<chiTietHocPhi> listCTHP, String maLop , int maHP) {
       
        String query = "SELECT hs.maHS, hs.hoTen, hp.ngayBatDau, hp.ngayKetThuc, hp.hocPhi1Bua, cthp.soBua, cthp.tong " +
                "FROM Chitiethocphi cthp " +
                "INNER JOIN HocPhi hp ON hp.maHP = cthp.maHP " +
                "INNER JOIN Chitiethocsinh cths ON cths.maHS = cthp.maHS AND cths.maLop = cthp.maLop " +
                "INNER JOIN HocSinh hs ON hs.maHS = cths.maHS " +
                "INNER JOIN LopHoc lh ON lh.maLop = cths.maLop "+
                "WHERE lh.maLop = ? AND hp.maHP = ? ";

                try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, maLop);
            statement.setInt(2, maHP);
            
                
          
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                HocSinh hs = new HocSinh();
                hocPhi hp = new hocPhi();
                chiTietHocPhi cthp = new chiTietHocPhi();
                
                hs.setMaHS(resultSet.getString("maHS"));
                hs.setHoTen(resultSet.getString("hoTen"));
                hp.setNgayBatDau(resultSet.getDate("ngayBatDau"));
                hp.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
                hp.setHocPhi1Bua(resultSet.getDouble("hocPhi1Bua"));
                cthp.setSoBua(resultSet.getInt("soBua"));
                cthp.setTong(resultSet.getDouble("tong"));
                
                listHS.add(hs);
                listHP.add(hp);
                listCTHP.add(cthp);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi lấy danh sách học phí lớp từ cơ sở dữ liệu!");
        }
        
    }

    public void updateHP1(chiTietHocPhi cthp) {
                   String query = " UPDATE Chitiethocphi SET soBua = ? ,tong = ? WHERE maHS = ? AND maLop = ? AND maHP = ? ";
         //  System.out.println(" MaHocSinh: " + cthp.getMaHS() + " Ma Lop " + cthp.getMaLop() + " Ma Hoc Phi " + cthp.getMaHP() + " So Bua " + cthp.getSoBua() + " Tong " + cthp.getTong());

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(3, cthp.getMaHS());
            statement.setString(4, cthp.getMaLop());
            statement.setInt(5, cthp.getMaHP());
            statement.setInt(1, cthp.getSoBua());
            statement.setDouble(2, cthp.getTong());
            statement.executeUpdate();
        
            statement.close();

        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi cập nhật dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
        public void deleteHP1(Chitiethocsinh ct){
                  String deleteQuery = "DELETE FROM Chitiethocphi WHERE maLop = ? AND maHS = ?";
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
