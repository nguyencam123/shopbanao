/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.ChucVu;
import java.util.List;
import repository.ChucVuRepository;

/**
 *
 * @author HP probook
 */
public interface IChucVuService {

    public List<ChucVu> getListCV();

    public String themCV(ChucVu c);
    public String SuaCV(ChucVu c,String id);
    public String xoaCV(String id);
}
