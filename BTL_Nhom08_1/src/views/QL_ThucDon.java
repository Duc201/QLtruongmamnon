
package views;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import controller.Controller_ThucDon;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import models.NienKhoa;
import models.ThucDon;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QL_ThucDon extends javax.swing.JFrame {

    private int selectedRow = -1;

    public QL_ThucDon() {
        connectDB_ThucDon = new Controller_ThucDon();
        initComponents();
        this.setLocationRelativeTo(null);
       setTitle("QUẢN LÝ THỰC ĐƠN");
       
        // No write trên txtMaThucDon
        txtMaThucDon.setEnabled(false);

        creatBang();
        
        // Lay du lieu cac nam hoc cho combobox NamHoc
        connectDB_ThucDon.layDanhSachNamHoc(cmbNamHoc);
         cmbNamHoc.setSelectedIndex(cmbNamHoc.getItemCount() - 1);
        taoMaTD();
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Group = new javax.swing.ButtonGroup();
        Lable_tieude = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Label_NamHoc = new javax.swing.JLabel();
        cmbNamHoc = new javax.swing.JComboBox<>();
        dateChooser = new com.toedter.calendar.JDateChooser();
        Label_Ngay = new javax.swing.JLabel();
        buaSangLabel = new javax.swing.JLabel();
        buaTruaLable = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXuatExcel = new javax.swing.JButton();
        dsThucdonLabel = new javax.swing.JLabel();
        dateChooserSearch = new com.toedter.calendar.JDateChooser();
        txtMaThucDon = new javax.swing.JTextField();
        maThucDonLable = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTenMonAnSang = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTenMonAnTrua = new javax.swing.JTextArea();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1150, 580));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(1150, 580));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lable_tieude.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        Lable_tieude.setText("Quản Lý Thực Đơn");
        getContentPane().add(Lable_tieude, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 660, 240));

        Label_NamHoc.setText("NĂM HỌC");
        getContentPane().add(Label_NamHoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        cmbNamHoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNamHocItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbNamHoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 290, -1));

        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateChooserPropertyChange(evt);
            }
        });
        getContentPane().add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 290, -1));

        Label_Ngay.setText("NGÀY");
        getContentPane().add(Label_Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 43, -1));

        buaSangLabel.setText("BỮA SÁNG");
        getContentPane().add(buaSangLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        buaTruaLable.setText("BỮA TRƯA");
        getContentPane().add(buaTruaLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 70, -1));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Edit-validated.24.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        getContentPane().add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, -1));

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 100, -1));

        btnXuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/XuatFIle (1).png"))); // NOI18N
        btnXuatExcel.setText("Tạo file");
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });
        getContentPane().add(btnXuatExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 100, 40));

        dsThucdonLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        dsThucdonLabel.setText("Danh sách thực đơn");
        getContentPane().add(dsThucdonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

        dateChooserSearch.setDateFormatString("dd/MM/yyyy");
        dateChooserSearch.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateChooserSearchPropertyChange(evt);
            }
        });
        getContentPane().add(dateChooserSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 190, -1));
        getContentPane().add(txtMaThucDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 290, -1));

        maThucDonLable.setText("MÃ THỰC ĐƠN");
        getContentPane().add(maThucDonLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txtTenMonAnSang.setColumns(20);
        txtTenMonAnSang.setLineWrap(true);
        txtTenMonAnSang.setRows(5);
        txtTenMonAnSang.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtTenMonAnSang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 295, -1));

        txtTenMonAnTrua.setColumns(20);
        txtTenMonAnTrua.setLineWrap(true);
        txtTenMonAnTrua.setRows(5);
        txtTenMonAnTrua.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtTenMonAnTrua);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 295, -1));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search.png"))); // NOI18N
        btnSearch.setText("Tìm Kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       // lay ngay da nhap 
        Date selectedDate = dateChooserSearch.getDate();
       
        
        if (selectedDate == null) {
            
            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập ngày cần tìm kiếm !  ",
                    "Lỗi",
                    JOptionPane.WARNING_MESSAGE
            );
        } else {
         
            searchTD(selectedDate);
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        addTD();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        updateTD();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        deleteTD();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        exportTD();
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow(); // lay ra so thu tu cua dong
        
        if (selectedRow != -1) {
            
            txtMaThucDon.setText(tableModel.getValueAt(selectedRow, 0).toString());
            txtTenMonAnSang.setText(tableModel.getValueAt(selectedRow, 1).toString());
            txtTenMonAnTrua.setText(tableModel.getValueAt(selectedRow, 2).toString());
            MaNK = tableModel.getValueAt(selectedRow, 4).toString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date date = dateFormat.parse(tableModel.getValueAt(selectedRow, 3).toString()); // Chuyen STring date(dd/mm/year)  ve dang Date
                dateChooser.setDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
                dateChooser.setDate(new Date()); // Nếu không thể chuyển đổi, đặt ngày hiện tại
            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void cmbNamHocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNamHocItemStateChanged
        updateTableByCmbNH();
        gioiHanNamHoc();
        clearText();
    }//GEN-LAST:event_cmbNamHocItemStateChanged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        clearText();
    }//GEN-LAST:event_formMouseClicked

    private void dateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooserPropertyChange
       
        checkDateRange( dateChooser);
    }//GEN-LAST:event_dateChooserPropertyChange

    private void dateChooserSearchPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooserSearchPropertyChange
       
       checkDateRange( dateChooserSearch);
    }//GEN-LAST:event_dateChooserSearchPropertyChange

//Đầu vào là thuộc kiểu Date -> đầu ra là kiểu String DD/MM/YYYY
public String CovertTimeDDMMYYYY(Date date1){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        return dateFormat.format(date1); 
    }
// Đầu vào là thuộc kiểu String DD/MM/YYYY -> Đầu ra 
    
private void checkDateRange(JDateChooser dateChooserCheck) {
  
    Date selectedDate = dateChooserCheck.getDate();
    Date minDate = dateChooserCheck.getMinSelectableDate();
    Date maxDate = dateChooserCheck.getMaxSelectableDate();

    
    if (selectedDate != null && (selectedDate.before(minDate) || selectedDate.after(maxDate))) {
        JOptionPane.showMessageDialog(
            this,
            "Ngày không thuộc khoảng thời gian Niên Khóa cho phép từ " + CovertTimeDDMMYYYY(minDate) + " đến " + CovertTimeDDMMYYYY(maxDate),
            "Lỗi",
            JOptionPane.WARNING_MESSAGE
        );
        dateChooserCheck.setDate(null);
    }
}

    public void creatBang() {
        tableModel = (DefaultTableModel) jTable1.getModel();        // viet them
        tableModel.setColumnIdentifiers(new Object[]{ // tao cac thuoc tinh ten cua cot trong bang
            "Mã Thực Đơn", "Tên món ăn Sáng ", "Tên món ăn trưa", "Ngày", "Mã Niên Khóa"
        });
    }

    public void gioiHanNamHoc() {
        NienKhoa nk = new NienKhoa();
        String NamHoc = cmbNamHoc.getSelectedItem().toString();
        nk = connectDB_ThucDon.layThoiGianNienKhoa(NamHoc);

        dateChooser.setMinSelectableDate(nk.getNgayBatDau());
        dateChooser.setMaxSelectableDate(nk.getNgayKetThuc());
        dateChooserSearch.setMinSelectableDate(nk.getNgayBatDau());
        dateChooserSearch.setMaxSelectableDate(nk.getNgayKetThuc());
    }

//Tạo tự tăng cho mã HS
    public void taoMaTD() {
        // Them đoạn code này để cập nhật lại day sach thuc don xac dinh gia tri ID tiep theo
         thucDonList = new Controller_ThucDon().layDanhSachThucDon();
        int id = 1;
        boolean state;
        while (true) {
            state = false;
            for (ThucDon ph : thucDonList) {
                if (ph.getMaThucDon().equals("TD" + id)) {
                    state = true;
                    break;
                }
            }
            if (!state) {
                break;
            }
            ++id;
        }
        txtMaThucDon.setText("TD" + id);
    }
    
    private void clearText() {

        taoMaTD();
        //txtMaThucDon.setText("");
        txtTenMonAnSang.setText("");
        txtTenMonAnTrua.setText("");
        dateChooser.setDate(null);
        
        dateChooserSearch.setDate(null);

        updateTableByCmbNH();
    }
    


   private void updateTable(List<ThucDon> danhSachThucDon) {
        tableModel.setRowCount(0); // Xóa dữ liệu trong bảng hiện tại
      
        for (ThucDon thucDon : danhSachThucDon) {
            Object[] rowData = {
                thucDon.getMaThucDon(),
                thucDon.getTenMonAnSang(),
                thucDon.getTenMonAnTrua(),
                // thucDon.getNgay(),
                CovertTimeDDMMYYYY(thucDon.getNgay()),  // String dd/mm/yyyy
                thucDon.getMaNienKhoa()
            };
            tableModel.addRow(rowData);
        }
    }

    private void updateTableByCmbNH() {
        //tableModel.setRowCount(0);
        String namHoc = cmbNamHoc.getSelectedItem().toString();
        thucDonList = connectDB_ThucDon.layDanhSachThucDonTheoNamHoc(namHoc);

//         sap xep  bang theo ngay
        Collections.sort(thucDonList, new Comparator<ThucDon>() {
            @Override
            public int compare(ThucDon td1, ThucDon td2) {
                return td1.getNgay().compareTo(td2.getNgay());
            }
        });

        updateTable(thucDonList);
    }



    private void addTD() {

        ThucDon thucDon = new ThucDon();

        thucDon.setMaThucDon(txtMaThucDon.getText());
        thucDon.setTenMonAnSang(txtTenMonAnSang.getText());
        thucDon.setTenMonAnTrua(txtTenMonAnTrua.getText());
        thucDon.setNgay(dateChooser.getDate());
        String namHoc = cmbNamHoc.getSelectedItem().toString();
        // connectDB_ThucDon.themThucDonDB(thucDon);

        if (thucDon.getNgay() == null ) {
            // Xử lý trường hợp không điền ngày . Nó có thể là TH ngày nhập ko đúng định dạng vì jDate chooer  nếu nhập ko đúng định dạng là cho null luôn
            JOptionPane.showMessageDialog(
                    this,
                    "Ngày không hợp lệ hoặc chưa điền ngày ",
                    "Lỗi",
                    JOptionPane.WARNING_MESSAGE
            );
           
        } else {
            // Nếu ngày hợp lệ, gọi phương thức checkDateRange
            connectDB_ThucDon.themThucDonDB(thucDon, namHoc);
             clearText();
        }
         
        updateTableByCmbNH();
    }

    private void updateTD() {

        ThucDon thucDon = new ThucDon();
        thucDon.setMaThucDon(txtMaThucDon.getText());
        thucDon.setTenMonAnSang(txtTenMonAnSang.getText());
        thucDon.setTenMonAnTrua(txtTenMonAnTrua.getText());
        thucDon.setNgay(dateChooser.getDate());
        thucDon.setMaNienKhoa(MaNK);

        if (thucDon.getNgay() == null ) {
             // Xử lý trường hợp không điền ngày . Nó có thể là TH ngày nhập ko đúng định dạng vì jDate chooer  nếu nhập ko đúng định dạng là cho null luôn
  
            JOptionPane.showMessageDialog(
                    this,
                    "Ngày không hợp lệ hoặc chưa điền ngày ",
                    "Lỗi",
                    JOptionPane.WARNING_MESSAGE
            );
            
        } else {

            connectDB_ThucDon.capNhatThucDonDB(thucDon);

        }
        // connectDB_ThucDon.capNhatThucDonDB(thucDon);
        updateTableByCmbNH();
       
        clearText();

    }

    private void deleteTD() {
         selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String maThucDon = tableModel.getValueAt(selectedRow, 0).toString();
            int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa thực đơn này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                String namHoc = cmbNamHoc.getSelectedItem().toString();
                connectDB_ThucDon.xoaThucDonDB(maThucDon);
                updateTableByCmbNH();
            
                clearText();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một thực đơn để xóa!");
        }
    }
    
        private void searchTD(Date ngayTimKiem) {
        
        List<ThucDon> danhSachTimKiem = new ArrayList<>();
          thucDonList = new Controller_ThucDon().layDanhSachThucDon();
        for (ThucDon thucDon : thucDonList) {
                if (ngayTimKiem.equals(thucDon.getNgay())) {
                danhSachTimKiem.add(thucDon);
            }
        }

        updateTable(danhSachTimKiem);
    }
//sử dụng thư viện Apache POI.
//Apache POI cung cấp các lớp và phương thức để tạo và quản lý tệp Excel (.xls và .xlsx).      
    private void exportTD() {
        
        if (tableModel.getRowCount() == 0) {    // lấy ra số lượng hàng
            JOptionPane.showMessageDialog(null, "Không có dữ liệu để xuất Excel!");
            return;
        }
        //Create a new Workbook
        Workbook workbook = new XSSFWorkbook();
        //// Create a new Sheet
        Sheet sheet = workbook.createSheet("Danh sách thực đơn");
        
        
        Row headerRow = sheet.createRow(0); // tạo hàng đầu -> là hàng các giá trị 
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            Cell cell = headerRow.createCell(i);    // tao ô thứ i của hàng đầu
            cell.setCellValue(tableModel.getColumnName(i));  // Gán giá trị cho ô thứ i của  hàng đầu = tên các cột trong table
        }

        // Tương tự cho các hàng khác
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            Row excelRow = sheet.createRow(row + 1);
            for (int column = 0; column < tableModel.getColumnCount(); column++) {
                Cell cell = excelRow.createCell(column);
                cell.setCellValue(tableModel.getValueAt(row, column).toString());
            }
        }

        
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
        LocalDateTime now = LocalDateTime.now(); // lay thoi gian hien tai 
        
        String namhoc = cmbNamHoc.getSelectedItem().toString();
        
        String fileName = namhoc + "_DanhSachThucDon_" + dtf.format(now) + ".xlsx"; // tao ten File

        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            
            workbook.write(outputStream);
            //ghi dữ liệu từ workbook ) vào outputStream 
            JOptionPane.showMessageDialog(null, "Xuất file Excel thành công!\nTên file: " + fileName);
            
        } catch (Exception e) {
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xuất file Excel!");
        } 
        // workbook  sẽ được đóng ngay cả khi có ngoại lệ xảy ra hoặc không
        finally {
            try {
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                           new QL_ThucDon().setVisible(true);
 
            }
        });
    }
    private String MaNK = " ";
    private Controller_ThucDon connectDB_ThucDon;
    private DefaultTableModel tableModel;
    private List<ThucDon> thucDonList;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_NamHoc;
    private javax.swing.JLabel Label_Ngay;
    private javax.swing.JLabel Lable_tieude;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.ButtonGroup btn_Group;
    private javax.swing.JLabel buaSangLabel;
    private javax.swing.JLabel buaTruaLable;
    private javax.swing.JComboBox<String> cmbNamHoc;
    private com.toedter.calendar.JDateChooser dateChooser;
    private com.toedter.calendar.JDateChooser dateChooserSearch;
    private javax.swing.JLabel dsThucdonLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel maThucDonLable;
    private javax.swing.JTextField txtMaThucDon;
    private javax.swing.JTextArea txtTenMonAnSang;
    private javax.swing.JTextArea txtTenMonAnTrua;
    // End of variables declaration//GEN-END:variables
}
