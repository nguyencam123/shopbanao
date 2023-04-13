/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;



/**
 *
 * @author Admin
 */
public class ChiTietSP {

    private String id;
    private String idSP;
    private String idSize;
    private String idMauSac;
    private String idDongSP;
    private String idAnh;
    private String maDanhMuc;
    private Integer thoiGianBH;
    private Double gia;
    private int soluong;
    private Integer trangThai;

    public ChiTietSP() {
    }

    public ChiTietSP(String id, String idSP, String idSize, String idMauSac, String idDongSP, String idAnh, String maDanhMuc, Integer thoiGianBH, Double gia, int soluong, Integer trangThai) {
        this.id = id;
        this.idSP = idSP;
        this.idSize = idSize;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.idAnh = idAnh;
        this.maDanhMuc = maDanhMuc;
        this.thoiGianBH = thoiGianBH;
        this.gia = gia;
        this.soluong = soluong;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public String getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(String idAnh) {
        this.idAnh = idAnh;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public Integer getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(Integer thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

   
 public String TrangThai() {
         if(trangThai==1){
            return "Đang hoạt động";
        }else{
            return "Dừng hoạt động";
        }
    }
   

}
