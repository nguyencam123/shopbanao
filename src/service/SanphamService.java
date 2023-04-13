/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.Anh;
import domainmodel.ChiTietSP;
import domainmodel.SanPham;
import java.util.List;
import repository.SanPhamRepository;
import viewmodel.SanphamProduct;


/**
 *
 * @author PC DUNG
 */
public interface SanphamService {
    List<SanphamProduct> getAllSp();
//    String insert(SanPham a,SanphamProduct c);
    String update(String ma,SanphamProduct d);
    String updateTT(String t);
    List<SanphamProduct> getAllListDongSP(String dsp);
    String insert(String ten,String ma,SanphamProduct c);
    List<SanphamProduct> timkiem(String t);
//    
     List<SanphamProduct> getDungHD();
}
