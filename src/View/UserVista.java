/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.CrearUsuario;
import Controller.ControladorCrearUsuario;
/**
 *
 * @author manum
 */
public class UserVista extends javax.swing.JFrame {

    /**
     * Creates new form UserVista
     */
    public UserVista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHistorial = new javax.swing.JButton();
        CajaAyuda = new javax.swing.JComboBox<>();
        btnRegistro = new javax.swing.JButton();
        btnBuscarCuentas = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        btnDepositos = new javax.swing.JButton();
        btnRetiros = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHistorial.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/historial.png"))); // NOI18N
        btnHistorial.setBorderPainted(false);
        btnHistorial.setContentAreaFilled(false);
        btnHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistorial.setMargin(new java.awt.Insets(2, 6, 3, 12));
        btnHistorial.setActionCommand("Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 70, 70));

        CajaAyuda.setBackground(new java.awt.Color(0, 0, 0));
        CajaAyuda.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        CajaAyuda.setForeground(new java.awt.Color(255, 255, 255));
        CajaAyuda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CajaAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CajaAyudaActionPerformed(evt);
            }
        });
        jPanel1.add(CajaAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 140, -1));

        btnRegistro.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registrarUsuario1.png"))); // NOI18N
        btnRegistro.setToolTipText("");
        btnRegistro.setActionCommand("Registro de Usuario");
        btnRegistro.setBorderPainted(false);
        btnRegistro.setContentAreaFilled(false);
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistro.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistro.setMargin(new java.awt.Insets(3, 7, 3, 7));
        btnRegistro.setPreferredSize(new java.awt.Dimension(50, 30));
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 70, 70));

        btnBuscarCuentas.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnBuscarCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BuscarCuentas.png"))); // NOI18N
        btnBuscarCuentas.setBorderPainted(false);
        btnBuscarCuentas.setContentAreaFilled(false);
        btnBuscarCuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCuentas.setActionCommand("Buscar Cuentas");
        btnBuscarCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCuentasActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 70, 70));

        btnCrear.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CrearCuenta1.png"))); // NOI18N
        btnCrear.setActionCommand("Crear Cuenta");
        btnCrear.setBorderPainted(false);
        btnCrear.setContentAreaFilled(false);
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnCrear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCrear.setMargin(new java.awt.Insets(3, 7, 3, 7));
        btnCrear.setPreferredSize(new java.awt.Dimension(50, 30));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 70, 70));

        btnGenerar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GenerarReporte.png"))); // NOI18N
        btnGenerar.setBorderPainted(false);
        btnGenerar.setContentAreaFilled(false);
        btnGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerar.setActionCommand("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 70, 70));

        btnDepositos.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnDepositos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Deposito.png"))); // NOI18N
        btnDepositos.setActionCommand("Depositos");
        btnDepositos.setBorderPainted(false);
        btnDepositos.setContentAreaFilled(false);
        btnDepositos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDepositos.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnDepositos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDepositos.setMargin(new java.awt.Insets(3, 7, 3, 7));
        btnDepositos.setPreferredSize(new java.awt.Dimension(50, 30));
        btnDepositos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositosActionPerformed(evt);
            }
        });
        jPanel1.add(btnDepositos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 70, 70));

        btnRetiros.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnRetiros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Retiro.png"))); // NOI18N
        btnRetiros.setBorderPainted(false);
        btnRetiros.setActionCommand("Retiros");
        btnRetiros.setContentAreaFilled(false);
        btnRetiros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRetiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirosActionPerformed(evt);
            }
        });
        jPanel1.add(btnRetiros, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 70, 70));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registar Nuevo Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 160, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 90, 70));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Crear Cuenta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 60, 10));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Deposito");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 143, 400, 10));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 40, 10));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Retiro");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 100, 10));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar Cuentas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 60, 10));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Historial");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 110, 10));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Generar Reporte");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CajaAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CajaAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CajaAyudaActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
      
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnDepositosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDepositosActionPerformed

    private void btnRetirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetirosActionPerformed

    private void btnBuscarCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarCuentasActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarActionPerformed

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
            java.util.logging.Logger.getLogger(UserVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserVista().setVisible(true);
            }
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> CajaAyuda;
    public javax.swing.JButton btnBuscarCuentas;
    public javax.swing.JButton btnCrear;
    public javax.swing.JButton btnDepositos;
    public javax.swing.JButton btnGenerar;
    public javax.swing.JButton btnHistorial;
    public javax.swing.JButton btnRegistro;
    public javax.swing.JButton btnRetiros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    // End of variables declaration//GEN-END:variables
}
