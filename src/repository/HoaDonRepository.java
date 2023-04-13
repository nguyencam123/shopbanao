/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.HoaDon;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DBConnection;
import viewmodel.bangSPinHoaDon;
import viewmodel.HoaDonChiTiet;
import viewmodel.GioHang;
import domainmodel.KhuyenMai;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDonRepository {

    DBConnection dbConnection;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<bangSPinHoaDon> listSP = null;
    List<bangSPinHoaDon> listSP2 = null;

    List<HoaDonChiTiet> listHDCT = null;
    List<HoaDonChiTiet> listHDCT2 = null;

    List<GioHang> listGH = null;
    List<KhuyenMai> listKM = null;

    public int getSoHd() {

        try {
            String sql = "select count(*) from HOADON";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getSoHd();
    }

    public List<bangSPinHoaDon> getSP() {
        listSP = new ArrayList<>();
        try {
            String sql = "select a.ma, a.ten,e.ten,c.Ten,i.SoSize,b.Gia,b.SoLuong,MoTa from SanPham a join ChiTietSP b on a.Id=b.IdSP\n"
                    + "join MauSac c on c.Id=b.IdMauSac\n"
                    + "join DanhMuc d on d.MaDanhMuc=b.MaDanhMuc\n"
                    + "join DongSP e on e.Id=b.IdDongSP\n"
                    + "join Size i on i.Id=b.IdSize";
            // +"where b.trangthai=1";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                bangSPinHoaDon b = new bangSPinHoaDon();
                b.setMaSP(rs.getString(1));
                b.setTenSP(rs.getString(2));
                b.setHang(rs.getString(3));
                b.setMauSac(rs.getString(4));
                b.setSize(rs.getInt(5));
                b.setGia(rs.getFloat(6));
                b.setSoLuong(rs.getInt(7));
                b.setMoTa(rs.getString(8));

                listSP.add(b);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSP;
    }

    public List<bangSPinHoaDon> showttthongke(int cannang,int chieucao) {
        String sql = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.DongSP.Ten AS Expr1, dbo.MauSac.Ten AS Expr2, dbo.Size.SoSize, dbo.ChiTietSP.Gia, dbo.ChiTietSP.SoLuong, dbo.DanhMuc.MoTa\n"
                + "FROM     dbo.ChiTietSP INNER JOIN\n"
                + "                  dbo.DanhMuc ON dbo.ChiTietSP.MaDanhMuc = dbo.DanhMuc.MaDanhMuc INNER JOIN\n"
                + "                  dbo.DongSP ON dbo.ChiTietSP.IdDongSP = dbo.DongSP.Id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                  dbo.Size ON dbo.ChiTietSP.IdSize = dbo.Size.Id where Size.cannangmin<=? and size.cannangmax>=? and Size.chieucaomin<=? and Size.chieucaomax>=?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<bangSPinHoaDon> tk = new ArrayList<>();
            ps.setObject(1, cannang);
            ps.setObject(2, cannang);
            ps.setObject(3, chieucao);
            ps.setObject(4, chieucao);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tk.add(new bangSPinHoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getFloat(6), rs.getInt(7), rs.getString(8)));
            }
            rs.close();
            return tk;
        } catch (Exception e) {
        }
        return null;
    }

    public List<bangSPinHoaDon> timSP(String t) {
        listSP2 = new ArrayList<>();
        try {
            String sql = "select a.ma, a.ten,e.ten,c.Ten,i.SoSize,b.Gia,b.SoLuong,MoTa from SanPham a join ChiTietSP b on a.Id=b.IdSP\n"
                    + "join MauSac c on c.Id=b.IdMauSac\n"
                    + "join DanhMuc d on d.MaDanhMuc=b.MaDanhMuc\n"
                    + "join DongSP e on e.Id=b.IdDongSP\n"
                    + "join Size i on i.Id=b.IdSize"
                    + "   where a.ten  like" + "'" + t + "%" + "'";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                bangSPinHoaDon b = new bangSPinHoaDon();
                b.setMaSP(rs.getString(1));
                b.setTenSP(rs.getString(2));
                b.setHang(rs.getString(3));
                b.setMauSac(rs.getString(4));
                b.setSize(rs.getInt(5));
                b.setGia(rs.getFloat(6));
                b.setSoLuong(rs.getInt(7));
                b.setMoTa(rs.getString(8));

                listSP2.add(b);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSP2;
    }

    public List<HoaDonChiTiet> getHD() {
        listHDCT = new ArrayList<>();
        try {
            String sql = "select a.mahd,tenkh,d.Ten,b.SoLuong,a.MaNV,ngaytao,TongTien,a.TienCanTra,TienKhachDua,TienThua,a.TRANGTHAI\n"
                    + "from HOADON a left join HoaDonChiTiet b on a.MaHD=b.MaHD\n"
                    + "left join ChiTietSP c on c.Id=b.IdChiTietSP\n"
                    + "left join SanPham d on d.Id=c.IdSP";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet b = new HoaDonChiTiet();
                b.setMaHD(rs.getString(1));
                b.setTenKH(rs.getString(2));
                b.setTenSP(rs.getString(3));
                b.setSl(rs.getInt(4));
                b.setMaNV(rs.getString(5));
                b.setNgayTao(rs.getDate(6));
                b.setTongTien(rs.getDouble(7));
                b.setTienCanTra(rs.getDouble(8));
                b.setTienKhachDua(rs.getDouble(9));
                b.setTIenThua(rs.getDouble(10));
                b.setTrangThai(rs.getInt(11));

                listHDCT.add(b);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHDCT;
    }

    public List<HoaDonChiTiet> TimHD(String t) {
        listHDCT2 = new ArrayList<>();
        try {
            String sql = "select a.mahd,tenkh,d.Ten,b.SoLuong,a.MaNV,ngaytao,TongTien,a.TienCanTra,TienKhachDua,TienThua,a.TRANGTHAI\n"
                    + "   from HOADON a join HoaDonChiTiet b on a.MaHD=b.MaHD\n"
                    + "   join ChiTietSP c on c.Id=b.IdChiTietSP\n"
                    + "   join SanPham d on d.Id=c.IdSP\n"
                    + "   where tenkh  like" + "'" + t + "%" + "'";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet b = new HoaDonChiTiet();
                b.setMaHD(rs.getString(1));
                b.setTenKH(rs.getString(2));
                b.setTenSP(rs.getString(3));
                b.setSl(rs.getInt(4));
                b.setMaNV(rs.getString(5));
                b.setNgayTao(rs.getDate(6));
                b.setTongTien(rs.getDouble(7));
                b.setTienCanTra(rs.getDouble(8));
                b.setTienKhachDua(rs.getDouble(9));
                b.setTIenThua(rs.getDouble(10));
                b.setTrangThai(rs.getInt(11));

                listHDCT2.add(b);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHDCT2;
    }

    public List<HoaDonChiTiet> timKiem(Date d1, Date d2) {

        String sql = "SELECT mahd,manv,tenkh,ngaytao,tongtien,trangthai from hoadon "
                + "where ngaytao >? and ngaytao <?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<HoaDonChiTiet> hd = new ArrayList<>();
            ps.setObject(1, d1);
            ps.setObject(2, d2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet b = new HoaDonChiTiet();
                b.setMaHD(rs.getString(1));
                b.setTenKH(rs.getString(3));

                b.setMaNV(rs.getString(2));
                b.setNgayTao(rs.getDate(4));
                b.setTongTien(rs.getDouble(5));

                b.setTrangThai(rs.getInt(6));

                hd.add(b);
            }
            rs.close();
            return hd;
        } catch (Exception e) {
        }
        return null;
    }

    public List<GioHang> getGH() {
        listGH = new ArrayList<>();
        try {
            String sql = "select d.Ten,j.Ten,e.Ten,f.SoSize,b.SoLuong,b.SoLuong*Gia from GioHang a left join GioHangChiTiet b on a.id=b.IdGioHang\n"
                    + "   left join ChiTietSP c on c.id=b.IdChiTietSP\n"
                    + "   left join SanPham d  on d.id=c.IdSP\n"
                    + "   left join MauSac e on e.id=c.IdMauSac\n"
                    + "	  left join DongSP j on j.Id=c.IdDongSP\n"
                    + "   left join Size f on f.Id=c.IdSize";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                GioHang b = new GioHang();
                b.setTenSP(rs.getString(1));
                b.setHang(rs.getString(2));
                b.setMauSac(rs.getString(3));
                b.setSize(rs.getInt(4));
                b.setSoLuong(rs.getInt(5));
                b.setGia(rs.getFloat(6));

                listGH.add(b);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listGH;
    }

    public List<GioHang> ClickHd(String ma) {
        listGH = new ArrayList<>();
        try {
            String sql = "select d.Ten,e.Ten,m.Ten,f.SoSize,b.SoLuong,c.gia from HOADON a join HoaDonChiTiet b on a.MaHD=b.MaHD\n"
                    + "join ChiTietSP c on c.id=b.IdChiTietSP\n"
                    + "join SanPham d on d.Id=c.IdSP\n"
                    + "join DongSP e on e.Id =c.IdDongSP\n"
                    + "join Size f on f.Id=c.IdSize\n"
                    + "join MauSac m on m.Id=c.IdMauSac\n"
                    + "where a.MaHD=?";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setObject(1, ma);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                GioHang b = new GioHang();
                b.setTenSP(rs.getString(1));
                b.setHang(rs.getString(2));
                b.setMauSac(rs.getString(3));
                b.setSize(rs.getInt(4));
                b.setSoLuong(rs.getInt(5));
                b.setGia(rs.getFloat(6));
                listGH.add(b);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listGH;
    }

    public void ClickSpVaoHd(String masp) {
        try {

            String sql = "if exists(select*from GioHang where MaGH='GH')\n"
                    + "begin\n"
                    + "print 'chua co'\n"
                    + "end\n"
                    + "else\n"
                    + "begin\n"
                    + " insert into GioHang(MaGH) values('GH')\n"
                    + "end"
                    + " declare @giohang table (ma nvarchar(50) ,soluong nvarchar(50))\n"
                    + " insert into @giohang  select d.Ma,b.SoLuong from GioHang a left join GioHangChiTiet b on a.id=b.IdGioHang\n"
                    + " left join ChiTietSP c on c.id=b.IdChiTietSP\n"
                    + " left join SanPham d  on d.id=c.IdSP\n"
                    + " left join MauSac e on e.id=c.IdMauSac;\n"
                    + "  select*from @giohang		\n"
                    + "					\n"
                    + "  if exists(select*from @giohang where ma=? )\n"
                    + "                    begin\n"
                    + "  declare @gan1 UNIQUEIDENTIFIER,@gan2 UNIQUEIDENTIFIER\n"
                    + "  set @gan1=(select Id from SanPham where Ma=?)\n"
                    + "  set  @gan2=(select Id from ChiTietSP where IdSP=@gan1)\n"
                    + "  update GioHangChiTiet set SoLuong=SoLuong+1 where IdChiTietSP=@gan2\n"
                    + "  update ChiTietSP set SoLuong=SoLuong-1 where IdSP=@gan1 \n"
                    + "  end\n"
                    + "  else\n"
                    + "  begin\n"
                    + "  declare @gan3 UNIQUEIDENTIFIER,@gan4 UNIQUEIDENTIFIER,@gan5 UNIQUEIDENTIFIER\n"
                    + "  set @gan3=(select Id from SanPham where Ma=?)\n"
                    + "  set @gan4=(select Id from GioHang where MaGH='GH')\n"
                    + "   set  @gan5=(select Id from ChiTietSP where IdSP=@gan3)\n"
                    + "   insert into GioHangChiTiet(IdGioHang,IdChiTietSP,SoLuong) values(@gan4,@gan5,1)\n"
                    + "   update ChiTietSP set SoLuong=SoLuong-1 where IdSP=@gan3 \n"
                    + "    end";
            pst = dbConnection.getConnection().prepareStatement(sql);
            pst.setObject(1, masp);
            pst.setObject(2, masp);
            pst.setObject(3, masp);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void ClickSpVaoHd2(String masp, int sl) {
        try {

            String sql = "if exists(select*from GioHang where MaGH='GH')\n"
                    + "begin\n"
                    + "print 'chua co'\n"
                    + "end\n"
                    + "else\n"
                    + "begin\n"
                    + " insert into GioHang(MaGH) values('GH')\n"
                    + "end"
                    + " declare @giohang table (ma nvarchar(50) ,soluong nvarchar(50))\n"
                    + " insert into @giohang  select d.Ma,b.SoLuong from GioHang a left join GioHangChiTiet b on a.id=b.IdGioHang\n"
                    + " left join ChiTietSP c on c.id=b.IdChiTietSP\n"
                    + " left join SanPham d  on d.id=c.IdSP\n"
                    + " left join MauSac e on e.id=c.IdMauSac;\n"
                    + "  select*from @giohang		\n"
                    + "					\n"
                    + "  if exists(select*from @giohang where ma=? )\n"
                    + "                    begin\n"
                    + "  declare @gan1 UNIQUEIDENTIFIER,@gan2 UNIQUEIDENTIFIER\n"
                    + "  set @gan1=(select Id from SanPham where Ma=?)\n"
                    + "  set  @gan2=(select Id from ChiTietSP where IdSP=@gan1)\n"
                    + "  update GioHangChiTiet set SoLuong=SoLuong+? where IdChiTietSP=@gan2\n"
                    + "  update ChiTietSP set SoLuong=SoLuong-? where IdSP=@gan1 \n"
                    + "  end\n"
                    + "  else\n"
                    + "  begin\n"
                    + "  declare @gan3 UNIQUEIDENTIFIER,@gan4 UNIQUEIDENTIFIER,@gan5 UNIQUEIDENTIFIER\n"
                    + "  set @gan3=(select Id from SanPham where Ma=?)\n"
                    + "  set @gan4=(select Id from GioHang where MaGH='GH')\n"
                    + "   set  @gan5=(select Id from ChiTietSP where IdSP=@gan3)\n"
                    + "   insert into GioHangChiTiet(IdGioHang,IdChiTietSP,SoLuong) values(@gan4,@gan5,?)\n"
                    + "   update ChiTietSP set SoLuong=SoLuong-? where IdSP=@gan3 \n"
                    + "    end";
            pst = dbConnection.getConnection().prepareStatement(sql);
            pst.setObject(1, masp);
            pst.setObject(2, masp);
            pst.setObject(3, sl);
            pst.setObject(4, sl);
            pst.setObject(5, masp);
            pst.setObject(6, sl);
            pst.setObject(7, sl);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public List<KhuyenMai> getKM() {
        listKM = new ArrayList<>();
        try {
            String sql = "select*from khuyenmai where trangthai=1";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                KhuyenMai b = new KhuyenMai();
                b.setMaKM(rs.getString(1));
                b.setTenKM(rs.getString(2));
                b.setSoTienGiam(rs.getDouble(3));
                b.setNgayBD(rs.getDate(4));
                b.setNgayKT(rs.getDate(5));
                b.setTrangThai(rs.getInt(6));

                listKM.add(b);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKM;
    }

    public void getKMsoTienGiam(String ma) {
        listKM = new ArrayList<>();
        try {
            String sql = "select SoTienGiam from KhuyenMai\n"
                    + "where TenKM=?";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setObject(1, ma);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void bttaoGH() {
        try {
            String delete = "delete from GioHangChiTiet\n"
                    + "delete from GioHang";

            pst = dbConnection.getConnection().prepareStatement(delete);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void xoaSPkhoiGH(String ten, int sl) {
        try {
            String delete = "declare @idSP UNIQUEIDENTIFIER,@idctsp UNIQUEIDENTIFIER\n"
                    + "	set @idsp=(select id from sanpham where ten=?)\n"
                    + "	set @idctsp=(select id from ChiTietSP where idsp=@idsp)\n"
                    + "	delete GIOHANGCHITIET where IdChiTietSP=@idctsp\n"
                    + "	update ChiTietSP set SoLuong=SoLuong + ?\n"
                    + "                    	where IdSP=@idsp";

            pst = dbConnection.getConnection().prepareStatement(delete);
            pst.setObject(1, ten);
            pst.setObject(2, sl);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void Themhd(HoaDonChiTiet v) {
        try {
            String insert
                    = " insert into  HoaDon(MaHD,NgayTao,TongTien,SDT,TenKH,MAKM,MaNV,TienCanTra,TienKhachDua,TienThua,TRANGTHAI) \n"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            pst = dbConnection.getConnection().prepareStatement(insert);
            pst.setObject(1, v.getMaHD());
            pst.setObject(2, v.getNgayTao());
            pst.setObject(3, v.getTongTien());
            pst.setObject(4, v.getSDT());
            pst.setObject(5, v.getTenKH());
            pst.setObject(6, v.getMaKM());
            pst.setObject(7, v.getMaNV());
            pst.setObject(8, v.getTienCanTra());
            pst.setObject(9, v.getTienKhachDua());
            pst.setObject(10, v.getTIenThua());
            pst.setObject(11, v.getTrangThai());
            listHDCT.add(v);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void Themhd1(HoaDonChiTiet v) {
        try {
            String insert
                    = " insert into  HoaDon(MaHD,TRANGTHAI) \n"
                    + "values (?,0)";
            pst = dbConnection.getConnection().prepareStatement(insert);
            pst.setObject(1, v.getMaHD());

            listHDCT.add(v);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void tt(HoaDonChiTiet v, String ma) {
        try {
            String insert = "update hoadon set TenKH=?,ngaytao=?,"
                    + "TongTien=?,sdt=?,TenKM=?,manv=?,TienCanTra=?, "
                    + "TienKhachDua=?, TienThua=?,TRANGTHAI=1\n"
                    + "where MaHD=?";
            pst = dbConnection.getConnection().prepareStatement(insert);
            pst.setObject(1, v.getTenKH());
            pst.setObject(2, v.getNgayTao());
            pst.setObject(3, v.getTongTien());
            pst.setObject(4, v.getSDT());
            pst.setObject(5, v.getMaKM());
            pst.setObject(6, v.getMaNV());
            pst.setObject(7, v.getTienCanTra());
            pst.setObject(8, v.getTienKhachDua());
            pst.setObject(9, v.getTIenThua());
            pst.setObject(10, ma);

            listHDCT.add(v);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void Themhdct(String masp, String mahd, int sl) {
        try {
            String insert = "declare @idspct UNIQUEIDENTIFIER\n"
                    + "                    \n"
                    + " set @idspct=(select b.Id from SanPham a join ChiTietSP b on a.Id=b.IdSP where a.Ten=?)\n"
                    + " insert into HoaDonChiTiet(MaHD,IdChiTietSP,SoLuong) values (?,@idspct,?)";

            pst = dbConnection.getConnection().prepareStatement(insert);
            pst.setObject(1, masp);
            pst.setObject(2, mahd);
            pst.setObject(3, sl);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void ThanhToanCho(double tienKD, double tienThua, String mahd) {
        try {
            String insert = "update hoadon set TienKhachDua=?, TienThua=?,TRANGTHAI=1\n"
                    + "where MaHD=?";

            pst = dbConnection.getConnection().prepareStatement(insert);
            pst.setObject(1, tienKD);
            pst.setObject(2, tienThua);
            pst.setObject(3, mahd);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String HuyHD(String ten, int sl) {
        try {
            String delete = "	declare @idSP UNIQUEIDENTIFIER\n"
                    + "	set @idSP=(select Id from sanpham where Ten=?)\n"
                    + "	update ChiTietSP set SoLuong=SoLuong + ?\n"
                    + "	where IdSP=@idsp";
            pst = dbConnection.getConnection().prepareStatement(delete);
            pst.setObject(1, ten);
            pst.setObject(2, sl);

            pst.executeUpdate();
            return "Huy thanh cong";
        } catch (SQLException ex) {

            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Huy that bai";
        }

    }

    public String HuyHD2(String ma) {
        try {
            String delete = "delete HoaDonChiTiet where MaHD=?\n"
                    + "	     delete hoadon where MaHD=?";

            pst = dbConnection.getConnection().prepareStatement(delete);

            pst.setObject(1, ma);
            pst.setObject(2, ma);
            pst.executeUpdate();
            return "Huy thanh cong";
        } catch (SQLException ex) {

            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Huy that bai";
        }
    }

    public static void main(String[] args) {
//        List<HoaDonChiTiet> list = new HoaDonRepository().getHD();
//        for (HoaDonChiTiet sPinHoaDon : list) {
//            System.out.println(sPinHoaDon.toString());
//        }
        List<bangSPinHoaDon> list = new HoaDonRepository().showttthongke(35, 60);
        for (bangSPinHoaDon sPinHoaDon : list) {
            System.out.println(sPinHoaDon.getMaSP());
        }
    }

}
