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
public class Size {

    private String id;
    private String ma;
    private int soSize;
    private int cannangmin;
    private int canmangmax;
    private int chieucaomin;
    private int chieucaomax;

    public Size() {
    }

    public Size(String id, String ma, int soSize, int cannangmin, int canmangmax, int chieucaomin, int chieucaomax) {
        this.id = id;
        this.ma = ma;
        this.soSize = soSize;
        this.cannangmin = cannangmin;
        this.canmangmax = canmangmax;
        this.chieucaomin = chieucaomin;
        this.chieucaomax = chieucaomax;
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

    public int getSoSize() {
        return soSize;
    }

    public void setSoSize(int soSize) {
        this.soSize = soSize;
    }

    public int getCannangmin() {
        return cannangmin;
    }

    public void setCannangmin(int cannangmin) {
        this.cannangmin = cannangmin;
    }

    public int getCanmangmax() {
        return canmangmax;
    }

    public void setCanmangmax(int canmangmax) {
        this.canmangmax = canmangmax;
    }

    public int getChieucaomin() {
        return chieucaomin;
    }

    public void setChieucaomin(int chieucaomin) {
        this.chieucaomin = chieucaomin;
    }

    public int getChieucaomax() {
        return chieucaomax;
    }

    public void setChieucaomax(int chieucaomax) {
        this.chieucaomax = chieucaomax;
    }

    @Override
    public String toString() {
        return "" + soSize + "";
    }

}
