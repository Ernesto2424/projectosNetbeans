package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class PersonaDAO {

    private Connection conexionTransaccional;

    
    public PersonaDAO() {
    }

    public PersonaDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_SELECTID = "SELECT * FROM persona WHERE idpersona = ?";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idpersona = ?";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idpersona = ?";


    public Persona seleccionar(Persona persona) throws SQLException  {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Persona person = null;

        try {

            cn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            pst = cn.prepareStatement(SQL_SELECTID);
            pst.setInt(1, persona.getIdPersona());
            rs = pst.executeQuery();

            rs.next();
            int idPersona = rs.getInt("idPersona");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            person = new Persona(idPersona, nombre, apellido, email, telefono);

        }  finally {
            try {
                //cerrar en orden contrario a como se usaron
                close(rs);
                close(pst);
                if (this.conexionTransaccional == null) {
                    close(cn);
                }

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return person;

    }

    public List<Persona> seleccionar() throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {

            cn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            pst = cn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();

            while (rs.next()) {
                int idPersona = rs.getInt("idPersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);

            }

        } finally {
            try {
                //cerrar en orden contrario a como se usaron
                close(rs);
                close(pst);
                
                if(this.conexionTransaccional==null){
                      close(cn);    
                 }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return personas;
    }

    public int insertar(Persona persona) throws SQLException {
        int totalRegistros = 0;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            pst = cn.prepareStatement(SQL_INSERT);
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getEmail());
            pst.setString(4, persona.getTelefono());

            totalRegistros = pst.executeUpdate();
        } finally {
            try {
                close(pst);
                if(this.conexionTransaccional==null){
                      close(cn);    
                 }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return totalRegistros;
    }

       
    public int eliminar(Persona persona) throws SQLException {
        int eliminado = 0;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            pst = cn.prepareStatement(SQL_DELETE);
            pst.setInt(1, persona.getIdPersona());
            eliminado = pst.executeUpdate();

        } finally {
            try {
                close(pst);
                if(this.conexionTransaccional==null){
                      close(cn);    
                 }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return eliminado;
    }

    public int actualizar(Persona persona) {

        int actualizado = 0;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            pst = cn.prepareStatement(SQL_UPDATE);

            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getEmail());
            pst.setString(4, persona.getTelefono());
            pst.setInt(5, persona.getIdPersona());

            actualizado = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            try {
                close(pst);
               if(this.conexionTransaccional==null){
                      close(cn);    
                 }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        if (actualizado == 0) {
            System.out.println("no se encontro la persona con identificador: " + persona.getIdPersona());
        }
        System.out.print("total modificados: ");
        return actualizado;

    }

}
