/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.ChucVu;
import java.util.List;
import repository.ChucVuRepository;
import service.IChucVuService;

/**
 *
 * @author HP probook
 */
public class ChucVuService implements IChucVuService {

    public ChucVuService() {
    }
    ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    public List<ChucVu> getListCV() {
        return chucVuRepository.getListCV();
    }
     public String themCV(ChucVu c){
         return chucVuRepository.themCV(c);
     }
     public String SuaCV(ChucVu c,String id){
         return chucVuRepository.SuaCV(c, id);
     }
     public String xoaCV(String id){
         return chucVuRepository.xoaCV(id);
     }

}
