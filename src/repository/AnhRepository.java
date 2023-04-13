/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Anh;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import utilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AnhRepository {

    DBConnection DB;
//    List<SanphamProduct> listSanpham = null;
    List<Anh> listAnh = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public List<Anh> getListAnh() {
        listAnh = new ArrayList<>();
        String sql = "select id,UrlImage,ten from anh";
        try {
            pst = DB.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Anh a = new Anh();
                a.setId(rs.getString("id"));
                a.setUrlImage(rs.getString("UrlImage"));
                a.setTen(rs.getString("ten"));
                listAnh.add(a);
            }
            rs.close();
        } catch (SQLException ex) {
//            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAnh;
    }

    public String themAnh(Anh a) {

        String sql = "insert into anh(id,UrlImage,ten) values(newid(),?,?)";
        try {
            pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setString(1, a.getUrlImage());
            pst.setString(2, a.getTen());

            listAnh.add(a);
            pst.executeUpdate();
            return "Thêm thành công";
        } catch (SQLException ex) {
//            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "Thêm thất bại";
    }

    public String update(Anh a, String ten) {
        String update = "declare @idanh UNIQUEIDENTIFIER \n"
                + "set @idanh =(select id from Anh where ten=?)"
                + "update Anh set UrlImage=? where id=@idanh";

        try {
            pst = DB.getConnection().prepareStatement(update);
            pst.setObject(2, a.getUrlImage());
            pst.setObject(1, ten);
           
            pst.executeUpdate();
            return "Sửa ảnh thành công";
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AnhRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return "Sửa ảnh thất bại";
        }
    }
}
