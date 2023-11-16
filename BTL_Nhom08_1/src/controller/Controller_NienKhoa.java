/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import models.NienKhoa;

/**
 *
 * @author Duc
 */

public class Controller_NienKhoa extends ConnectDB{
    public List<NienKhoa> getListNK (){
        List<NienKhoa> list = new ArrayList<>();
        
        String query = " SELECT *FROM Nienkhoa";
        
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rel = statement.executeQuery();
            while(rel.next()){
                NienKhoa nk = new NienKhoa();
                nk.setMaNienKhoa(rel.getString("maNienKhoa"));
                nk.setNamHoc(rel.getString("namHoc"));
                nk.setNgayBatDau(rel.getDate("ngayBD"));
                nk.setNgayKetThuc(rel.getDate("ngayKT"));
                list.add(nk);
            }
            statement.close();
            rel.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi không lấy được danh sách Niên Khóa!");
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
                String tenNam = resultSet.getString("namHoc");
                comboBoxModel.addElement(tenNam);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi lấy danh sách năm học từ cơ sở dữ liệu!");
        }
    }
    public void addNienKhoa(NienKhoa nk){
        String query = " INSERT INTO Nienkhoa(maNienKhoa,namHoc,ngayBD,ngayKT ) VALUES (?,?,?,?) ";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nk.getMaNienKhoa());
            statement.setString(2, nk.getNamHoc());
            statement.setDate(3,new Date(nk.getNgayBatDau().getTime()));
            statement.setDate(4,new Date(nk.getNgayKetThuc().getTime()));
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, " Thêm niên khóa thành công");
            statement.close();

        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    public void repairNienKhoa(NienKhoa nk){
        String query = " UPDATE NienKhoa SET namHoc = ?, ngayBD = ?, ngayKT= ? WHERE maNienKhoa = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nk.getNamHoc());
            statement.setDate(2, new Date(nk.getNgayBatDau().getTime()));
            statement.setDate(3, new Date(nk.getNgayKetThuc().getTime()));
            statement.setString(4, nk.getMaNienKhoa());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật niên khóa thành công ");
            statement.close();
        } catch (SQLException ex) {
            String errorMessage = "Lỗi khi thêm dữ liệu: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }                
    }

    public void deleteNienKhoa( String maNienKhoa) {
       String query = " DELETE FROM NienKhoa WHERE maNienKhoa = ? ";
       
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,maNienKhoa );
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa Niên Khóa thành công ");
            statement.close();
            
        } catch (SQLException ex) {
             ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa Niên Khóa!");
        }
    }
}
