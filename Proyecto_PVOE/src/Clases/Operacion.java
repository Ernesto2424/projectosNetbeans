
package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import operaciones.BaseDeDatos;


public class Operacion {
    
    public void getDatos(String valor, JTable tabla){
        String titulos [] = {"id","ESTATUS","NOMBRE","APELLIDO PATERNO", "APELLIDO MATERNO","EDAD","GENERO","TUTOR","APELLID PATERNO", "APELLIDO MATERNO"
                             ,"DIRECCION","TELEFONO 1","TELEFONO EMERGENCIA","TURNO","NIVEL","GRUPO","COMIDA ESPECIAL","POR PAGAR" };
        String registros [] = new String[18];
        String sql = "SELECT * FROM alumno WHERE CONCAT (nivel, ' ',nombreA) LIKE '%"+valor+"%'";
        DefaultTableModel model = new DefaultTableModel(null,titulos);
        BaseDeDatos bd = new BaseDeDatos();
        Connection cc = bd.Connectar();
        
        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("estatus");
                registros[2] = rs.getString("nombreA");
                registros[3] = rs.getString("paternoA");
                registros[4] = rs.getString("maternoA");
                registros[5] = rs.getString("edad");
                registros[6] = rs.getString("genero");
                registros[7] = rs.getString("nombreT");
                registros[8] = rs.getString("paternoT");
                registros[9] = rs.getString("maternoT");
                registros[10] = rs.getString("direccion");
                registros[11] = rs.getString("tel");
                registros[12] = rs.getString("telE");
                registros[13] = rs.getString("turno");
                registros[14] = rs.getString("nivel");
                registros[15] = rs.getString("grupo");
                registros[16] = rs.getString("comidaEspecial");
                registros[17] = rs.getString("pagar");
                model.addRow(registros);
                
                
            }
            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getDatosUsuario(String valor, JTable tabla){
        String titulos [] = {"id","ESTATUS","NOMBRE","APELLIDO PATERNO", "APELLIDO MATERNO","EDAD","GENERO","TUTOR","APELLID PATERNO", "APELLIDO MATERNO"
                             ,"DIRECCION","TELEFONO 1","TELEFONO EMERGENCIA","TURNO","NIVEL","GRUPO","COMIDA ESPECIAL","POR PAGAR" };
        String registros [] = new String[18];
        String sql = "SELECT * FROM alumno WHERE CONCAT (nombreT, ' ',paternoT) LIKE '%"+valor+"%'";
        DefaultTableModel model = new DefaultTableModel(null,titulos);
        BaseDeDatos bd = new BaseDeDatos();
        Connection cc = bd.Connectar();
        
        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("estatus");
                registros[2] = rs.getString("nombreA");
                registros[3] = rs.getString("paternoA");
                registros[4] = rs.getString("maternoA");
                registros[5] = rs.getString("edad");
                registros[6] = rs.getString("genero");
                registros[7] = rs.getString("nombreT");
                registros[8] = rs.getString("paternoT");
                registros[9] = rs.getString("maternoT");
                registros[10] = rs.getString("direccion");
                registros[11] = rs.getString("tel");
                registros[12] = rs.getString("telE");
                registros[13] = rs.getString("turno");
                registros[14] = rs.getString("nivel");
                registros[15] = rs.getString("grupo");
                registros[16] = rs.getString("comidaEspecial");
                registros[17] = rs.getString("pagar");
                model.addRow(registros);
                
                
            }
            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
}
