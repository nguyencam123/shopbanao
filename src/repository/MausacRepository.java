/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utilities.DBConnection;
import domainmodel.MauSac;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC DUNG
 */
public class MausacRepository {

     DBConnection DB;
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<MauSac> listMausac = null;

    public List<MauSac> getListMauSac() {
        listMausac = new ArrayList<>();

        String select = "Select*from Mausac";

        try {
            pst = DB.getConnection().prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setId(rs.getString(1));
                ms.setMa(rs.getString(2));
                ms.setTen(rs.getString(3));
                listMausac.add(ms);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MausacRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMausac;
    }

    public String insertMausac(MauSac ms) {
        String insert = "INSERT INTO MauSac\n"
                + "                  ( Ma, Ten)\n"
                + "VALUES (?,?)";
        try {
            pst = DB.getConnection().prepareStatement(insert);
            
            pst.setObject(1, ms.getMa());
            pst.setObject(2, ms.getTen());
            pst.executeUpdate();
            return "Thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(MausacRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Thatbai";
        }

    }

    public String updateMausac(MauSac m) {
        String update = "UPDATE MauSac\n"
                + "SET Ma =?, Ten =? where Id=?";
        try {
            pst = DB.getConnection().prepareStatement(update);
            
            pst.setObject(1, m.getMa());
            pst.setObject(2, m.getTen());
            pst.setObject(3, m.getId());
            pst.executeUpdate();
            return "Thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(MausacRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "That bai";
        }
    }

    public String delete_mausac(String s) {
        String delect = "delete from Mausac where id=?";
        try {
            pst=DB.getConnection().prepareStatement(delect);
           
            pst.setString(1, s);
            pst.executeUpdate();
            return "Thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(MausacRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "That bai";
        }
        
    }

      public static void main(String[] args) {
        for (MauSac arg : new MausacRepository().getListMauSac()) {
            System.out.println(arg.toString());
        }
    }
}
