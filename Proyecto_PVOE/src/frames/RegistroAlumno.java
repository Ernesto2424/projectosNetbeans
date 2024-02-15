/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Clases.Infante;
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
public class RegistroAlumno extends javax.swing.JFrame {

    /**
     * Creates new form RegistroAlumno
     */
    public RegistroAlumno() {
        initComponents();
        agrupamiento();
        area_comidaEspecial.setVisible(false);
        lb_subtotal.setVisible(false);
        lb_total.setVisible(false);
        lb_nivel.setText("NIVEL:");
        this.setExtendedState(MAXIMIZED_BOTH);
        
    }
    
    public void toclean(){
        txt_nombreAlumno.setText("");    txt_nombreTutor.setText("");
        txt_paternoAlumno.setText("");   txt_paternoTutor.setText("");
        txt_maternoAlumno.setText("");   txt_maternoTutor.setText("");
        txt_edadAlumno.setText("");      txt_direccion.setText("");
        radio_masculino.setSelected(true); txt_numeroContacto.setText("");
        txt_numeroEmergencia.setText("");
        radio_matutino.setSelected(true);
        radio_a.setSelected(true);
        box_comidaEspecial.setSelected(false);
        area_comidaEspecial.setVisible(false);
        txt_nombreAlumno.requestFocus();
        
    }
    
    public boolean RevisaCampos(){
        boolean vacios = false;
        if(txt_nombreAlumno.getText().isEmpty()||txt_paternoAlumno.getText().isEmpty()||txt_maternoAlumno.getText().isEmpty()||txt_edadAlumno.getText().isEmpty()
         ||txt_nombreTutor.getText().isEmpty()||txt_maternoTutor.getText().isEmpty()|| txt_paternoTutor.getText().isEmpty()||txt_direccion.getText().isEmpty()
         ||txt_numeroContacto.getText().isEmpty()||txt_numeroEmergencia.getText().isEmpty()){
            vacios = true;
            JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS SON OBLIGATORIOS","ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
        return vacios;
    }
    
    public void agrupamiento(){
        radio_masculino.setSelected(true);
        grupo_genero.add(radio_masculino);
        grupo_genero.add(radio_femenino);
        radio_matutino.setSelected(true);
        grupo_turno.add(radio_matutino);
        grupo_turno.add(radio_vespertino);
        radio_a.setSelected(true);
        grupo_grupo.add(radio_a);
        grupo_grupo.add(radio_b);
    }
    
    public void RegistroInfante(){
        Infante infante = new Infante();
        infante.setNombreA(txt_nombreAlumno.getText());
        infante.setMaternoA(txt_maternoAlumno.getText());
        infante.setPaternoA(txt_paternoAlumno.getText());
        infante.setEdad(Integer.parseInt(txt_edadAlumno.getText()));
        if(radio_masculino.isSelected()){
        infante.setGenero(radio_masculino.getText());    
        }else{
         infante.setGenero(radio_femenino.getText());
        }
        infante.setNombreT(txt_nombreTutor.getText());
        infante.setPaternoT(txt_paternoTutor.getText());
        infante.setMaternoT(txt_maternoTutor.getText());
        infante.setDireccion(txt_direccion.getText());
        infante.setTelefono(txt_numeroContacto.getText());
        infante.setTelefonoE(txt_numeroEmergencia.getText());
        if(radio_matutino.isSelected()){
            infante.setTurno(radio_matutino.getText());
        }else{
            infante.setTurno(radio_vespertino.getText());
        }
        infante.setNivel(lb_nivel.getText());
        if(radio_a.isSelected()){
            infante.setGrupo(radio_a.getText());
        }else{
            infante.setGrupo(radio_b.getText());
        }
        if(box_comidaEspecial.isSelected()){
        infante.setDescripcion_comida(area_comidaEspecial.getText());    
        }else{
            infante.setDescripcion_comida("NULL");
        }
        infante.setPagar(Integer.parseInt(lb_total.getText()));
        String sql = "INSERT INTO alumno (id,estatus,nombreA,paternoA,maternoA,edad,genero,nombreT,paternoT,maternoT,direccion,tel,telE,turno,nivel,grupo,comidaEspecial,pagar) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setString(1, null);
            pst.setString(2, "ACTIVO");
            pst.setString(3, infante.getNombreA());
            pst.setString(4, infante.getPaternoA());
            pst.setString(5, infante.getMaternoA());
            pst.setInt(6, infante.getEdad());
            pst.setString(7, infante.getGenero());
            pst.setString(8, infante.getNombreT());
            pst.setString(9, infante.getPaternoT());
            pst.setString(10, infante.getMaternoT());
            pst.setString(11, infante.getDireccion());
            pst.setString(12, infante.getTelefono());
            pst.setString(13, infante.getTelefonoE());
            pst.setString(14, infante.getTurno());
            pst.setString(15, infante.getNivel());
            pst.setString(16, infante.getGrupo());
            pst.setString(17, infante.getDescripcion_comida());
            pst.setInt(18, infante.getPagar());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡REGISTRADO EN SISTEMA!", "REGISTRADO", JOptionPane.INFORMATION_MESSAGE);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegistroAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public Image getIconImage(){
     Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/mi_logo.png"));   
      return retValue;   
    }
    
    public int OpcionComidaEspecial(){
        int precio = 0;
        if(box_comidaEspecial.isSelected()){
            area_comidaEspecial.setVisible(true);
            area_comidaEspecial.setText("");
             precio = 100;
        }else{
            area_comidaEspecial.setVisible(false);
            area_comidaEspecial.setText("");
             precio = 0;
        }
        
        return precio;
        
        
    }
    
    private int cuotaEdad(){
        
        
        int subtotal =0;
        String edad = txt_edadAlumno.getText();
        
        if(!edad.isEmpty()){
        int Edad = Integer.parseInt(edad);
        
        if(Edad<0 || Edad>4){
            subtotal = 0;
            lb_nivel.setText("NIVEL:");
        }else if(Edad<1){
            subtotal = 500;
            lb_nivel.setText("LACTANTE");
            
        }else if(Edad<=2){
            subtotal = 600;
            lb_nivel.setText("MATERNAL");
            
        }else if(subtotal<=4){
            subtotal = 650;
            lb_nivel.setText("PREESCOLAR");
        }
        }
        
        
        return subtotal;
    }
    
    private void porPagar(){
        int subtotal = cuotaEdad();
        if(subtotal != 0){
        int costoComida = OpcionComidaEspecial();
        int total = subtotal + costoComida;
        lb_subtotal.setVisible(true);
        lb_subtotal.setText("SUBTOTAL: $ " + subtotal);
        lb_total.setVisible(true);
        lb_total.setText("" + total);
        }else{
            lb_subtotal.setVisible(false);
            lb_total.setVisible(false);
            box_comidaEspecial.setSelected(false);
            area_comidaEspecial.setVisible(false);
            //JOptionPane.showMessageDialog(null, "INGRESE UNA EDAD VALIDA!", "ERROR", JOptionPane.ERROR_MESSAGE);
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

        grupo_genero = new javax.swing.ButtonGroup();
        grupo_turno = new javax.swing.ButtonGroup();
        grupo_grupo = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_numeroContacto = new javax.swing.JTextField();
        txt_numeroEmergencia = new javax.swing.JTextField();
        radio_matutino = new javax.swing.JRadioButton();
        radio_vespertino = new javax.swing.JRadioButton();
        radio_a = new javax.swing.JRadioButton();
        radio_b = new javax.swing.JRadioButton();
        box_comidaEspecial = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_comidaEspecial = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        lb_nivel = new javax.swing.JLabel();
        lb_subtotal = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_nombreTutor = new javax.swing.JTextField();
        txt_paternoAlumno = new javax.swing.JTextField();
        txt_maternoAlumno = new javax.swing.JTextField();
        radio_femenino = new javax.swing.JRadioButton();
        radio_masculino = new javax.swing.JRadioButton();
        txt_edadAlumno = new javax.swing.JTextField();
        txt_paternoTutor = new javax.swing.JTextField();
        txt_maternoTutor = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        txt_nombreAlumno = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btn_registar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("NOMBRE DEL TUTOR:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("APELLIDO PATERNO:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("APELLIDO MATERNO:");

        txt_numeroContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numeroContactoActionPerformed(evt);
            }
        });

        radio_matutino.setText("MATUTINO");

        radio_vespertino.setText("VESPERTINO");

        radio_a.setText(" A");

        radio_b.setText(" B");

        box_comidaEspecial.setText("AÑADIR");
        box_comidaEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_comidaEspecialActionPerformed(evt);
            }
        });

        area_comidaEspecial.setColumns(20);
        area_comidaEspecial.setRows(5);
        jScrollPane1.setViewportView(area_comidaEspecial);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informacion-personal.png"))); // NOI18N
        jButton1.setToolTipText("Consulta Datos");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lb_nivel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_nivel.setForeground(new java.awt.Color(0, 0, 102));
        lb_nivel.setText("PREESCOLAR:  A");
        lb_nivel.setToolTipText("Mostrar precio a pagar");
        lb_nivel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_nivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_nivelMouseClicked(evt);
            }
        });

        lb_subtotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_subtotal.setForeground(new java.awt.Color(0, 0, 102));
        lb_subtotal.setText("SUBTOTAL:  $650");

        lb_total.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_total.setForeground(new java.awt.Color(0, 0, 102));
        lb_total.setText("TOTAL:  $750");
        lb_total.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital San Rafael - Agendar Cita");
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("ATIENDE:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("BIENVENIDO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("HORA:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setText("ALERGIA A ALGUNA MEDCINA:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setText("EDAD:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("APELLIDO PATERNO:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 0));
        jLabel12.setText("APELLIDO MATERNO:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 0, 0));
        jLabel14.setText("DIRECCION:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 110, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 0));
        jLabel15.setText("TELEFONO DE CONTACTO:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, -1));

        txt_nombreTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreTutorActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nombreTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 200, -1));

        txt_paternoAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_paternoAlumnoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_paternoAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 200, -1));

        txt_maternoAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maternoAlumnoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_maternoAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 200, -1));

        radio_femenino.setText("FEMENINO");
        radio_femenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_femeninoActionPerformed(evt);
            }
        });
        jPanel1.add(radio_femenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 90, -1));

        radio_masculino.setText("MASCULINO");
        radio_masculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_masculinoActionPerformed(evt);
            }
        });
        jPanel1.add(radio_masculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 100, -1));

        txt_edadAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_edadAlumnoKeyReleased(evt);
            }
        });
        jPanel1.add(txt_edadAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 200, -1));

        txt_paternoTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_paternoTutorActionPerformed(evt);
            }
        });
        jPanel1.add(txt_paternoTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 200, -1));

        txt_maternoTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maternoTutorActionPerformed(evt);
            }
        });
        jPanel1.add(txt_maternoTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 200, -1));

        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 200, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 0, 0));
        jLabel16.setText("ERNESTO FLORES MACHUCA");
        jLabel16.setToolTipText("PRESIONE PARA SALIR");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 170, 370, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 153, 153));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 20, 530));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 0, 0));
        jLabel17.setText("DATOS DEL PACIENTE:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 1300, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 0, 0));
        jLabel18.setText("GENERO:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 60, -1));

        txt_nombreAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreAlumnoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nombreAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 200, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 0, 0));
        jLabel20.setText("NOMBRE:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 0, 0));
        jLabel21.setText("FECHA:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 250, 50, -1));

        btn_registar.setBackground(new java.awt.Color(153, 0, 0));
        btn_registar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_registar.setForeground(new java.awt.Color(255, 255, 255));
        btn_registar.setText("AGENDAR");
        btn_registar.setBorder(null);
        btn_registar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_registar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_registar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 420, 240, 40));

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/punta-de-flecha-izquierda-en-un-circulo.png"))); // NOI18N
        jLabel22.setToolTipText("Atras");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 30, 30));

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setFont(new java.awt.Font("MS UI Gothic", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("AGENDAR CITA");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 70));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 370, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 0, 0));
        jLabel23.setText("PRECIO:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 350, 50, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 0, 0));
        jLabel24.setText("DOCTOR:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 200, 60, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 0));
        jLabel10.setText("TELEFONO DE CASO DE EMERGENCIA:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOMBRE" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 200, 210, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD / MM / AAAA" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 250, 210, -1));

        jComboBox3.setForeground(new java.awt.Color(153, 0, 0));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00 : 00" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 300, 210, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 350, 210, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1400, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        Login lg = new Login();
        lg.setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "SESIÓN FINALIZADA!", "EXIT", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Consulta ct = new Consulta();
        ct.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void box_comidaEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_comidaEspecialActionPerformed
        // TODO add your handling code here:
        OpcionComidaEspecial();
        porPagar();
    }//GEN-LAST:event_box_comidaEspecialActionPerformed

    private void btn_registarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registarActionPerformed
        // TODO add your handling code here:
        if(RevisaCampos()==false){
            RegistroInfante();
            toclean();
        }
        
    }//GEN-LAST:event_btn_registarActionPerformed

    private void lb_nivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_nivelMouseClicked
        // TODO add your handling code here:
        porPagar();
    }//GEN-LAST:event_lb_nivelMouseClicked

    private void txt_edadAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_edadAlumnoKeyReleased
        // TODO add your handling code here:
        porPagar();
        
    }//GEN-LAST:event_txt_edadAlumnoKeyReleased

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        Menu mn = new Menu();
        mn.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void txt_nombreAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreAlumnoActionPerformed
        // TODO add your handling code here:
        txt_paternoAlumno.requestFocus();
    }//GEN-LAST:event_txt_nombreAlumnoActionPerformed

    private void txt_paternoAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_paternoAlumnoActionPerformed
        // TODO add your handling code here:
        txt_maternoAlumno.requestFocus();
    }//GEN-LAST:event_txt_paternoAlumnoActionPerformed

    private void txt_maternoAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maternoAlumnoActionPerformed
        // TODO add your handling code here:
        txt_edadAlumno.requestFocus();
    }//GEN-LAST:event_txt_maternoAlumnoActionPerformed

    private void radio_masculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_masculinoActionPerformed
        // TODO add your handling code here:
        txt_nombreTutor.requestFocus();
    }//GEN-LAST:event_radio_masculinoActionPerformed

    private void radio_femeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_femeninoActionPerformed
        // TODO add your handling code here:
        txt_nombreTutor.requestFocus();
    }//GEN-LAST:event_radio_femeninoActionPerformed

    private void txt_nombreTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreTutorActionPerformed
        // TODO add your handling code here:
        txt_paternoTutor.requestFocus();
    }//GEN-LAST:event_txt_nombreTutorActionPerformed

    private void txt_paternoTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_paternoTutorActionPerformed
        // TODO add your handling code here:
        txt_maternoTutor.requestFocus();
    }//GEN-LAST:event_txt_paternoTutorActionPerformed

    private void txt_maternoTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maternoTutorActionPerformed
        // TODO add your handling code here:
        txt_direccion.requestFocus();
    }//GEN-LAST:event_txt_maternoTutorActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
        txt_numeroContacto.requestFocus();
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void txt_numeroContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numeroContactoActionPerformed
        // TODO add your handling code here:
        txt_numeroEmergencia.requestFocus();
    }//GEN-LAST:event_txt_numeroContactoActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_comidaEspecial;
    private javax.swing.JCheckBox box_comidaEspecial;
    private javax.swing.JButton btn_registar;
    private javax.swing.ButtonGroup grupo_genero;
    private javax.swing.ButtonGroup grupo_grupo;
    private javax.swing.ButtonGroup grupo_turno;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lb_nivel;
    private javax.swing.JLabel lb_subtotal;
    private javax.swing.JLabel lb_total;
    private javax.swing.JRadioButton radio_a;
    private javax.swing.JRadioButton radio_b;
    private javax.swing.JRadioButton radio_femenino;
    private javax.swing.JRadioButton radio_masculino;
    private javax.swing.JRadioButton radio_matutino;
    private javax.swing.JRadioButton radio_vespertino;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_edadAlumno;
    private javax.swing.JTextField txt_maternoAlumno;
    private javax.swing.JTextField txt_maternoTutor;
    private javax.swing.JTextField txt_nombreAlumno;
    private javax.swing.JTextField txt_nombreTutor;
    private javax.swing.JTextField txt_numeroContacto;
    private javax.swing.JTextField txt_numeroEmergencia;
    private javax.swing.JTextField txt_paternoAlumno;
    private javax.swing.JTextField txt_paternoTutor;
    // End of variables declaration//GEN-END:variables
BaseDeDatos bd = new BaseDeDatos();
Connection cc = bd.Connectar();
}
