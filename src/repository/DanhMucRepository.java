/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.DanhMuc;
import domainmodel.DongSP;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DBConnection;

/**
 *
 * @author PC DUNG
 */
public class DanhMucRepository {

    DBConnection DB;
    List<DanhMuc> list = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public List<DanhMuc> getListDanhMuc() {
        list = new ArrayList<>();
        String select = "select*from DanhMuc";
        try {
            pst = DB.getConnection().prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setMaDanhMuc(rs.getString(1));
                danhMuc.setTen(rs.getString(2));
                danhMuc.setMoTa(rs.getString(3));
                list.add(danhMuc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String insertDongSP(DanhMuc danhMuc) {
        String insert = "INSERT INTO DanhMuc\n"
                + "                  (MaDanhMuc, Ten,MoTa)\n"
                + "VALUES (?,?,?)";
        try {
            pst = DB.getConnection().prepareStatement(insert);

            pst.setString(1, danhMuc.getMaDanhMuc());
            pst.setString(2, danhMuc.getTen());
            pst.setString(3, danhMuc.getMoTa());
            pst.executeUpdate();
            return "Thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "That bai";
        }
    }

    public String updateDongSP(DanhMuc danhMuc) {
        String update = "UPDATE  DanhMuc  \n"
                + "SET    Ten =? , MoTa=? where MaDanhMuc=?";
                
        
        try {
            pst = DB.getConnection().prepareStatement(update);
            pst.setString(1, danhMuc.getMaDanhMuc());
            pst.setString(2, danhMuc.getTen());
            pst.setString(3, danhMuc.getMoTa());
            pst.executeUpdate();
            return "Thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "That bai";
        }
    }

    public String deleteDongSP(String maDanhMuc) {
        String delete = "Delete from DanhMuc where MaDanhMuc=?";
        try {
            pst = DB.getConnection().prepareStatement(delete);
            pst.setString(1, maDanhMuc);
            pst.executeUpdate();
            return "Thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "That bai";
        }
    }

    public static void main(String[] args) {
        for (DanhMuc arg : new DanhMucRepository().getListDanhMuc()) {
            System.out.println(arg);
        }
    }
}
