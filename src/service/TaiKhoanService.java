/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.NhanVien;
import domainmodel.TaiKhoan;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.TaiKhoanRepository;

/**
 *
 * @author Admin
 */
public class TaiKhoanService {

    private final TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();

    public List<NhanVien> getLog() throws SQLException {
        return taiKhoanRepository.getLogin();
    }

    public boolean xacThuc(String taiKhoan, String matKhau) throws SQLException {
        NhanVien nhanVien = taiKhoanRepository.getAccountByUserName(taiKhoan);
        if (nhanVien != null) {
            return nhanVien.getMatKhau().equals(matKhau);
        }
        return false;
    }

    public boolean updateMK(String tk) {
        try {
            return taiKhoanRepository.updateMK(tk);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean dangKi(TaiKhoan tk) {
        try {
            return taiKhoanRepository.dangKi(tk);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    public String checkEmail(String taiKhoan, String email) throws SQLException {
        NhanVien nhanVien = taiKhoanRepository.getAccountByUserName(taiKhoan);
        if (nhanVien != null) {
            if (nhanVien.getEmail().equals(email)) {
                return "true";
            } else {
                return "sai email";
            }
        } else {
            return "không tồn tại";
        }

    }
}
