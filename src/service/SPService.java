/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.SanPham;
import java.util.List;

/**
 *
 * @author PC DUNG
 */
public interface SPService {
    List<SanPham> getAllSP();
    String them(SanPham sp);
    String sua(SanPham p);
}
