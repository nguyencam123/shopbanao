/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.DongSP;
import java.util.List;

/**
 *
 * @author PC DUNG
 */
public interface DongspService {
    List<DongSP> getListDongsp();
    String add(DongSP dog);
    String update(DongSP d);
    String delete(String dong);

//    public List<DongSP> getListDongsp(String ten);
}
