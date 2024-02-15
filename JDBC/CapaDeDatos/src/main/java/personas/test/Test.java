package personas.test;

import java.sql.*;
import java.util.List;
import personas.jdbc.*;
import personas.dto.*;
;

public class Test {

    public static void main(String[] args) {
         
        Connection conexion = null;
        
        try {
           conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
             PersonaDAO personadao = new PersonaDaoJDBC(conexion);
             
             List<Persona> lista =personadao.select();
             
             for(Persona personas: lista){
                 System.out.println("personasDTO = " + personas);
             }
             
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
