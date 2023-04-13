/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.util.Vector;

/**
 *
 * @author Admin
 */
public class Size1 {

    private String id;
    private String ma;
    private Integer soSize;

    public Size1() {
    }

    public Size1(String id, String ma, Integer soSize) {
        this.id = id;
        this.ma = ma;
        this.soSize = soSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Integer getSoSize() {
        return soSize;
    }

    public void setSoSize(Integer soSize) {
        this.soSize = soSize;
    }

    
    @Override
    public String toString() {
        return "" + soSize + "";
    }

   

    



}
