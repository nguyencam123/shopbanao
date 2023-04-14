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
public class KhuyenMai {

    private String maKM;
    private String tenKM;
    private Double soTienGiam;
    private Date ngayBD;
    private Date ngayKT;
    private Integer trangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(Date ngayBD, Date ngayKT) {
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public KhuyenMai(String maKM, String tenKM, Double soTienGiam, Date ngayBD, Date ngayKT, Integer trangThai) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.soTienGiam = soTienGiam;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.trangThai = trangThai;
    }

    public KhuyenMai(Double soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

  
    

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public Double getSoTienGiam() {
        return soTienGiam;
    }

    public void setSoTienGiam(Double soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

       @Override
    public String toString(){
        return tenKM;
    }

    public KhuyenMai(String maKM, String tenKM, Date ngayBD, Date ngayKT) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

}
