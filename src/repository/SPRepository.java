/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.SanPham;
import java.util.List;
import utilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC DUNG
 */
public class SPRepository {
     DBConnection DB;
    List<SanPham> listSP = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public List<SanPham> getListSP() {
        listSP = new ArrayList<>();
        String select = "select*from Sanpham";
       
         try {
             pst = DB.getConnection().prepareStatement(select);
             rs=pst.executeQuery();
             while (rs.next()) {                 
                 SanPham s=new SanPham();
                 s.setId(rs.getString(1));
                 s.setMa(rs.getString(2));
                 s.setTen(rs.getNString(3));
                 listSP.add(s);
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(SPRepository.class.getName()).log(Level.SEVERE, null, ex);
         }
          return listSP;
         
    }
    
   public String them(SanPham sp){
       listSP=new ArrayList<>();
       String insert="INSERT INTO SanPham\n" +
"                  ( Ma, Ten)\n" +
"VALUES (?,?)";
         try {
             pst=DB.getConnection().prepareStatement(insert);
//             pst.setObject(1, sp.getId());
             pst.setObject(1, sp.getMa());
             pst.setObject(2, sp.getTen());
             pst.executeUpdate();
             return "Thanh cong";
         } catch (SQLException ex) {
             Logger.getLogger(SPRepository.class.getName()).log(Level.SEVERE, null, ex);
             return "That bai";
         }
   }
   public String sua(SanPham p){
       listSP=new ArrayList<>();
       String update="Update Sanpham set ten=? where ma=?";
       
         try {
             pst=DB.getConnection().prepareStatement(update);
            
             pst.setObject(1, p.getTen());
             pst.setObject(2,p.getMa());
             pst.executeUpdate();
             return "Sửa thành công";
         } catch (SQLException ex) {
             Logger.getLogger(SPRepository.class.getName()).log(Level.SEVERE, null, ex);
             return "Sửa thất bại";
         }
       
   }
}
