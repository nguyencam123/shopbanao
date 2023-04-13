/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.MauSac;
import java.util.List;

/**
 *
 * @author PC DUNG
 */
public interface MausacService {
    List<MauSac> getListMausac();
    String add(MauSac ms);
    String update(MauSac m);
    String delete(String s);
}
