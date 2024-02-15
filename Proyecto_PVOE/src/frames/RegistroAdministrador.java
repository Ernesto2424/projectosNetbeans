/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Clases.Profe;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import operaciones.BaseDeDatos;

/**
 *
 * @author Personal
 */
public class RegistroAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form RegistroAdministrador
     */
    public RegistroAdministrador() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    public Image getIconImage(){
     Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/mi_logo.png"));   
      return retValue;   
    }
    public boolean RevisaCampos(){
        boolean camposVacios = false;
        if(txt_nombre.getText().isEmpty()||txt_paterno.getText().isEmpty()
           ||txt_materno.getText().isEmpty()|| txt_correo.getText().isEmpty()||pass_contraseña.getText().isEmpty()){
            camposVacios = true;
        }
        return camposVacios;
    }
    
    public void RegistroProfe(){
 
        Profe admin = new Profe();
        admin.setNombre(txt_nombre.getText());
        admin.setPaterno(txt_paterno.getText());
        admin.setMaterno(txt_materno.getText());
        admin.setCorreo(txt_correo.getText());
        admin.setContraseña(pass_contraseña.getText());
        String sql = "INSERT INTO administrador (id, nombre, paterno, materno, correo, contraseña) VALUES (?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setString(1, null);
            pst.setString(2,admin.getNombre());
            pst.setString(3, admin.getPaterno());
            pst.setString(4, admin.getMaterno());
            pst.setString(5, admin.getCorreo());
            pst.setString(6, admin.getContraseña());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RegistroAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_paterno = new javax.swing.JTextField();
        txt_materno = new javax.swing.JTextField();
        pass_contraseña = new javax.swing.JPasswordField();
        btn_registrar = new javax.swing.JButton();
        lb_atras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital San Rafael - Registro Usuario");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("APELLIDO MATERNO:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, 10));

        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("CONTRASEÑA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario2.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 130, 150));

        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("APELLIDO PATERNO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, 10));

        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("NOMBRE:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, 10));

        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("CORREO ELECTRONICO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, 10));
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 180, -1));

        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 180, -1));

        txt_paterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_paternoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_paterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 180, -1));
        jPanel1.add(txt_materno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 180, -1));

        pass_contraseña.setEchoChar('\u2022');
        jPanel1.add(pass_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 180, -1));

        btn_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar-usuario.png"))); // NOI18N
        btn_registrar.setText("Crear");
        btn_registrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 455, 120, 40));

        lb_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/punta-de-flecha-izquierda-en-un-circulo.png"))); // NOI18N
        lb_atras.setToolTipText("Atras");
        lb_atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_atrasMouseClicked(evt);
            }
        });
        jPanel1.add(lb_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_paternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_paternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_paternoActionPerformed

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        // TODO add your handling code here:
        boolean checa = RevisaCampos();
        if(checa == false){
            RegistroProfe();
            JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO","GOOD", JOptionPane.WARNING_MESSAGE);
            Menu mn = new Menu();
            mn.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS SON OBLIGATORIOS","ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_registrarActionPerformed

    private void lb_atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_atrasMouseClicked
        // TODO add your handling code here:
        Menu mn = new Menu();
        mn.setVisible(true);
        dispose();
    }//GEN-LAST:event_lb_atrasMouseClicked

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
            java.util.logging.Logger.getLogger(RegistroAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_atras;
    private javax.swing.JPasswordField pass_contraseña;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_materno;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_paterno;
    // End of variables declaration//GEN-END:variables
BaseDeDatos bd = new BaseDeDatos();
        Connection cc = bd.Connectar();
}
