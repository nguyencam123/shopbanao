/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.Size;
import java.util.List;
import repository.Sizerepository;
import service.ISizeService;

/**
 *
 * @author c
 */
public class SizeServiceiml1 implements ISizeService {

    Sizerepository size = new Sizerepository();

    @Override
    public List<Size> getall() {
        return size.getall();
    }

    @Override
    public String addrow(Size nv) {
        if (size.add(nv)) {
            return "add complete";
        } else {
            return "fail";
        }
    }

    @Override
    public String sua(Size nv, String manv
    ) {
        if (size.update(nv, manv)) {
            return "update thanh cong";
        } else {
            return "update k thanh cong";
        }
    }

    @Override
    public String delete(String manv
    ) {
        if (size.delete(manv)) {
            return "delete thanh cong";
        } else {
            return "delete k thanh cong";
        }
    }

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
}
