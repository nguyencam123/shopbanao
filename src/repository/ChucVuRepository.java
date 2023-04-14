/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Anh;
import domainmodel.ChucVu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DBConnection;

/**
 *
 * @author HP probook
 */
public class ChucVuRepository {

    DBConnection dBConnection;
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<ChucVu> listCV = null;

    public List<ChucVu> getListCV() {
        listCV = new ArrayList<>();
        String sql = "select id,ma,ten from chucvu";
        try {
            pst = dBConnection.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ChucVu c = new ChucVu();
                c.setId(rs.getString("id"));
                c.setMa(rs.getString("ma"));
                c.setTen(rs.getString("ten"));
                listCV.add(c);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCV;
    }

    public String themCV(ChucVu c) {

        String sql = "insert into chucvu(ma,ten) values(?,?)";
        try {
            pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setObject(1, c.getMa());
            pst.setObject(2, c.getTen());

            listCV.add(c);
            pst.executeUpdate();
            return "Thêm thành công";
        } catch (SQLException ex) {
            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "Thêm thất bại";
    }

    public String SuaCV(ChucVu c, String id) {

        String sql = "update chucvu set ma=?,ten=? where id=?";
        try {
            pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setObject(1, c.getMa());
            pst.setObject(2, c.getTen());
            pst.setObject(3, id);
            listCV.add(c);
            pst.executeUpdate();
            return "Thêm thành công";
        } catch (SQLException ex) {
            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "Thêm thất bại";
    }

    public String xoaCV(String id) {

        String sql = "delete chucvu where id=?";
        try {
            pst = DBConnection.getConnection().prepareStatement(sql);

            pst.setObject(1,id);

            pst.executeUpdate();
            return "Thêm thành công";
        } catch (SQLException ex) {
            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "Thêm thất bại";
    }
    public static void main(String[] args) {
        List<ChucVu> list=new ChucVuRepository().getListCV();
        for (ChucVu chucVu : list) {
            System.out.println(chucVu.toString());
        }
    } 

}
