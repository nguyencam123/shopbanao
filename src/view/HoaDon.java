/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.sql.Connection;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import repository.HoaDonRepository;
import service.IHoaDonService;
import service.impl.HoaDonService;
import utilities.DBConnection;
import viewmodel.HoaDonChiTiet;

/**
 *
 * @author Admin
 */
public class HoaDon extends javax.swing.JPanel {

    /**
     * Creates new form HoaDon
     */
    DefaultTableModel dtm = new DefaultTableModel();
    IHoaDonService hoaDonService = new HoaDonService();
    List<HoaDonChiTiet> listhd = new ArrayList<>();
    // List<HoaDonChiTiet> listhdtk = null;

    public HoaDon() {
        initComponents();
        listhd = hoaDonService.getHD();
        //     listhdtk = timKiem();
//        loadData(listhdtk);
        loadData(hoaDonService.getHD());
    }

    public void loadData(List<HoaDonChiTiet> list) {
        dtm.setRowCount(0);
        dtm = (DefaultTableModel) tbHoaDon.getModel();
        for (HoaDonChiTiet hoaDon : list) {
            dtm.addRow(new Object[]{
                hoaDon.getMaHD(), hoaDon.getMaNV(), hoaDon.getTenKH(), hoaDon.getNgayTao(),
                hoaDon.getTongTien(), hoaDon.TrangThai()
            });
        }
    }

    public List<HoaDonChiTiet> daThanhToan() {
        String sql = "select MaHD, MaNV, TenKH, NgayTao, TongTien, TRANGTHAI from HOADON where TRANGTHAI like N'1'";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<HoaDonChiTiet> hd = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maNV = rs.getString("MaNV");
                String tenKH = rs.getString("TenKH");
                Date ngayTao = rs.getDate("NgayTao");
                Double tongTien = rs.getDouble("TongTien");
                Integer trangThai = rs.getInt("TrangThai");

                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaHD(maHD);
                hdct.setMaNV(maNV);
                hdct.setTenKH(tenKH);
                hdct.setNgayTao(ngayTao);
                hdct.setTongTien(tongTien);
                hdct.setTrangThai(trangThai);
                hd.add(hdct);
            }
            rs.close();
            return hd;
        } catch (Exception e) {
        }
        return null;
    }

    public List<HoaDonChiTiet> choThanhToan() {
        String sql = "select MaHD, MaNV, TenKH, NgayTao, TongTien, TRANGTHAI from HOADON where TRANGTHAI like N'0'";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<HoaDonChiTiet> hd = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maNV = rs.getString("MaNV");
                String tenKH = rs.getString("TenKH");
                Date ngayTao = rs.getDate("NgayTao");
                Double tongTien = rs.getDouble("TongTien");
                Integer trangThai = rs.getInt("TrangThai");

                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaHD(maHD);
                hdct.setMaNV(maNV);
                hdct.setTenKH(tenKH);
                hdct.setNgayTao(ngayTao);
                hdct.setTongTien(tongTien);
                hdct.setTrangThai(trangThai);
                hd.add(hdct);
            }
            rs.close();
            return hd;
        } catch (Exception e) {
        }
        return null;
    }

    public List<HoaDonChiTiet> huy() {
        String sql = "select MaHD, MaNV, TenKH, NgayTao, TongTien, TRANGTHAI from HOADON where TRANGTHAI like N'2'";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<HoaDonChiTiet> hd = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maNV = rs.getString("MaNV");
                String tenKH = rs.getString("TenKH");
                Date ngayTao = rs.getDate("NgayTao");
                Double tongTien = rs.getDouble("TongTien");
                Integer trangThai = rs.getInt("TrangThai");

                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaHD(maHD);
                hdct.setMaNV(maNV);
                hdct.setTenKH(tenKH);
                hdct.setNgayTao(ngayTao);
                hdct.setTongTien(tongTien);
                hdct.setTrangThai(trangThai);
                hd.add(hdct);
            }
            rs.close();
            return hd;
        } catch (Exception e) {
        }
        return null;
    }

    public Integer updateTrangThai() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        Integer ketQua = -1;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update HOADON set TRANGTHAI = '0' where TRANGTHAI like N'2'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, hoaDonChiTiet.getTrangThai());
            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {

        }
        return ketQua;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbTrangThai = new javax.swing.JComboBox<>();
        dtTu = new com.toedter.calendar.JDateChooser();
        dtDen = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        chkSelect = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Hóa Đơn");

        jLabel2.setText("Trạng Thái Hóa Đơn:");

        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ĐÃ TT", "CHỜ TT", "TẤT CẢ", " " }));
        cbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTrangThaiActionPerformed(evt);
            }
        });

        jLabel3.setText("Từ Ngày:");

        jLabel4.setText("Đến Ngày:");

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Mã Nhân Viên", "Tên Khách Hàng", "Ngày Tạo", "Tổng Tiền", "Trạng Thái", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        chkSelect.setText("Select All");
        chkSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtTu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtDen, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem))
                    .addComponent(jLabel1))
                .addContainerGap(163, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkSelect)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(dtTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSelectActionPerformed
        // TODO add your handling code here:
        if (chkSelect.isSelected()) {

            for (int i = 0; i < tbHoaDon.getRowCount(); i++) {
                tbHoaDon.getModel().setValueAt(true, i, 6);
            }

        } else {

            for (int i = 0; i < tbHoaDon.getRowCount(); i++) {
                tbHoaDon.getModel().setValueAt(false, i, 6);
            }
        }
    }//GEN-LAST:event_chkSelectActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        HoaDonRepository donRepository = new HoaDonRepository();
        Date date1 =  dtTu.getDate();
        Date date2 =  dtDen.getDate();
        donRepository.timKiem(date1, date2);
        listhd= donRepository.timKiem(date1, date2);
        loadData(listhd);



    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTrangThaiActionPerformed
//        // TODO add your handling code here:
//        if (cbTrangThai.getSelectedItem().equals("Đã Thanh Toán")) {
//            daThanhToan();
//        } else if (cbTrangThai.getSelectedItem().equals("Chờ Thanh Toán")) {
//            choThanhToan();
//        } else {
//            huy();
//        }
        dtm.setRowCount(0);
        listhd = hoaDonService.getHD();
        dtm = (DefaultTableModel) tbHoaDon.getModel();
        for (int i = 0; i < listhd.size(); i++) {
            if (listhd.get(i).TrangThai().equalsIgnoreCase(cbTrangThai.getSelectedItem().toString())) {
                dtm.addRow(new Object[]{
                    listhd.get(i).getMaHD(), listhd.get(i).getMaNV(), listhd.get(i).getTenKH(), listhd.get(i).getNgayTao(),
                    listhd.get(i).getTongTien(), listhd.get(i).TrangThai()
                });

            }
            if (cbTrangThai.getSelectedItem() == "TẤT CẢ") {
                loadData(listhd);
            }

        }


    }//GEN-LAST:event_cbTrangThaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JCheckBox chkSelect;
    private com.toedter.calendar.JDateChooser dtDen;
    private com.toedter.calendar.JDateChooser dtTu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbHoaDon;
    // End of variables declaration//GEN-END:variables
}
