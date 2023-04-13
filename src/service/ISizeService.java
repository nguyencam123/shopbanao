/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.Size;
import java.util.List;

/**
 *
 * @author c
 */
public interface ISizeService {
    List<Size> getall();

    String addrow(Size nv);

    String sua(Size nv, String manv);

    String delete(String manv);
}
