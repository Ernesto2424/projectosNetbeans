package datos;


import static datos.Conexion.*;
import domain.*;
import java.sql.*;
import java.util.*;


public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_SELECT_ID = "SELECT * FROM usuario WHERE id_usuario = ?";
    private static final String SQL_INSERT = "INSERT INTO usuario (usuario, password) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

   
    public Usuario SELECT(Usuario usuario){
        
        Usuario usu = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            cn = getConnection();
            pst = cn.prepareStatement(SQL_SELECT_ID);
            pst.setInt(1, usuario.getIdUsuario());
            rs = pst.executeQuery();
            
            rs.next();
            
            int id = rs.getInt("id_usuario");
            String nombre = rs.getString("usuario");
            String pass = rs.getString("password");
            
            usu = new Usuario(id, nombre, pass);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally {
            try {
                close(rs);
                close(pst);
                close(cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return usu;
        
        
        
    }
    
    
    
    public List<Usuario> SELECT() {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> lista = new ArrayList<>();

        try {
            /*Primero se debe obteber la conexion
            despues preparamos el pst con la sentencia sql
            posteriormente mandamos al rs la ejecucion de la consulta del pst
             */

            cn = getConnection();
            pst = cn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();

            //comenzamos a iterar en la BD con ayuda del rs
            while (rs.next()) {
                /*se obtiene toda la info campo por campo de la tabla
             y se guarda en un objeto del tipo Usuario para
            posteriromente añadir uno por uno a un ArrayList*/

                int id = rs.getInt("id_usuario");
                String nombre = rs.getString("usuario");
                String pass = rs.getString("password");

                usuario = new Usuario(id, nombre, pass);

                lista.add(usuario);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(pst);
                close(cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return lista;

    }

    public int INSERT(Usuario usuario) {

        Connection cn = null;
        PreparedStatement pst = null;
        int registros = 0;

        try {
            /*Primero se debe obteber la conexion
            despues preparamos el pst con la sentencia sql*/

            cn = getConnection();
            pst = cn.prepareStatement(SQL_INSERT);

            /*ahora vamos a obtener los datos del usuario proporcionado
            y lo vamos a mandar a la sentencia sql */
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getPassword());

            /*posteriormente se ejecuta la sentencia pero con pst
            y ademas con ejecutar actualizacion NOTA: esto no es de sql
            es de que va a cambiar el estado de la BD*/
            registros = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(pst);
                close(cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;

    }

    public int UPDATE(Usuario usuario) {

        int registros = 0;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            // a partir de estos metodos el procedimiento es parecido
            cn = getConnection();
            pst = cn.prepareStatement(SQL_UPDATE);

            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getPassword());
            pst.setInt(3, usuario.getIdUsuario());

            registros = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(pst);
                close(cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }
    
    
    public int DELETE(Usuario usuario){
       
        int registros =0;
        Connection cn = null;
        PreparedStatement pst = null;
        
        try {
            cn = getConnection();
            pst = cn.prepareStatement(SQL_DELETE);
            
            pst.setInt(1, usuario.getIdUsuario());
            registros = pst.executeUpdate();
        } catch (SQLException ex) {
                 ex.printStackTrace(System.out);
        }finally {
            try {
                close(pst);
                close(cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
        
    }

}
