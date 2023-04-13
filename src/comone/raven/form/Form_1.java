package comone.raven.form;

import comone.raven.chart.ModelChart;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import service.impl.ThongkeViewModeliml;
import viewmodel.BieudoViewModel;
import viewmodel.ThongKenowViewModel;

public class Form_1 extends javax.swing.JPanel {

    public Form_1() {
        initComponents();
        setOpaque(false);
        init();
    }

    private void init() {

        //
        chart.addLegend("Doanh thu các năm(VND)", new Color(12, 84, 175), new Color(0, 108, 247));
//        chart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
//        chart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
//        chart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        List<BieudoViewModel> tk2018s2 = new ThongkeViewModeliml().showdoanhtu2018();
        for (BieudoViewModel bieudoViewModel : tk2018s2) {
            chart.addData(new ModelChart(bieudoViewModel.getNgaytao(), new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
        }

//        chart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
//        chart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
//        chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
//        chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
//        chart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
//        chart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        chart.start();
        lineChart.addLegend("Doanh thu tháng(VND)", new Color(12, 84, 175), new Color(0, 108, 247));
//        lineChart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
//        lineChart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
//        lineChart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
//        int date = dateyaer.getYear();
//        List<BieudoViewModel> tk2018 = new ThongkeViewModeliml().showttbieudo2021(date);
//        for (BieudoViewModel bieudoViewModel : tk2018) {
//            lineChart.addData(new ModelChart(bieudoViewModel.getNgaytao(), new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
//        }
//        List<BieudoViewModel> tk2019 = new ThongkeViewModeliml().showdoanhtu2019();
//        for (BieudoViewModel bieudoViewModel : tk2019) {
//            lineChart.addData(new ModelChart("2019", new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
//        }
//        List<BieudoViewModel> tk2020 = new ThongkeViewModeliml().showdoanhtu2020();
//        List<BieudoViewModel> tktime2020 = new ThongkeViewModeliml().showtime2020();
//        for (BieudoViewModel bieudoViewModel : tk2020) {
//            for (BieudoViewModel thongKenowViewModel : tktime2020) {
//                //lblmoneyday2.setText(thongKenowViewModel.getTongtien() + " VNĐ");
//            }
//            lineChart.addData(new ModelChart("2020", new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
//
//        }
//        //
//        List<BieudoViewModel> tk = new ThongkeViewModeliml().showttbieudo();
//        List<BieudoViewModel> tk1 = new ThongkeViewModeliml().showttbieudo2021();
//        for (BieudoViewModel bieudoViewModel : tk1) {
//            for (BieudoViewModel thongKenowViewModel : tk) {
//                //lblmoneyday2.setText(thongKenowViewModel.getTongtien() + " VNĐ");
//            }
//            lineChart.addData(new ModelChart("2021", new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
//
//        }
//        List<BieudoViewModel> tk2022 = new ThongkeViewModeliml().showdoanhthu2022();
//        List<BieudoViewModel> tktime2022 = new ThongkeViewModeliml().showtime2022();
//        for (BieudoViewModel bieudoViewModel : tk2022) {
//            for (BieudoViewModel thongKenowViewModel : tktime2022) {
//                //lblmoneyday2.setText(thongKenowViewModel.getTongtien() + " VNĐ");
//            }
//            lineChart.addData(new ModelChart("2022", new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
//
//        }

//        lineChart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
//        lineChart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
//        lineChart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
//        lineChart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
//        lineChart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
//        progress1.start();
//        progress2.start();
//        progress3.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new comone.raven.swing.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        roundPanel2 = new comone.raven.swing.RoundPanel();
        chart = new comone.raven.chart.Chart();
        roundPanel3 = new comone.raven.swing.RoundPanel();
        lineChart = new comone.raven.chart.LineChart();
        jPanel4 = new javax.swing.JPanel();
        dateyaer = new com.toedter.calendar.JYearChooser();
        btnloc = new javax.swing.JButton();

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(220, 220, 220));
        jLabel2.setText("Báo cáo doanh thu");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
        );

        roundPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        dateyaer.setBackground(new java.awt.Color(102, 102, 102));

        btnloc.setBackground(new java.awt.Color(102, 102, 102));
        btnloc.setText("Lọc");
        btnloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateyaer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnloc)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnloc)
                    .addComponent(dateyaer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnlocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlocActionPerformed
        // TODO add your handling code here:
        int date = dateyaer.getYear();
        Date date1 = new Date();
        lineChart.clear();
        if (dateyaer.getYear() >= 2024) {
            JOptionPane.showMessageDialog(roundPanel1, "bạn đã nhập quá số năm");
        } else {
            List<BieudoViewModel> tk2018 = new ThongkeViewModeliml().showttbieudo2021(date);
            for (BieudoViewModel bieudoViewModel : tk2018) {
                lineChart.addData(new ModelChart(bieudoViewModel.getNgaytao(), new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
            }
        }
        lineChart.start();
    }//GEN-LAST:event_btnlocActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnloc;
    private comone.raven.chart.Chart chart;
    private com.toedter.calendar.JYearChooser dateyaer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private comone.raven.chart.LineChart lineChart;
    private comone.raven.swing.RoundPanel roundPanel1;
    private comone.raven.swing.RoundPanel roundPanel2;
    private comone.raven.swing.RoundPanel roundPanel3;
    // End of variables declaration//GEN-END:variables
}
