/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.Anh;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IAnhService {
    
    List<Anh> getListAnh();
    String them(Anh a);
    String sua(Anh a, String ten);
}
