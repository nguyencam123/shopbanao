/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.KhuyenMai;
import java.util.List;
import repository.KhuyenMaiRepository;
import service.IKhuyenMaiService;

/**
 *
 * @author AS
 */
public class KhuyenMaiServiceImpl implements IKhuyenMaiService {

    private KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();

    @Override
    public List<KhuyenMai> getAll() {
        return khuyenMaiRepository.getAll();

    }

    @Override
    public Integer add(KhuyenMai khuyenMai) {
        return khuyenMaiRepository.add(khuyenMai);
    }

    @Override
    public Integer update(KhuyenMai khuyenMai) {
        return khuyenMaiRepository.update(khuyenMai);
    }

    @Override
    public Integer delete(String maKM) {
        return khuyenMaiRepository.delete(maKM);
    }

    @Override
    public List<KhuyenMai> sapDienRa() {
        return khuyenMaiRepository.sapDienRa();
    }

    @Override
    public List<KhuyenMai> hetHan() {
        return khuyenMaiRepository.hetHan();
    }

    @Override
    public List<KhuyenMai> dangDienRa() {
        return khuyenMaiRepository.dangDienRa();
    }

}

