/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author HP probook
 */
public class GioHang {

    private String TenSP;
    private String Hang;
    private String MauSac;
    private int Size;
    private int SoLuong;
    private double Gia;

    public GioHang() {
    }

    public GioHang(String TenSP, String Hang, String MauSac, int Size, int SoLuong, double Gia) {
        this.TenSP = TenSP;
        this.Hang = Hang;
        this.MauSac = MauSac;
        this.Size = Size;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
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

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }
     public int Thanhtien() {
        return (int) (this.Gia * this.SoLuong);
    }

   
   
    

}
