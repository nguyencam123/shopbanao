/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.Anh;
import domainmodel.ChiTietSP;
import domainmodel.SanPham;
import java.util.List;
import repository.SanPhamRepository;
import service.SanphamService;
import viewmodel.SanphamProduct;

/**
 *
 * @author PC DUNG
 */
public class SanphamServiceimpl implements SanphamService{

    SanPhamRepository repository=new SanPhamRepository();

    @Override
    public List<SanphamProduct> getAllSp() {
        return repository.getListSP();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }




//    @Override
//    public String delete(String masp) {
//        return repository.delete(masp);
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public List<SanphamProduct> getAllListDongSP(String dsp) {
        return repository.getListSPtheoDSP(dsp);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String insert(String ten, String ma, SanphamProduct c) {
        return repository.insertSP(ten, ma, c);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public String updateTT(SanphamProduct t) {
//        return repository.updateTT(t);
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public String updateTT(String t) {
        return repository.updateTT(t);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(String ma, SanphamProduct d) {
        return repository.update(ma, d);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanphamProduct> getDungHD() {
        return repository.getListSPDungHD();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanphamProduct> timkiem(String t) {
        return repository.timSP(t);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

   


  



  
    

  

  

 

  

   
    
    
   


   

  
  
    
}
