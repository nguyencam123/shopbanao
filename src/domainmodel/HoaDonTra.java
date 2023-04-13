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
public class HoaDonTra {

    private String maHDT;
    private Date ngayLapHD;
    private BigDecimal tongTien;
    private String liDoTra;
    private String maHD;
    private String maNV;

    public HoaDonTra() {
    }

    public HoaDonTra(String maHDT, Date ngayLapHD, BigDecimal tongTien, String liDoTra, String maHD, String maNV) {
        this.maHDT = maHDT;
        this.ngayLapHD = ngayLapHD;
        this.tongTien = tongTien;
        this.liDoTra = liDoTra;
        this.maHD = maHD;
        this.maNV = maNV;
    }

    public String getMaHDT() {
        return maHDT;
    }

    public void setMaHDT(String maHDT) {
        this.maHDT = maHDT;
    }

    public Date getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(Date ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getLiDoTra() {
        return liDoTra;
    }

    public void setLiDoTra(String liDoTra) {
        this.liDoTra = liDoTra;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

}
