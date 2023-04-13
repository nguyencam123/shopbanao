/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

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
public class DongspRepository {

    DBConnection DB;
    List<DongSP> listDongSP = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public List<DongSP> getListDongSP() {
        listDongSP = new ArrayList<>();
        String select = "select*from DongSP";
        try {
            pst = DB.getConnection().prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {
                DongSP dong = new DongSP();
                dong.setId(rs.getString(1));
                dong.setMa(rs.getString(2));
                dong.setTen(rs.getString(3));
                listDongSP.add(dong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DongspRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDongSP;
    }

    public String insertDongSP(DongSP dog) {
        String insert = "INSERT INTO DongSP\n"
                + "                  (Ma, Ten)\n"
                + "VALUES (?,?)";
        try {
            pst = DB.getConnection().prepareStatement(insert);

            pst.setString(1, dog.getMa());
            pst.setString(2, dog.getTen());
            pst.executeUpdate();
            return "Thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(DongspRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "That bai";
        }
    }

    public String updateDongSP(DongSP d) {
        String update = "UPDATE DongSP\n"
                + "SET   Ma =?, Ten =? where id=? ";
        try {
            pst = DB.getConnection().prepareStatement(update);
            pst.setString(1, d.getMa());
            pst.setString(2, d.getTen());
            pst.setString(3, d.getId());
            pst.executeUpdate();
            return "Thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(DongspRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "That bai";
        }
    }

    public String deleteDongSP(String dong) {
        String delete = "Delete from Dongsp where id=?";
        try {
            pst=DB.getConnection().prepareStatement(delete);
            pst.setString(1, dong);
            pst.executeUpdate();
            return "Thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(DongspRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "That bai";
        }
    }
     public static void main(String[] args) {
        for (DongSP arg : new DongspRepository().getListDongSP()) {
            System.out.println(arg);
        }
    }
}
