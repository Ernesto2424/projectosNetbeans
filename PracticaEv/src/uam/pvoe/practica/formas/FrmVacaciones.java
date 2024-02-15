/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.practica.formas;

import java.util.Enumeration;
import java.util.LinkedList;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import uam.pvoe.practica.modelo.Atractivo;
import uam.pvoe.practica.modelo.Estado;
import uam.pvoe.practica.modelo.MedioTransporte;
import uam.pvoe.practica.modelo.Servicio;
import uam.pvoe.practica.operaciones.Operaciones;

/**
 *
 * @author
 */
public class FrmVacaciones extends javax.swing.JFrame {

    /**
     * Creates new form FrmVacaciones
     */
    public FrmVacaciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        agrupaBotones();
        agrupaCasillas();
        llenadoListaEstados();
        llenadoRadioBotones();
        llenadoCasillas();
        
    }
    
    public void agrupaBotones(){
        btnAutobus.setSelected(true);
        buttonGroup1.add(btnAutobus);
        buttonGroup1.add(btnAvion);
        buttonGroup1.add(btnAutoPropio);
        buttonGroup1.add(btnAutoRentado);   
        cmbEstados.removeAllItems();
        cmbAtractivos.removeAllItems();
    }
    
     LinkedList<JCheckBox>listaCasillas = new LinkedList();
    public void agrupaCasillas(){
        listaCasillas.add(chkDesayuno);
        listaCasillas.add(chkLavanderia);
        listaCasillas.add(chkCajaFuerte);
        listaCasillas.add(chkTour);
        listaCasillas.add(chkGuarderia);
        listaCasillas.add(chkDespertador);    
    }
    
    public void llenadoListaEstados(){
        Estado nulo = new Estado();
        nulo.setNombre(" ------------------------------------------------- ESTADO -------------------------------------------------- ");
        nulo.setClave("null");
        cmbEstados.addItem(nulo);
        Operaciones o1 = new Operaciones();
        LinkedList<Estado> lista = o1.llenarListaEstados();
        for(int i=0; i<lista.size(); ++i){
            Estado e = lista.get(i);
            cmbEstados.addItem(e);
        }
    }
    
    public void llenadoListaAtractivo(String clave){
        Operaciones op = new Operaciones();
        LinkedList<Atractivo> lista = op.llenarListaAtractivos(clave);
        cmbAtractivos.removeAllItems();
        for(int i=0; i<lista.size(); ++i){
            Atractivo a = lista.get(i);
            cmbAtractivos.addItem(a);
        }
    }
    
    public void llenadoRadioBotones(){
        MedioTransporte auto = new MedioTransporte("Auto", "AUTO");
        MedioTransporte bus = new MedioTransporte("Autobús", "BUS");
        MedioTransporte avion = new MedioTransporte("Avión", "AVION");
        MedioTransporte autoR = new MedioTransporte("Auto Rentado", "AUTO_R");
        btnAutobus.setText(bus.getNombre());
        btnAutobus.putClientProperty("clave", bus);
        btnAutoPropio.setText(auto.getNombre());
        btnAutoPropio.putClientProperty("clave", auto);
        btnAvion.setText(avion.getNombre());
        btnAvion.putClientProperty("clave", avion);
        btnAutoRentado.setText(autoR.getNombre());
        btnAutoRentado.putClientProperty("clave", autoR);
    }
    
    public void llenadoCasillas(){
        Servicio desayuno = new Servicio("Desayuno", "DES");
        Servicio recorrido = new Servicio("Recorridos", "REC");
        Servicio lavanderia = new Servicio("Lavandería", "LAV");
        Servicio guarderia = new Servicio("Guardería", "GUAR");
        Servicio caja = new Servicio("Caja Fuerte", "CAJA");
        Servicio despertador = new Servicio("Despertador", "DESP");
        chkDesayuno.setText(desayuno.getNombre());
        chkDesayuno.putClientProperty("clave", desayuno);
        chkTour.setText(recorrido.getNombre());
        chkTour.putClientProperty("clave", recorrido);
        chkLavanderia.setText(lavanderia.getNombre());
        chkLavanderia.putClientProperty("clave", lavanderia);
        chkGuarderia.setText(guarderia.getNombre());
        chkGuarderia.putClientProperty("clave", guarderia);
        chkCajaFuerte.setText(caja.getNombre());
        chkCajaFuerte.putClientProperty("clave", caja);
        chkDespertador.setText(despertador.getNombre());
        chkDespertador.putClientProperty("clave", despertador);
    }
    
    public void bloquearDatos(){
        cmbAtractivos.setVisible(false);
        btnAutobus.setVisible(false);
        btnAvion.setVisible(false);
        btnAutoPropio.setVisible(false);
        btnAutoRentado.setVisible(false);
        chkDesayuno.setVisible(false);
        chkCajaFuerte.setVisible(false);
        chkDespertador.setVisible(false);
        chkGuarderia.setVisible(false);
        chkLavanderia.setVisible(false);
        chkTour.setVisible(false);
        btnRegistrar.setVisible(false);
    }
    
     public void desbloquearDatos(){
        cmbAtractivos.setVisible(true);
        btnAutobus.setVisible(true);
        btnAvion.setVisible(true);
        btnAutoPropio.setVisible(true);
        btnAutoRentado.setVisible(true);
        chkDesayuno.setVisible(true);
        chkCajaFuerte.setVisible(true);
        chkDespertador.setVisible(true);
        chkGuarderia.setVisible(true);
        chkLavanderia.setVisible(true);
        chkTour.setVisible(true);
        btnRegistrar.setVisible(true);
    }
    
     public MedioTransporte obtenerRadiosBotones(){
         Enumeration<AbstractButton> btn = buttonGroup1.getElements();
         MedioTransporte mt = new MedioTransporte("a", "b");
         while(btn.hasMoreElements()){
             JRadioButton aux = (JRadioButton) btn.nextElement();
             if(aux.isSelected()){
                 mt = (MedioTransporte) aux.getClientProperty("clave");
             }
         }
        return mt;
         
     }
    
    public String RecolectaDatos(){
        
        MedioTransporte mt = obtenerRadiosBotones();
        Estado e = (Estado) cmbEstados.getSelectedItem();
        Atractivo a = (Atractivo) cmbAtractivos.getSelectedItem();
       String casillas = "";
        for(int i=0; i<listaCasillas.size(); ++i){
            JCheckBox caja = listaCasillas.get(i);
            if(caja.isSelected()){
                Servicio serv = (Servicio) caja.getClientProperty("clave");
                casillas += serv.getClave()+ "  ";
            }
        }

        String datos = e.getClave()+"\n"
                      +a.getAtractivo() + " " + a.getNombre() + "\n"
                      +mt.getClave()+ " \n"  
                      +casillas;

        return datos;
    }
    
    public void limpiarDatos(){
        cmbEstados.setSelectedIndex(0);
        btnAutobus.setSelected(true);
        
         for(int i=0; i<listaCasillas.size(); ++i){
            JCheckBox caja = listaCasillas.get(i);
            if(caja.isSelected()){
                caja.setSelected(false);
            }
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

        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        cmbEstados = new javax.swing.JComboBox<>();
        cmbAtractivos = new javax.swing.JComboBox<>();
        lblSeleccionaEstado = new javax.swing.JLabel();
        lblSeleccionaAtractivo = new javax.swing.JLabel();
        lblServicioAdicional = new javax.swing.JLabel();
        spr = new javax.swing.JSeparator();
        btnAutobus = new javax.swing.JRadioButton();
        btnAvion = new javax.swing.JRadioButton();
        btnAutoPropio = new javax.swing.JRadioButton();
        btnAutoRentado = new javax.swing.JRadioButton();
        lblFormaViaje = new javax.swing.JLabel();
        chkDesayuno = new javax.swing.JCheckBox();
        chkTour = new javax.swing.JCheckBox();
        chkLavanderia = new javax.swing.JCheckBox();
        chkGuarderia = new javax.swing.JCheckBox();
        chkCajaFuerte = new javax.swing.JCheckBox();
        chkDespertador = new javax.swing.JCheckBox();
        btnRegistrar = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta para Vacaciones");
        setBackground(new java.awt.Color(0, 204, 204));
        setForeground(new java.awt.Color(0, 204, 204));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblTitulo.setText("Selección de Destinos Turísticos");

        cmbEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadosActionPerformed(evt);
            }
        });

        lblSeleccionaEstado.setText("Selecciona el Estado");

        lblSeleccionaAtractivo.setText("Selecciona el Atractivo Turístico");

        lblServicioAdicional.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblServicioAdicional.setText("Servicios Adicionales en tu Estancia");

        lblFormaViaje.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblFormaViaje.setText("¿Cómo piensas viajar?");

        chkDesayuno.setText("jCheckBox1");

        chkTour.setText("jCheckBox2");

        chkLavanderia.setText("jCheckBox3");

        chkGuarderia.setText("jCheckBox4");

        chkCajaFuerte.setText("jCheckBox5");

        chkDespertador.setText("jCheckBox6");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistrar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(spr, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitulo)
                            .addComponent(cmbEstados, 0, 498, Short.MAX_VALUE)
                            .addComponent(cmbAtractivos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(lblSeleccionaEstado)
                        .addComponent(lblSeleccionaAtractivo)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAutobus)
                            .addGap(64, 64, 64)
                            .addComponent(btnAvion)
                            .addGap(69, 69, 69)
                            .addComponent(btnAutoPropio)
                            .addGap(70, 70, 70)
                            .addComponent(btnAutoRentado))
                        .addComponent(lblFormaViaje)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(chkTour)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chkGuarderia))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(chkDesayuno)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chkLavanderia))
                                .addComponent(lblServicioAdicional, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(72, 72, 72)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(chkCajaFuerte)
                                .addComponent(chkDespertador)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(40, 40, 40)
                .addComponent(lblSeleccionaEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblSeleccionaAtractivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAtractivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(spr, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFormaViaje)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAutobus)
                    .addComponent(btnAvion)
                    .addComponent(btnAutoPropio)
                    .addComponent(btnAutoRentado))
                .addGap(37, 37, 37)
                .addComponent(lblServicioAdicional)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkDesayuno)
                    .addComponent(chkLavanderia)
                    .addComponent(chkCajaFuerte))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkTour)
                    .addComponent(chkGuarderia)
                    .addComponent(chkDespertador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadosActionPerformed
        
        if(cmbEstados.getSelectedIndex()!=0){
        Estado estado = (Estado) cmbEstados.getSelectedItem();
            llenadoListaAtractivo(estado.getClave());
            desbloquearDatos();
        
        }else{
            bloquearDatos();
        }
        
       
            
        
    }//GEN-LAST:event_cmbEstadosActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, RecolectaDatos(), "INFORMACION", JOptionPane.WARNING_MESSAGE);
        limpiarDatos();
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVacaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVacaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVacaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVacaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVacaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnAutoPropio;
    private javax.swing.JRadioButton btnAutoRentado;
    private javax.swing.JRadioButton btnAutobus;
    private javax.swing.JRadioButton btnAvion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkCajaFuerte;
    private javax.swing.JCheckBox chkDesayuno;
    private javax.swing.JCheckBox chkDespertador;
    private javax.swing.JCheckBox chkGuarderia;
    private javax.swing.JCheckBox chkLavanderia;
    private javax.swing.JCheckBox chkTour;
    private javax.swing.JComboBox<Atractivo> cmbAtractivos;
    private javax.swing.JComboBox<Estado> cmbEstados;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel lblFormaViaje;
    private javax.swing.JLabel lblSeleccionaAtractivo;
    private javax.swing.JLabel lblSeleccionaEstado;
    private javax.swing.JLabel lblServicioAdicional;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSeparator spr;
    // End of variables declaration//GEN-END:variables
}
