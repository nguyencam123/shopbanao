/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.NhanVien;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import utilities.DBConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class NhanVienRepository {

    public List<NhanVien> getAll() {
        List<NhanVien> listNhanVien = new ArrayList<>();
        try {

            String sql = "SELECT manv, tennv, gioitinh, email, quequan,ngaysinh,taikhoan,matkhau,trangthai  FROM NhanVien";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNV(rs.getString("manv"));
                nhanVien.setTenNV(rs.getString("TenNV"));
                nhanVien.setGioiTinh(rs.getString("GioiTinh"));
                nhanVien.setEmail(rs.getString("Email"));
                nhanVien.setQueQuan(rs.getString("QueQuan"));
                nhanVien.setNgaySinh(rs.getDate("NgaySinh"));
                nhanVien.setTaiKhoan(rs.getString("TaiKhoan"));
                nhanVien.setMatKhau(rs.getString("MatKhau"));
                nhanVien.setTrangThai(rs.getInt("TrangThai"));

                listNhanVien.add(nhanVien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNhanVien;
    }

    public Integer addNhanVien(NhanVien nhanVien) {
        Integer ketQua = -1;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO nhanvien(manv,tennv,gioitinh,email,quequan,ngaysinh,taikhoan,matkhau,trangthai) values (?,?,?,?,?,?,?,?,0)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nhanVien.getMaNV());
            ps.setString(2, nhanVien.getTenNV());
            ps.setString(3, nhanVien.getGioiTinh());
            ps.setString(4, nhanVien.getEmail());
            ps.setString(5, nhanVien.getQueQuan());
            ps.setDate(6, new Date(nhanVien.getNgaySinh().getTime()));
            ps.setString(7, nhanVien.getTaiKhoan());
            ps.setString(8, nhanVien.getMatKhau());
           

            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;

    }

//    public Integer deleteChiTietSP(String id) {
//        Integer ketQua = -1;
//        try {
//            Connection con = DBConnection.getConnection();
//            String sql = "DELETE FROM ChiTietSP WHERE Id = ?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, id);
//            ketQua = ps.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(ChiTietSPRepo.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return ketQua;
//    }
    public Integer updateNhanVien(NhanVien nhanVien) {
        Integer ketQua = -1;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE nhanvien SET tennv=?, gioitinh=?, email=?, quequan=?, ngaysinh=?, taikhoan=?, matkhau=?, trangthai=0 WHERE manv=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(8, nhanVien.getMaNV());
            ps.setString(1, nhanVien.getTenNV());
            ps.setString(2, nhanVien.getGioiTinh());
            ps.setString(3, nhanVien.getEmail());
            ps.setString(4, nhanVien.getQueQuan());
            ps.setDate(5, new Date(nhanVien.getNgaySinh().getTime()));
            ps.setString(6, nhanVien.getTaiKhoan());
            ps.setString(7, nhanVien.getMatKhau());
        
            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }
      public Integer updateTT(String m) {
        Integer ketQua = -1;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE nhanvien SET trangthai=1 WHERE manv=? ";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setObject(1,m);
            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }
      

    public List<NhanVien> timKiem(String ma) {
        List<NhanVien> listNhanVien1 = new ArrayList<>();
        try {

            String sql = "SELECT manv, tennv, gioitinh, email, quequan,ngaysinh,taikhoan,matkhau,trangthai  FROM NhanVien where maNV=?";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNV(rs.getString("manv"));
                nhanVien.setTenNV(rs.getString("TenNV"));
                nhanVien.setGioiTinh(rs.getString("GioiTinh"));
                nhanVien.setEmail(rs.getString("Email"));
                nhanVien.setQueQuan(rs.getString("QueQuan"));
                nhanVien.setNgaySinh(rs.getDate("NgaySinh"));
                nhanVien.setTaiKhoan(rs.getString("TaiKhoan"));
                nhanVien.setMatKhau(rs.getString("MatKhau"));
                nhanVien.setTrangThai(rs.getInt("TrangThai"));

                listNhanVien1.add(nhanVien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNhanVien1;
    }
}
