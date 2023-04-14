/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.NhanVien;
import domainmodel.TaiKhoan;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import utilities.DBConnection;

/**
 *
 * @author Admin
 */
public class TaiKhoanRepository {

    public List<NhanVien> getLogin() throws SQLException {
        List<NhanVien> nhanVien = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "select taiKhoan, matKhau, email from nhanvien where trangthai=0";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String username = rs.getString("taiKhoan");
            String password = rs.getString("matKhau");
            String email = rs.getString("email");

            NhanVien nhanViens = new NhanVien();
            nhanViens.setTaiKhoan(username);
            nhanViens.setMatKhau(password);
            nhanViens.setEmail(email);
            nhanVien.add(nhanViens);
        }
        return nhanVien;
    }

    public NhanVien getAccountByUserName(String taiKhoan) throws SQLException {
        for (NhanVien nhanVien : getLogin()) {
            if (nhanVien.getTaiKhoan().equalsIgnoreCase(taiKhoan)) {
                return nhanVien;
            }
        }
        return null;
    }
    
    public boolean dangKi(TaiKhoan tk) throws SQLException {
        int check = 0;

        Connection connection = DBConnection.getConnection();
        String sql = "INSERT TaiKhoan(username, password, email, roll) VALUES (?, ?, ?, 'staff')";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, tk.getUsername());
        ps.setString(2, tk.getPassword());
        ps.setString(3, tk.getEmail());

        check = ps.executeUpdate();
        ps.close();
        connection.close();
        return true;
    }
    
    public boolean updateMK(String tk) throws SQLException {
        int check = 0;

        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE NhanVien SET MatKhau='12345' WHERE TaiKhoan=?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, tk);

        check = ps.executeUpdate();
        ps.close();
        connection.close();
        return check > 0;
    }
}
