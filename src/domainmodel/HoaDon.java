/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {

     private String maHD;
    private String TenKH;
    private String TenSP;
    private Date NgayTao;
    private Double TongTien;
    private Double TienCanTra;
    private Double TienKhachDua;
    private Double TIenThua;
    private int TrangThai;
    private String maKM;
    private String maNV;
    private String SDT;
    private int sl;

    public HoaDon() {
    }

    public HoaDon(String maHD, String TenKH, String TenSP, Date NgayTao, Double TongTien, Double TienCanTra, Double TienKhachDua, Double TIenThua, int TrangThai, String maKM, String maNV, String SDT, int sl) {
        this.maHD = maHD;
        this.TenKH = TenKH;
        this.TenSP = TenSP;
        this.NgayTao = NgayTao;
        this.TongTien = TongTien;
        this.TienCanTra = TienCanTra;
        this.TienKhachDua = TienKhachDua;
        this.TIenThua = TIenThua;
        this.TrangThai = TrangThai;
        this.maKM = maKM;
        this.maNV = maNV;
        this.SDT = SDT;
        this.sl = sl;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public void setTongTien(Double TongTien) {
        this.TongTien = TongTien;
    }

    public Double getTienCanTra() {
        return TienCanTra;
    }

    public void setTienCanTra(Double TienCanTra) {
        this.TienCanTra = TienCanTra;
    }

    public Double getTienKhachDua() {
        return TienKhachDua;
    }

    public void setTienKhachDua(Double TienKhachDua) {
        this.TienKhachDua = TienKhachDua;
    }

    public Double getTIenThua() {
        return TIenThua;
    }

    public void setTIenThua(Double TIenThua) {
        this.TIenThua = TIenThua;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

   

}
