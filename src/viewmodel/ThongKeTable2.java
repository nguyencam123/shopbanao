/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author c
 */
public class ThongKeTable2 {
    private String ma;
    private String name;
    private int soluong;

    public ThongKeTable2() {
    }

    public ThongKeTable2(String ma, String name, int soluong) {
        this.ma = ma;
        this.name = name;
        this.soluong = soluong;
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    
    
    public Object[] todatarow(){
        return new Object[] {name,ma,soluong};
    }
    
}
