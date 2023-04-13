/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.DanhMuc;
import domainmodel.DongSP;
import java.util.List;
import repository.DanhMucRepository;
import service.DanhMucService;

/**
 *
 * @author PC DUNG
 */
public class DanhMucServiceimpl implements DanhMucService{

    DanhMucRepository repository=new DanhMucRepository();
    @Override
    public List<DanhMuc> getDanhMucs() {
        return repository.getListDanhMuc();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(DanhMuc danhMuc) {
        return repository.insertDongSP(danhMuc);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(DanhMuc danhMuc) {
        return repository.updateDongSP(danhMuc);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(String maDanhMuc) {
        return repository.deleteDongSP(maDanhMuc);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
