/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.TaiKhoanService;
import java.sql.SQLException;
import utilities.DBConnection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class FrmChange extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */
    private TaiKhoanService taiKhoanService = new TaiKhoanService();

    public FrmChange() {
        initComponents();
    }

    public void update() {
        String user = txtUser.getText();
        String pass = txtPass.getText();
        String sql = "update NhanVien set MatKhau=? where TaiKhoan='" + user + "'";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FrmChange.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean validateFrm(){
        if(txtUser.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Không được để trống user");
            return false;
        }
        if(txtPass.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Không được để trống pass");
            return false;
        }
        if(txtPass1.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Không được để trống repass");
            return false;
        }
        if(!txtPass1.getText().equals(txtPass.getText())){
            JOptionPane.showMessageDialog(this, "Mật khẩu không trùng khớp");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JPasswordField();
        txtPass = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        txtUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 203, 32));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sd.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, 41));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/as.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, 40));

        btnDoi.setBackground(new java.awt.Color(255, 252, 196));
        btnDoi.setFont(new java.awt.Font("Roboto Slab Light", 0, 18)); // NOI18N
        btnDoi.setText("Đổi");
        btnDoi.setBorder(null);
        btnDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 110, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Đổi Mật Khẩu");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Quên Mật Khẩu");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lock_32px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, 40));

        txtPass1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 200, 30));

        txtPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 212, 200, 30));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 120, 40));

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 120, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("<-");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 370, 450));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Hình nền cảnh núi, đồi đẹp.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiActionPerformed
       if(validateFrm()){
           update();
           JOptionPane.showMessageDialog(this, "Đã thay đổi mật khẩu thành công");
        }
    }//GEN-LAST:event_btnDoiActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        FrmForgot frmForgot = new FrmForgot();
        frmForgot.show();
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.show();
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(FrmChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmChange().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
