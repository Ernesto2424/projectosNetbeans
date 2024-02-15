package datos;

import dominio.EntradaSalida;
import dominio.Producto;
import interfaces.OperacionesDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase cuenta con los metodos necesarios para
 * la obtención asi como la insercción de información
 * referente a las salidas que se registran.
 * 
 * @author Ernesto F.
 */
public class EntradaDao implements OperacionesDatos<Object>{
    
    /**
     * metodo constructor por defecto
     */
    public EntradaDao(){}
    
    /**
     * Variables estaticas constantes que hacen referencia
     * a cada una de las consultas SQL.
     */

    private static final String SQL_INSERT = "INSERT INTO entrada(fecha, cantidad, codigo_producto) VALUES(?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM entrada";

    /**
     * 
     * Este metodo tiene como objetivo imsertar una nueva
     * Entrada a la base de datos.
     * 
     * @param objeto Reibe un objeto del tipo
     * EntradaSalida pero que tiene la funcion de una 
     * salida del inventario de productos.
     * 
     * 
     * @return si el valor del entero es 0, quiere decir que no se inserto
     * el objeto a la base de datos, si el valor es 1, significa lo contrario.
     */
    
    @Override
    public Object INSERT(Object objeto) {
         Connection cn = null;
        PreparedStatement pst = null;
        int rows = 0;
        EntradaSalida es = null;
        es = (EntradaSalida) objeto;
        
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_INSERT);
        
            pst.setString(1, es.getFecha());
            pst.setInt(2, es.getCantidad());
            pst.setInt(3, es.getProducto().getCodigo());
            rows = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(pst);
            Conexion.close(cn);
        }
        
        return rows;
    }

    
    /**
     * Este metodo tiene como objetivo el recuperar de 
     * la base de datos todos los registros del tipo Entrada.
     * 
     * @return Lista de objetos del tipo EntradaSalida pero que tienen
     * la función de una Entrada del inventario de productos.
     */
    @Override
    public List<Object> SELECT() {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        EntradaSalida entrada = null;
        List<Object> entradas = new ArrayList<Object>();
        OperacionesDatos op = new ProductoDao();
        Producto producto = null;
        
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String fecha = rs.getString("fecha");
                int cantidad = rs.getInt("cantidad");
                int idProducto = rs.getInt("codigo_producto");
                producto = (Producto) op.SELECT_BY_ID(idProducto);
                
                
                entrada = new EntradaSalida(producto, codigo, fecha, cantidad);
                entradas.add(entrada);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return entradas;
        
    }

    @Override
    public Object SELECT_BY_ID(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    

}
