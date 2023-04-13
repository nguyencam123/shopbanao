/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.SanPham;
import domainmodel.Size;
import java.util.List;

/**
 *
 * @author c
 */
public interface ISanPhamService1 {
    List<SanPham> getall();

    String addrow(SanPham nv);

    String sua(SanPham nv, String manv);

    String delete(String manv);
}
