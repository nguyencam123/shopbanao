/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import domainmodel.Size;
import domainmodel.Size1;
import java.sql.SQLException;
import utilities.DBConnection;

/**
 *
 * @author c
 */
public class Sizerepository {

    public List<Size> getall() {
        String sql = "select * from size";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<Size> nv = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.add(new Size(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
            }
            rs.close();
            return nv;
        } catch (Exception e) {
        }
        return null;
    }

    public List<Size1> getone() {
        String sql = "select id,ma,Sosize from size";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<Size1> nv = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.add(new Size1(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            rs.close();
            return nv;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean add(Size nv) {
        String sql = "INSERT INTO [dbo].[Size]\n"
                + "           ([Ma]\n"
                + "           ,[SoSize]\n"
                + "           ,[cannangmin]\n"
                + "           ,[cannangmax]\n"
                + "           ,[chieucaomin]\n"
                + "           ,[chieucaomax])\n"
                + "     VALUES\n"
                + "           (?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getSoSize());
            ps.setObject(3, nv.getCannangmin());
            ps.setObject(4, nv.getCanmangmax());
            ps.setObject(5, nv.getChieucaomin());
            ps.setObject(6, nv.getChieucaomax());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean update(Size nv, String manv) {
        String sql = "UPDATE [dbo].[Size]\n"
                + "     SET [Ma] = ?"
                + "      ,[SoSize] = ?"
                + "      ,[cannangmin] = ?"
                + "      ,[cannangmax] = ?"
                + "      ,[chieucaomin] = ?"
                + "      ,[chieucaomax] = ?"
                + " WHERE ma=?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getSoSize());
            ps.setObject(3, nv.getCannangmin());
            ps.setObject(4, nv.getCanmangmax());
            ps.setObject(5, nv.getChieucaomin());
            ps.setObject(6, nv.getChieucaomax());
            ps.setObject(7, manv);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[Size]\n"
                + "      WHERE ma=?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
