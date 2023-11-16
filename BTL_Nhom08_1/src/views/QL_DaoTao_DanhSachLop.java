/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controller.Controller_QlDsLop;
import controller.Controller_ThucDon;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.LopHoc;
import models.ThucDon;

/**
 *
 * @author Duc
 */
public class QL_DaoTao_DanhSachLop extends javax.swing.JFrame {

    /**
     * Creates new form QL_DaoTao_DanhSachLop
     */
    private DefaultTableModel tableModel;
    private List<LopHoc> listLopHocs;
    private int selecRow = -1;
    
    public QL_DaoTao_DanhSachLop() {
        initComponents();
        this.setLocationRelativeTo(null);
        new Controller_QlDsLop().LayDanhSachNamHoc(comboBoxNienKhoa);
        taoBang();
        //taoMaLopHoc();
        txtMaLopHoc.setEnabled(false);
        txtMaNamHoc.setEnabled(false);
        clearText();
        txtSiSo.setEnabled(false);
    }
    
    public void taoBang(){
        
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.setColumnIdentifiers(new Object[]{
        "Mã Lớp Học", " Tên lớp học " , " Sĩ Số ", " Mã Niên Khóa"
    });
    }
    public void capNhatBang(){
          if (tableModel == null) {
        taoBang();
    }
        tableModel.setRowCount(0);
       
        String namHoc = comboBoxNienKhoa.getSelectedItem().toString();
        System.out.println(namHoc);
        listLopHocs = new Controller_QlDsLop().getListLopHocFollowNamHoc(namHoc);
        for(LopHoc lh : listLopHocs){
            Object[] rowData = {lh.getMaLop(), lh.getTenLop(), lh.getSiSo() , lh.getMaNienKhoa() };
            tableModel.addRow(rowData);
        }
    }
     public void taoMaLopHoc() {
        // Them đoạn code này để cập nhật lại day sach thuc don xac dinh gia tri ID tiep theo
         listLopHocs = new Controller_QlDsLop().getListLopHoc();
        int id = 1;
        boolean state;
        while (true) {
            state = false;
            for (LopHoc lh : listLopHocs) {
                if (lh.getMaLop().equals("LH" + id)) {
                    state = true;
                    break;
                }
            }
            if (!state) {
                break;
            }
            ++id;
        }
        txtMaLopHoc.setText("LH" + id);
    }
    public void clearText(){
        taoMaLopHoc();
        txtTenLopHoc.setText("");
        txtSiSo.setText("0");
       capNhatBang();
        
    }
    public void themLopHoc(){
        LopHoc lh = new LopHoc();
        lh.setMaLop(txtMaLopHoc.getText());
        lh.setTenLop(txtTenLopHoc.getText());
        lh.setSiSo(Integer.parseInt(txtSiSo.getText())); // chuyen du lieu text ve int
        lh.setMaNienKhoa(txtMaNamHoc.getText());
        String namHoc = comboBoxNienKhoa.getSelectedItem().toString();
        new Controller_QlDsLop().themLopHoc(lh,namHoc);
       // capNhatBang();
        clearText();
    }
    public void capNhatLopHoc(){
        LopHoc lh = new LopHoc();
        lh.setMaLop(txtMaLopHoc.getText());
        lh.setTenLop(txtTenLopHoc.getText());
        lh.setSiSo(Integer.parseInt(txtSiSo.getText())); // chuyen du lieu text ve int
        lh.setMaNienKhoa(txtMaNamHoc.getText());
        
        new Controller_QlDsLop().capnhatLopHoc(lh);
        //capNhatBang();
        clearText();
    }
    public void xoaLopHoc(){
         selecRow = table.getSelectedRow();
        if (selecRow != -1) {
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn lớp học này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
              
                new Controller_QlDsLop().deleteLopHoc(txtMaLopHoc.getText());
            
                clearText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một lớp để xóa!");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        txtMaLopHoc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaNamHoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSiSo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenLopHoc = new javax.swing.JTextField();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        comboBoxNienKhoa = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLayeredPane1.setLayout(new java.awt.FlowLayout());

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnXoa);

        btnCapNhat.setText("Sửa");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnCapNhat);

        btnLamMoi.setText("Làm Mới");
        jLayeredPane1.add(btnLamMoi);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnThem);

        jLayeredPane2.setAlignmentX(2.0F);
        jLayeredPane2.setAlignmentY(2.0F);
        jLayeredPane2.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 32, 0, 6);
        jLayeredPane2.add(txtMaLopHoc, gridBagConstraints);

        jLabel6.setText("Mã Niên Khóa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
        jLayeredPane2.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 32, 0, 16);
        jLayeredPane2.add(txtMaNamHoc, gridBagConstraints);

        jLabel4.setText("Tên Lớp Học");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 6, 0, 0);
        jLayeredPane2.add(jLabel4, gridBagConstraints);

        jLabel3.setText("Mã Lớp Học");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 0, 0);
        jLayeredPane2.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 32, 0, 6);
        jLayeredPane2.add(txtSiSo, gridBagConstraints);

        jLabel5.setText("Sĩ Số");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 52;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        jLayeredPane2.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 32, 0, 6);
        jLayeredPane2.add(txtTenLopHoc, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ DANH SÁCH LỚP HỌC");

        jLayeredPane3.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLayeredPane4.setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("Năm học");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 32, 0, 0);
        jLayeredPane4.add(jLabel7, gridBagConstraints);

        comboBoxNienKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxNienKhoaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 0, 0);
        jLayeredPane4.add(comboBoxNienKhoa, gridBagConstraints);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.8;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 6, 16);
        jLayeredPane4.add(jScrollPane2, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane1)
                    .addComponent(jLayeredPane2))
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
            .addComponent(jLayeredPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        themLopHoc();
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        capNhatLopHoc();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        xoaLopHoc();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void comboBoxNienKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxNienKhoaActionPerformed
         capNhatBang();
        String namHoc = comboBoxNienKhoa.getSelectedItem().toString();
        txtMaNamHoc.setText(new Controller_QlDsLop().layMaNienKhoa(namHoc));
       
 
    }//GEN-LAST:event_comboBoxNienKhoaActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        selecRow = table.getSelectedRow();
     
     if(selecRow != -1){
         txtMaLopHoc.setText(tableModel.getValueAt(selecRow, 0).toString());
         txtTenLopHoc.setText(tableModel.getValueAt(selecRow , 1).toString());
         txtSiSo.setText(tableModel.getValueAt(selecRow, 2).toString());
         txtMaNamHoc.setText(tableModel.getValueAt(selecRow, 3).toString());
     }
    }//GEN-LAST:event_tableMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(QL_DaoTao_DanhSachLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_DaoTao_DanhSachLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_DaoTao_DanhSachLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_DaoTao_DanhSachLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_DaoTao_DanhSachLop().setVisible(true);
            }
        });
    }
  
         
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> comboBoxNienKhoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtMaLopHoc;
    private javax.swing.JTextField txtMaNamHoc;
    private javax.swing.JTextField txtSiSo;
    private javax.swing.JTextField txtTenLopHoc;
    // End of variables declaration//GEN-END:variables
}