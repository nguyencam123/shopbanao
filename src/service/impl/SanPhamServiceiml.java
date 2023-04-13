/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.SanPham;
import domainmodel.Size;
import java.util.List;
import repository.SPrepository1;
import repository.Sizerepository;
import service.ISanPhamService1;
import service.ISizeService;

/**
 *
 * @author c
 */
public class SanPhamServiceiml implements ISanPhamService1 {

    SPrepository1 size = new SPrepository1();

//    Nxbrepository rs = new Nxbrepository();
//
//    @Override
//    public List<Nsx> getall() {
//        return rs.getall();
//    }
//
//    @Override
//    public String addrow(Nsx nv) {
//        if (rs.add(nv)) {
//            return "add complete";
//        } else {
//            return "fail";
//        }
//    }
//
//    @Override
//    public String sua(Nsx nv, String manv) {
//        if (rs.update(nv, manv)) {
//            return "update thanh cong";
//        } else {
//            return "update k thanh cong";
//        }
//    }
//
//    @Override
//    public String delete(String manv) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public List<SanPham> getall() {
        return size.getall();
    }

    @Override
    public String addrow(SanPham nv) {
        if (size.add(nv)) {
            return "add complete";
        } else {
            return "fail";
        }
    }

    @Override
    public String sua(SanPham nv, String manv) {
        if (size.update(nv, manv)) {
            return "update thanh cong";
        } else {
            return "update k thanh cong";
        }
    }

    @Override
    public String delete(String manv) {
        if (size.delete(manv)) {
            return "delete thanh cong";
        } else {
            return "delete k thanh cong";
        }
    }

    }
