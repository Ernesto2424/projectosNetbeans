/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.practica.formas;

import java.awt.Button;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author
 */
public class FrmConversiones extends javax.swing.JFrame {

    /**
     * Creates new form FrmConversiones
     */
    public FrmConversiones() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        grupoBotonesR();
        rango();
        
        
        
        
        
        
    }
    
    
    
    public void grupoBotonesR(){
        buttonGroup1.add(radio_centigrados);
        buttonGroup1.add(radio_fa);
        buttonGroup1.add(radio_kelvin);
        
    }
    
    
    
    
    public void rango(){
        SpinnerModel modelo = new SpinnerNumberModel(0,-100,100,1);
        spnr_Temperatura.setModel(modelo);
    }
    
    public void centigrados(){
        Integer centigrado = (Integer) spnr_Temperatura.getValue();
            double F = (centigrado*1.8) + 32;
            double K = centigrado + 273.15;
            String FF = Double.toString(F);
            txt_Farenheit.setText(FF);
            String KK = Double.toString(K);
            txt_Kelvin.setText(KK);
            
           
    }
    public void farenheit(){
         Integer farenheits = (Integer) spnr_Temperatura.getValue();
         double C = (farenheits-32)* 0.5555555556;
         double K = C+273.15;
         String CC = Double.toString(C);
         txt_Centigrados.setText(CC);
         String KK = Double.toString(K);
         txt_Kelvin.setText(KK);
    }
    
    public void kelvin(){
        Integer kelvin = (Integer) spnr_Temperatura.getValue();
        if(kelvin >=0){
          double C = kelvin - 273.15;
        double F = (C*1.8) + 32;
        String CC = Double.toString(C);
        txt_Centigrados.setText(CC);
        String FF = Double.toString(F);
        txt_Farenheit.setText(FF);    
        }else{
            JOptionPane.showMessageDialog(null, "Temperatura no permitida", "ERROR", JOptionPane.ERROR_MESSAGE);
            spnr_Temperatura.setValue(0);
        }
        
    }
 
    public void opcion_seleccionada(){
        if(radio_centigrados.isSelected()){
            txt_Centigrados.setVisible(false);
            txt_Farenheit.setVisible(true);
            txt_Kelvin.setVisible(true);
            centigrados();
        }else if(radio_fa.isSelected()){
            txt_Farenheit.setVisible(false);
            txt_Centigrados.setVisible(true);
            txt_Kelvin.setVisible(true);
            farenheit();
        }else if(radio_kelvin.isSelected()){
            kelvin();
            txt_Kelvin.setVisible(false);
            txt_Centigrados.setVisible(true);
            txt_Farenheit.setVisible(true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        spnr_Temperatura = new javax.swing.JSpinner();
        txt_Centigrados = new javax.swing.JTextField();
        txt_Farenheit = new javax.swing.JTextField();
        txt_Kelvin = new javax.swing.JTextField();
        lblCentigrados = new javax.swing.JLabel();
        lblFar = new javax.swing.JLabel();
        lblKelvin = new javax.swing.JLabel();
        lblOrigen = new javax.swing.JLabel();
        radio_centigrados = new javax.swing.JRadioButton();
        radio_fa = new javax.swing.JRadioButton();
        radio_kelvin = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversiones de Temperaturas");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblTitulo.setText("Sistema de Conversiones");

        spnr_Temperatura.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnr_TemperaturaStateChanged(evt);
            }
        });
        spnr_Temperatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spnr_TemperaturaMouseClicked(evt);
            }
        });

        lblCentigrados.setText("Grados Centígrados");

        lblFar.setText("Grados  Fahrenheit");

        lblKelvin.setText("Grados Kelvin");

        lblOrigen.setText("Temperatura Origen");

        radio_centigrados.setSelected(true);
        radio_centigrados.setText("Grados Centígrados");
        radio_centigrados.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radio_centigradosStateChanged(evt);
            }
        });
        radio_centigrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_centigradosActionPerformed(evt);
            }
        });

        radio_fa.setText("Grados Fahrenheit");
        radio_fa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_faActionPerformed(evt);
            }
        });

        radio_kelvin.setText("Grados Kelvin");
        radio_kelvin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_kelvinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spnr_Temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOrigen)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(radio_centigrados)
                                            .addComponent(radio_kelvin, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radio_fa, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Centigrados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblKelvin)
                                        .addGap(172, 172, 172))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_Farenheit, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                                    .addComponent(txt_Kelvin))))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addContainerGap(624, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblCentigrados)
                        .addGap(178, 178, 178))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblFar)
                        .addGap(181, 181, 181))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTitulo)
                .addGap(38, 38, 38)
                .addComponent(lblCentigrados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Centigrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrigen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnr_Temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Farenheit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(radio_centigrados))
                    .addComponent(lblKelvin))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Kelvin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(radio_fa)))
                .addGap(37, 37, 37)
                .addComponent(radio_kelvin)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radio_centigradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_centigradosActionPerformed
        opcion_seleccionada();
        
        
    }//GEN-LAST:event_radio_centigradosActionPerformed

    private void radio_faActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_faActionPerformed
        // TODO add your handling code here:
       opcion_seleccionada();
    }//GEN-LAST:event_radio_faActionPerformed

    private void radio_kelvinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_kelvinActionPerformed
        // TODO add your handling code here:
        opcion_seleccionada();
    }//GEN-LAST:event_radio_kelvinActionPerformed

    private void spnr_TemperaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spnr_TemperaturaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_spnr_TemperaturaMouseClicked

    private void spnr_TemperaturaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnr_TemperaturaStateChanged

       opcion_seleccionada();
    }//GEN-LAST:event_spnr_TemperaturaStateChanged

    private void radio_centigradosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radio_centigradosStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_radio_centigradosStateChanged

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formMouseExited

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formMouseReleased

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        opcion_seleccionada();
    }//GEN-LAST:event_formMouseEntered

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
            java.util.logging.Logger.getLogger(FrmConversiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConversiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConversiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConversiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmConversiones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblCentigrados;
    private javax.swing.JLabel lblFar;
    private javax.swing.JLabel lblKelvin;
    private javax.swing.JLabel lblOrigen;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton radio_centigrados;
    private javax.swing.JRadioButton radio_fa;
    private javax.swing.JRadioButton radio_kelvin;
    private javax.swing.JSpinner spnr_Temperatura;
    private javax.swing.JTextField txt_Centigrados;
    private javax.swing.JTextField txt_Farenheit;
    private javax.swing.JTextField txt_Kelvin;
    // End of variables declaration//GEN-END:variables
}
