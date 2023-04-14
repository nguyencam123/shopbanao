/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import ViewModel.ThongkeViewModel;
import domainmodel.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import service.impl.ThongkeViewModeliml;
import utilities.DBConnection;
import viewmodel.BieudoViewModel;
import viewmodel.ThongKeTable2;
import viewmodel.ThongKenowViewModel;

/**
 *
 * @author c
 */
public class ThongkeRepositoty {
    
    public List<ThongkeViewModel> getall() {
        String sql = "SELECT dbo.HOADON.MaHD, dbo.NhanVien.TenNV, dbo.HOADON.TongTien, dbo.HOADON.NgayTao\n"
                + "FROM     dbo.HOADON INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HOADON.MaNV = dbo.NhanVien.MaNV";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<ThongkeViewModel> sp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new ThongkeViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            rs.close();
            return sp;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<ThongKeTable2> getalltable2() {
        String sql = "SELECT top(5) dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.HoaDonChiTiet.SoLuong\n"
                + "				FROM     dbo.ChiTietSP INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.ChiTietSP.Id = dbo.HoaDonChiTiet.IdChiTietSP INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id order by soluong desc";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<ThongKeTable2> sp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new ThongKeTable2(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            rs.close();
            return sp;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<ThongKenowViewModel> showTTday1() {
        String sql = "select sum(TongTien) from HOADON where NgayTao = CONVERT(date,getdate());";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<ThongKenowViewModel> sp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new ThongKenowViewModel(rs.getString(1)));
            }
            rs.close();
            return sp;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<ThongKenowViewModel> showTTday7() {
        String sql = "select sum(TongTien) from HOADON where NgayTao > CONVERT(date,getdate()-8);";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<ThongKenowViewModel> sp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new ThongKenowViewModel(rs.getString(1)));
            }
            rs.close();
            return sp;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<ThongKenowViewModel> showTTday30() {
        String sql = "select sum(TongTien) from HOADON where NgayTao > CONVERT(date,getdate()-31);";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<ThongKenowViewModel> sp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new ThongKenowViewModel(rs.getString(1)));
            }
            rs.close();
            return sp;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<ThongKenowViewModel> showhoadonbanday1() {
        String sql = "SELECT COUNT(mahd)FROM hoadon WHERE NgayTao = CONVERT(date,getdate());";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<ThongKenowViewModel> sp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new ThongKenowViewModel(rs.getString(1)));
            }
            rs.close();
            return sp;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<ThongKenowViewModel> showhoadonbanday7() {
        String sql = "SELECT COUNT(mahd)FROM hoadon WHERE NgayTao > CONVERT(date,getdate()-8);";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<ThongKenowViewModel> sp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new ThongKenowViewModel(rs.getString(1)));
            }
            rs.close();
            return sp;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<ThongKenowViewModel> showhoadonbanday30() {
        String sql = "SELECT COUNT(mahd)FROM hoadon WHERE NgayTao > CONVERT(date,getdate()-31);";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<ThongKenowViewModel> sp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new ThongKenowViewModel(rs.getString(1)));
            }
            rs.close();
            return sp;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<ThongKenowViewModel> showttthongke(Date date1, Date date2) {
        String sql = "select sum(TongTien) from Hoadon where ngaytao > ? and ngaytao < ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<ThongKenowViewModel> tk = new ArrayList<>();
            ps.setObject(1, date1);
            ps.setObject(2, date2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tk.add(new ThongKenowViewModel(rs.getString(1)));
            }
            rs.close();
            return tk;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<ThongKenowViewModel> showhoadonthongke(Date date1, Date date2) {
        String sql = "SELECT COUNT(mahd)FROM hoadon where ngaytao > ? and ngaytao < ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<ThongKenowViewModel> tk = new ArrayList<>();
            ps.setObject(1, date1);
            ps.setObject(2, date2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tk.add(new ThongKenowViewModel(rs.getString(1)));
            }
            rs.close();
            return tk;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<BieudoViewModel> showtime2021() {
        String sql = "select year(ngaytao) from hoadon where year(ngaytao)=2021";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<BieudoViewModel> sp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new BieudoViewModel(rs.getString(1), 0));
            }
            rs.close();
            return sp;
        } catch (Exception e) {
        }
        return null;
    }

    public List<BieudoViewModel> showtongtien2021(int date1) {
        String sql = "select sum(tongtien),month(NgayTao) from hoadon where year(NgayTao)= ? group by month(NgayTao)";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<BieudoViewModel> sp = new ArrayList<>();
            ps.setObject(1, date1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new BieudoViewModel(rs.getString(2), rs.getInt(1)));
            }
            rs.close();
            return sp;
        } catch (Exception e) {
        }
        return null;
    }
//    public List<BieudoViewModel> showtime2022() {
//        String sql = "select year(ngaytao) from hoadon where year(ngaytao)=2022";
//        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
//            List<BieudoViewModel> sp = new ArrayList<>();
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                sp.add(new BieudoViewModel(rs.getString(1),0));
//            }
//            rs.close();
//            return sp;
//        } catch (Exception e) {
//        }
//        return null;
//    }
//    public List<BieudoViewModel> showtongtien2022() {
//        String sql = "select sum(tongtien) from hoadon where year(ngaytao)='2022'";
//        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
//            List<BieudoViewModel> sp = new ArrayList<>();
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                sp.add(new BieudoViewModel(null,rs.getInt(1)));
//            }
//            rs.close();
//            return sp;
//        } catch (Exception e) {
//        }
//        return null;
//    }

    public List<BieudoViewModel> showtongtien2018() {
        String sql = "select sum(tongtien),year(NgayTao) from hoadon where trangthai=1 group by year(NgayTao) ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<BieudoViewModel> sp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new BieudoViewModel(rs.getString(2), rs.getInt(1)));
            }
            rs.close();
            return sp;
        } catch (Exception e) {
        }
        return null;
    }
}
