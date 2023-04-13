/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.SanPham;
import java.util.List;
import repository.SPRepository;

import service.SPService;

/**
 *
 * @author PC DUNG
 */
public class SPServiceImpl implements SPService{
    SPRepository repository=new SPRepository();
    @Override
    public List<SanPham> getAllSP() {
        return repository.getListSP();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String them(SanPham sp) {
        return repository.them(sp);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String sua(SanPham p) {
        return repository.sua(p);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
