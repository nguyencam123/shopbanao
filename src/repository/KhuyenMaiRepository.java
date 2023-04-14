/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import domainmodel.KhuyenMai;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DBConnection;

/**
 *
 * @author AS
 */
public class KhuyenMaiRepository {

    //Connection con = DBConnection.getConnection();
    ResultSet rs = null;
    PreparedStatement ps = null;

    public List<KhuyenMai> getAll() {
        List<KhuyenMai> listKM = new ArrayList<>();
        String sql = "SELECT *FROM KhuyenMai";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString(1));
                km.setTenKM(rs.getString(2));
                km.setSoTienGiam(rs.getDouble(3));
                km.setNgayBD(rs.getDate(4));
                km.setNgayKT(rs.getDate(5));
                km.setTrangThai(rs.getInt(6));
                listKM.add(km);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKM;

    }
     public List<KhuyenMai> getlist() {
        List<KhuyenMai> listKM = new ArrayList<>();
        String sql = "SELECT ngaybd,ngaykt FROM KhuyenMai";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();           
                km.setNgayBD(rs.getDate(1));
                km.setNgayKT(rs.getDate(2));
               
                listKM.add(km);
            }
        } catch (SQLException ex) {
        }
        return listKM;

    }

    public Integer add(KhuyenMai khuyenMai) {
        Integer ketQua = -1;
        List<KhuyenMai> listKM = new ArrayList<>();

        String sql = "Insert into KhuyenMai(MaKM, TenKM, SoTienGiam, NgayBD, NgayKT) values (?,?,?,?,?)";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, khuyenMai.getMaKM());
            ps.setString(2, khuyenMai.getTenKM());
            ps.setDouble(3, khuyenMai.getSoTienGiam());
            ps.setDate(4, new Date(khuyenMai.getNgayBD().getTime()));
            ps.setDate(5, new Date(khuyenMai.getNgayKT().getTime()));
          
            ketQua = ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    public Integer update(KhuyenMai khuyenMai) {
        Integer ketQua = -1;
        List<KhuyenMai> listKM = new ArrayList<>();

        String sql = "Update KhuyenMai SET TenKM=?, SoTienGiam=?, NgayBD=?, "
                + "NgayKT=? WHERE MaKM =?";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, khuyenMai.getTenKM());
            ps.setDouble(2, khuyenMai.getSoTienGiam());
            ps.setDate(3, new Date(khuyenMai.getNgayBD().getTime()));
            ps.setDate(4, new Date(khuyenMai.getNgayKT().getTime()));
         //   ps.setInt(5, khuyenMai.getTrangThai());
            ps.setString(5,khuyenMai.getMaKM());

            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }
    public Integer updateTT(int trangThai, String maKM) {
        Integer ketQua = -1;
        List<KhuyenMai> listKM = new ArrayList<>();

        String sql = "Update KhuyenMai SET TrangThai=? WHERE MaKM =?";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, trangThai);
            ps.setObject(2, maKM);

            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }
    public Integer ngungHD(KhuyenMai khuyenMai, String maKM) {
        Integer ketQua = -1;
        List<KhuyenMai> listKM = new ArrayList<>();

        String sql = "Update KhuyenMai SET TrangThai=? WHERE MaKM =?";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);

         
            ps.setInt(1, khuyenMai.getTrangThai());
            ps.setString(2, maKM);

            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    public Integer delete(String maKM) {
        Integer ketQua = -1;
        List<KhuyenMai> listKM = new ArrayList<>();

        String sql = "DELETE FROM KhuyenMai WHERE MaKM =?";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            KhuyenMai khuyenMai = new KhuyenMai();
            ps.setString(1, maKM);

            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }
    
    public List<KhuyenMai> sapDienRa() {
        List<KhuyenMai> listKM = new ArrayList<>();
        String sql = "SELECT *FROM KhuyenMai WHERE trangthai=2";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString(1));
                km.setTenKM(rs.getString(2));
                km.setSoTienGiam(rs.getDouble(3));
                km.setNgayBD(rs.getDate(4));
                km.setNgayKT(rs.getDate(5));
                km.setTrangThai(rs.getInt(6));
                listKM.add(km);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKM;
    }
    
    public List<KhuyenMai> hetHan() {
        List<KhuyenMai> listKM = new ArrayList<>();
        String sql = "SELECT *FROM KhuyenMai WHERE trangthai=0";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString(1));
                km.setTenKM(rs.getString(2));
                km.setSoTienGiam(rs.getDouble(3));
                km.setNgayBD(rs.getDate(4));
                km.setNgayKT(rs.getDate(5));
                km.setTrangThai(rs.getInt(6));
                listKM.add(km);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKM;
    }
    
    public List<KhuyenMai> dangDienRa() {
        List<KhuyenMai> listKM = new ArrayList<>();
        String sql = "SELECT *FROM KhuyenMai WHERE trangthai=1";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString(1));
                km.setTenKM(rs.getString(2));
                km.setSoTienGiam(rs.getDouble(3));
                km.setNgayBD(rs.getDate(4));
                km.setNgayKT(rs.getDate(5));
                km.setTrangThai(rs.getInt(6));
                listKM.add(km);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKM;
    }

}
