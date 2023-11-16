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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import models.LopHoc;
import models.NienKhoa;

/**
 *
 * @author Duc
 */
public class Controller_QlDsLop extends ConnectDB{
    
    public int getCountStudent(String maLop){
        String query = "SELECT COUNT(*) AS Total FROM Chitiethocsinh WHERE maLop = ? ";
        int totalCount = 0;
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, maLop);
            ResultSet rel = statement.executeQuery();
           
            while(rel.next()){
                totalCount = rel.getInt("Total");
            }
         statement.close();
         rel.close();
        } catch (Exception e) {
             e.printStackTrace();
        }
        
       return totalCount;
    }
    
    
    public ArrayList<LopHoc> getListLopHocFollowNamHoc(String namHoc) {
        ArrayList<LopHoc> list = new ArrayList<>();
        String query = "SELECT lh.maLop, lh.tenLop, COUNT(cths.maHS) AS siSo, lh.maNienKhoa " +
                           "FROM Lophoc lh " +
                           "LEFT JOIN Chitiethocsinh cths ON lh.maLop = cths.maLop " +
                           "INNER JOIN Nienkhoa nk ON lh.maNienKhoa = nk.maNienKhoa " +
                           "WHERE nk.namHoc = ? " + 
                           "GROUP BY lh.maLop, lh.tenLop, lh.maNienKhoa";
                            
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, namHoc);
            ResultSet rel = statement.executeQuery();
            
            while(rel.next()){
                LopHoc lh = new LopHoc();
                lh.setMaLop(rel.getString("maLop"));
                lh.setTenLop(rel.getString("tenLop"));
                lh.setSiSo(rel.getInt("siSo"));
                lh.setMaNienKhoa(rel.getString("maNienKhoa"));
                list.add(lh);
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
    
    public ArrayList<LopHoc> getListLopHoc() {
        ArrayList<LopHoc> list = new ArrayList<>();
        String query = "SELECT lh.maLop, lh.tenLop, COUNT(cths.maHS) AS siSo, lh.maNienKhoa " +
                           "FROM Lophoc lh " +
                           "LEFT JOIN Chitiethocsinh cths ON lh.maLop = cths.maLop " +
                           "GROUP BY lh.maLop, lh.tenLop, lh.maNienKhoa";
                            
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rel = statement.executeQuery();
            
            while(rel.next()){
                LopHoc lh = new LopHoc();
                lh.setMaLop(rel.getString("maLop"));
                lh.setTenLop(rel.getString("tenLop"));
                lh.setSiSo(rel.getInt("siSo"));
                lh.setMaNienKhoa(rel.getString("maNienKhoa"));
                list.add(lh);
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
    
      public void LayDanhSachNamHoc(JComboBox<String> cmbNamHoc) {
        String query = "SELECT namHoc FROM Nienkhoa";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
            cmbNamHoc.setModel(comboBoxModel);
          
            while (resultSet.next()) {
                String namHoc = resultSet.getString("namHoc");
                comboBoxModel.addElement(namHoc);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi lấy danh sách lớp học từ cơ sở dữ liệu!");
        }
    }
      
      public String layMaNienKhoa( String namHoc){
          String query = "SELECT maNienKhoa FROM Nienkhoa WHERE namHoc = ?";
          
          String maNienKhoa = " ";
          try{
              PreparedStatement statement = conn.prepareStatement(query);
              statement.setString(1, namHoc);
              
              ResultSet resultSet = statement.executeQuery();
              
                while (resultSet.next()) {
               maNienKhoa = resultSet.getString("maNienKhoa");

            }
                
          }
          catch(SQLException ex){
              String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
          }
          
          return maNienKhoa;
      }
      
      
       public String layMaLopHoc( String tenLopHoc , String tenNamHoc){
          String query = "SELECT lh.maLop " + 
                  "FROM Lophoc lh " +
                  "INNER JOIN NienKhoa nk ON nk.maNienKhoa = lh.maNienKhoa "+
                  "WHERE lh.tenLop = ? AND nk.namHoc = ? ";
          
        String maLopHoc = "";
          try{
              PreparedStatement statement = conn.prepareStatement(query);
              statement.setString(1, tenLopHoc);
               statement.setString(2, tenNamHoc);
              
              ResultSet resultSet = statement.executeQuery();
              
                while (resultSet.next()) {
               maLopHoc = resultSet.getString("maLop");
            }
                
          }
          catch(SQLException ex){
              String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
          }
          
          return maLopHoc;
      }
       
        public void layDanhSachLopHoc(String namHoc, JComboBox<String> cmbLopHoc) {
        String query = "SELECT Lophoc.tenLop FROM Lophoc "
                + "INNER JOIN Nienkhoa ON Lophoc.maNienKhoa = Nienkhoa.maNienKhoa "
                + "WHERE Nienkhoa.namHoc = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, namHoc);
            ResultSet resultSet = statement.executeQuery();

            // Tạo một model mới cho combobox và thiết lập cho combobox , giúp tách biệt truy vấn và giao diện
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
            cmbLopHoc.setModel(comboBoxModel);

            while (resultSet.next()) {
                String tenLop = resultSet.getString("tenLop");
                comboBoxModel.addElement(tenLop);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi lấy danh sách lớp học từ cơ sở dữ liệu!");
        }
    }
    public void themLopHoc(LopHoc lh,String namHoc){
      
        String query = "INSERT INTO LopHoc(maLop,tenLop,siSo,maNienKhoa) VALUES(?,?,?,?)";
         try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, lh.getMaLop());
            statement.setString(2, lh.getTenLop());
            statement.setInt(3,lh.getSiSo() );
            statement.setString(4, lh.getMaNienKhoa());
            
            statement.executeUpdate();
             JOptionPane.showMessageDialog(null, " Thêm thành công");
            statement.close();
                   
        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    public void capnhatLopHoc(LopHoc lh){
        String query = " UPDATE LopHoc SET tenLop = ? , siSo = ?, maNienKhoa = ? WHERE maLop = ?";
        
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, lh.getTenLop());
            statement.setInt(2,lh.getSiSo() );
            statement.setString(3, lh.getMaNienKhoa());
            statement.setString(4, lh.getMaLop());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            statement.close();
        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
   public void deleteLopHoc(String maLop){
               String query = " DELETE FROM LopHoc WHERE maLop = ? ";
       
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,maLop );
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa Niên Khóa thành công ");
            statement.close();
            
        } catch (SQLException ex) {
             ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa thực đơn!");
        }
    }
}
