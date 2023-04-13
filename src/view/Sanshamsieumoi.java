/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domainmodel.DanhMuc;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.impl.DanhMucServiceimpl;
import service.DanhMucService;
import domainmodel.Anh;
import domainmodel.ChiTietSP;
import domainmodel.DanhMuc;
import domainmodel.DongSP;
import domainmodel.MauSac;
import domainmodel.SanPham;
import domainmodel.Size;
import domainmodel.Size1;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import repository.SanPhamRepository;
import service.DongspService;
import service.ISizeService;
import service.MausacService;
import service.impl.DongspServiceimpl;
import service.impl.MausacServiceimpl;
import service.impl.SizeServiceiml1;
import service.DanhMucService;
import service.IAnhService;
import service.SPService;
import service.SanphamService;
import service.impl.AnhService;
import service.impl.DanhMucServiceimpl;
import service.impl.SPServiceImpl;
import service.impl.SanphamServiceimpl;
import viewmodel.SanphamProduct;
//
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.Sizerepository;

/**
 *
 * @author PC DUNG
 */
public class Sanshamsieumoi extends javax.swing.JPanel {

    private String urlPic = "D:\\giayduan1";
    DefaultTableModel defaultTableCT = new DefaultTableModel();

    DefaultTableModel defaultTable = new DefaultTableModel();

    DefaultTableModel defaultTableMS = new DefaultTableModel();
    DefaultTableModel defaultTableDM = new DefaultTableModel();
    DefaultTableModel defaultTableSize = new DefaultTableModel();
    DefaultTableModel defaultTableDong = new DefaultTableModel();
    DefaultTableModel defaultTableSP = new DefaultTableModel();

    List<SanphamProduct> listSanpham = new ArrayList<>();
    List<SanphamProduct> listSanpham1 = new ArrayList<>();

//    
    DefaultTableModel defaultDungHD = new DefaultTableModel();
    List<SanphamProduct> listDungHD = new ArrayList<>();

    List<MauSac> listMausac = new ArrayList<>();
    List<DongSP> listDongsp = new ArrayList<>();
    List<Size> listSize = new ArrayList<>();
    List<DanhMuc> listDanhmuc = new ArrayList<>();
    List<Anh> listAnh = new ArrayList<>();
    List<SanPham> listSP = new ArrayList<>();

    MausacService service_mausac = new MausacServiceimpl();
    DongspService service_dongsp = new DongspServiceimpl();
    ISizeService service_size = new SizeServiceiml1();
    DanhMucService service_danhmuc = new DanhMucServiceimpl();
    SPService service_sp = new SPServiceImpl();
//    
    SanphamService service_sanpham = new SanphamServiceimpl();
    Sizerepository sizerp = new Sizerepository();
    IAnhService service_anh = new AnhService();
    List<Size1> listSize11 = new ArrayList<>();
    /**
     *
     */
    public Sanshamsieumoi() {
        initComponents();
        listSanpham = service_sanpham.getAllSp();
        listDongsp = service_dongsp.getListDongsp();
        listMausac = service_mausac.getListMausac();
        listSize11 = sizerp.getone();
        listDanhmuc = service_danhmuc.getDanhMucs();
        listAnh = service_anh.getListAnh();
        listSP = service_sp.getAllSP();
//        

        cboDongsp.setModel(new DefaultComboBoxModel(listDongsp.toArray()));
        cboMausac.setModel(new DefaultComboBoxModel(listMausac.toArray()));
        cboSize.setModel(new DefaultComboBoxModel(listSize.toArray()));
        cboDanhmuc.setModel(new DefaultComboBoxModel(listDanhmuc.toArray()));

        cboLoaiHangLoc.setModel(new DefaultComboBoxModel(listDongsp.toArray()));

        //fill
        FillDanhMuc();
        fillMausac();
        FillDongSp();
        fillSize();
        FillSp();

        fillSanpham();

        fillSanphamCT();
    }
    //fill Sanpham chi tiet

    public void fillSanphamCT() {
        defaultTableCT.setRowCount(0);
        defaultTableCT = (DefaultTableModel) tblSanphamct.getModel();
        for (int i = 0; i < listSanpham.size(); i++) {
            defaultTableCT.addRow(new Object[]{i + 1,
                listSanpham.get(i).getIdSp(), listSanpham.get(i).getTensp(),
                listSanpham.get(i).getMoTa(),
                listSanpham.get(i).getGia(), listSanpham.get(i).getSoluong(),
                listSanpham.get(i).getIdDongsp(), listSanpham.get(i).getIdSize(), listSanpham.get(i).getMaDanhmuc(),
                listSanpham.get(i).getIdMausac(), listSanpham.get(i).getThoiGianBH(), listSanpham.get(i).TrangThai()
            });
        }

    }

    public void fillSanpham() {
        defaultTable.setRowCount(0);
        defaultTable = (DefaultTableModel) tblSanpham.getModel();
        for (int i = 0; i < listSanpham.size(); i++) {
            defaultTable.addRow(new Object[]{i + 1,
                listSanpham.get(i).getIdSp(), listSanpham.get(i).getTensp(),
                listSanpham.get(i).getMoTa(),
                listSanpham.get(i).getGia(), listSanpham.get(i).getSoluong(),
                listSanpham.get(i).getIdDongsp(), listSanpham.get(i).getIdSize(), listSanpham.get(i).getMaDanhmuc(),
                listSanpham.get(i).getIdMausac(), listSanpham.get(i).getThoiGianBH(), listSanpham.get(i).TrangThai()
            });
        }

    }

//fillSanpham
    public void FillSp() {
        defaultTableSP.setRowCount(0);
        defaultTableSP = (DefaultTableModel) tblSp.getModel();
        for (int i = 0; i < listSP.size(); i++) {
            defaultTableSP.addRow(new Object[]{i + 1, listSP.get(i).getMa(), listSP.get(i).getTen()});
        }
    }
//    fill danh muc

    public void FillDanhMuc() {
        defaultTableDM.setRowCount(0);
        defaultTableDM = (DefaultTableModel) tblDanhmuc.getModel();
        for (DanhMuc danhMuc : listDanhmuc) {
            defaultTableDM.addRow(new Object[]{danhMuc.getMaDanhMuc(), danhMuc.getTen(), danhMuc.getMoTa()});
        }
    }
//    fill mau sac

    public void fillMausac() {
        defaultTableMS.setRowCount(0);
        defaultTableMS = (DefaultTableModel) tblMausac.getModel();
        for (MauSac ms : listMausac) {
            defaultTableMS.addRow(new Object[]{ms.getMa(), ms.getTen()});
        }
    }

    // fill dong
    public void FillDongSp() {
        defaultTableDong.setRowCount(0);
        defaultTableDong = (DefaultTableModel) tblDongsp.getModel();
        for (DongSP dongSP : listDongsp) {
            defaultTableDong.addRow(new Object[]{dongSP.getMa(), dongSP.getTen()});
        }
    }

    // fill size
    public void fillSize() {
        defaultTableSize.setRowCount(0);
        defaultTableSize = (DefaultTableModel) tblSize.getModel();
        for (Size size : listSize) {
            defaultTableSize.addRow(new Object[]{size.getMa(), size.getSoSize()});
        }
    }

    //
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanphamct = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        cboLoaiHangLoc = new javax.swing.JComboBox<>();
        btnIndulieu = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSp = new javax.swing.JTable();
        txtMaSp = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        lblMaSP = new javax.swing.JLabel();
        lblTenSP = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lblTenspct = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblMaspct = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        cboDongsp = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        cboMausac = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        txtSoluong1 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        cboSize = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        txtNambh = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        jButton21 = new javax.swing.JButton();
        btnThemctsp = new javax.swing.JButton();
        btnSuaChitietSp = new javax.swing.JButton();
        btnCapnhatctsp = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        cboDanhmuc = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnChon = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSanpham = new javax.swing.JTable();
        lblGia = new javax.swing.JLabel();
        lblDongsp1 = new javax.swing.JLabel();
        lblMausac = new javax.swing.JLabel();
        lblDanhmuc1 = new javax.swing.JLabel();
        lblSoluong = new javax.swing.JLabel();
        lblNambh = new javax.swing.JLabel();
        lblanh = new javax.swing.JLabel();
        btnHoatdong = new javax.swing.JButton();
        btnDunghoatdong = new javax.swing.JButton();
        txtTimkiem1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMausac = new javax.swing.JTable();
        txtMamausac = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenmausac = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnThemMS = new javax.swing.JButton();
        btnSuaMS = new javax.swing.JButton();
        btnXoaMS = new javax.swing.JButton();
        lblMaMS = new javax.swing.JLabel();
        lblTenMS = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDanhmuc = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaDanhmuc = new javax.swing.JTextField();
        txtTenDanhmuc = new javax.swing.JTextField();
        btnLammoi = new javax.swing.JButton();
        btnThemdanhmuc = new javax.swing.JButton();
        btnSuadanhmuc = new javax.swing.JButton();
        btnXoaDanhmuc = new javax.swing.JButton();
        lblMadm = new javax.swing.JLabel();
        lblTenDM = new javax.swing.JLabel();
        txtMotaDanhmuc = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        lblMotaDM = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDongsp = new javax.swing.JTable();
        txtmaDong = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTenDong = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        lblMaDong = new javax.swing.JLabel();
        lblTenDong = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSize = new javax.swing.JTable();
        txtmasize = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txttensize = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtcannangmin = new javax.swing.JTextField();
        txtcannangmax = new javax.swing.JTextField();
        txtchieucaomin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtchieucaomax = new javax.swing.JTextField();

        jLabel8.setText("jLabel8");

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        tblSanphamct.setBackground(new java.awt.Color(204, 255, 255));
        tblSanphamct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sp", "Tên sp", "Mô tả", "Đơn giá", "Số lượng", "Dòng sp", "Size", "Danh mục", "Màu", "Năm BH", "Trạng thái"
            }
        ));
        tblSanphamct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanphamctMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanphamct);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Loại hàng");

        cboLoaiHangLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLoaiHangLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiHangLocActionPerformed(evt);
            }
        });

        btnIndulieu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIndulieu.setText("In file ");
        btnIndulieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndulieuActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Import");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtTimkiem.setBackground(new java.awt.Color(255, 204, 204));
        txtTimkiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTimkiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });
        txtTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimkiemKeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboLoaiHangLoc, 0, 324, Short.MAX_VALUE)
                            .addComponent(txtTimkiem))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(btnIndulieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cboLoaiHangLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIndulieu))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jButton2))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(423, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Danh sách", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));

        tblSp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên"
            }
        ));
        tblSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSpMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblSp);

        jLabel22.setText("Mã");

        jLabel23.setText("Tên");

        lblMaSP.setText("-");

        lblTenSP.setText("-");

        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton17.setText("Làm mới");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton18.setText("Thêm");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton19.setText("Sửa");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton20.setText("Xóa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaSp)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(lblMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMaSP)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton18)
                                .addGap(20, 20, 20)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenSP)
                            .addComponent(jButton19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jButton20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết sản phẩm"));

        jLabel27.setText("Tên sản phẩm:");

        lblTenspct.setForeground(new java.awt.Color(255, 51, 51));
        lblTenspct.setText("*");

        jLabel29.setText("Mã sp:");

        lblMaspct.setForeground(new java.awt.Color(255, 51, 51));
        lblMaspct.setText("*");

        jLabel31.setText("Giá:");

        cboDongsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cboDongspMouseReleased(evt);
            }
        });

        jLabel32.setText("Dòng sp:");

        cboMausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboMausacMouseClicked(evt);
            }
        });

        jLabel33.setText("Màu sắc:");

        jLabel34.setText("Số lượng:");

        cboSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cboSizeMouseReleased(evt);
            }
        });

        jLabel35.setText("Size:");

        jLabel36.setText("Năm BH:");

        jLabel37.setText("Mô tả");

        txtMota.setEditable(false);
        txtMota.setColumns(20);
        txtMota.setRows(5);
        jScrollPane5.setViewportView(txtMota);

        jButton21.setText("Làm mới");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        btnThemctsp.setText("Thêm");
        btnThemctsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemctspActionPerformed(evt);
            }
        });

        btnSuaChitietSp.setText("Sửa");
        btnSuaChitietSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaChitietSpActionPerformed(evt);
            }
        });

        btnCapnhatctsp.setText("Cập nhật TT");
        btnCapnhatctsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapnhatctspActionPerformed(evt);
            }
        });

        jLabel41.setText("Danh mục");

        cboDanhmuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboDanhmucMouseClicked(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setText("+");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setText("+");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnChon.setText("Chọn ảnh");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        tblSanpham.setBackground(new java.awt.Color(204, 255, 255));
        tblSanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sp", "Tên sp", "Mô tả", "Đơn giá", "Số lượng", "Dòng sp", "Size", "Danh mục", "Màu", "Năm BH", "Trạng thái"
            }
        ));
        tblSanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanphamMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblSanpham);

        lblGia.setForeground(new java.awt.Color(255, 0, 51));
        lblGia.setText("-");

        lblDongsp1.setForeground(new java.awt.Color(255, 0, 0));
        lblDongsp1.setText("-");

        lblMausac.setForeground(new java.awt.Color(255, 0, 51));
        lblMausac.setText("-");

        lblDanhmuc1.setForeground(new java.awt.Color(255, 0, 51));
        lblDanhmuc1.setText("-");

        lblSoluong.setForeground(new java.awt.Color(255, 0, 0));
        lblSoluong.setText("-");

        lblNambh.setForeground(new java.awt.Color(255, 0, 51));
        lblNambh.setText("-");

        lblanh.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblanh.setText("Ảnh");

        btnHoatdong.setText("Hoạt động");
        btnHoatdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoatdongActionPerformed(evt);
            }
        });

        btnDunghoatdong.setText("Dừng hoạt động");
        btnDunghoatdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDunghoatdongActionPerformed(evt);
            }
        });

        txtTimkiem1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimkiem1KeyReleased(evt);
            }
        });

        jLabel42.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel29)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jButton21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThemctsp))
                            .addComponent(lblDongsp1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboDongsp, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboDanhmuc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaspct, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTenspct, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboMausac, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblMausac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDanhmuc1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jButton5)
                            .addComponent(jButton7))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNambh)
                                    .addComponent(cboSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSoluong1)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                    .addComponent(lblNambh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(btnHoatdong)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDunghoatdong)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChon)
                                .addGap(92, 92, 92))))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(375, 375, 375)
                        .addComponent(btnSuaChitietSp)
                        .addGap(50, 50, 50)
                        .addComponent(btnCapnhatctsp))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel42)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimkiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboDongsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel37)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDongsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(lblMausac))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(lblMaspct)
                            .addComponent(txtSoluong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(18, 18, 18)
                        .addComponent(lblSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(lblTenspct)
                            .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNambh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGia)
                            .addComponent(lblNambh, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboDanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnChon)
                        .addComponent(btnHoatdong)
                        .addComponent(btnDunghoatdong)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDanhmuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21)
                    .addComponent(btnThemctsp)
                    .addComponent(btnSuaChitietSp)
                    .addComponent(btnCapnhatctsp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Cập nhật", jPanel4);

        jTabbedPane1.addTab("Danh sách sản phẩm", jTabbedPane2);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Màu sắc"));

        tblMausac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã màu", "Tên màu"
            }
        ));
        tblMausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMausacMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMausac);

        jLabel1.setText("Mã màu:");

        jLabel2.setText("Tên màu:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton1.setText("Làm mới");

        btnThemMS.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnThemMS.setText("Thêm");
        btnThemMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMSActionPerformed(evt);
            }
        });

        btnSuaMS.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnSuaMS.setText("Sửa");
        btnSuaMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMSActionPerformed(evt);
            }
        });

        btnXoaMS.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnXoaMS.setText("Xóa");

        lblMaMS.setText("-");

        lblTenMS.setText("-");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMamausac, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(txtTenmausac)
                            .addComponent(lblMaMS, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenMS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThemMS)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuaMS)
                                .addGap(30, 30, 30)
                                .addComponent(btnXoaMS)))
                        .addContainerGap(35, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMamausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addComponent(lblMaMS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenmausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenMS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnThemMS)
                    .addComponent(btnSuaMS)
                    .addComponent(btnXoaMS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh mục"));

        tblDanhmuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên danh mục", "Mô tả"
            }
        ));
        tblDanhmuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhmucMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDanhmuc);

        jLabel5.setText("Mã:");

        jLabel6.setText("Tên:");

        btnLammoi.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnLammoi.setText("Làm mới");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        btnThemdanhmuc.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnThemdanhmuc.setText("Thêm");
        btnThemdanhmuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemdanhmucActionPerformed(evt);
            }
        });

        btnSuadanhmuc.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnSuadanhmuc.setText("Sửa");
        btnSuadanhmuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuadanhmucActionPerformed(evt);
            }
        });

        btnXoaDanhmuc.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnXoaDanhmuc.setText("Xóa");
        btnXoaDanhmuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDanhmucActionPerformed(evt);
            }
        });

        lblMadm.setText("-");

        lblTenDM.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblTenDM.setText("-");

        jLabel40.setText("Mô tả");

        lblMotaDM.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblMotaDM.setText("-");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnLammoi)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemdanhmuc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuadanhmuc)
                        .addGap(38, 38, 38)
                        .addComponent(btnXoaDanhmuc)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)))
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMotaDM, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTenDanhmuc, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                                        .addComponent(txtMaDanhmuc)
                                        .addComponent(lblMadm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMotaDanhmuc)
                                        .addComponent(lblTenDM, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtMaDanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblMadm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenDanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenDM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMotaDanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMotaDM)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLammoi)
                    .addComponent(btnThemdanhmuc)
                    .addComponent(btnSuadanhmuc)
                    .addComponent(btnXoaDanhmuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Dòng sản phẩm"));

        tblDongsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dòng", "Tên dòng"
            }
        ));
        tblDongsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDongspMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblDongsp);

        jLabel9.setText("Mã dòng:");

        jLabel10.setText("Tên dòng:");

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton9.setText("Làm mới");

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton10.setText("Thêm");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton11.setText("Sửa");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton12.setText("Xóa");

        lblMaDong.setText("-");

        lblTenDong.setText("-");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTenDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTenDong, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton9)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10)
                                .addGap(18, 18, 18)
                                .addComponent(jButton11)
                                .addGap(26, 26, 26)
                                .addComponent(jButton12))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblMaDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtmaDong, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmaDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(6, 6, 6)
                .addComponent(lblMaDong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenDong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Kích thước"));

        tblSize.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã size", "Tên size", "chieucaomax", "chieucaomin", "cannangmax", "cannangmin"
            }
        ));
        tblSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSizeMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblSize);
        if (tblSize.getColumnModel().getColumnCount() > 0) {
            tblSize.getColumnModel().getColumn(3).setResizable(false);
            tblSize.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel13.setText("Mã size:");

        jLabel14.setText("Tên size:");

        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton13.setText("Làm mới");

        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton14.setText("Thêm");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton15.setText("Sửa");

        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton16.setText("Xóa");

        jLabel3.setText("can nang min");

        jLabel4.setText("can nang max");

        jLabel7.setText("chieu cao min");

        jLabel11.setText("chieu cao max");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(24, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtchieucaomax, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                    .addComponent(txtchieucaomin)
                                    .addComponent(txtcannangmax)
                                    .addComponent(txtcannangmin)
                                    .addComponent(txtmasize, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                    .addComponent(txttensize))
                                .addGap(40, 40, 40))))))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton13)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14)
                        .addGap(18, 18, 18)
                        .addComponent(jButton15)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmasize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txttensize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcannangmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcannangmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtchieucaomin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtchieucaomax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton14)
                    .addComponent(jButton15)
                    .addComponent(jButton16))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách thuộc tính", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanphamctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanphamctMouseClicked
        // TODO add your handling code here:
        txtMaDanhmuc.setText("");
        txtTenDanhmuc.setText("");
        txtMotaDanhmuc.setText("");
    }//GEN-LAST:event_tblSanphamctMouseClicked

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnThemdanhmucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemdanhmucActionPerformed
        // TODO add your handling code here:
        if (checkdieuKien()) {
            DanhMuc danhMuc = new DanhMuc();
            if (checkMatcher(listDanhmuc, txtMaDanhmuc.getText())) {
                danhMuc.setMaDanhMuc(txtMaDanhmuc.getText());
                danhMuc.setTen(txtTenDanhmuc.getText());
                danhMuc.setMoTa(txtMotaDanhmuc.getText());

                service_danhmuc.add(danhMuc);

            }
            listDanhmuc = service_danhmuc.getDanhMucs();

            FillDanhMuc();
        }
    }//GEN-LAST:event_btnThemdanhmucActionPerformed

    private void btnSuadanhmucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuadanhmucActionPerformed
        // TODO add your handling code here:
        int index = tblDanhmuc.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chọn hàng để sửa");
        } else {
            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setMaDanhMuc(txtMaDanhmuc.getText());
            danhMuc.setTen(txtTenDanhmuc.getText());
            danhMuc.setMoTa(txtMotaDanhmuc.getText());
            service_danhmuc.update(danhMuc); // up in service
            JOptionPane.showMessageDialog(this, "Sửa dòng sản phẩm thành công");

            listDanhmuc = service_danhmuc.getDanhMucs();
            FillDanhMuc();

        }
    }//GEN-LAST:event_btnSuadanhmucActionPerformed

    private void btnXoaDanhmucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDanhmucActionPerformed
        // TODO add your handling code here:
        int row = tblDanhmuc.getSelectedRow();
        int j = tblDanhmuc.getSelectedRowCount() - 1;
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn hàng muốn xóa");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                //dongspService.delete(tblDongsp.getValueAt(row,0).toString());
                if (row >= 0) {
                    for (int i = row; i <= row + j; i++) {
                        service_danhmuc.delete(tblDanhmuc.getValueAt(row, 0).toString());
                        JOptionPane.showMessageDialog(this, "Xóa thành công");
                        listDanhmuc = service_danhmuc.getDanhMucs();
                        FillDanhMuc();
                    }

                }
            }
        }
    }//GEN-LAST:event_btnXoaDanhmucActionPerformed

    private void tblSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSpMouseClicked
        // TODO add your handling code here:
        int row = tblSp.getSelectedRow();
        txtMaSp.setText(tblSp.getValueAt(row, 1).toString());
        txtTenSP.setText(tblSp.getValueAt(row, 2).toString());
        lblMaspct.setText(tblSp.getValueAt(row, 1).toString());
        lblTenspct.setText(tblSp.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tblSpMouseClicked

    private void btnCapnhatctspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapnhatctspActionPerformed
        // TODO add your handling code here:
        int row = tblSanpham.getSelectedRow();
//        JOptionPane.showMessageDialog(this, service_sanpham.updateTT(tblSanpham.getValueAt(row, 0).toString(),themsanpham(), themsp()));

        int choice = JOptionPane.showConfirmDialog(this, "Bạn muốn cập nhật trạng thái", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            service_sanpham.updateTT(lblTenspct.getText());
            listSanpham = service_sanpham.getAllSp();
            JOptionPane.showMessageDialog(this, "Cập nhật trạng thái thành công");
            fillSanpham();
//                
        }

    }//GEN-LAST:event_btnCapnhatctspActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Dongspview s = new Dongspview();
        s.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Mausacview v = new Mausacview();
        v.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        DanhMucView m = new DanhMucView();
        m.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        ViewSize1 e = new ViewSize1();
        e.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void cboMausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMausacMouseClicked
        // TODO add your handling code here:
        listMausac = service_mausac.getListMausac();
        cboMausac.setModel(new DefaultComboBoxModel(listMausac.toArray()));
    }//GEN-LAST:event_cboMausacMouseClicked

    private void cboDanhmucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboDanhmucMouseClicked
        // TODO add your handling code here:
        listDanhmuc = service_danhmuc.getDanhMucs();
        cboDanhmuc.setModel(new DefaultComboBoxModel(listDanhmuc.toArray()));
    }//GEN-LAST:event_cboDanhmucMouseClicked

    public boolean cheksp() {
        if (txtMaSp.getText().isBlank()) {
            lblMaSP.setText("Mã sản phẩm trống");
        } else {
            lblMaSP.setText("");
        }

        if (txtTenSP.getText().isBlank()) {
            lblTenSP.setText("Tên sản phẩm trống");
            return false;
        } else {
            lblTenSP.setText("");

        }
        return true;
    }

    private boolean checkMaSp(List<SanPham> list, String Masv) {

        for (SanPham taikhoan : list) {
            if (taikhoan.getMa().equals(Masv)) {
                JOptionPane.showMessageDialog(this, "Mã Sản phẩm đã tồn tại");
                return false;
            }
        }
        return true;
    }

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        if (cheksp()) {
            // TODO add your handling code here:
            SanPham s = new SanPham();
            if (checkMaSp(listSP, txtMaSp.getText())) {
                s.setMa(txtMaSp.getText());
                s.setTen(txtTenSP.getText());
                service_sp.them(s);
                listSP = service_sp.getAllSP();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                FillSp();
            }
        }
    }//GEN-LAST:event_jButton18ActionPerformed
    byte[] urlimage = null;
    String filename = null;


    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("D:\\giayduan1");
            jfc.setDialogTitle("Chọn Ảnh :");
            jfc.showOpenDialog(null);
            File fl = jfc.getSelectedFile();
            urlPic = fl.getAbsolutePath();
            if (urlPic != null) {
                lblanh.setIcon(resizeImage(urlPic));
            } else {
                JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Ảnh!"
                        + "Nếu Chưa Chọn Thì Hệ Thống Sẽ Chọn Ảnh Mặc Định");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Ảnh!"
                    + "Nếu Chưa Chọn Thì Hệ Thống Sẽ Chọn Ảnh Mặc Định");
        }
    }//GEN-LAST:event_btnChonActionPerformed

    public ImageIcon resizeImage(String imagePath) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(lblanh.getWidth(), lblanh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

//       
    public boolean checkSanpham() {

        if (txtGia.getText().isBlank()) {
            lblGia.setText("Giá còn trống");
//            return false;
        } else {
            lblGia.setText("");
        }

        if (txtSoluong1.getText().isBlank()) {
            lblSoluong.setText("Số lượng còn trống");
//            return false;
        } else {
            lblSoluong.setText("");
        }

        if (txtNambh.getText().isBlank()) {
            lblNambh.setText("Năm còn trống");
            return false;
        } else {
            lblNambh.setText("");
        }

        //        giá nhập
        try {
            double giaNhap = Double.parseDouble(txtGia.getText());
            if (giaNhap < 0) {
                JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0");
                return false;

            } else {

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Sai định dạng giá nhập bạn phải nhập số");
            return false;
        }

        try {
            int sl = Integer.parseInt(txtSoluong1.getText());
            if (sl < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                return false;

            } else {

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Sai định dạng số lượng bạn phải nhập số");
            return false;
        }

        try {
            int nambh = Integer.parseInt(txtNambh.getText());
            if (nambh < 0) {
                JOptionPane.showMessageDialog(this, "Năm bảo hành phải lớn hơn 0");
                return false;

            } else {

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Sai định dạng bảo hành bạn phải nhập số");
            return false;
        }

        return true;
    }
//    
    private int trangThai;

    SanPham themsanpham() {
        return new SanPham(txtMaSp.getText(), txtTenSP.getText());
    }

    SanphamProduct themsp() {
        SanphamProduct s = new SanphamProduct();
        s.setGia(Double.parseDouble(txtGia.getText()));
        s.setMaDanhmuc(((DanhMuc) cboDanhmuc.getSelectedItem()).getMaDanhMuc());
        s.setIdSize(((Size1) cboSize.getSelectedItem()).getId());
        s.setIdMausac(((MauSac) cboMausac.getSelectedItem()).getId());
        s.setIdDongsp(((DongSP) cboDongsp.getSelectedItem()).getId());
        s.setAnh(urlPic);
        s.setThoiGianBH(Integer.parseInt(txtNambh.getText()));
        s.setSoluong(Integer.parseInt(txtSoluong1.getText()));
//        int tt;
//        if (cboTT.getSelectedItem().equals("Đang hoạt động")) {
//            tt = 0;
//        } else {
//            tt = 1;
//        }
//        s.setTrangThai(tt);
        return s;
    }

    SanphamProduct capnhatsp() {
        SanphamProduct s = new SanphamProduct();
        s.setGia(Double.parseDouble(txtGia.getText()));
        s.setMaDanhmuc(((DanhMuc) cboDanhmuc.getSelectedItem()).getMaDanhMuc());
        s.setIdMausac(((MauSac) cboMausac.getSelectedItem()).getId());
        s.setIdSize(((Size1) cboSize.getSelectedItem()).getId());
        s.setIdDongsp(((DongSP) cboDongsp.getSelectedItem()).getId());
//        s.setAnh(urlPic);
        s.setThoiGianBH(Integer.parseInt(txtNambh.getText()));
        s.setSoluong(Integer.parseInt(txtSoluong1.getText()));
//        int tt;
//        if (cboTT.getSelectedItem().equals("Đang hoạt động")) {
//            tt = 0;
//        } else {
//            tt = 1;
//        }
//        s.setTrangThai(tt);
        return s;
    }
//    private boolean checkMaSanpham(List<SanPham> list, String Masv) {
//
//        for (SanPham taikhoan : list) {
//            if (taikhoan.getMa().equals(Masv)) {
//                JOptionPane.showMessageDialog(this, "Mã Sản phẩm đã tồn tại");
//                return false;
//            }
//        }
//        return true;
//    }
    private void btnThemctspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemctspActionPerformed
        // TODO add your handling code here:
        Anh a = new Anh();
        a.setTen(txtTenSP.getText());
//        String anh = txtAnh.getText();
//        anh = anh.replace("//", "////");
//        a.setUrlImage(urlimage);
        a.setUrlImage(urlPic);
        listAnh.add(a);
        service_anh.them(a);
        if (checkSanpham()) {
             service_sanpham.insert(txtTenSP.getText(), txtMaSp.getText(), themsp());
            listSanpham = service_sanpham.getAllSp();
            fillSanpham();
        }

    }//GEN-LAST:event_btnThemctspActionPerformed

    private void tblSanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanphamMouseClicked
        // TODO add your handling code here:
        int index = tblSanpham.getSelectedRow();
        SanphamProduct a = listSanpham.get(index);
        lblMaspct.setText(tblSanpham.getValueAt(index, 1).toString());
        lblTenspct.setText(tblSanpham.getValueAt(index, 2).toString());
//                txtAnh.setText(tblSanpham.getValueAt(index, 2).toString());
        txtGia.setText(tblSanpham.getValueAt(index, 4).toString());
        txtSoluong1.setText(tblSanpham.getValueAt(index, 5).toString());

//        byte[] image = (listAnh.get(index).getUrlImage());
//        ImageIcon icon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(lblanh.getWidth(), lblanh.getHeight(), Image.SCALE_SMOOTH));
//        lblanh.setIcon(icon);
        lblanh.setIcon(resizeImage(String.valueOf(a.getAnh())));
        if (tblSanpham.getValueAt(index, 6) == null) {
            lblDongsp1.setText("Sản phẩm không có mã dòng sản phẩm ");
        } else {
            lblDongsp1.setText("");
            for (int j = 0; j < listDongsp.size(); j++) {
                if (listDongsp.get(j).getTen().equals(tblSanpham.getValueAt(index, 6).toString())) {
                    cboDongsp.setSelectedIndex(j);
                }
            }
        }

        //
//                if (tblSanpham.getValueAt(index, 7) == null) {
//                    lblSize.setText("Sản phẩm không có size ");
//                } else {
//                    lblSize.setText("");
//                    for (int j = 0; j < listSize.size(); j++) {
//                        if (listSize.get(j).getSoSize().equals(tblSanpham.getValueAt(index, 7).toString())) {
//                            cboSize.setSelectedIndex(j);
//                        }
//                    }
//                }
        cboSize.setSelectedItem(tblSanpham.getValueAt(index, 7).toString());
//          for (int j = 0; j < listSize.size(); j++) {
//                if (listSize.get(j).getSoSize().equals(tblSanpham.getValueAt(index, 7).toString())) {
//                    cboSize.setSelectedIndex(j);
//                         
//
//                }
//            }

//
//        //
        if (tblSanpham.getValueAt(index, 8) == null) {
            lblDanhmuc1.setText("Sản phẩm không có mã danh mục ");
        } else {
            lblDanhmuc1.setText("");
            for (int j = 0; j < listDanhmuc.size(); j++) {
                if (listDanhmuc.get(j).getTen().equals(tblSanpham.getValueAt(index, 8).toString())) {
                    cboDanhmuc.setSelectedIndex(j);
                }
            }
        }
        txtNambh.setText(tblSanpham.getValueAt(index, 10).toString());
//        cboTT.getModel().setSelectedItem(tblSanpham.getValueAt(index, 11).toString());
        //
        //
        if (tblSanpham.getValueAt(index, 9) == null) {
            lblMausac.setText("Sản phẩm không có màu sắc ");
        } else {
            lblMausac.setText("");
            for (int j = 0; j < listMausac.size(); j++) {
                if (listMausac.get(j).getTen().equals(tblSanpham.getValueAt(index, 10).toString())) {
                    cboMausac.setSelectedIndex(j);
                }
            }
        }

        txtMota.setText(tblSanpham.getValueAt(index, 3).toString());
    }//GEN-LAST:event_tblSanphamMouseClicked

    public boolean checkdieuKienMS() {
        if (txtMamausac.getText().isBlank()) {
            lblMaMS.setText("Mã màu sắc còn trống");

        } else {
            lblTenMS.setText("");
        }

        if (txtTenmausac.getText().isBlank()) {
            lblTenMS.setText("Tên màu sắc còn trống");
            return false;
        } else {
            lblTenMS.setText("");
        }

        return true;
    }

    public boolean checkdieuKienDONg() {
        if (txtmaDong.getText().isBlank()) {
            lblMaDong.setText("Mã dòng còn trống");

        } else {
            lblMaDong.setText("");
        }

        if (txtTenDong.getText().isBlank()) {
            lblTenDong.setText("Tên dòng còn trống");
            return false;
        } else {
            lblTenDong.setText("");
        }

        return true;
    }


    private void btnThemMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMSActionPerformed
        // TODO add your handling code here:
        if (checkdieuKienMS()) {
            MauSac ms = new MauSac();
            ms.setMa(txtMamausac.getText());
            ms.setTen(txtTenmausac.getText());
            service_mausac.add(ms);
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            listMausac = service_mausac.getListMausac();
            fillMausac();
        }
    }//GEN-LAST:event_btnThemMSActionPerformed

    private void btnSuaMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMSActionPerformed
        // TODO add your handling code here:
        MauSac ms = new MauSac();
        ms.setMa(txtMamausac.getText());
        ms.setTen(txtTenmausac.getText());
        service_mausac.update(ms);
        JOptionPane.showMessageDialog(this, "Sửa thành công");
        listMausac = service_mausac.getListMausac();
        fillMausac();
    }//GEN-LAST:event_btnSuaMSActionPerformed


    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if (checkdieuKienDONg()) {
            DongSP s = new DongSP();
            s.setMa(txtmaDong.getText());
            s.setTen(txtTenDong.getText());
            service_dongsp.add(s);
        }
        listDongsp = service_dongsp.getListDongsp();
        FillDongSp();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        DongSP s = new DongSP();
        s.setMa(txtmaDong.getText());
        s.setTen(txtTenDong.getText());
        service_dongsp.update(s);

        listDongsp = service_dongsp.getListDongsp();
        FillDongSp();

    }//GEN-LAST:event_jButton11ActionPerformed

    private void tblDanhmucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhmucMouseClicked
        // TODO add your handling code here:
        int dong = tblDanhmuc.getSelectedRow();
        txtMaDanhmuc.setText(tblDanhmuc.getValueAt(dong, 0).toString());
        txtTenDanhmuc.setText(tblDanhmuc.getValueAt(dong, 1).toString());
        txtMotaDanhmuc.setText(tblDanhmuc.getValueAt(dong, 2).toString());
    }//GEN-LAST:event_tblDanhmucMouseClicked

    private void tblMausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMausacMouseClicked
        // TODO add your handling code here:
        int ms = tblMausac.getSelectedRow();

        txtMamausac.setText(tblMausac.getValueAt(ms, 0).toString());
        txtTenmausac.setText(tblMausac.getValueAt(ms, 1).toString());
    }//GEN-LAST:event_tblMausacMouseClicked

    private void tblDongspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDongspMouseClicked
        // TODO add your handling code here:
        int dong = tblDongsp.getSelectedRow();
        txtmaDong.setText(tblDongsp.getValueAt(dong, 0).toString());

        txtTenDong.setText(tblDongsp.getValueAt(dong, 1).toString());
    }//GEN-LAST:event_tblDongspMouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        Size s = new Size();
        s.setMa(txtmasize.getText());
        s.setSoSize(Integer.parseInt(txttensize.getText()));
        service_size.addrow(s);
        listSize = service_size.getall();
        fillSize();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void tblSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSizeMouseClicked
        // TODO add your handling code here:
        int so = tblSize.getSelectedRow();
        txtmasize.setText(tblSize.getValueAt(so, 0).toString());
        txttensize.setText(tblSize.getValueAt(so, 1).toString());
    }//GEN-LAST:event_tblSizeMouseClicked

    private void cboLoaiHangLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiHangLocActionPerformed
        // TODO add your handling code here:

        defaultTableCT.setRowCount(0);
        DongSP ba = (DongSP) cboLoaiHangLoc.getSelectedItem();
        listSanpham1 = service_sanpham.getAllSp();
        defaultTableCT = (DefaultTableModel) tblSanphamct.getModel();
        System.out.println(listSanpham1);
        for (int i = 0; i < listSanpham1.size(); i++) {
            if (listSanpham1.get(i).getIdDongsp().equalsIgnoreCase(cboLoaiHangLoc.getSelectedItem().toString())) {

                defaultTableCT.addRow(new Object[]{i + 1, listSanpham1.get(i).getIdSp(), listSanpham1.get(i).getTensp(), listSanpham1.get(i).getMoTa(),
                    listSanpham1.get(i).getGia(), listSanpham1.get(i).getSoluong(),
                    listSanpham1.get(i).getIdDongsp(), listSanpham1.get(i).getIdSize(), listSanpham1.get(i).getMaDanhmuc(), listSanpham1.get(i).getIdMausac(),
                    listSanpham1.get(i).getThoiGianBH(), listSanpham1.get(i).TrangThai()});

            }

        }


    }//GEN-LAST:event_cboLoaiHangLocActionPerformed

    private void btnIndulieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIndulieuActionPerformed
        // TODO add your handling code here:

        try {
            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("danhsach");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(2);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SACH GIAY");

            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tên sp");

//            cell = row.createCell(3, CellType.STRING);
//            cell.setCellValue("Ảnh");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Mô tả");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Đơn giá");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Số lượng");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Dòng sp");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Size");

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Danh mục");

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Màu");

            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue("Năm BH");

            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue("Trạng thái");

            for (int i = 0; i < listSanpham.size(); i++) {
                //Modelbook book =arr.get(i);
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(listSanpham.get(i).getIdSp());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(listSanpham.get(i).getTensp());

//                cell = row.createCell(3, CellType.);
//                cell.setCellValue(listSanpham.get(i).getAnh());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(listSanpham.get(i).getMoTa());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(listSanpham.get(i).getGia());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(listSanpham.get(i).getSoluong());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(listSanpham.get(i).getIdDongsp());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(listSanpham.get(i).getIdSize());

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(listSanpham.get(i).getMaDanhmuc());

                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(listSanpham.get(i).getIdMausac());

                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue(listSanpham.get(i).getThoiGianBH());

                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue(listSanpham.get(i).getTrangThai());

            }

            File f = new File("D://danhsach.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                wordkbook.write(fis);
                fis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(this, "in thanh cong D:\\danhsach");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Loi mo file");
        }


    }//GEN-LAST:event_btnIndulieuActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        lblanh.setIcon(null);
//        txtAnh.setText("");
        txtMota.setText("");
        txtGia.setText("");
        txtNambh.setText("");
        txtSoluong1.setText("");

    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        SanPham s = new SanPham();

        s.setMa(txtMaSp.getText());
        s.setTen(txtTenSP.getText());
        service_sp.sua(s);
        listSP = service_sp.getAllSP();
        JOptionPane.showMessageDialog(this, "Sửa sản phẩm ");
        FillSp();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void btnSuaChitietSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaChitietSpActionPerformed
        int i = tblSanpham.getSelectedRow();
        int row1 = tblSanpham.getSelectedRow();

        Anh a = new Anh();
        a.setTen(txtTenSP.getText());
        a.setUrlImage(urlPic);

//        service_anh.sua(a, lblTenspct.getText());
//        listAnh = service_anh.getListAnh();
//        service_sanpham.update(lblMaspct.getText(), capnhatsp());
//        listSanpham = service_sanpham.getAllSp();
//        JOptionPane.showMessageDialog(this, "Cập nhật trạng thái thành công");
//
//        fillSanpham();
        if (checkSanpham()) {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
//               
                service_anh.sua(a, lblTenspct.getText());
                listAnh = service_anh.getListAnh();
                service_sanpham.update(lblMaspct.getText(), capnhatsp());
                listSanpham = service_sanpham.getAllSp();
                JOptionPane.showMessageDialog(this, "Sửa thành công");

                fillSanpham();
            }
        }
    }//GEN-LAST:event_btnSuaChitietSpActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        defaultTable = (DefaultTableModel) tblSanpham.getModel();
        defaultTableCT = (DefaultTableModel) tblSanphamct.getModel();
        fillSanphamCT();
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportWorkBook = null;
//        
        String currentDirectoryPath = "C:\\Users\\HP probook\\OneDrive\\Máy tính";
        JFileChooser excelFileChooserImport = new JFileChooser(currentDirectoryPath);

        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEl FILES", "xls", "xlsx", "xlsm");
        excelFileChooserImport.setFileFilter(fnef);
//        
        excelFileChooserImport.setDialogTitle("Select Excel File");
        int excelChooser = excelFileChooserImport.showOpenDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                File excelFile = excelFileChooserImport.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportWorkBook = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportWorkBook.getSheetAt(0);

                for (int i = 0; i < excelSheet.getLastRowNum(); i++) {

                    XSSFRow excelRow = excelSheet.getRow(i);
                    XSSFCell celllImportedSTT = excelRow.getCell(0);
                    XSSFCell celllImportedMa = excelRow.getCell(1);
//                    System.out.println(celll);
                    XSSFCell celllImportedTen = excelRow.getCell(2);
//                    XSSFCell celllImportedAnh = excelRow.getCell(3);
                    XSSFCell celllImportedMota = excelRow.getCell(3);
                    XSSFCell celllImportedDongia = excelRow.getCell(4);
                    XSSFCell celllImportedSoluong = excelRow.getCell(5);
                    XSSFCell celllImportedDongsp = excelRow.getCell(6);
                    XSSFCell celllImportedSize = excelRow.getCell(7);
                    XSSFCell celllImportedDM = excelRow.getCell(8);
                    XSSFCell celllImportedMau = excelRow.getCell(9);
                    XSSFCell celllImportedNam = excelRow.getCell(10);
                    XSSFCell celllImportedTT = excelRow.getCell(11);

//                    JLabel excelJL=new JLabel(new ImageIcon());
                    defaultTable.addRow(new Object[]{i + listSanpham.size() + 1, celllImportedMa, celllImportedTen,
                        celllImportedMota,
                        celllImportedDongia, celllImportedSoluong,
                        celllImportedDongsp, celllImportedSize,
                        celllImportedDM, celllImportedMau,
                        celllImportedNam, celllImportedTT
                    });

                    defaultTableCT.addRow(new Object[]{i + listSanpham.size() + 1,
                        celllImportedMa, celllImportedTen,
                        celllImportedMota,
                        celllImportedDongia, celllImportedSoluong,
                        celllImportedDongsp, celllImportedSize,
                        celllImportedDM, celllImportedMau,
                        celllImportedNam, celllImportedTT
                    });
                }

                JOptionPane.showMessageDialog(null, "Lay du lieu thanh cong");

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(Sanshamsieumoi.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public String stt() {
        int i = listSanpham.size() + 1;
        return null;
    }
    private void btnHoatdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoatdongActionPerformed
        // TODO add your handling code here:
        defaultTable.setRowCount(0);
        defaultTable = (DefaultTableModel) tblSanpham.getModel();
        listSanpham = service_sanpham.getAllSp();
        for (int i = 0; i < listSanpham.size(); i++) {
            defaultTable.addRow(new Object[]{i + 1,
                listSanpham.get(i).getIdSp(), listSanpham.get(i).getTensp(), listSanpham.get(i).getMoTa(),
                listSanpham.get(i).getGia(), listSanpham.get(i).getSoluong(),
                listSanpham.get(i).getIdDongsp(), listSanpham.get(i).getIdSize(), listSanpham.get(i).getMaDanhmuc(),
                listSanpham.get(i).getIdMausac(), listSanpham.get(i).getThoiGianBH(), listSanpham.get(i).TrangThai()
            });
        }
    }//GEN-LAST:event_btnHoatdongActionPerformed

    private void btnDunghoatdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDunghoatdongActionPerformed
        // TODO add your handling code here:
        defaultTable.setRowCount(0);
        defaultTable = (DefaultTableModel) tblSanpham.getModel();
        listDungHD = service_sanpham.getDungHD();

        for (int i = 0; i < listDungHD.size(); i++) {
            defaultTable.addRow(new Object[]{i + 1,
                listDungHD.get(i).getIdSp(), listDungHD.get(i).getTensp(), listDungHD.get(i).getMoTa(),
                listDungHD.get(i).getGia(), listDungHD.get(i).getSoluong(),
                listDungHD.get(i).getIdDongsp(), listDungHD.get(i).getIdSize(), listDungHD.get(i).getMaDanhmuc(),
                listDungHD.get(i).getIdMausac(), listDungHD.get(i).getThoiGianBH(), listDungHD.get(i).TrangThai()
            });
        }
    }//GEN-LAST:event_btnDunghoatdongActionPerformed

    private void cboDongspMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboDongspMouseReleased
        // TODO add your handling code here:
        listDongsp = service_dongsp.getListDongsp();
        cboDongsp.setModel(new DefaultComboBoxModel(listDongsp.toArray()));
    }//GEN-LAST:event_cboDongspMouseReleased

    private void cboSizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboSizeMouseReleased
        // TODO add your handling code here:
//        DefaultComboBoxModel dcbm=new DefaultComboBoxModel();
//        listSize = sizerp.getone();
//        cboSize.setModel(dcbm = new DefaultComboBoxModel());
        List<Size1> listSize1 = new ArrayList<>();
        listSize1 = sizerp.getone();
        cboSize.setModel(new DefaultComboBoxModel(listSize1.toArray()));
//        for (Size sanphamProduct : listSize) {
//            dcbm.addElement(sanphamProduct.getSoSize());
//        }

    }//GEN-LAST:event_cboSizeMouseReleased

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void txtTimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemKeyReleased
        // TODO add your handling code here:
        SanPhamRepository repository = new SanPhamRepository();
        repository.timSP(txtTimkiem.getText());
        defaultTableCT.setRowCount(0);
        defaultTableCT = (DefaultTableModel) tblSanphamct.getModel();
        listSanpham1 = repository.timSP(txtTimkiem.getText());
        for (int i = 0; i < listSanpham1.size(); i++) {
            defaultTableCT.addRow(new Object[]{i + 1,
                listSanpham1.get(i).getIdSp(), listSanpham1.get(i).getTensp(),
                listSanpham1.get(i).getMoTa(),
                listSanpham1.get(i).getGia(), listSanpham1.get(i).getSoluong(),
                listSanpham1.get(i).getIdDongsp(), listSanpham1.get(i).getIdSize(), listSanpham1.get(i).getMaDanhmuc(),
                listSanpham1.get(i).getIdMausac(), listSanpham1.get(i).getThoiGianBH(), listSanpham1.get(i).TrangThai()
            });
        }
    }//GEN-LAST:event_txtTimkiemKeyReleased

    private void txtTimkiem1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiem1KeyReleased
        // TODO add your handling code here:
        SanPhamRepository repository = new SanPhamRepository();
        repository.timSP(txtTimkiem1.getText());
        defaultTable.setRowCount(0);
        defaultTable = (DefaultTableModel) tblSanpham.getModel();
        listSanpham = repository.timSP(txtTimkiem1.getText());
        for (int i = 0; i < listSanpham.size(); i++) {
            defaultTable.addRow(new Object[]{i + 1,
                listSanpham.get(i).getIdSp(), listSanpham.get(i).getTensp(),
                listSanpham.get(i).getMoTa(),
                listSanpham.get(i).getGia(), listSanpham.get(i).getSoluong(),
                listSanpham.get(i).getIdDongsp(), listSanpham.get(i).getIdSize(), listSanpham.get(i).getMaDanhmuc(),
                listSanpham.get(i).getIdMausac(), listSanpham.get(i).getThoiGianBH(), listSanpham.get(i).TrangThai()
            });
        }
    }//GEN-LAST:event_txtTimkiem1KeyReleased

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        txtMaSp.setText("");
        txtTenSP.setText("");
    }//GEN-LAST:event_jButton17ActionPerformed

    public boolean checkdieuKien() {
        if (txtMaDanhmuc.getText().isBlank()) {
            lblMadm.setText("Mã dòng còn trống");

        } else {
            lblMadm.setText("");
        }

        if (txtTenDanhmuc.getText().isBlank()) {
            lblTenDM.setText("Tên dòng sp còn trống");
            return false;
        } else {
            lblTenDM.setText("");
        }

        if (txtMotaDanhmuc.getText().isBlank()) {
            lblMotaDM.setText("Tên dòng sp còn trống");
            return false;
        } else {
            lblMotaDM.setText("");
        }
        return true;
    }

    public boolean checkdkupdate() {

        if (txtTenDanhmuc.getText().isBlank()) {
            lblTenDM.setText("Tên dòng sp còn trống");
            return false;
        } else {
            lblTenDM.setText("");
        }

        if (txtMotaDanhmuc.getText().isBlank()) {
            lblMotaDM.setText("Tên dòng sp còn trống");
            return false;
        } else {
            lblMotaDM.setText("");
        }

        return true;
    }
    //check ma trung

    private boolean checkMatcher(List<DanhMuc> list, String maDanhMuc) {

        for (DanhMuc taikhoan : list) {
            if (taikhoan.getMaDanhMuc().equals(maDanhMuc)) {
                JOptionPane.showMessageDialog(this, "Mã dòng đã tồn tại");
                return false;
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapnhatctsp;
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnDunghoatdong;
    private javax.swing.JButton btnHoatdong;
    private javax.swing.JButton btnIndulieu;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSuaChitietSp;
    private javax.swing.JButton btnSuaMS;
    private javax.swing.JButton btnSuadanhmuc;
    private javax.swing.JButton btnThemMS;
    private javax.swing.JButton btnThemctsp;
    private javax.swing.JButton btnThemdanhmuc;
    private javax.swing.JButton btnXoaDanhmuc;
    private javax.swing.JButton btnXoaMS;
    private javax.swing.JComboBox<String> cboDanhmuc;
    private javax.swing.JComboBox<String> cboDongsp;
    private javax.swing.JComboBox<String> cboLoaiHangLoc;
    private javax.swing.JComboBox<String> cboMausac;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblDanhmuc1;
    private javax.swing.JLabel lblDongsp1;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblMaDong;
    private javax.swing.JLabel lblMaMS;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblMadm;
    private javax.swing.JLabel lblMaspct;
    private javax.swing.JLabel lblMausac;
    private javax.swing.JLabel lblMotaDM;
    private javax.swing.JLabel lblNambh;
    private javax.swing.JLabel lblSoluong;
    private javax.swing.JLabel lblTenDM;
    private javax.swing.JLabel lblTenDong;
    private javax.swing.JLabel lblTenMS;
    private javax.swing.JLabel lblTenSP;
    private javax.swing.JLabel lblTenspct;
    private javax.swing.JLabel lblanh;
    private javax.swing.JTable tblDanhmuc;
    private javax.swing.JTable tblDongsp;
    private javax.swing.JTable tblMausac;
    private javax.swing.JTable tblSanpham;
    private javax.swing.JTable tblSanphamct;
    private javax.swing.JTable tblSize;
    private javax.swing.JTable tblSp;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaDanhmuc;
    private javax.swing.JTextField txtMaSp;
    private javax.swing.JTextField txtMamausac;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextField txtMotaDanhmuc;
    private javax.swing.JTextField txtNambh;
    private javax.swing.JTextField txtSoluong1;
    private javax.swing.JTextField txtTenDanhmuc;
    private javax.swing.JTextField txtTenDong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenmausac;
    private javax.swing.JTextField txtTimkiem;
    private javax.swing.JTextField txtTimkiem1;
    private javax.swing.JTextField txtcannangmax;
    private javax.swing.JTextField txtcannangmin;
    private javax.swing.JTextField txtchieucaomax;
    private javax.swing.JTextField txtchieucaomin;
    private javax.swing.JTextField txtmaDong;
    private javax.swing.JTextField txtmasize;
    private javax.swing.JTextField txttensize;
    // End of variables declaration//GEN-END:variables
}
