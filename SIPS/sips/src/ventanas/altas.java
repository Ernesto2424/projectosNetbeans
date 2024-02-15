/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ERNESTO FLORES
 */
public class altas extends javax.swing.JFrame {

    /**
     * Creates new form altas
     */
    
    clase cn = new clase();
    Connection cc = cn.Connetar();
    public altas() {
        initComponents();
        mostrar("");
        this.setLocationRelativeTo(null);
        txtGuardar.setVisible(false);
    }

    
    public Image getIconImage(){
     Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/k.png.jpg"));   
      return retValue;   
    }
    
    
    void mostrar (String valor){
        String titulos [] = {"ID","CLAVE","PRODUCTO","CANTIDAD ALTAS","UNIDADES","UBICACION","PRECIO","PRECIO USD","PRECIO TOTAL","FECHA","HORA","PROVEEDOR"};
        String [] registros = new String [12];
        String sql = "SELECT * FROM actualizacion where CONCAT (PRODUCTO, ' ',HORA  ) LIKE '%"+valor+"%'";
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        clase cn = new clase();
        Connection cc = cn.Connetar();
        
        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                registros [0] = rs.getString("ID");
                registros [1] = rs.getString("CLAVE");
                registros [2] = rs.getString("PRODUCTO");
                registros [3] = rs.getString("EXISTENCIA");
                registros [4] = rs.getString("UNIDADES");
                registros [5] = rs.getString("UBICACION");
                registros [6] = rs.getString("PRECIO");
                registros [7] = rs.getString("PRECIO_USD");
                registros [8] = rs.getString("PRECIOT");
                registros [9] = rs.getString("HORA");
                registros [10] = rs.getString("FECHA");
                registros [11] = rs.getString("PROVEEDOR");
               model.addRow(registros);
            }
            tablaA.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(PRODUCTOS2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void guardar(){
            String sql = "INSERT INTO pdf(id,direccion) VALUES(?,?)";
            JFileChooser GD = new JFileChooser();
            int op = GD.showSaveDialog(this);
                if(op == JFileChooser.APPROVE_OPTION){
                    File f=GD.getSelectedFile();
                    txtGuardar.setText(f.toString());
                    try {
                        PreparedStatement pps = cc.prepareStatement(sql);
                        pps.setString(1, "1");
                        pps.setString(2,f.toString());
                        pps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(bajas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
    }
    
    void pdf(){
         String ruta = txtGuardar.getText();
         try {
            SimpleDateFormat dms = new SimpleDateFormat("EEEE MMMM d");
            SimpleDateFormat hmsa = new SimpleDateFormat("HH:mm:ss yyyy");
            int fila = tablaA.getRowCount(); 
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(ruta+".pdf"));
            PdfWriter pdf = PdfWriter.getInstance(document, new FileOutputStream(ruta+".pdf"));
            Paragraph medio = new Paragraph("ALTA");
            medio.setIndentationLeft(50);
            Paragraph vacio1 = new Paragraph();
            vacio1.add("\n\n");
            document.open();
            document.add(medio);
            document.add(vacio1);
            PdfPTable tabla = new PdfPTable(10);
            tabla.setWidthPercentage(110);
            tabla.setWidths(new float[] {13,20,15,15,15,15,15,15,15,15});
            
            Paragraph columna2 = new Paragraph("CLAVE");
            columna2.getFont().setStyle(Font.BOLD);
            columna2.getFont().setStyle(3);
            tabla.addCell(columna2);
            
            Paragraph columna3 = new Paragraph("PRODUCTO");
            columna3.getFont().setStyle(Font.BOLD);
            columna3.getFont().setStyle(3);
            tabla.addCell(columna3);
            
            Paragraph columna4 = new Paragraph("CANTIDAD ALTAS");
            columna4.getFont().setStyle(Font.BOLD);
            columna4.getFont().setStyle(3);
            tabla.addCell(columna4);
            
            Paragraph columna5 = new Paragraph("UNIDADES");
            columna5.getFont().setStyle(Font.BOLD);
            columna5.getFont().setStyle(3);
            tabla.addCell(columna5);
            
            Paragraph columna7 = new Paragraph("PRECIO");
            columna7.getFont().setStyle(Font.BOLD);
            columna7.getFont().setStyle(3);
            tabla.addCell(columna7);
            
             Paragraph columna8 = new Paragraph("PRECIO USD");
            columna7.getFont().setStyle(Font.BOLD);
            columna7.getFont().setStyle(3);
            tabla.addCell(columna8);
            
            Paragraph columna9 = new Paragraph("PRECIO TOTAL");
            columna8.getFont().setStyle(Font.BOLD);
            columna8.getFont().setStyle(3);
            tabla.addCell(columna9);
            
            Paragraph columna10 = new Paragraph("HORA");
            columna9.getFont().setStyle(Font.BOLD);
            columna9.getFont().setStyle(3);
            tabla.addCell(columna10);
            
            Paragraph columna11 = new Paragraph("FECHA");
            columna10.getFont().setStyle(Font.BOLD);
            columna10.getFont().setStyle(3);
            tabla.addCell(columna11);
            
            Paragraph columna12 = new Paragraph("PROVEEDOR");
            columna11.getFont().setStyle(Font.BOLD);
            columna11.getFont().setStyle(3);
            tabla.addCell(columna12);
            
            for(int i = 0; i<fila; i++){
                tabla.addCell(tablaA.getValueAt(i, 1).toString());
                tabla.addCell(tablaA.getValueAt(i, 2).toString());
                tabla.addCell(tablaA.getValueAt(i, 3).toString());
                tabla.addCell(tablaA.getValueAt(i, 4).toString());
                tabla.addCell("$"+tablaA.getValueAt(i, 6).toString());
                tabla.addCell("$$"+tablaA.getValueAt(i, 7).toString());
                tabla.addCell("$"+tablaA.getValueAt(i, 8).toString());
                tabla.addCell(tablaA.getValueAt(i, 9).toString());
                tabla.addCell(tablaA.getValueAt(i, 10).toString());
                tabla.addCell(tablaA.getValueAt(i, 11).toString());
            }
            document.add(tabla);
            document.close();
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(entrada_salida.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
          File path = new File (ruta+".pdf");
          Desktop.getDesktop().open(path);
        }catch (IOException ex) {
          ex.printStackTrace();
        }
    }
    
    void acceptar(){
        int acc = 0;
        String direc=null;
        String sql = "SELECT * FROM pdf WHERE id = 1";
        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                acc = Integer.parseInt(rs.getString("id"));
                direc = String.format(rs.getString("direccion"));
            }
//            JOptionPane.showMessageDialog(null, acc);
//            JOptionPane.showMessageDialog(null, direc);
            if(acc == 1){
                txtGuardar.setText(direc);
                pdf();
            }else{
                JOptionPane.showMessageDialog(null, "No a guardado la direccion de Altas");
                guardar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(bajas.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaA = new javax.swing.JTable();
        txtGuardar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        aux = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaA);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1090, 340));
        getContentPane().add(txtGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 140, -1));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Search_32px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 120, 10));

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("S E A R C H . . . .  ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, -1));

        aux.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        aux.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                auxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                auxKeyReleased(evt);
            }
        });
        jPanel1.add(aux, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ALTAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        acceptar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void auxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_auxKeyReleased
        mostrar(aux.getText());
    }//GEN-LAST:event_auxKeyReleased

    private void auxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_auxKeyPressed
 char car = evt.getKeyChar();
        jLabel8.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_auxKeyPressed

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
            java.util.logging.Logger.getLogger(altas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(altas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(altas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(altas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new altas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aux;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaA;
    private javax.swing.JTextField txtGuardar;
    // End of variables declaration//GEN-END:variables
}
