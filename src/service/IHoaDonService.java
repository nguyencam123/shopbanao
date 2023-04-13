/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.HoaDon;
import domainmodel.KhuyenMai;
import java.util.List;
import viewmodel.GioHang;
import viewmodel.bangSPinHoaDon;
import viewmodel.HoaDonChiTiet;

/**
 *
 * @author Admin
 */
public interface IHoaDonService {

    public List<bangSPinHoaDon> getSP();

    public List<HoaDonChiTiet> getHD();

    public void ClickSpVaoHd(String masp);

    public void bttaoGH();

    public List<GioHang> getGH();

    public void Themhd(HoaDonChiTiet v);

    public void Themhdct(String masp, String mahd, int sl);

    public String HuyHD2(String ma);

    public List<KhuyenMai> getKM();

    public void ThanhToanCho(double tienKD, double tienThua, String mahd);

    public void getKMsoTienGiam(String ma);

    public void xoaSPkhoiGH(String ten, int sl);

    public List<GioHang> ClickHd(String ma);

    public String HuyHD(String ten, int sl);

    public void ClickSpVaoHd2(String masp, int sl);

    public List<HoaDonChiTiet> TimHD(String ten);

    public void Themhd1(HoaDonChiTiet v);

    public void tt(HoaDonChiTiet v, String ma);

    public int getSoHd();
    public List<GioHang> barcode(String ma);
}
