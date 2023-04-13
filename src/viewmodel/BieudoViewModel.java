/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author c
 */
public class BieudoViewModel {
    private String ngaytao;
    private int tongtien;

    public BieudoViewModel() {
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public BieudoViewModel(String ngaytao, int tongtien) {
        this.ngaytao = ngaytao;
        this.tongtien = tongtien;
    }

    
}
