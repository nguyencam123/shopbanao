/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author HP probook
 */
public class bangSPinHoaDon {

    private String maSP;
    private String tenSP;
    private String Hang;
    private String MauSac;
    private int Size;
    private double Gia;
    private int SoLuong;
    private String MoTa;
    private int trangthai;

    public bangSPinHoaDon() {
    }

    public bangSPinHoaDon(String maSP, String tenSP, String Hang, String MauSac, int Size, double Gia, int SoLuong, String MoTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.Hang = Hang;
        this.MauSac = MauSac;
        this.Size = Size;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.MoTa = MoTa;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    @Override
    public String toString() {
        return "bangSPinHoaDon{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", Hang=" + Hang + ", MauSac=" + MauSac + ", Size=" + Size + ", Gia=" + Gia + ", SoLuong=" + SoLuong + ", MoTa=" + MoTa + ", trangthai=" + trangthai + '}';
    }

    public Object[] todatarow() {
        return new Object[]{maSP,tenSP,Hang,MauSac,Size,Gia,SoLuong,MoTa,trangthai};
    }

}
