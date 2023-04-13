/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.KhuyenMai;
import java.util.List;

/**
 *
 * @author AS
 */
public interface IKhuyenMaiService {

    List<KhuyenMai> getAll();

    Integer add(KhuyenMai khuyenMai);

    Integer update(KhuyenMai khuyenMai);

    Integer delete(String maKM);
    
    List<KhuyenMai> sapDienRa();
    List<KhuyenMai> hetHan();
    List<KhuyenMai> dangDienRa();
}
