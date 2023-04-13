/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.raven.main.Main;
import com.raven.main.Main1;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import service.TaiKhoanService;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */
    private TaiKhoanService taiKhoanService = new TaiKhoanService();

    public FrmLogin() {
        initComponents();
        manv();
    }

    public String manv() {
        String i = txtUser.getText();
        System.out.println(i);
        return i;
    }

    public boolean validateFrm() {
        if (txtUser.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống user");
            return false;
        }
        if (txtPass.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống pass");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chkShow = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        btnSignin = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        txtUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 203, 32));

        txtPass.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        txtPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 203, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sd.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 41));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lock_32px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 40));

        chkShow.setText("Hiển thị mật khẩu");
        chkShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowActionPerformed(evt);
            }
        });
        jPanel1.add(chkShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setText("Quên mật khẩu?");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 108, -1));

        btnSignin.setBackground(new java.awt.Color(255, 252, 196));
        btnSignin.setFont(new java.awt.Font("Roboto Slab Light", 0, 18)); // NOI18N
        btnSignin.setText("Đăng nhập");
        btnSignin.setBorder(null);
        btnSignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigninActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 110, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Wellcome ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 370, 400));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Hình nền cảnh núi, đồi đẹp.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowActionPerformed
        // TODO add your handling code here:
        if (chkShow.isSelected()) {
            txtPass.setEchoChar((char) 0);
        } else {
            txtPass.setEchoChar('*');
        }
    }//GEN-LAST:event_chkShowActionPerformed

    private void btnSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigninActionPerformed
        // TODO add your handling code here:
        
        if (validateFrm()) {
            try {
                boolean isAccepted = taiKhoanService.xacThuc(txtUser.getText(), txtPass.getText());
                if (isAccepted) {
                    ToanCuc t=new ToanCuc();
                    t.setMaNV(txtUser.getText());
                    
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                    Main1 main1 = new Main1();
                    main1.show();
                    //                  FrmHome frmHome = new FrmHome();
                    // frmHome.show();
                    this.dispose();
                } else if (txtUser.getText().equals("admin") && txtPass.getText().equals("admin")) {
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                    ToanCuc t=new ToanCuc();
                    t.setMaNV(txtUser.getText());
                    Main main = new Main();
                    main.show();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSigninActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        FrmForgot frmForgot = new FrmForgot();
        frmForgot.show();
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignin;
    private javax.swing.JCheckBox chkShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}