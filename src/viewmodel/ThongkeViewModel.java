/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author c
 */
public class ThongkeViewModel {
    private String ma;
    private String name;
    private String soluong;
    private String trangthai;

    public ThongkeViewModel() {
    }

    public ThongkeViewModel(String ma, String name, String soluong, String trangthai) {
        this.ma = ma;
        this.name = name;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "ThongkeViewModel{" + "ma=" + ma + ", name=" + name + ", soluong=" + soluong + ", trangthai=" + trangthai + '}';
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    
    
    public Object[] todatarow(){
        return new Object[] {ma,name,soluong,trangthai};
    }
}
