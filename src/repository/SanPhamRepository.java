/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Anh;
import domainmodel.ChiTietSP;
import domainmodel.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.SanphamService;
import utilities.DBConnection;
import viewmodel.SanphamProduct;
import repository.AnhRepository;

/**
 *
 * @author Admin
 */
public class SanPhamRepository {

    DBConnection DB;
    List<SanphamProduct> listSanpham = null;
    List<SanphamProduct> listSanpham1 = null;
    List<SanphamProduct> listDungHD = null;

    List<Anh> listAnh = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public List<SanphamService> get;

    public ArrayList<SanphamProduct> getListSP() {

        listSanpham = new ArrayList<>();
        String sql = "select sanpham.Ma,SanPham.ten,\n"
                + "anh.UrlImage,mota,gia,size.sosize,mausac.ten,dongsp.ten,danhmuc.ten,thoigianbh,soluong,trangthai \n"
                + "\n"
                + "from chitietsp\n"
                + "join sanpham on sanpham.id=chitietsp.IdSP\n"
                + "join DongSP on DongSP.Id=ChiTietSP.IdDongSP\n"
                + "join size on size.id=chitietsp.IdSize\n"
                + "join danhmuc on danhmuc.madanhmuc=chitietsp.madanhmuc\n"
                + "join mausac on mausac.id=chitietsp.IdMauSac\n"
                + "left join anh on anh.id=chitietsp.IdAnh where trangthai=1";

        try {
            pst = DB.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                SanphamProduct sp = new SanphamProduct();
                sp.setIdSp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setAnh(rs.getString(3));
                sp.setMoTa(rs.getNString(4));
                sp.setGia(rs.getDouble(5));
                sp.setIdSize(rs.getString(6));
                sp.setIdMausac(rs.getNString(7));
                sp.setIdDongsp(rs.getNString(8));
                sp.setMaDanhmuc(rs.getNString(9));
                sp.setThoiGianBH(rs.getInt(10));
                sp.setSoluong(rs.getInt(11));
                sp.setTrangThai(rs.getInt(12));
                listSanpham.add(sp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<SanphamProduct>) listSanpham;
    }

//    public String insert(SanPham a, SanphamProduct c) {
//        listSanpham = new ArrayList<>();
//
//        listAnh = new ArrayList<>();
//        String insert
//                = "declare @idanh Uniqueidentifier\n"
//                + "set @idanh=(select id from anh where ten=?)"
//                + "insert SANPHAM(Ma,Ten) values(?,?)"
//                + "declare @idsp Uniqueidentifier\n"
//                + "set @idsp =(select id from SanPham where Ma=?)\n"
//                + "insert into chitietSP (Idsp,IdSize,IdMauSac,IdDongSP,idAnh,MaDanhMuc,ThoiGianBH,soluong,Gia,trangthai) values"
//                + "(@idsp,?,?,?,@idanh,?,?,?,?,?)";
//
//        try {
//            pst = DB.getConnection().prepareStatement(insert);
//            pst.setObject(1, a.getTen());
//
//            pst.setObject(2, a.getMa());
//            pst.setObject(3, a.getTen());
//            pst.setObject(4, a.getMa());
//            pst.setObject(5, c.getIdSize());
//            pst.setObject(6, c.getIdMausac());
//            pst.setObject(7, c.getIdDongsp());
//            pst.setObject(8, c.getMaDanhmuc());
//            pst.setObject(9, c.getThoiGianBH());
//            pst.setObject(10, c.getSoluong());
//            pst.setObject(11, c.getGia());
//            pst.setObject(12, c.getTrangThai());
//
//            pst.executeUpdate();
//            return "Thanh cong";
//        } catch (SQLException ex) {
//            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
//            return "That bai";
//        }
//    }
    public String insertSP(String ten, String ma, SanphamProduct c) {
        listSanpham = new ArrayList<>();

        listAnh = new ArrayList<>();
        String insert
                = "declare @idanh Uniqueidentifier\n"
                + "set @idanh=(select id from anh where ten=?)"
                //                + "insert SANPHAM(Ma,Ten) values(?,?)"
                + "declare @idsp Uniqueidentifier\n"
                + "set @idsp =(select id from SanPham where Ma=?)\n"
                + "insert into chitietSP (Idsp,IdSize,IdMauSac,IdDongSP,idAnh,MaDanhMuc,"
                + "ThoiGianBH,soluong,Gia,trangthai) values"
                + "(@idsp,?,?,?,@idanh,?,?,?,?,1)";

        try {
            pst = DB.getConnection().prepareStatement(insert);
            pst.setObject(1, ten);

            pst.setObject(2, ma);

            pst.setObject(3, c.getIdSize());
            pst.setObject(4, c.getIdMausac());
            pst.setObject(5, c.getIdDongsp());
            pst.setObject(6, c.getMaDanhmuc());
            pst.setObject(7, c.getThoiGianBH());
            pst.setObject(8, c.getSoluong());
            pst.setObject(9, c.getGia());
//            pst.setObject(10, c.getTrangThai());

            pst.executeUpdate();
            return "Thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "That bai";
        }
    }

    public String updateTT(String t) {

//        String delete = " declare @idsp Uniqueidentifier\n"
//                + " set @idsp=(select id from SANPHAM where ten=?)\n"
//                + "\n"
//                + " update ChiTietSP set TrangThai=0 where  IdSP=@idsp";
        String delete = " declare @idsp Uniqueidentifier ,@tt int\n"
                + "      set @idsp=(select id from SANPHAM where ten=?)\n"
                + "    set @tt=(  select trangthai from ChiTietSP where  IdSP=@idsp)\n"
                + "	if(@tt=1)\n"
                + "	begin\n"
                + "	  update ChiTietSP set TrangThai=0 where  IdSP=@idsp\n"
                + "	end\n"
                + "	else\n"
                + "	begin\n"
                + "	   update ChiTietSP set TrangThai=1 where  IdSP=@idsp\n"
                + "	end";
        try {
            pst = DB.getConnection().prepareStatement(delete);
            pst.setObject(1, t);

            pst.executeUpdate();
            return "Sửa trạng thái thành công";
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Sửa trạng thái thất bại";
        }
    }

//    
    public String update(String ma, SanphamProduct d) {
        String update
                = "declare @idsp Uniqueidentifier\n"
                + "  set @idsp =(select id from SanPham where ma=?)\n"
                + "  update chitietSP set IdSize=?,IdMauSac=?,IdDongSP=?,MaDanhMuc=?"
                + ",ThoiGianBH=?,soluong=?,Gia=? where idSp=@idsp";

        try {
            pst = DB.getConnection().prepareStatement(update);
            pst.setObject(1, ma);

            pst.setObject(2, d.getIdSize());
            pst.setObject(3, d.getIdMausac());
            pst.setObject(4, d.getIdDongsp());
            pst.setObject(5, d.getMaDanhmuc());
            pst.setObject(6, d.getThoiGianBH());
            pst.setObject(7, d.getSoluong());
            pst.setObject(8, d.getGia());
//            pst.setObject(12, d.getTrangThai());
            pst.executeUpdate();
            return "Sửa thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Sửa thất bại";
        }
    }
//      public String update(String ma,SanPham a) {
//        String update = ""
//                + "declare @idsp Uniqueidentifier\n"
//                + "    set @idsp =(select id from SanPham where Ma=?)\n"
//                + "	update SANPHAM set Ma=?,Ten=? where id=@idsp\n";
//              
//        
//        try {
//            pst=DB.getConnection().prepareStatement(update);
//             pst.setObject(1, ma);
//       
//           
//            pst.setObject(2, a.getMa());
//            pst.setObject(3, a.getTen());
//           
//            pst.executeUpdate();
//            return "Sửa thanh cong";
//        } catch (SQLException ex) {
//            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
//            return "Sửa thất bại";
//        }
//    }

    public ArrayList<SanphamProduct> getListSPtheoDSP(String dsp) {

        listSanpham1 = new ArrayList<>();
        String sql = "select sanpham.Ma,SanPham.ten,\n"
                + "anh.UrlImage,mota,gia,size.sosize,mausac.ten,dongsp.ten,danhmuc.ten,thoigianbh,soluong,trangthai \n"
                + "\n"
                + "from chitietsp\n"
                + "join sanpham on sanpham.id=chitietsp.IdSP\n"
                + "join DongSP on DongSP.Id=ChiTietSP.IdDongSP\n"
                + "join size on size.id=chitietsp.IdSize\n"
                + "join danhmuc on danhmuc.madanhmuc=chitietsp.madanhmuc\n"
                + "join mausac on mausac.id=chitietsp.IdMauSac\n"
                + "left join anh on anh.id=chitietsp.IdAnh"
                + "where DongSP.ten=?";

        try {
            pst = DB.getConnection().prepareStatement(sql);
            pst.setObject(1, dsp);

            rs = pst.executeQuery();
            while (rs.next()) {
                SanphamProduct sp = new SanphamProduct();
                sp.setIdSp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setAnh(rs.getString(3));
                sp.setMoTa(rs.getNString(4));
                sp.setGia(rs.getDouble(5));
                sp.setIdSize(rs.getString(6));
                sp.setIdMausac(rs.getNString(7));
                sp.setIdDongsp(rs.getNString(8));
                sp.setMaDanhmuc(rs.getNString(9));
                sp.setThoiGianBH(rs.getInt(10));
                sp.setSoluong(rs.getInt(11));
                sp.setTrangThai(rs.getInt(12));
                listSanpham1.add(sp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<SanphamProduct>) listSanpham1;
    }

    public ArrayList<SanphamProduct> getListSPDungHD() {

        listSanpham = new ArrayList<>();
        String sql = "select sanpham.Ma,SanPham.ten,\n"
                + "anh.UrlImage,mota,gia,size.sosize,mausac.ten,dongsp.ten,danhmuc.ten,thoigianbh,soluong,trangthai \n"
                + "\n"
                + "from chitietsp\n"
                + "join sanpham on sanpham.id=chitietsp.IdSP\n"
                + "join DongSP on DongSP.Id=ChiTietSP.IdDongSP\n"
                + "join size on size.id=chitietsp.IdSize\n"
                + "join danhmuc on danhmuc.madanhmuc=chitietsp.madanhmuc\n"
                + "join mausac on mausac.id=chitietsp.IdMauSac\n"
                + "left join anh on anh.id=chitietsp.IdAnh where trangthai=0";

        try {
            pst = DB.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                SanphamProduct sp = new SanphamProduct();
                sp.setIdSp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setAnh(rs.getString(3));
                sp.setMoTa(rs.getNString(4));
                sp.setGia(rs.getDouble(5));
                sp.setIdSize(rs.getString(6));
                sp.setIdMausac(rs.getNString(7));
                sp.setIdDongsp(rs.getNString(8));
                sp.setMaDanhmuc(rs.getNString(9));
                sp.setThoiGianBH(rs.getInt(10));
                sp.setSoluong(rs.getInt(11));
                sp.setTrangThai(rs.getInt(12));
                listSanpham.add(sp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<SanphamProduct>) listSanpham;
    }

    public List<SanphamProduct> timSP(String t) {
        listSanpham = new ArrayList<>();
        try {
//            String sql = "select a.ma, a.ten,e.ten,c.Ten,i.SoSize,b.Gia,b.SoLuong,MoTa from SanPham a join ChiTietSP b on a.Id=b.IdSP\n"
//                    + "join MauSac c on c.Id=b.IdMauSac\n"
//                    + "join DanhMuc d on d.MaDanhMuc=b.MaDanhMuc\n"
//                    + "join DongSP e on e.Id=b.IdDongSP\n"
//                    + "join Size i on i.Id=b.IdSize"
//                    + "   where a.ten  like" + "'" + t + "%" + "'";
            String sql = "select sanpham.Ma,SanPham.ten,\n"
                    + "       anh.UrlImage,mota,gia,size.sosize,mausac.ten,dongsp.ten,danhmuc.ten,thoigianbh,soluong,trangthai\n"
                    + "                \n"
                    + "              from chitietsp\n"
                    + "              join sanpham on sanpham.id=chitietsp.IdSP\n"
                    + "              join DongSP on DongSP.Id=ChiTietSP.IdDongSP\n"
                    + "              join size on size.id=chitietsp.IdSize\n"
                    + "              join danhmuc on danhmuc.madanhmuc=chitietsp.madanhmuc\n"
                    + "               join mausac on mausac.id=chitietsp.IdMauSac\n"
                    + "              left join anh on anh.id=chitietsp.IdAnh where SanPham.ten like "+"'" +t+"%" +"'";
        
             pst = DB.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                SanphamProduct sp1 = new SanphamProduct();
                sp1.setIdSp(rs.getString(1));
                sp1.setTensp(rs.getString(2));
                sp1.setAnh(rs.getString(3));
                sp1.setMoTa(rs.getNString(4));
                sp1.setGia(rs.getDouble(5));
                sp1.setIdSize(rs.getString(6));
                sp1.setIdMausac(rs.getNString(7));
                sp1.setIdDongsp(rs.getNString(8));
                sp1.setMaDanhmuc(rs.getNString(9));
                sp1.setThoiGianBH(rs.getInt(10));
                sp1.setSoluong(rs.getInt(11));
                sp1.setTrangThai(rs.getInt(12));
                listSanpham.add(sp1);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSanpham;
    }

    public static void main(String[] args) {
        for (SanphamProduct arg : new SanPhamRepository().getListSP()) {
            System.out.println(arg);
        }
    }

}
