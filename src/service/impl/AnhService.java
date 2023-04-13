/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.Anh;
import java.util.List;
import repository.AnhRepository;
import repository.SanPhamRepository;
import service.IAnhService;

/**
 *
 * @author Admin
 */
public class AnhService implements IAnhService{

    
    AnhRepository anhreposity=new AnhRepository();
    @Override
    public String them(Anh a) {
        return anhreposity.themAnh(a);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Anh> getListAnh() {
        return anhreposity.getListAnh();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String sua(Anh a, String ten) {
        return anhreposity.update(a, ten);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
