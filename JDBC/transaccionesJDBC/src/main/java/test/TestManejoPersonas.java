package test;

import datos.*;
import domain.Persona;
import java.sql.*;
import java.util.List;


public class TestManejoPersonas {

    public static void main(String[] args) {
        
        
        
        
        
        
        Connection conexion = null;
        
        try {
           conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
             PersonaDAO personadao = new PersonaDAO(conexion);
             Persona personaCambio = new Persona(5);
             personaCambio.setNombre("nomMODIFICADOa");
             personaCambio.setApellido("apeMODIFICAD0aO");
             personaCambio.setEmail("emailMODIFICADOa");
             personaCambio.setTelefono("telMODIFICADOa");
             personadao.actualizar(personaCambio);
             
             
             Persona personaNueva = new Persona("ARL", "PAL", "al_pal@gmail.com", "554751");
             personadao.insertar(personaNueva);
             
             conexion.commit();
             System.out.println("se ha hecho commit de la trasaccion");
             
             
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("ENTRAMOS AL ROLLBACK");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
        
        
        

    }

}
