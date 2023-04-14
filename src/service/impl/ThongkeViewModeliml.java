/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import ViewModel.ThongkeViewModel;
import java.util.Date;
import java.util.List;
import repository.ThongkeRepositoty;
import service.IThongkeViewModel;
import viewmodel.BieudoViewModel;
import viewmodel.ThongKeTable2;
import viewmodel.ThongKenowViewModel;

/**
 *
 * @author c
 */
public class ThongkeViewModeliml implements IThongkeViewModel {

    ThongkeRepositoty rp = new ThongkeRepositoty();

    @Override
    public List<ThongkeViewModel> getall() {
        return rp.getall();
    }

    @Override
    public List<ThongKenowViewModel> showttday1() {
        return rp.showTTday1();
    }

    @Override
    public List<ThongKenowViewModel> showttday7() {
        return rp.showTTday7();
    }

    @Override
    public List<ThongKenowViewModel> showttday30() {
        return rp.showTTday30();
    }

    @Override
    public List<ThongKenowViewModel> showttcustom(Date date1, Date date2) {
        return rp.showttthongke(date1, date2);
    }

    @Override
    public List<ThongKenowViewModel> showtthoadonday1() {
        return rp.showhoadonbanday1();
    }

    @Override
    public List<ThongKenowViewModel> showtthoadonday7() {
        return rp.showhoadonbanday7();
    }

    @Override
    public List<ThongKenowViewModel> showtthoadonday30() {
        return rp.showhoadonbanday30();
    }

    @Override
    public List<ThongKenowViewModel> showhoadoncustom(Date date1, Date date2) {
        return rp.showhoadonthongke(date1, date2);
    }

    @Override
    public List<ThongKeTable2> getalltable2() {
        return rp.getalltable2();
    }


    @Override
    public List<BieudoViewModel> showdoanhtu2018() {
        return rp.showtongtien2018();
    }

    @Override
    public List<BieudoViewModel> showttbieudo2021(int date1) {
        return rp.showtongtien2021(date1);
    }
    

}
