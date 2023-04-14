/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.List;

/**
 *
 * @author c
 */
public class ThongKenowViewModel {
    private String tongtien;

    @Override
    public String toString() {
        return "ThongKenowViewModel{" + "tongtien=" + tongtien + '}';
    }

    public ThongKenowViewModel(String tongtien) {
        this.tongtien = tongtien;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public ThongKenowViewModel() {
    }
    
     public Object[] todatarow(){
        return new Object[] {tongtien};
    }

    
}
