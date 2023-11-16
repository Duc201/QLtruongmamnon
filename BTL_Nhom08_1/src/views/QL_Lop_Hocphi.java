/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controller.Controller_NienKhoa;
import controller.Controller_QlDsLop;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Chitiethocsinh;
import models.HocSinh;
import models.chiTietHocPhi;
import models.hocPhi;

/**
 *
 * @author Duc
 */

public class QL_Lop_Hocphi extends javax.swing.JFrame {
    private  DefaultTableModel tableModel;
    /**
     * Creates new form QL_LOP_HOCPHI
     */
    public QL_Lop_Hocphi() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        new Controller_NienKhoa().LayDanhSachNamHoc(ComboBoxNienKhoa);
        String namHoc = ComboBoxNienKhoa.getSelectedItem().toString();
        
        new Controller_QlDsLop().layDanhSachLopHoc(namHoc, ComboboxLopHoc);
        new controller.Controller_HocPhi().layDanhSachHocPhi(namHoc, ComboboxHocPhi);
        String maLop = new Controller_QlDsLop().layMaLopHoc(ComboboxLopHoc.getSelectedItem().toString(),ComboBoxNienKhoa.getSelectedItem().toString());
        int maHP = new controller.Controller_HocPhi().layMaHocPhichung(ComboboxHocPhi.getSelectedItem().toString(),ComboBoxNienKhoa.getSelectedItem().toString() );
        
        if( ! new controller.Controller_HocPhi().isHocPhiExists(maHP, maLop)){
            creatChiTietHocPhi();
        }
        else{
            UpdateChiTietHocPhi();
        }
        
        creatTable();
        updateTable();
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnTao = new javax.swing.JButton();
        ComboBoxNienKhoa = new javax.swing.JComboBox<>();
        ComboboxLopHoc = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        ComboboxHocPhi = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnTao.setText("Tìm Kiếm");
        btnTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoActionPerformed(evt);
            }
        });

        ComboBoxNienKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxNienKhoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxNienKhoaItemStateChanged(evt);
            }
        });

        ComboboxLopHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboboxLopHoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboboxLopHocItemStateChanged(evt);
            }
        });

        jLabel11.setText("Năm học");

        jLabel12.setText("Lớp Học");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("HỌC PHÍ");

        jLabel7.setText("Tên Học Phí");

        ComboboxHocPhi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboboxHocPhi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboboxHocPhiItemStateChanged(evt);
            }
        });

        jButton1.setText("Xuất File");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(43, 43, 43)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ComboBoxNienKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComboboxLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboboxHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(408, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(ComboBoxNienKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboboxLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ComboboxHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTao)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxNienKhoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxNienKhoaItemStateChanged
                if (ComboBoxNienKhoa.getSelectedItem() != null) {
            String namHoc = ComboBoxNienKhoa.getSelectedItem().toString();
           // connectedDB.layDanhSachLopHoc(namHoc, ComboboxLopHoc);
                    new Controller_QlDsLop().layDanhSachLopHoc(namHoc, ComboboxLopHoc);
                    new controller.Controller_HocPhi().layDanhSachHocPhi(namHoc, ComboboxHocPhi);

            //updateTable();
        }
    }//GEN-LAST:event_ComboBoxNienKhoaItemStateChanged

    private void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoActionPerformed
     //  creatHocPhi();
 
    }//GEN-LAST:event_btnTaoActionPerformed

    private void ComboboxLopHocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboboxLopHocItemStateChanged

//if( ! new controller.Controller_HocPhi().isHocPhiExists(new controller.Controller_HocPhi().layMaHocPhichung(ComboboxHocPhi.getSelectedItem().toString(),ComboBoxNienKhoa.getSelectedItem().toString() ), new Controller_QlDsLop().layMaLopHoc(ComboboxLopHoc.getSelectedItem().toString(),ComboBoxNienKhoa.getSelectedItem().toString()))){
//            creatChiTietHocPhi();
//       }
        creatTable();
       updateTable();
    }//GEN-LAST:event_ComboboxLopHocItemStateChanged

    private void ComboboxHocPhiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboboxHocPhiItemStateChanged
      if( ! new controller.Controller_HocPhi().isHocPhiExists(new controller.Controller_HocPhi().layMaHocPhichung(ComboboxHocPhi.getSelectedItem().toString(),ComboBoxNienKhoa.getSelectedItem().toString() ), new Controller_QlDsLop().layMaLopHoc(ComboboxLopHoc.getSelectedItem().toString(),ComboBoxNienKhoa.getSelectedItem().toString()))){
            creatChiTietHocPhi();
       }
      else{
          UpdateChiTietHocPhi();
      }
        creatTable();
        updateTable();
    }//GEN-LAST:event_ComboboxHocPhiItemStateChanged

     private void creatTable(){
         tableModel = (DefaultTableModel) jTable1.getModel();        // viet them
         tableModel.setColumnIdentifiers(new Object[]{               // tao cac thuoc tinh ten cua cot trong bang
         "Mã Học Sinh", "Tên Học Sinh " ,"Ngày Bắt Đầu","Ngày Kết Thúc","Số Buổi"," Giá 1 Buổi "," Tổng " 
        });
    }
     private void updateTable(){
             List<HocSinh> listHS = new ArrayList<>();
             List<hocPhi> listHP = new ArrayList<>();
             List<chiTietHocPhi> listCTHP = new ArrayList<>();
             int maHP = new controller.Controller_HocPhi().layMaHocPhichung(ComboboxHocPhi.getSelectedItem().toString(),ComboBoxNienKhoa.getSelectedItem().toString() );
             String maLop = new Controller_QlDsLop().layMaLopHoc(ComboboxLopHoc.getSelectedItem().toString(),ComboBoxNienKhoa.getSelectedItem().toString());
             new controller.Controller_HocPhi().getListHocPhi1Lop(listHS,listHP,listCTHP,maLop,maHP);
            tableModel.setRowCount(0);
         for (int i = 0; i < listHS.size(); i++) {
             HocSinh hs = listHS.get(i);
             hocPhi hp = listHP.get(i);
             chiTietHocPhi cthp = listCTHP.get(i);
             System.out.println();

      
        Object[] rowData = {
            hs.getMaHS(),
            hs.getHoTen(),
            hp.getNgayBatDau(),
            hp.getNgayKetThuc(),
            cthp.getSoBua(),
            hp.getHocPhi1Bua(),
            cthp.getTong(),
            
        };
         tableModel.addRow(rowData);    
        }

     }

     
     private void creatChiTietHocPhi(){
     List<HocSinh> listHocSinh = new ArrayList<>();
     List<Chitiethocsinh> listCTHS = new ArrayList<>();
     List<chiTietHocPhi> listCTHP = new ArrayList<>();
     hocPhi hp = new hocPhi();
     int maHPChung = new controller.Controller_HocPhi().layMaHocPhichung(ComboboxHocPhi.getSelectedItem().toString(), ComboBoxNienKhoa.getSelectedItem().toString());
      
     new controller.Controller_HocPhi().getHocPhi( maHPChung,hp);
         
     
     String maLop = new Controller_QlDsLop().layMaLopHoc(ComboboxLopHoc.getSelectedItem().toString(),ComboBoxNienKhoa.getSelectedItem().toString());
     new controller.Controller_QLLop_DanhGia().layDachSachHocSinh1Lop(maLop, listHocSinh, listCTHS);
             for (HocSinh hs : listHocSinh){
            for(Chitiethocsinh cths :listCTHS )
            {
                if(hs.getMaHS().equals(cths.getMaHS())){
                            chiTietHocPhi cthp = new chiTietHocPhi();
                            cthp.setMaHS(hs.getMaHS());
                            cthp.setMaLop(cths.getMaLop());
                            cthp.setMaHP(maHPChung);
                            cthp.setSoBua(new controller.Controller_DiemDanh().countTrueDD(cths, hp));
                            cthp.setTong(cthp.getSoBua()*hp.getHocPhi1Bua());
                       new controller.Controller_HocPhi().addHP1(cthp);
//System.out.println(" MaHocSinh: " + cthp.getMaHS() + " Ma Lop " + cthp.getMaLop() + " Ma Hoc Phi " + cthp.getMaHP() + " So Bua " + cthp.getSoBua() + " Tong " + cthp.getTong());

                } 
            }
        }
     }
     private void UpdateChiTietHocPhi(){
     List<HocSinh> listHocSinh = new ArrayList<>();
     List<Chitiethocsinh> listCTHS = new ArrayList<>();
     List<chiTietHocPhi> listCTHP = new ArrayList<>();
     hocPhi hp = new hocPhi();
     int maHPChung = new controller.Controller_HocPhi().layMaHocPhichung(ComboboxHocPhi.getSelectedItem().toString(), ComboBoxNienKhoa.getSelectedItem().toString());
      
     new controller.Controller_HocPhi().getHocPhi( maHPChung,hp);
         
     
     String maLop = new Controller_QlDsLop().layMaLopHoc(ComboboxLopHoc.getSelectedItem().toString(),ComboBoxNienKhoa.getSelectedItem().toString());
     new controller.Controller_QLLop_DanhGia().layDachSachHocSinh1Lop(maLop, listHocSinh, listCTHS);
             for (HocSinh hs : listHocSinh){
            for(Chitiethocsinh cths :listCTHS )
            {
                if(hs.getMaHS().equals(cths.getMaHS())){
                            chiTietHocPhi cthp = new chiTietHocPhi();
                            cthp.setMaHS(hs.getMaHS());
                            cthp.setMaLop(cths.getMaLop());
                            cthp.setMaHP(maHPChung);
                            cthp.setSoBua(new controller.Controller_DiemDanh().countTrueDD(cths, hp));
                            cthp.setTong(cthp.getSoBua()*hp.getHocPhi1Bua());
                       new controller.Controller_HocPhi().updateHP1(cthp);
//System.out.println(" MaHocSinh: " + cthp.getMaHS() + " Ma Lop " + cthp.getMaLop() + " Ma Hoc Phi " + cthp.getMaHP() + " So Bua " + cthp.getSoBua() + " Tong " + cthp.getTong());

                } 
            }
        }
     }

    

     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QL_Lop_Hocphi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_Lop_Hocphi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_Lop_Hocphi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_Lop_Hocphi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_Lop_Hocphi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxNienKhoa;
    private javax.swing.JComboBox<String> ComboboxHocPhi;
    private javax.swing.JComboBox<String> ComboboxLopHoc;
    private javax.swing.JButton btnTao;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}