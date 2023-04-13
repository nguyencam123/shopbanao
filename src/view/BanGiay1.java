/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.raven.main.Main;
import com.toedter.calendar.JCalendar;
import domainmodel.HoaDon;
import domainmodel.KhuyenMai;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import repository.HoaDonRepository;
import service.IHoaDonService;
import service.impl.HoaDonService;
import viewmodel.GioHang;
import viewmodel.bangSPinHoaDon;
import viewmodel.HoaDonChiTiet;

/**
 *
 * @author HP probook
 */
public class BanGiay1 extends javax.swing.JPanel implements Runnable, ThreadFactory {

    FrmLogin fl = new FrmLogin();
    ToanCuc h = new ToanCuc();
    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    HoaDonService hds = null;
    List<bangSPinHoaDon> banglist = new ArrayList<>();

    /**
     * Creates new form BanGiay
     */
    public BanGiay1() {

        initComponents();
        txtMaNV.setText(h.getMaNV());
        dtmSP = (DefaultTableModel) tblSP.getModel();
        listSP = hoaDonService.getSP();
        dtmGH = (DefaultTableModel) tblGH.getModel();
        listGH = hoaDonService.getGH();
        dtmHDCT = (DefaultTableModel) tblHoaDon.getModel();
        listHDCT = hoaDonService.getHD();
        listKM = hoaDonService.getKM();
        cbxKM.setModel(new DefaultComboBoxModel(listKM.toArray()));
        hoaDonService.bttaoGH();

        loadHDCT();
        loadSP();
        loadGH();

//        btnTaoHd.setEnabled(false);
//        btnHuy.setEnabled(false);
//        btnThanhToan.setEnabled(false);
//        btnXuatHd.setEnabled(false);
    }
    int i = 0;

    private void initWebcam() {
        if (i == 0) {
            Dimension size = WebcamResolution.QVGA.getSize();
            webcam = Webcam.getWebcams().get(0); //0 is default webcam
            webcam.setViewSize(size);

            panel = new WebcamPanel(webcam);
            panel.setPreferredSize(size);
            panel.setFPSDisplayed(true);

            cam1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 391, 288));

            executor.execute(this);
        }

    }

    @Override
    public void run() {

        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {
                result_field.setText(result.getText());
                int t = 0;

                String soLuong = JOptionPane.showInputDialog("Số lượng ", "1");
                int sl = Integer.parseInt(tblSP.getValueAt(i, 6).toString());
                if (Integer.valueOf(soLuong) <= sl) {
                    IHoaDonService donService = new HoaDonService();
                    donService.ClickSpVaoHd2(result_field.getText(), Integer.parseInt(soLuong));
                    loadGH();
                    loadSP();
                    for (GioHang h : listGH) {
                        t = (int) (t + h.getGia());
                    }
                    float tiengiam = Float.valueOf(txtTienGiam.getText());
                    float tienct = t - tiengiam;
                    txtTongTien.setText(String.valueOf(t));

                    txtTienCanTra.setText(String.valueOf(tienct));
                    // float tienKD = Float.valueOf(txtTienKD.getText());
                    // float tienThua = tienKD - tienct;
                    // txtTienThua.setText(String.valueOf(tienThua));
                    JCalendar jcalendar = new JCalendar();
                    ngaytao.setDate(jcalendar.getDate());
                } else {
                    JOptionPane.showMessageDialog(this, "Số lượng vượt quá sản phẩm của cửa hàng.");
                }

            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtmSP = new DefaultTableModel();
    private DefaultTableModel dtmHDCT = new DefaultTableModel();
    private DefaultTableModel dtmGH = new DefaultTableModel();
    private DefaultComboBoxModel boxModel = new DefaultComboBoxModel();

    private IHoaDonService hoaDonService = new HoaDonService();
    List<bangSPinHoaDon> listSP = new ArrayList<>();
    List<bangSPinHoaDon> listSP2 = new ArrayList<>();

    List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    List<HoaDonChiTiet> listHDCT2 = new ArrayList<>();

    List<GioHang> listGH = new ArrayList<>();
    List<GioHang> listGH1 = new ArrayList<>();
    private HoaDonRepository rr = new HoaDonRepository();
    List<KhuyenMai> listKM = new ArrayList<>();

    public void loadSP() {
        dtmSP.setRowCount(0);
        dtmSP = (DefaultTableModel) tblSP.getModel();
        listSP = hoaDonService.getSP();
        for (bangSPinHoaDon s : listSP) {
            dtmSP.addRow(new Object[]{s.getMaSP(), s.getTenSP(), s.getHang(), s.getMauSac(), s.getSize(),
                s.getGia(), s.getSoLuong(), s.getMoTa()});
        }
    }

    public void locsizesp() {
//        dtmSP.setRowCount(0);
//        dtmSP = (DefaultTableModel) tblSP.getModel();
//        banglist=rr.showttthongke(cannang, chieucao);
//        showdatatable(listSP);
        int cannang = Integer.parseInt(txtcannang.getText());
        int chieucao = Integer.parseInt(txtchieucao.getText());
        dtmSP.setRowCount(0);
        dtmSP = (DefaultTableModel) tblSP.getModel();
        listSP = rr.showttthongke(cannang, chieucao);
        for (bangSPinHoaDon s : listSP) {
            dtmSP.addRow(new Object[]{s.getMaSP(), s.getTenSP(), s.getHang(), s.getMauSac(), s.getSize(),
                s.getGia(), s.getSoLuong(), s.getMoTa()});
        }
    }

    public void loadGH() {
        dtmGH.setRowCount(0);
        dtmGH = (DefaultTableModel) tblGH.getModel();
        listGH = hoaDonService.getGH();

        for (GioHang s : listGH) {
            dtmGH.addRow(new Object[]{s.getTenSP(), s.getHang(), s.getMauSac(),
                s.getSize(), s.getSoLuong(), s.getGia()
            });
        }
    }

    public void loadHDCT() {
        dtmHDCT.setRowCount(0);
        dtmHDCT = (DefaultTableModel) tblHoaDon.getModel();
        listHDCT = hoaDonService.getHD();
        for (HoaDonChiTiet s : listHDCT) {
            dtmHDCT.addRow(new Object[]{s.getMaHD(), s.getTenKH(), s.getTenSP(), s.getSl(), s.getMaNV(),
                s.getNgayTao(), s.getTongTien(), s.getTienCanTra(), s.getTienKhachDua(),
                s.getTIenThua(), s.TrangThai()
            });
        }
    }

    HoaDonChiTiet ThongTinHD() {
        HoaDonChiTiet h = new HoaDonChiTiet();
        h.setMaHD(txtMaHD.getText());
        h.setNgayTao(ngaytao.getDate());
        h.setTongTien(Double.valueOf(txtTongTien.getText()));
        h.setSDT(txtSDT.getText());
        h.setTenKH(txtTenKH.getText());
        h.setMaKM(cbxKM.getSelectedItem().toString());
        h.setTienCanTra(Double.valueOf(txtTienCanTra.getText()));
        h.setTienKhachDua(Double.valueOf(txtTienKD.getText()));
        h.setTIenThua(Double.valueOf(txtTienThua.getText()));
        h.setTienCanTra(Double.valueOf(txtTienCanTra.getText()));
        h.setTrangThai(TrangThai());
        h.setMaNV(txtMaNV.getText());

        listHDCT.add(h);
        return h;
    }

    HoaDonChiTiet ThongTinHDNew() {
        HoaDonChiTiet h = new HoaDonChiTiet();
        h.setNgayTao(ngaytao.getDate());
        h.setTongTien(Double.valueOf(txtTongTien.getText()));
        h.setSDT(txtSDT.getText());
        h.setTenKH(txtTenKH.getText());
        h.setMaKM(cbxKM.getSelectedItem().toString());
        h.setTienCanTra(Double.valueOf(txtTienCanTra.getText()));
        h.setTienKhachDua(Double.valueOf(txtTienKD.getText()));
        h.setTIenThua(Double.valueOf(txtTienThua.getText()));
        h.setTienCanTra(Double.valueOf(txtTienCanTra.getText()));
        //  h.setTrangThai(TrangThai());
        h.setMaNV(txtMaNV.getText());

        listHDCT.add(h);
        return h;
    }

    HoaDonChiTiet ThongTinHD1() {
        HoaDonChiTiet h = new HoaDonChiTiet();
        h.setMaHD(txtMaHD.getText());

        listHDCT.add(h);
        return h;
    }

    public int TrangThai() {

        try {
            double tkd = Double.valueOf(txtTienKD.getText());
            double tct = Double.valueOf(txtTienCanTra.getText());
            if (tkd < tct) {
                return 2;
            } else {
                return 1;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public void New() {
        hoaDonService.bttaoGH();
        txtTongTien.setText("");

        txtGhiChu.setText("");

        txtMaHD.setText("");
        txtTienCanTra.setText("");
        txtTienKD.setText("0");
        // txtTienThua.setText("");
        txtTienGiam.setText("0");
    }

    public boolean clickSP() {
        int i = tblGH.getSelectedRow();
        if (txtMaHD.getText().isBlank() != true && tblHoaDon.getValueAt(i, 10).toString().equalsIgnoreCase("CHỜ TT")) {
            tblSP.setEnabled(true);
        } else {
            tblSP.setEnabled(false);

        }
        return true;
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtTimSP = new javax.swing.JTextField();
        lblmaHd = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ngaytao = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTienKD = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTienCanTra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTienGiam = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        cbxKM = new javax.swing.JComboBox<>();
        btnThanhToan = new javax.swing.JButton();
        btnTaoHd = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        lblMa = new javax.swing.JLabel();
        btnXuatHd = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();
        lblMaHd = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGH = new javax.swing.JTable();
        btnTaoGh = new javax.swing.JButton();
        btnBoSP = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        cbxDaTT = new javax.swing.JCheckBox();
        cbxChoTT = new javax.swing.JCheckBox();
        cbxTatCa = new javax.swing.JCheckBox();
        txtTim = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnlocsize = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtchieucao = new javax.swing.JTextField();
        txtcannang = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));
        setForeground(java.awt.Color.white);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ SP", "TÊN SP", "HÃNG", "MÀU SẮC", "SIZE", "ĐƠN GIÁ", "SỐ LƯỢNG", "MÔ TẢ"
            }
        ));
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSP);

        jLabel13.setText("Tìm Kiếm");

        txtTimSP.setBackground(new java.awt.Color(255, 204, 204));
        txtTimSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtTimSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimSPActionPerformed(evt);
            }
        });
        txtTimSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimSPKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        lblmaHd.setBackground(new java.awt.Color(255, 204, 204));
        lblmaHd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        lblmaHd.setForeground(new java.awt.Color(22, 143, 241));

        jLabel1.setText("MAHD");

        txtMaHD.setEditable(false);

        jLabel2.setText("NGÀY TẠO");

        jLabel3.setText("TỔNG");

        txtTienThua.setText("0");

        jLabel4.setText("TIỀN CT");

        jLabel5.setText("TIỀN KD");

        jLabel6.setText("TIỀN THỪA");

        txtTienKD.setText("0");
        txtTienKD.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKDCaretUpdate(evt);
            }
        });
        txtTienKD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTienKDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTienKDFocusLost(evt);
            }
        });
        txtTienKD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTienKDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTienKDMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtTienKDMouseReleased(evt);
            }
        });
        txtTienKD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKDActionPerformed(evt);
            }
        });
        txtTienKD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKDKeyReleased(evt);
            }
        });

        txtTienCanTra.setEditable(false);
        txtTienCanTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienCanTraActionPerformed(evt);
            }
        });

        jLabel7.setText("TENKM");

        jLabel8.setText("MANV");

        jLabel9.setText("TIỀN GIẢM");

        jLabel10.setText("TÊN KH");

        jLabel11.setText("SDT");

        jLabel12.setText("GHI CHÚ");

        txtMaNV.setEditable(false);

        txtTienGiam.setText("0");
        txtTienGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienGiamActionPerformed(evt);
            }
        });

        txtTenKH.setText("KHÁCH LẺ");
        txtTenKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenKHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenKHFocusLost(evt);
            }
        });

        txtSDT.setText("0XXXXXXX1");
        txtSDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSDTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSDTFocusLost(evt);
            }
        });

        cbxKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxKMActionPerformed(evt);
            }
        });

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoHd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaoHd.setText("TẠO HD");
        btnTaoHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHdActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setText("HỦY HD");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXuatHd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuatHd.setText("XUẤT HD");
        btnXuatHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHdActionPerformed(evt);
            }
        });

        bill.setColumns(20);
        bill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bill.setRows(5);
        bill.setText("                           HÓA ĐƠN");
        jScrollPane4.setViewportView(bill);

        lblMaHd.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        lblMaHd.setForeground(java.awt.Color.red);
        lblMaHd.setText("*");

        javax.swing.GroupLayout lblmaHdLayout = new javax.swing.GroupLayout(lblmaHd);
        lblmaHd.setLayout(lblmaHdLayout);
        lblmaHdLayout.setHorizontalGroup(
            lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblmaHdLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblmaHdLayout.createSequentialGroup()
                        .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblmaHdLayout.createSequentialGroup()
                                .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(lblmaHdLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(40, 40, 40)
                                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMaHd)
                                .addGap(48, 48, 48)
                                .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMa)
                                    .addGroup(lblmaHdLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel8)))
                                .addGap(40, 52, Short.MAX_VALUE))
                            .addGroup(lblmaHdLayout.createSequentialGroup()
                                .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addGroup(lblmaHdLayout.createSequentialGroup()
                                        .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblmaHdLayout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18))
                                            .addGroup(lblmaHdLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(16, 16, 16)))
                                        .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                            .addComponent(txtTienKD, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTienCanTra, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9))
                                .addGap(21, 21, 21)))
                        .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTienGiam, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxKM, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(lblmaHdLayout.createSequentialGroup()
                        .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTaoHd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXuatHd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4)))
                .addGap(15, 15, 15))
        );
        lblmaHdLayout.setVerticalGroup(
            lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblmaHdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaHd))
                    .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMa)))
                .addGap(18, 18, 18)
                .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTienCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienKD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(lblmaHdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblmaHdLayout.createSequentialGroup()
                        .addComponent(btnTaoHd, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXuatHd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblGH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "TÊN SP", "HÃNG", "MÀU SẮC", "SIZE", "SL", "GIÁ"
            }
        ));
        jScrollPane3.setViewportView(tblGH);

        btnTaoGh.setText("LÀM MỚI GH");
        btnTaoGh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoGhActionPerformed(evt);
            }
        });

        btnBoSP.setText("XÓA SP");
        btnBoSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnTaoGh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBoSP, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoGh)
                    .addComponent(btnBoSP))
                .addGap(236, 236, 236))
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDon.setAutoCreateRowSorter(true);
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ HD", "TÊN KH", "TÊN SP", "SL", "MANV", "NGÀY TT", "TỔNG", "CẦN TRẢ", "TIỀN KD", "TIỀN THỪA", "TRẠNG THÁI"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        buttonGroup1.add(cbxDaTT);
        cbxDaTT.setText("ĐÃ THANH TOÁN");
        cbxDaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDaTTActionPerformed(evt);
            }
        });

        buttonGroup1.add(cbxChoTT);
        cbxChoTT.setText("CHỜ THANH TOÁN");
        cbxChoTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxChoTTActionPerformed(evt);
            }
        });

        buttonGroup1.add(cbxTatCa);
        cbxTatCa.setText("TẤT CẢ");
        cbxTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTatCaActionPerformed(evt);
            }
        });

        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });
        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKeyReleased(evt);
            }
        });

        jLabel14.setText("Tìm HD");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxDaTT)
                .addGap(18, 18, 18)
                .addComponent(cbxChoTT)
                .addGap(18, 18, 18)
                .addComponent(cbxTatCa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxDaTT)
                    .addComponent(cbxChoTT)
                    .addComponent(cbxTatCa)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("lọc sản phẩm theo chiều cao và cân nặng"));

        btnlocsize.setText("Lọc sản phẩm");
        btnlocsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlocsizeActionPerformed(evt);
            }
        });

        jLabel15.setText("Chiều cao");

        jLabel16.setText("Cân nặng");

        jButton1.setText("tất cả sản phẩm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("bảng quy đổi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(18, 18, 18)
                            .addComponent(txtcannang))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(18, 18, 18)
                            .addComponent(txtchieucao, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnlocsize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtchieucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtcannang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlocsize)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblmaHd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblmaHd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoGhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoGhActionPerformed
        // TODO add your handling code here:

//        btnChoTT.setEnabled(true);
//        btnHuy.setEnabled(true);
//        btnThanhToan.setEnabled(true);
        hoaDonService.bttaoGH();

        for (GioHang g : listGH) {
            hoaDonService.HuyHD(g.getTenSP(), g.getSoLuong());
        }
        hoaDonService.bttaoGH();
        New();
        loadGH();
        loadSP();

    }//GEN-LAST:event_btnTaoGhActionPerformed

    private void btnBoSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoSPActionPerformed
        // TODO add your handling code here:
        int i = tblGH.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần xóa.");
        } else {
            hoaDonService.xoaSPkhoiGH(tblGH.getValueAt(i, 0).toString(), Integer.parseInt(tblGH.getValueAt(i, 4).toString()));
            loadGH();
            loadSP();
            int t = 0;
            for (GioHang h : listGH) {
                t = (int) (t + h.getGia());
            }
            float tiengiam = Float.valueOf(txtTienGiam.getText());
            float tienct = t - tiengiam;
            txtTongTien.setText(String.valueOf(t));

            txtTienCanTra.setText(String.valueOf(tienct));
            float tienKD = Float.valueOf(txtTienKD.getText());
            float tienThua = tienKD - tienct;
            txtTienThua.setText(String.valueOf(tienThua));
        }

    }//GEN-LAST:event_btnBoSPActionPerformed


    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        int i = tblHoaDon.getSelectedRow();
        String regex = "^[1-9]\\d{1}[0-9]{1,}$";
        if (i != -1) {
            double tkd = Double.valueOf(txtTienKD.getText());
            double tct = Double.valueOf(txtTienCanTra.getText());
            if (tkd < tct) {
                   JOptionPane.showMessageDialog(this,"Không đủ tiền thanh toán.");
            } else {
                hoaDonService.tt(ThongTinHDNew(), txtMaHD.getText());
                for (GioHang g : listGH) {
                    hoaDonService.Themhdct(g.getTenSP(), txtMaHD.getText(), g.getSoLuong());
                }
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn in hóa đơn không", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (chon == JOptionPane.YES_OPTION) {
                    bill_print2();
                } else {
                    JOptionPane.showMessageDialog(this, "Thanh toán thành công");

                }
                hoaDonService.bttaoGH();
                loadHDCT();
                loadGH();
                loadSP();

                return;
            }

        }
//
//        double tkd = Double.valueOf(txtTienKD.getText());
//        double tct = Double.valueOf(txtTienCanTra.getText());
//        if (tkd < tct) {
//            JOptionPane.showMessageDialog(this, "Không đủ tiền để thanh toán");
//            return;
//        } else {
//            hoaDonService.ThanhToanCho(Double.valueOf(txtTienKD.getText()), Double.valueOf(txtTienThua.getText()), tblHoaDon.getValueAt(i, 0).toString());
//            JOptionPane.showMessageDialog(this, "Hóa đơn đã được thanh toán.");
//            int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn in hóa đơn không", "Xác nhận", JOptionPane.YES_NO_OPTION);
//            if (chon == JOptionPane.YES_OPTION) {
//                bill_print2();
//            } else {
//                JOptionPane.showMessageDialog(this, "Hóa đơn đã được thanh toán.");
//
//            }
//            loadGH();
//            loadSP();
//            loadHDCT();
//            hoaDonService.bttaoGH();
//        }


    }//GEN-LAST:event_btnThanhToanActionPerformed

    public boolean CheckMa() {
        if (!txtMaHD.getText().isBlank() == true) {
            lblMaHd.setText("");
        } else {
            lblMaHd.setText("Trống MaHD");
            return false;
        }
        return true;
    }

    public boolean checkTrungMa() {
        for (int i = 0; i < listHDCT.size(); i++) {
            if (!listHDCT.get(i).getMaHD().equalsIgnoreCase(txtMaHD.getText())) {
                lblMaHd.setText("");

            } else {
                taoMa2();
                return true;
            }
        }
        return true;
    }
    private void btnTaoHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHdActionPerformed
        // TODO add your handling code here:
        int t = 0;
        taoMa();

        if (CheckMa()) {
            if (checkTrungMa()) {
                hoaDonService.Themhd1(ThongTinHD1());
//                for (GioHang g : listGH) {
//                    Double tct = Double.valueOf(txtTienCanTra.getText());
//                    txtTienKD.setText("0");
//                    Double tt = 0 - tct;
//                    txtTienThua.setText(String.valueOf(tt));
//
//                    t = (int) (t + g.getGia());
//                    txtTongTien.setText(String.valueOf(t));
//                    hoaDonService.Themhdct(g.getTenSP(), txtMaHD.getText(), g.getSoLuong());
//                }
                JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công.");
                loadGH();
                loadHDCT();
                hoaDonService.bttaoGH();
            }
        }


    }//GEN-LAST:event_btnTaoHdActionPerformed

    public String taoMa() {
        int i = listHDCT.size() + 1;
        txtMaHD.setText("HD" + i);
        return null;
    }

    public String taoMa2() {
        int i = listHDCT.size() + 2;
        txtMaHD.setText("HD" + i);
        return null;
    }
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        int i = tblHoaDon.getSelectedRow();
        if (i >= 0) {
            for (GioHang g : listGH) {
                hoaDonService.HuyHD(g.getTenSP(), g.getSoLuong());

            }
            int in = tblHoaDon.getSelectedRow();
            hoaDonService.HuyHD2(tblHoaDon.getValueAt(in, 0).toString());
            JOptionPane.showMessageDialog(this, "Hủy hóa đơn thành công");
            New();
            loadSP();
            loadGH();
            loadHDCT();
            hoaDonService.bttaoGH();
        } else {
            JOptionPane.showMessageDialog(this, "Mời chọn hóa đơn cần hủy.");
        }

    }//GEN-LAST:event_btnHuyActionPerformed

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        // TODO add your handling code here
        int i = tblSP.getSelectedRow();
        String soLuong = JOptionPane.showInputDialog("Số lượng ", "1");
        int sll = Integer.valueOf(tblSP.getValueAt(i, 6).toString());
//        if(Integer.valueOf(soLuong)>sll){
//            JOptionPane.showMessageDialog(this,"Không đủ số lượng.");
//        }
//        btnTaoHd.setEnabled(true);
//        btnHuy.setEnabled(false);
//        btnThanhToan.setEnabled(false);
//        btnXuatHd.setEnabled(false);
        int sl = Integer.parseInt(tblSP.getValueAt(i, 6).toString());
        if (Integer.valueOf(soLuong) <= sl) {
            int t = 0;
            hoaDonService.ClickSpVaoHd2(tblSP.getValueAt(i, 0).toString(), Integer.parseInt(soLuong));
            loadGH();
            loadSP();
            for (GioHang h : listGH) {
                t = (int) (t + h.getGia());
            }
            float tiengiam = Float.valueOf(txtTienGiam.getText());
            float tienct = t - tiengiam;
            txtTongTien.setText(String.valueOf(t));

            txtTienCanTra.setText(String.valueOf(tienct));
            // float tienKD = Float.valueOf(txtTienKD.getText());
            // float tienThua = tienKD - tienct;
            // txtTienThua.setText(String.valueOf(tienThua));
            JCalendar jcalendar = new JCalendar();
            ngaytao.setDate(jcalendar.getDate());
        } else {
            JOptionPane.showMessageDialog(this, "Không đủ sản phẩm để bán. ");
        }
    }//GEN-LAST:event_tblSPMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int i = tblHoaDon.getSelectedRow();
        if (i >= 0) {
            if (tblHoaDon.getValueAt(i, 10).toString().equalsIgnoreCase("CHỜ TT")) {
                btnTaoHd.setEnabled(true);
                btnHuy.setEnabled(true);
                btnThanhToan.setEnabled(true);
                btnXuatHd.setEnabled(true);
                txtMaHD.setText(tblHoaDon.getValueAt(i, 0).toString());
                txtTongTien.setText(tblHoaDon.getValueAt(i, 6).toString());
                txtTienCanTra.setText(tblHoaDon.getValueAt(i, 7).toString());
                txtTienKD.setText(tblHoaDon.getValueAt(i, 8).toString());
                txtTienThua.setText(tblHoaDon.getValueAt(i, 9).toString());
                hoaDonService.bttaoGH();
                loadGH();

            } else {
                btnTaoHd.setEnabled(true);
                btnHuy.setEnabled(false);
                btnThanhToan.setEnabled(false);
                btnXuatHd.setEnabled(true);
                txtMaHD.setText(tblHoaDon.getValueAt(i, 0).toString());
                ngaytao.setDate((Date) tblHoaDon.getValueAt(i, 5));
                // txtTenKH.setText(tblHoaDon.getValueAt(i, 1).toString());
                // txtMaNV.setText(tblHoaDon.getValueAt(i, 4).toString());
                // cbxKM.setSelectedItem(tblHoaDon.getValueAt(i,4).toString());
                txtTongTien.setText(tblHoaDon.getValueAt(i, 6).toString());
                txtTienCanTra.setText(tblHoaDon.getValueAt(i, 7).toString());
                txtTienKD.setText(tblHoaDon.getValueAt(i, 8).toString());
                txtTienThua.setText(tblHoaDon.getValueAt(i, 9).toString());

                dtmGH = (DefaultTableModel) tblGH.getModel();
                dtmGH = (DefaultTableModel) tblGH.getModel();
                if (tblHoaDon.getValueAt(i, 10).equals("ĐÃ TT")) {
                    listGH = hoaDonService.ClickHd(tblHoaDon.getValueAt(i, 0).toString());

                    dtmGH.setRowCount(0);
                    for (GioHang s : listGH) {
                        dtmGH.addRow(new Object[]{s.getTenSP(), s.getHang(), s.getMauSac(),
                            s.getSize(), s.getSoLuong(), s.getGia() * s.getSoLuong()
                        });
                    }
                }
            }

        } else {
            btnTaoHd.setEnabled(true);
            btnHuy.setVisible(false);
            btnThanhToan.setVisible(false);
            btnXuatHd.setVisible(false);

        }

//        btnChoTT.setEnabled(false);
//        btnHuy.setVisible(true);
//        btnThanhToan.setVisible(true);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void cbxDaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDaTTActionPerformed
        // TODO add your handling code here:
        dtmHDCT.setRowCount(0);
        dtmHDCT = (DefaultTableModel) tblHoaDon.getModel();
        listHDCT = hoaDonService.getHD();
        for (int i = 0; i < listHDCT.size(); i++) {
            if (listHDCT.get(i).TrangThai() == "ĐÃ TT") {

                dtmHDCT.addRow(new Object[]{listHDCT.get(i).getMaHD(), listHDCT.get(i).getTenKH(),
                    listHDCT.get(i).getTenSP(), listHDCT.get(i).getSl(), listHDCT.get(i).getMaNV(),
                    listHDCT.get(i).getNgayTao(), listHDCT.get(i).getTongTien(), listHDCT.get(i).getTienCanTra(),
                    listHDCT.get(i).getTienKhachDua(), listHDCT.get(i).getTIenThua(), listHDCT.get(i).TrangThai()});
            }
        }
    }//GEN-LAST:event_cbxDaTTActionPerformed

    private void cbxChoTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxChoTTActionPerformed
        // TODO add your handling code here:
        dtmHDCT.setRowCount(0);
        dtmHDCT = (DefaultTableModel) tblHoaDon.getModel();
        listHDCT = hoaDonService.getHD();
        for (int i = 0; i < listHDCT.size(); i++) {
            if (listHDCT.get(i).getTrangThai() == 2) {

                dtmHDCT.addRow(new Object[]{listHDCT.get(i).getMaHD(), listHDCT.get(i).getTenKH(),
                    listHDCT.get(i).getTenSP(), listHDCT.get(i).getSl(), listHDCT.get(i).getMaNV(),
                    listHDCT.get(i).getNgayTao(), listHDCT.get(i).getTongTien(), listHDCT.get(i).getTienCanTra(),
                    listHDCT.get(i).getTienKhachDua(), listHDCT.get(i).getTIenThua(), listHDCT.get(i).TrangThai()});
            }
        }
    }//GEN-LAST:event_cbxChoTTActionPerformed

    private void cbxTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTatCaActionPerformed
        // TODO add your handling code here:
        dtmHDCT.setRowCount(0);
        dtmHDCT = (DefaultTableModel) tblHoaDon.getModel();
        listHDCT = hoaDonService.getHD();
        for (HoaDonChiTiet s : listHDCT) {
            dtmHDCT.addRow(new Object[]{s.getMaHD(), s.getTenKH(), s.getTenSP(), s.getSl(), s.getMaNV(),
                s.getNgayTao(), s.getTongTien(), s.getTienCanTra(), s.getTienKhachDua(),
                s.getTIenThua(), s.TrangThai()
            });
        }
    }//GEN-LAST:event_cbxTatCaActionPerformed

    private void txtTienKDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKDActionPerformed
        // TODO add your handling code here:
        int i = tblHoaDon.getSelectedRow();
        String regex = "^[1-9]\\d{1}[0-9]{1,}$";
        if (!txtTienKD.getText().matches(regex)) {
            JOptionPane.showMessageDialog(this, "Nhập đúng định dạng tiền.");
            return;
        } else {
//        int t = 0;
//        for (GioHang h : listGH) {
//            t = (int) (t + h.getGia());
//        }
            float t = Float.valueOf(txtTongTien.getText());
            float tiengiam = Float.valueOf(txtTienGiam.getText());
            float tienct = t - tiengiam;
            txtTongTien.setText(String.valueOf(t));

            txtTienCanTra.setText(String.valueOf(tienct));
            float tienKD = Float.valueOf(txtTienKD.getText());
            float tienThua = tienKD - tienct;
            txtTienThua.setText(String.valueOf(tienThua));
        }
    }//GEN-LAST:event_txtTienKDActionPerformed

    private void cbxKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxKMActionPerformed
        // TODO add your handling code here:
        KhuyenMai km = (KhuyenMai) cbxKM.getSelectedItem();
        hoaDonService.getKMsoTienGiam(km.getTenKM());
        txtTienGiam.setText(String.valueOf(km.getSoTienGiam()));
        int t = 0;
        for (GioHang h : listGH) {
            t = (int) (t + h.getGia());
        }
        float tiengiam = Float.valueOf(txtTienGiam.getText());
        float tienct = t - tiengiam;
        txtTongTien.setText(String.valueOf(t));

        txtTienCanTra.setText(String.valueOf(tienct));
        float tienKD = Float.valueOf(txtTienKD.getText());
        float tienThua = tienKD - tienct;
        txtTienThua.setText(String.valueOf(tienThua));
    }//GEN-LAST:event_cbxKMActionPerformed

    public void bill_print() {

        try {
            bill.setText("                     ShoeShopUp \n");
            bill.setText(bill.getText() + "\t589/ King Road, \n");
            bill.setText(bill.getText() + "\tColombo, Srilanka, \n");
            bill.setText(bill.getText() + "\t+9411 123456789, \n");
            bill.setText(bill.getText() + "----------------------------------------------------------------\n");
            bill.setText(bill.getText() + " MaHD \tTênSP \tSL\n");
            bill.setText(bill.getText() + "----------------------------------------------------------------\n");

            DefaultTableModel df = (DefaultTableModel) tblHoaDon.getModel();
            for (int i = 0; i < tblHoaDon.getSelectedRow(); i++) {

                String MaHd = df.getValueAt(i, 0).toString();
                String TenKh = df.getValueAt(i, 1).toString();
                String TenSP = df.getValueAt(i, 2).toString();
                String SL = df.getValueAt(i, 3).toString();
                String ngayTao = df.getValueAt(i, 5).toString();
                String TienCT = df.getValueAt(i, 7).toString();
                String TienKD = df.getValueAt(i, 8).toString();
                String TienThua = df.getValueAt(i, 9).toString();

                bill.setText(bill.getText() + MaHd + "\t" + TenSP + "\t" + SL + "\n");

            }
            int i = tblHoaDon.getSelectedRow();
            String MaHd = df.getValueAt(i, 0).toString();
            String TenKh = df.getValueAt(i, 1).toString();
            String TenSP = df.getValueAt(i, 2).toString();
            String SL = df.getValueAt(i, 3).toString();
            String ngayTao = df.getValueAt(i, 5).toString();
            String TienCT = df.getValueAt(i, 7).toString();
            String TienKD = df.getValueAt(i, 8).toString();
            String TienThua = df.getValueAt(i, 9).toString();

            bill.setText(bill.getText() + "----------------------------------------------------------------\n");
            bill.setText(bill.getText() + "Tiền cần trả :\t" + TienCT + "\n");
            bill.setText(bill.getText() + "Tiền khách đưa :\t" + TienKD + "\n");
            bill.setText(bill.getText() + "Tiền thừa :\t" + TienThua + "\n");
            bill.setText(bill.getText() + "====================================\n");
            bill.setText(bill.getText() + "                     Thanks For Your Business...!" + "\n");
            bill.setText(bill.getText() + "----------------------------------------------------------------\n");
            bill.setText(bill.getText() + "                     Software by Techinbox" + "\n");

            bill.print();

        } catch (PrinterException ex) {

            Logger.getLogger(BanGiay1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void bill_print2() {

        try {
            bill.setText("                         ShoeShopUp \n");
            // bill.setText("\n");
            bill.setText(bill.getText() + " \nMaHD \tTênSP \tSL\n");
            bill.setText(bill.getText() + "----------------------------------------------------------------\n");
//            DefaultTableModel df = (DefaultTableModel) tblHoaDon.getModel();
//            for (int i = 0; i < tblHoaDon.getSelectedRow(); i++) {
            String MaHd = txtMaHD.getText();
            String TenKh = txtTenKH.getText();
            for (GioHang g : listGH) {
                String TenSP = g.getTenSP();
                int SL = g.getSoLuong();
                bill.setText(bill.getText() + MaHd + "\t" + TenSP + "\t" + SL + "\n");

            }

            Date ngayTao = ngaytao.getDate();
            String TienCT = txtTienCanTra.getText();
            String TienKD = txtTienKD.getText();
            String TienThua = txtTienThua.getText();

            //  }
            bill.setText(bill.getText() + "----------------------------------------------------------------\n");
            bill.setText(bill.getText() + "Tiền cần trả :\t" + TienCT + "\n");
            bill.setText(bill.getText() + "Tiền khách đưa :" + TienKD + "\n");
            bill.setText(bill.getText() + "Tiền thừa :\t" + TienThua + "\n");
            bill.setText(bill.getText() + "====================================\n");
            bill.setText(bill.getText() + "              Cảm ơn quý khách " + TenKh + " hẹn gặp lại" + "\n");
            bill.setText(bill.getText() + "----------------------------------------------------------------\n");
            bill.setText(bill.getText() + "               " + ngayTao + "\n");

            bill.print();

        } catch (PrinterException ex) {

            Logger.getLogger(BanGiay1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public void cart_cal() {
//
//        int numofrow = tblHoaDon.getRowCount();
//        double total = 0;
//        for (int i = 0; i < numofrow; i++) {
//            double value = Double.valueOf(tblHoaDon.getValueAt(i, 2).toString());
//            total += value;
//
//        }
//
//        DecimalFormat df = new DecimalFormat("00.00");
//        String d1 = df.format(total);
//        Too.setText(d1);
//
//    }
    private void btnXuatHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHdActionPerformed
        // TODO add your handling code here:

        bill_print2();
    }//GEN-LAST:event_btnXuatHdActionPerformed

    private void txtTienCanTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienCanTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienCanTraActionPerformed

    private void txtTienGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienGiamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienGiamActionPerformed

    private void txtTimSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimSPKeyReleased
        // TODO add your handling code here:
        HoaDonRepository donRepository = new HoaDonRepository();
        donRepository.timSP(txtTimSP.getText());
        dtmSP.setRowCount(0);
        dtmSP = (DefaultTableModel) tblSP.getModel();
        listSP2 = donRepository.timSP(txtTimSP.getText());
        for (bangSPinHoaDon s : listSP2) {
            dtmSP.addRow(new Object[]{s.getMaSP(), s.getTenSP(), s.getHang(), s.getMauSac(), s.getSize(),
                s.getGia(), s.getSoLuong(), s.getMoTa()});
        }

    }//GEN-LAST:event_txtTimSPKeyReleased

    private void txtTimSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimSPActionPerformed

    private void txtTenKHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenKHFocusGained
        // TODO add your handling code here:
        if (txtTenKH.getText().equalsIgnoreCase("KHÁCH LẺ")) {
            txtTenKH.setText("");
        }
    }//GEN-LAST:event_txtTenKHFocusGained

    private void txtTenKHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenKHFocusLost
        // TODO add your handling code here:
        if (txtTenKH.getText().equalsIgnoreCase("")) {
            txtTenKH.setText("KHÁCH LẺ");
        }
    }//GEN-LAST:event_txtTenKHFocusLost

    private void txtSDTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTFocusGained
        // TODO add your handling code here:
        if (txtSDT.getText().equalsIgnoreCase("0XXXXXXX1")) {
            txtSDT.setText("");
        }
    }//GEN-LAST:event_txtSDTFocusGained

    private void txtSDTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTFocusLost
        // TODO add your handling code here:
        if (txtSDT.getText().equalsIgnoreCase("")) {
            txtSDT.setText("0XXXXXXX1");
        }
    }//GEN-LAST:event_txtSDTFocusLost

    private void txtTienKDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKDKeyReleased

    private void txtTimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyReleased
        // TODO add your handling code here:
        dtmHDCT.setRowCount(0);
        dtmHDCT = (DefaultTableModel) tblHoaDon.getModel();
        listHDCT2 = hoaDonService.TimHD(txtTim.getText());

        for (HoaDonChiTiet s : listHDCT2) {
            dtmHDCT.addRow(new Object[]{s.getMaHD(), s.getTenKH(), s.getTenSP(), s.getSl(), s.getMaNV(),
                s.getNgayTao(), s.getTongTien(), s.getTienCanTra(), s.getTienKhachDua(),
                s.getTIenThua(), s.TrangThai()
            });
        }
    }//GEN-LAST:event_txtTimKeyReleased

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimActionPerformed

    private void txtTienKDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTienKDFocusGained
        // TODO add your handling code here:
        if (txtTienKD.getText().equals("0")) {
            txtTienKD.setText("");
        }
    }//GEN-LAST:event_txtTienKDFocusGained

    private void txtTienKDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTienKDFocusLost
        // TODO add your handling code here:
        if (txtTienKD.getText().equals("")) {
            txtTienKD.setText("0");
        }
    }//GEN-LAST:event_txtTienKDFocusLost

    private void txtTienKDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKDKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTienKDKeyPressed

    private void txtTienKDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKDMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTienKDMouseReleased

    private void txtTienKDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKDMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTienKDMouseEntered

    private void txtTienKDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKDMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTienKDMouseClicked

    private void txtTienKDCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKDCaretUpdate
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTienKDCaretUpdate

    private void btnlocsizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlocsizeActionPerformed
        // TODO add your handling code here:
        locsizesp();
    }//GEN-LAST:event_btnlocsizeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        loadSP();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Picturequydoi s = new Picturequydoi();
        s.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bill;
    private javax.swing.JButton btnBoSP;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnTaoGh;
    private javax.swing.JButton btnTaoHd;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXuatHd;
    private javax.swing.JButton btnlocsize;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbxChoTT;
    private javax.swing.JCheckBox cbxDaTT;
    private javax.swing.JComboBox<String> cbxKM;
    private javax.swing.JCheckBox cbxTatCa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblMaHd;
    private javax.swing.JPanel lblmaHd;
    private com.toedter.calendar.JDateChooser ngaytao;
    private javax.swing.JTable tblGH;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTienCanTra;
    private javax.swing.JTextField txtTienGiam;
    private javax.swing.JTextField txtTienKD;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTimSP;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtcannang;
    private javax.swing.JTextField txtchieucao;
    // End of variables declaration//GEN-END:variables
}
