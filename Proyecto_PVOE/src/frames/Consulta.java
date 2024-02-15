/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Clases.Infante;
import Clases.Operacion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import operaciones.BaseDeDatos;

/**
 *
 * @author Personal
 */
public class Consulta extends javax.swing.JFrame {
    

    /**
     * Creates new form Consulta
     */
    public Consulta() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        area_especial.setVisible(false);
        mostrar();
        
        
        
    }
    public void clean(){
        txt_nombreAlumno.setText("");
        txt_maternoA.setText("");
        txt_paternoAlumno.setText("");
        txt_nombreTutor.setText("");
        txt_paternoTutor.setText("");
        txt_maternoTutor.setText("");
        txt_edad.setText("");
        txt_direccion.setText("");
        txt_telefono.setText("");
        txt_telefonoE.setText("");
        lb_nivel.setText("");
        lb_subtotal.setText("");
        lb_total.setText("");
        radio_A.setSelected(false);
        radio_B.setSelected(false);
        radio_matutino.setSelected(false);
        radio_vespertino.setSelected(false);
        box_especial.setSelected(false);
        area_especial.setText("");
        area_especial.setVisible(false);
    }
    public boolean validaCampo(){
        boolean vacios;
        if(txt_nombreAlumno.getText().isEmpty()||txt_paternoAlumno.getText().isEmpty()||txt_maternoA.getText().isEmpty()||txt_nombreTutor.getText().isEmpty()
           ||txt_paternoTutor.getText().isEmpty()||txt_edad.getText().isEmpty()||txt_direccion.getText().isEmpty()||txt_telefonoE.getText().isEmpty()){
            vacios = true;
        }else{
            vacios=false;
            
        }
        return vacios;
    }
    private int cuotaEdad(){
    
        int subtotal =0;
        String edad = txt_edad.getText();
        
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
    
    
    
    public Image getIconImage(){
     Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/mi_logo.png"));   
      return retValue;   
    }
    
    public void mostrar(){
        Operacion op = new Operacion();
        op.getDatos("", tabla_datos);
    }
    
    public void getDatoTabla(){
        int fila = tabla_datos.getSelectedRow();
        String id = tabla_datos.getValueAt(fila, 0).toString();
        lb_id.setText(id);
        String estatus = tabla_datos.getValueAt(fila, 1).toString();
        lb_estatus.setText(estatus);
        String nameA = tabla_datos.getValueAt(fila, 2).toString();
        txt_nombreAlumno.setText(nameA);
        String paternoA = tabla_datos.getValueAt(fila, 3).toString();
        txt_paternoAlumno.setText(paternoA);
        String maternoA = tabla_datos.getValueAt(fila, 4).toString();
        txt_maternoA.setText(maternoA);
        String edad = tabla_datos.getValueAt(fila, 5).toString();
        txt_edad.setText(edad);
        String genero = tabla_datos.getValueAt(fila, 6).toString();
        lb_genero.setText(genero);
        String nameT = tabla_datos.getValueAt(fila, 7).toString();
        txt_nombreTutor.setText(nameT);
        String paternoT = tabla_datos.getValueAt(fila, 8).toString();
        txt_paternoTutor.setText(paternoT);
        String maternoT = tabla_datos.getValueAt(fila, 9).toString();
        txt_maternoTutor.setText(maternoT);
        String direccion = tabla_datos.getValueAt(fila, 10).toString();
        txt_direccion.setText(direccion);
        String tel = tabla_datos.getValueAt(fila, 11).toString();
        txt_telefono.setText(tel);
        String telE = tabla_datos.getValueAt(fila, 12).toString();
        txt_telefonoE.setText(telE);
        String turno = tabla_datos.getValueAt(fila, 13).toString();
        String nivel = tabla_datos.getValueAt(fila, 14).toString();
        String grupo = tabla_datos.getValueAt(fila, 15).toString();
        String pagar = tabla_datos.getValueAt(fila, 17).toString();
        
        if(grupo.equals(radio_A.getText())){
            radio_A.setSelected(true);
            radio_B.setSelected(false);
        }else{
            radio_B.setSelected(true);
            radio_A.setSelected(false);
        }
        
        
        if(turno.equals("MATUTINO")){
           radio_matutino.setSelected(true);
           radio_vespertino.setSelected(false);
           
        }else{
            radio_vespertino.setSelected(true);
            radio_matutino.setSelected(false);
            
        }
        String comida = tabla_datos.getValueAt(fila, 16).toString();
        int subtotal = cuotaEdad();
        if(comida.equals("NULL")){
            box_especial.setSelected(false);
            area_especial.setVisible(false);
            area_especial.setText("");
            lb_subtotal.setText(""+subtotal);
            lb_total.setText(""+subtotal);
        }else{
            box_especial.setSelected(true);
            area_especial.setVisible(true);
            area_especial.setText(comida);
            lb_subtotal.setText(""+subtotal);
            lb_total.setText(""+(subtotal+100));
            
        }
       // lb_total.setText(pagar);

    }
    
    public void ActualizaElimina(String estado){
        Infante infante = new Infante();
        infante.setNombreA(txt_nombreAlumno.getText());
        infante.setPaternoA(txt_paternoAlumno.getText());
        infante.setMaternoA(txt_maternoA.getText());
        infante.setEdad(Integer.parseInt(txt_edad.getText()));
        infante.setNombreT(txt_nombreTutor.getText());
        infante.setPaternoT(txt_paternoTutor.getText());
        infante.setMaternoT(txt_maternoTutor.getText());
        infante.setDireccion(txt_direccion.getText());
        infante.setTelefono(txt_telefono.getText());
        infante.setTelefonoE(txt_telefonoE.getText());
        infante.setNivel(lb_nivel.getText());
        infante.setPagar(Integer.parseInt(lb_total.getText()));
        if(radio_A.isSelected()){
            infante.setGrupo(radio_A.getText());
            
        }else{
            infante.setGrupo(radio_B.getText());
        }
        if(radio_matutino.isSelected()){
            infante.setTurno(radio_matutino.getText());
        }else{
            infante.setTurno(radio_vespertino.getText());
        }
        if(box_especial.isSelected()){
            infante.setDescripcion_comida(area_especial.getText());
        }else{
            infante.setDescripcion_comida("NULL");
        }
        infante.setGenero(lb_genero.getText());
        infante.setEstatus(estado);
        
        
            BaseDeDatos bd = new BaseDeDatos();
            Connection cc = bd.Connectar();
            
            String sql = "UPDATE alumno SET estatus=?, nombreA=?, paternoA=?, maternoA=?, edad=?, genero=?, nombreT=?, paternoT=?, maternoT=?, direccion=?, tel=?, telE=?, turno=?, nivel=?, grupo=?, comidaEspecial=?, pagar=? WHERE id=?";
           
            try {
                PreparedStatement pst = cc.prepareStatement(sql);
               
                pst.setString(1, infante.getEstatus());
                pst.setString(2, infante.getNombreA());
                pst.setString(3, infante.getPaternoA());
                pst.setString(4, infante.getMaternoA());
                pst.setInt(5, infante.getEdad());
                pst.setString(6, infante.getGenero());
                pst.setString(7, infante.getNombreT());
                pst.setString(8, infante.getPaternoT());
                pst.setString(9, infante.getMaternoT());
                pst.setString(10, infante.getDireccion());
                pst.setString(11, infante.getTelefono());
                pst.setString(12, infante.getTelefonoE());
                pst.setString(13, infante.getTurno());
                pst.setString(14, infante.getNivel());
                pst.setString(15, infante.getGrupo());
                pst.setString(16, infante.getDescripcion_comida());
                pst.setInt(17, infante.getPagar());
                pst.setString(18, lb_id.getText());
                
                if(pst.executeUpdate()>0){
                    mostrar();
                    JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE","ACTUALIZADO",JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR EN LA OPERACION","ERROR", JOptionPane.ERROR_MESSAGE);
                }
                
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
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

        grupo_grupo = new javax.swing.ButtonGroup();
        grupo_turno = new javax.swing.ButtonGroup();
        txt_edad = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lbto = new javax.swing.JLabel();
        radio_matutino = new javax.swing.JRadioButton();
        radio_vespertino = new javax.swing.JRadioButton();
        radio_A = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        radio_B = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lb_busqueda = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lb_subtotal = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_datos = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txt_direccion = new javax.swing.JTextField();
        txt_nombreAlumno = new javax.swing.JTextField();
        txt_paternoAlumno = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        txt_maternoA = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        txt_nombreTutor = new javax.swing.JTextField();
        txt_paternoTutor = new javax.swing.JTextField();
        lb_nivel = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        box_especial = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        area_especial = new javax.swing.JTextArea();
        btn_eliminar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txt_maternoTutor = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        txt_telefonoE = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        lb_estatus = new javax.swing.JLabel();
        lb_genero = new javax.swing.JLabel();

        txt_edad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_edad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt_edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_edadKeyReleased(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 102));
        jLabel38.setText("NIVEL:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 102));
        jLabel40.setText("SUBTOTAL: $");

        lbto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbto.setForeground(new java.awt.Color(0, 0, 102));
        lbto.setText("TOTAL: $");

        radio_matutino.setText("MATUTINO");
        radio_matutino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_matutinoActionPerformed(evt);
            }
        });

        radio_vespertino.setText("VESPERTINO");
        radio_vespertino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_vespertinoActionPerformed(evt);
            }
        });

        radio_A.setText(" A");
        radio_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_AActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 102));
        jLabel20.setText("GRUPO:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 102));
        jLabel33.setText("TURNO:");

        radio_B.setText(" B");
        radio_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_BActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital San Rafael - Consulta");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(1380, 710));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setForeground(new java.awt.Color(153, 0, 0));
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
        jLabel2.setText("CONSULTA Y ACTUALIZACIÓN DE DATOS");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 70));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 0, 0));
        jLabel21.setText("ERNESTO FLORES MACHUCA");
        jLabel21.setToolTipText("PRESIONE PARA SALIR");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 0, 0));
        jLabel23.setText("APELLIDO PATERNO:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, -1));

        lb_busqueda.setBackground(new java.awt.Color(153, 153, 153));
        lb_busqueda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_busqueda.setForeground(new java.awt.Color(153, 153, 153));
        lb_busqueda.setText("Nombre . . . .");
        lb_busqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(lb_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 90, 120, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 0, 0));
        jLabel25.setText("APELLIDO PATERNO:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, -1, -1));

        lb_subtotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(lb_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 70, 10));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 0, 0));
        jLabel27.setText("APELLIDO MATERNO:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, -1));

        tabla_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_datos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1330, 270));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 0, 0));
        jLabel28.setText("NOMBRE DEL PACIENTE:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 0, 0));
        jLabel29.setText("BIENVENIDO:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconoBusqueda.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 90, 30, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(153, 0, 0));
        jLabel30.setText("ALERGIA A ALGUNA MEDICINA");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, -1, -1));

        txt_busqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_busquedaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 100, 130, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 120, 120, 10));

        txt_direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_direccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 140, -1));

        txt_nombreAlumno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nombreAlumno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_nombreAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 140, -1));

        txt_paternoAlumno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_paternoAlumno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_paternoAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 140, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 580, 140, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 140, 10));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 140, 10));

        txt_maternoA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_maternoA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_maternoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 140, -1));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 140, 10));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 50, 10));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 140, 10));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 140, 10));

        txt_nombreTutor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nombreTutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_nombreTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 140, -1));

        txt_paternoTutor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_paternoTutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_paternoTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 480, 140, -1));

        lb_nivel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(lb_nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, 90, 10));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 0, 0));
        jLabel31.setText("NOMBRE DEL DOCTOR:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        box_especial.setText("AÑADIR");
        box_especial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_especialActionPerformed(evt);
            }
        });
        jPanel1.add(box_especial, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 450, 90, -1));

        area_especial.setColumns(20);
        area_especial.setRows(5);
        jScrollPane2.setViewportView(area_especial);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, 260, 110));

        btn_eliminar.setBackground(new java.awt.Color(153, 0, 0));
        btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_eliminar.setText("REPORTE CLINICO");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 530, 180, 40));

        btn_actualizar.setBackground(new java.awt.Color(153, 0, 0));
        btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.setBorder(new javax.swing.border.MatteBorder(null));
        btn_actualizar.setBorderPainted(false);
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 453, 180, 40));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(153, 0, 0));
        jLabel32.setText("APELLIDO MATERNO:");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, -1, -1));

        txt_maternoTutor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_maternoTutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_maternoTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, 140, -1));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, 140, 10));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(153, 0, 0));
        jLabel34.setText("TELEFONO:");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 650, -1, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_telefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 140, -1));
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 620, 140, 10));

        txt_telefonoE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_telefonoE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_telefonoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 640, 140, -1));
        jPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 660, 140, 10));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(153, 0, 0));
        jLabel37.setText("EDAD:");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 570, -1, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(153, 0, 0));
        jLabel39.setText("DIRECCIÓN:");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 610, -1, -1));

        lb_total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(lb_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 520, 70, 10));

        lb_id.setForeground(new java.awt.Color(255, 255, 255));
        lb_id.setText("ID:");
        jPanel1.add(lb_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 10, 10));

        lb_estatus.setForeground(new java.awt.Color(255, 255, 255));
        lb_estatus.setText("ESTATUS:");
        jPanel1.add(lb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 10, 10));

        lb_genero.setForeground(new java.awt.Color(255, 255, 255));
        lb_genero.setText("GENERO:");
        jPanel1.add(lb_genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 10, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1400, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        
        RegistroAlumno ra = new RegistroAlumno();
        ra.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        
        Login lg = new Login();
        lg.setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "SESIÓN FINALIZADA!", "EXIT", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void txt_busquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txt_busquedaKeyPressed

    private void txt_busquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_busquedaKeyTyped

    private void txt_busquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyReleased
        // TODO add your handling code here:
        if(txt_busqueda.getText().isEmpty()){
        lb_busqueda.setText("Nombre ó Nivel . . . .");  
        mostrar();
        }else{
            lb_busqueda.setText("");
            Operacion op = new Operacion();
            op.getDatos(txt_busqueda.getText(), tabla_datos);
        }
    }//GEN-LAST:event_txt_busquedaKeyReleased

    private void box_especialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_especialActionPerformed
        // TODO add your handling code here:
        int subtotal = cuotaEdad();
        if(box_especial.isSelected()){
            area_especial.setText("");
            area_especial.setVisible(true);    
            lb_total.setText(""+(subtotal+100));
        }else{
            area_especial.setText("");
            area_especial.setVisible(false);
            lb_total.setText(""+subtotal);
        }
    }//GEN-LAST:event_box_especialActionPerformed

    private void tabla_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_datosMouseClicked
        // TODO add your handling code here:
        getDatoTabla();
    }//GEN-LAST:event_tabla_datosMouseClicked

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
        if(validaCampo()==false){
        ActualizaElimina(lb_estatus.getText());
        clean();    
        }else{
            JOptionPane.showMessageDialog(null, "VERIFIQUE QUE LA INFORMACIÓN ESTE COMPLETA","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        if(validaCampo()==false){
        int res = JOptionPane.showConfirmDialog(null, "¿DESEA INACTIVAR AL ALUMNO?");
        if(res==JOptionPane.OK_OPTION){
        ActualizaElimina("INACTIVO");
        clean();    
        }
            
        }else{
            JOptionPane.showMessageDialog(null, "COMPLETE LA INFORMACION O SELECCIONE UN OBJETO","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void radio_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_AActionPerformed
        // TODO add your handling code here:
        radio_B.setSelected(false);
    }//GEN-LAST:event_radio_AActionPerformed

    private void radio_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_BActionPerformed
        // TODO add your handling code here:
        radio_A.setSelected(false);
    }//GEN-LAST:event_radio_BActionPerformed

    private void radio_matutinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_matutinoActionPerformed
        // TODO add your handling code here:
        radio_vespertino.setSelected(false);
    }//GEN-LAST:event_radio_matutinoActionPerformed

    private void radio_vespertinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_vespertinoActionPerformed
        // TODO add your handling code here:
        radio_matutino.setSelected(false);
    }//GEN-LAST:event_radio_vespertinoActionPerformed

    private void txt_edadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_edadKeyReleased
        // TODO add your handling code here:
        int sub = cuotaEdad();
        if(box_especial.isSelected()){
            lb_total.setText(""+(sub+100));
        }else{
            lb_total.setText(""+sub);
        }
        lb_subtotal.setText(""+sub);
    }//GEN-LAST:event_txt_edadKeyReleased

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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_especial;
    private javax.swing.JCheckBox box_especial;
    volatile javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.ButtonGroup grupo_grupo;
    private javax.swing.ButtonGroup grupo_turno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lb_busqueda;
    private javax.swing.JLabel lb_estatus;
    private javax.swing.JLabel lb_genero;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_nivel;
    private javax.swing.JLabel lb_subtotal;
    private javax.swing.JLabel lb_total;
    private javax.swing.JLabel lbto;
    private javax.swing.JRadioButton radio_A;
    private javax.swing.JRadioButton radio_B;
    private javax.swing.JRadioButton radio_matutino;
    private javax.swing.JRadioButton radio_vespertino;
    private javax.swing.JTable tabla_datos;
    volatile javax.swing.JTextField txt_busqueda;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_maternoA;
    private javax.swing.JTextField txt_maternoTutor;
    private javax.swing.JTextField txt_nombreAlumno;
    private javax.swing.JTextField txt_nombreTutor;
    private javax.swing.JTextField txt_paternoAlumno;
    private javax.swing.JTextField txt_paternoTutor;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_telefonoE;
    // End of variables declaration//GEN-END:variables
}
