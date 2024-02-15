/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode39;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ERNESTO FLORES
 */
public class entrada_salida extends javax.swing.JFrame implements Runnable {
     String hora,minutos,segundos;
    Thread hilo;
DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form entrada_salida
     */
    public entrada_salida() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrar("");
        txt_existencia.setEnabled(false);
        txt_precioto.setEnabled(false);
        lfecha.setText(fecha());
        hilo = new Thread(this);
        hilo.start();
        setVisible(true);
        TXT_CANTIDAD.setText("0");
        txtdolar.setText("0");
    
    }
    public Image getIconImage(){
     Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/k.png.jpg"));   
      return retValue;   
    }
    
    public void hora(){
        
        Calendar calendario = new GregorianCalendar();
        Date horaactual = new Date ();
        calendario.setTime(horaactual);
        hora=calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
        minutos=calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
    }
      public void run(){
        Thread current =  Thread.currentThread();
        while (current == hilo){
            hora();
            lhora.setText(hora+":"+minutos+":"+segundos);
        }
    }
      
      
      void costot(){
           LCOSTOT.setText("0");
        int ta = tablaA.getRowCount();
        int c = 0;
        do 
            try {
                int f = c++;
                float n1 = Float.parseFloat(tablaA.getValueAt(f, 6).toString());
                String nu = LCOSTOT.getText();
                double nu2;
                nu2=Double.parseDouble(nu);
                float re = (float) (n1+nu2);
                LCOSTOT.setText(String.valueOf(re));
            } catch (Exception e) {
                
            }
        while(c<ta);
      }
      
      
    
      
      
      
      
 void mostrar (String valor){
        String titulos [] = {"ID","CLAVE","PRODUCTO","EXISTENCIA","UNIDADES","UBICACION","PRECIO","PRECIO USD","PRECIO TOTAL","HORA","FECHA","PROVEEDOR"};
        String [] registros = new String [12];
        String sql = "SELECT * FROM inventario where CONCAT (CLAVE, ' ',PRODUCTO   ) LIKE '%"+valor+"%'";
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
 
 void insertar2(){
    clase cn = new clase();
    Connection cc= cn.Connetar();
    
    String aid, aclave, aproducto, aexistencia, aunidades, aubicacion, aprecio, apreciot, ahora, afecha,aproveedor,CA;
    
    aid=txt_id.getText();
    aclave=txt_cla.getText();
    aproducto=txt_producto.getText();
    aexistencia=txt_existencia.getText();
    aunidades= txtuni.getText();
    aubicacion=txt_ubicacion.getText();
    aprecio=txt_precio.getText();
    apreciot=txt_precioto.getText();
    ahora=lhora.getText();
    afecha=lfecha.getText();
    aproveedor=txt_proveedor.getText();
    String sql,DOLAR=txt_predo.getText();
    CA=TXT_CANTIDAD.getText();
    
    sql = "INSERT INTO actualizacion2 (ID, CLAVE, PRODUCTO, EXISTENCIA, UNIDADES, UBICACION, PRECIO, PRECIO_USD, PRECIOT, FECHA, HORA,PROVEEDOR) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
    
         try {
             PreparedStatement pst = cc.prepareStatement(sql);
             pst.setString(1, aid);
             pst.setString(2, aclave);
             pst.setString(3, aproducto);
             pst.setString(4, CA);
             pst.setString(5, aunidades);
             pst.setString(6, aubicacion);
             pst.setString(7, aprecio);
             pst.setString(8, DOLAR);
             pst.setString(9, apreciot);
             pst.setString(10, ahora);
             pst.setString(11, afecha);
             pst.setString(12, aproveedor);
             
             if(aid.isEmpty() || aclave.isEmpty() || aproducto.isEmpty() || aexistencia.isEmpty() || aunidades.isEmpty() || aubicacion.isEmpty() || aprecio.isEmpty() || apreciot.isEmpty()){
                 JOptionPane.showMessageDialog(null, "ERROR EN LA OPERACION", "ERROR", JOptionPane.ERROR_MESSAGE);
             }else{
                 int n = pst.executeUpdate();
             }
         } catch (SQLException ex) {
             Logger.getLogger(entrada_salida.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    
 }
 
 
 
 
 void insertar(){
    clase cn = new clase();
    Connection cc= cn.Connetar();
    
    String aid, aclave, aproducto, aexistencia, aunidades, aubicacion, aprecio, apreciot, ahora, afecha,aproveedor,C;
    
    aid=txt_id.getText();
    aclave=txt_cla.getText();
    aproducto=txt_producto.getText();
    aexistencia=txt_existencia.getText();
    aunidades= txtuni.getText();
    aubicacion=txt_ubicacion.getText();
    aprecio=txt_precio.getText();
    apreciot=txt_precioto.getText();
    ahora=lhora.getText();
    afecha=lfecha.getText();
    aproveedor=txt_proveedor.getText();
    C= TXT_CANTIDAD.getText();
            
    String sql,DOLAR=txt_predo.getText();
    
    sql = "INSERT INTO actualizacion (ID, CLAVE, PRODUCTO, EXISTENCIA, UNIDADES, UBICACION, PRECIO, PRECIO_USD, PRECIOT, FECHA, HORA,PROVEEDOR) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
    
         try {
             PreparedStatement pst = cc.prepareStatement(sql);
             pst.setString(1, aid);
             pst.setString(2, aclave);
             pst.setString(3, aproducto);
             pst.setString(4, C);
             pst.setString(5, aunidades);
             pst.setString(6, aubicacion);
             pst.setString(7, aprecio);
             pst.setString(8, DOLAR);
             pst.setString(9, apreciot);
             pst.setString(10, ahora);
             pst.setString(11, afecha);
             pst.setString(12, aproveedor);
             
             if(aid.isEmpty() || aclave.isEmpty() || aproducto.isEmpty() || aexistencia.isEmpty() || aunidades.isEmpty() || aubicacion.isEmpty() || aprecio.isEmpty() || apreciot.isEmpty()){
                 JOptionPane.showMessageDialog(null, "ERROR EN LA OPERACION", "ERROR", JOptionPane.ERROR_MESSAGE);
             }else{
                 int n = pst.executeUpdate();
             }
         } catch (SQLException ex) {
             Logger.getLogger(entrada_salida.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    
 }
 
 void actualizacion (String valor){
        String titulos [] = {"ID","CLAVE","PRODUCTO","EXISTENCIA","UNIDADES","UBICACION","PRECIO","PRECIO USD","PRECIO TOTAL","HORA","FECHA","PROVEEDOR"};
        String [] registros = new String [12];
        String sql = "SELECT * FROM inventario where CONCAT (CLAVE, ' ',PRODUCTO   ) LIKE '%"+valor+"%'";
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
            tabla_act.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(PRODUCTOS2.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_act = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnaumentar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TXT_CANTIDAD = new javax.swing.JTextField();
        btndescontar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_existencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_ubicacion = new javax.swing.JTextField();
        txt_producto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_cla = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_precioto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        aux = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        LCOSTOT = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lhora = new javax.swing.JLabel();
        lfecha = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtuni = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaA = new javax.swing.JTable();
        txt_proveedor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtdolar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txt_predo = new javax.swing.JTextField();

        tabla_act.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla_act);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONTROL DE INVENTARIO");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnaumentar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnaumentar.setText("ALTA");
        btnaumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaumentarActionPerformed(evt);
            }
        });
        jPanel1.add(btnaumentar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 160, 110, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("< Back ");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 19));

        jLabel7.setText("CANTIDAD:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 230, -1, -1));
        jPanel1.add(TXT_CANTIDAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 230, 50, -1));

        btndescontar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btndescontar.setText("BAJA");
        btndescontar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndescontarActionPerformed(evt);
            }
        });
        jPanel1.add(btndescontar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 190, 110, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 670, 140));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("EXISTENCIA:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        txt_existencia.setEnabled(false);
        txt_existencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_existenciaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_existencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("UBICACION:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        txt_ubicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ubicacionActionPerformed(evt);
            }
        });
        jPanel1.add(txt_ubicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 150, -1));
        jPanel1.add(txt_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 150, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("PRODUCTO:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        txt_cla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_claActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cla, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 150, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("CLAVE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        txt_id.setBorder(null);
        txt_id.setEnabled(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 150, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("PRECIO USD:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));
        jPanel1.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("PRECIO TOTAL:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));
        jPanel1.add(txt_precioto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 140, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 40, 170, 10));

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("S E A R C H. . . .");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 20, 130, -1));

        aux.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        aux.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                auxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                auxKeyReleased(evt);
            }
        });
        jPanel1.add(aux, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 20, 130, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Search_32px.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, -1, -1));

        LCOSTOT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.add(LCOSTOT, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 260, 10));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("COSTO TOTAL:");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, -1));

        lhora.setText("00:00:00");
        jPanel1.add(lhora, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        lfecha.setText("DD/MM/YYYY");
        jPanel1.add(lfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("UNIDADES:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));
        jPanel1.add(txtuni, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 150, -1));

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
        tablaA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaA);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1310, 250));
        jPanel1.add(txt_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 150, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("PROVEEDOR:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        txtdolar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdolarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdolarKeyReleased(evt);
            }
        });
        jPanel1.add(txtdolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 80, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("VALOR DEL DOLAR:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("MNX");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("REPORTES / BAJA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 190, 140, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("REPORTES / ALTA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 160, 140, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("ID:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 220, 140, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("PRECIO:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        txt_predo.setEnabled(false);
        jPanel1.add(txt_predo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_claActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_claActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_claActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_ubicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ubicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ubicacionActionPerformed

    private void auxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_auxKeyPressed
        char car = evt.getKeyChar();
        jLabel8.setText("");
    }//GEN-LAST:event_auxKeyPressed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        PRODUCTOS2 PR = new PRODUCTOS2();
        PR.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void btnaumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaumentarActionPerformed

        
        
        float exis,canti,result,P,r,dol,dolt;
 exis=Float.parseFloat(txt_existencia.getText());
 canti=Float.parseFloat(TXT_CANTIDAD.getText());
 P=Float.parseFloat(txt_precio.getText());
 dol=Float.parseFloat(txtdolar.getText());
  result = (exis+canti);
  txt_existencia.setText(String.valueOf(result));
  r=result*P;
  dolt=r*dol;
  txt_predo.setText(String.valueOf(dolt));
  txt_precioto.setText(String.valueOf(r));
  
        
        
        
        
        clase cn = new clase();
 Connection cc = cn.Connetar();
 
 
 
 
 String c,p,e,u,i,C,H,F,pi,t,uni,po,dolar;
 c=txt_cla.getText();
 p=txt_producto.getText();
 e=txt_existencia.getText();
 u=txt_ubicacion.getText();
 i=txt_id.getText();
 C=TXT_CANTIDAD.getText();
 H=lhora.getText();
 F=lfecha.getText();
 pi=txt_precio.getText();
 t=txt_precioto.getText();
 uni=txtuni.getText();
 po=txt_proveedor.getText();
 dolar=txt_predo.getText();
 
 if(c.isEmpty()|| p.isEmpty()|| e.isEmpty()|| e.isEmpty()|| u.isEmpty()|| i.isEmpty() || pi.isEmpty() ){
     JOptionPane.showMessageDialog(null, "ERROR","ERROR EN LA OPERACION",JOptionPane.ERROR_MESSAGE);
 }else{
     String sql = "UPDATE inventario SET CLAVE=?, PRODUCTO=?, EXISTENCIA=?, UNIDADES=?,  UBICACION=?, PRECIO=?, PRECIO_USD=?, PRECIOT=?, FECHA=?, HORA=?, PROVEEDOR=?  WHERE ID=? ";
    try {
        PreparedStatement pst = cc.prepareStatement(sql);
        pst.setString(1, c);
        pst.setString(2, p);
        pst.setString(3, e);
        pst.setString(4, uni);
        pst.setString(5, u);
        pst.setString(6, pi);
        pst.setString(7, dolar);
        pst.setString(8, t);
         pst.setString(9, F);
        pst.setString(10, H);
        pst.setString(11, po);
        pst.setString(12, i);
      
        if(pst.executeUpdate()>0){
            insertar();
            mostrar("");
            
            costot();
            
            txt_id.setText("");
            txt_cla.setText("");
            txt_producto.setText("");
            txt_existencia.setText("");
            txt_ubicacion.setText("");
            TXT_CANTIDAD.setText("0");
            txtuni.setText("");
            txt_precio.setText("");
            txt_predo.setText("");
            txt_precioto.setText("");
            txt_proveedor.setText("");
            
        }else{
            JOptionPane.showMessageDialog(null, "DATOS NO ACTUALIZADOS", "INTENTE DE NUEVO", JOptionPane.ERROR_MESSAGE);
        }
        
        
      
    } catch (SQLException ex) {
        Logger.getLogger(entrada_salida.class.getName()).log(Level.SEVERE, null, ex);
       
    }
 }
 
 
    }//GEN-LAST:event_btnaumentarActionPerformed

    private void tablaAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAMouseClicked
       int fila = this.tablaA.getSelectedRow();
       this.txt_id.setText(tablaA.getValueAt(fila, 0).toString());
       this.txt_cla.setText(tablaA.getValueAt(fila, 1).toString());
       this.txt_producto.setText(tablaA.getValueAt(fila, 2).toString());
       this.txt_existencia.setText(tablaA.getValueAt(fila, 3).toString());
       this.txtuni.setText(tablaA.getValueAt(fila, 4).toString());
       this.txt_ubicacion.setText(tablaA.getValueAt(fila, 5).toString());
       this.txt_precio.setText(tablaA.getValueAt(fila, 6).toString());
       this.txt_predo.setText(tablaA.getValueAt(fila, 7).toString());
       this.txt_precioto.setText(tablaA.getValueAt(fila, 8).toString());
       this.txt_proveedor.setText(tablaA.getValueAt(fila, 11).toString());
       
       
    }//GEN-LAST:event_tablaAMouseClicked

    private void auxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_auxKeyReleased
mostrar(aux.getText());         // TODO add your handling code here:
    }//GEN-LAST:event_auxKeyReleased

    private void btndescontarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndescontarActionPerformed

        
        float exis,canti,result,P,r,dol,dola;
 exis=Float.parseFloat(txt_existencia.getText());
 canti=Float.parseFloat(TXT_CANTIDAD.getText());
 P=Float.parseFloat(txt_precio.getText());
 dol=Float.parseFloat(txtdolar.getText());
 
  result = (exis-canti);
  
  if(canti>exis){
      JOptionPane.showMessageDialog(null, "SE HA PRODUCIDO UN ERROR","INTENTE DE NUEVO",JOptionPane.ERROR_MESSAGE);
  }
  else{
      
  
  txt_existencia.setText(String.valueOf(result));
  r=result*P;
  dola=r*dol;
  txt_predo.setText(String.valueOf(dola));
  txt_precioto.setText(String.valueOf(r));
  
        
        
        
        
        clase cn = new clase();
 Connection cc = cn.Connetar();
 
 
 
 
 String c,p,e,u,i,C,H,F,pi,t,uni,PRO;
 c=txt_cla.getText();
 p=txt_producto.getText();
 e=txt_existencia.getText();
 u=txt_ubicacion.getText();
 i=txt_id.getText();
 C=TXT_CANTIDAD.getText();
 H=lhora.getText();
 F=lfecha.getText();
 pi=txt_precio.getText();
 t=txt_precioto.getText();
 uni=txtuni.getText();
 PRO=txt_proveedor.getText();
 String dolar= txt_predo.getText();
 
 if(c.isEmpty()|| p.isEmpty()|| e.isEmpty()|| e.isEmpty()|| u.isEmpty()|| i.isEmpty() || pi.isEmpty() ){
     JOptionPane.showMessageDialog(null, "ERROR","ERROR EN LA OPERACION",JOptionPane.ERROR_MESSAGE);
 }else{
     String sql = "UPDATE inventario SET CLAVE=?, PRODUCTO=?, EXISTENCIA=?, UNIDADES=?, UBICACION=?, PRECIO=?, PRECIO_USD=?, PRECIOT=?, FECHA=?, HORA=?, PROVEEDOR=?  WHERE id=?";
    try {
        PreparedStatement pst = cc.prepareStatement(sql);
        pst.setString(1, c);
        pst.setString(2, p);
        pst.setString(3, e);
        pst.setString(4, uni);
        pst.setString(5, u);
        pst.setString(6, pi);
         pst.setString(7, dolar);
        pst.setString(8, t);
         pst.setString(9, F);
        pst.setString(10, H);
        pst.setString(11, PRO);
        pst.setString(12, i);
       
        
        if(pst.executeUpdate()>0){
            mostrar("");
            insertar2();
            costot();
            
            txt_id.setText("");
            txt_cla.setText("");
            txt_producto.setText("");
            txt_existencia.setText("");
            txtuni.setText("");
            txt_ubicacion.setText("");
            TXT_CANTIDAD.setText("0");
            txt_precio.setText("");
            txt_predo.setText("");
            txt_precioto.setText("");
            txt_proveedor.setText("");
            
        }else{
            JOptionPane.showMessageDialog(null, "DATOS NO ACTUALIZADOS", "INTENTE DE NUEVO", JOptionPane.ERROR_MESSAGE);
        }
        
        
      
    } catch (SQLException ex) {
        Logger.getLogger(entrada_salida.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
 }
 
 
        // TODO add your handling code here:
    }//GEN-LAST:event_btndescontarActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
costot();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void txt_existenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_existenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_existenciaActionPerformed

    private void txtdolarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdolarKeyPressed
    
       
    }//GEN-LAST:event_txtdolarKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       altas al = new altas();
       al.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
bajas al = new bajas();
al.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtdolarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdolarKeyReleased
//LCOSTOT.setText("0");
//       int ta = tablaA.getRowCount();
//       int c =0;
//    
//      
//       do
//           try {
//              int f = c++;
//              float n1 = Float.parseFloat(tablaA.getValueAt(f, 6).toString());
//
//              String nu = LCOSTOT.getText();
//
//              double nu2;
//           nu2 = Double.parseDouble(nu);
//              float re = (float) (n1+nu2);
//              float reua,r2;
//              reua=Float.parseFloat(txtdolar.getText());
//              r2=re*reua;
//              
//             
//              LCOSTOT.setText(String.valueOf(re));
//              LCOSTOEU.setText(String.valueOf(r2));
//           } catch (Exception e) {
//               
//           }
//           
//           
//           while(c<ta);                // TODO add your handling code here:
    }//GEN-LAST:event_txtdolarKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  clase cn = new clase();
 Connection cc = cn.Connetar();
 int conf;
 conf=JOptionPane.showConfirmDialog(null, "¿ DESEA ELIMINAR ESTE PRODUCTO ?");
 if(conf==JOptionPane.OK_OPTION){
     String sql = "DELETE FROM inventario WHERE ID = ?";
     String id;
     id=txt_id.getText();
            try {
                PreparedStatement pst =  cc.prepareStatement(sql);
                
                pst.setString(1, id);
                
                if(pst.executeUpdate() > 0){
                    
                    mostrar("");
                }else{
                    JOptionPane.showMessageDialog(null, "PRODUCTO NO SELECCIONADO");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(entrada_salida.class.getName()).log(Level.SEVERE, null, ex);
            }
 }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
public static String fecha(){
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }
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
            java.util.logging.Logger.getLogger(entrada_salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(entrada_salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(entrada_salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(entrada_salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new entrada_salida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LCOSTOT;
    private javax.swing.JTextField TXT_CANTIDAD;
    private javax.swing.JTextField aux;
    private javax.swing.JButton btnaumentar;
    private javax.swing.JButton btndescontar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lfecha;
    private javax.swing.JLabel lhora;
    private javax.swing.JTable tablaA;
    private javax.swing.JTable tabla_act;
    private javax.swing.JTextField txt_cla;
    private javax.swing.JTextField txt_existencia;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_precioto;
    private javax.swing.JTextField txt_predo;
    private javax.swing.JTextField txt_producto;
    private javax.swing.JTextField txt_proveedor;
    private javax.swing.JTextField txt_ubicacion;
    private javax.swing.JTextField txtdolar;
    private javax.swing.JTextField txtuni;
    // End of variables declaration//GEN-END:variables

  
  
}
