/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.DanhMuc;
import domainmodel.DongSP;
import java.util.List;

/**
 *
 * @author PC DUNG
 */
public interface DanhMucService {
    List<DanhMuc> getDanhMucs();
    String add(DanhMuc danhMuc);
    String update(DanhMuc danhMuc);
    String delete(String maDanhMuc);
}
