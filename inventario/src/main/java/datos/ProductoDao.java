package datos;

import dominio.Producto;
import interfaces.OperacionesDatos;
import java.sql.Connection;
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
 * referente a los Productos que se registran.
 * 
 * @author Ernesto F.
 */
public class ProductoDao implements OperacionesDatos<Object>{
    
     /**
     * Variables estaticas constantes que hacen referencia
     * a cada una de las consultas SQL.
     */
    
    private static final String SQL_INSERT = "INSERT INTO producto(descripcion, costo) VALUES(?,?)";
     private static final String SQL_SELECT = "SELECT * FROM producto";
     private static final String SQL_SELECT_BY_ID = "SELECT * FROM producto WHERE codigo = ?";
     
     /**
     * 
     * Este metodo tiene como objetivo imsertar una nuevo
     * Producto a la base de datos.
     * 
     * @param objeto Reibe un objeto del tipo
     * Producto. 
     * 
     * @return si el valor del entero es 0, quiere decir que no se inserto
     * el objeto a la base de datos, si el valor es 1, significa lo contrario.
     */
     
    @Override
    public Object INSERT(Object objeto) {
        
        Connection cn = null;
        PreparedStatement pst = null;
        int rows = 0;
        Producto producto = null;
        producto =  (Producto) objeto;
        
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_INSERT);
            pst.setString(1, producto.getDescripcion());
            pst.setDouble(2, producto.getCostoUnitario());
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
     * la base de datos todos los registros del tipo Producto.
     * 
     * @return Lista de objetos del tipo Producto.
     */
    
    @Override
    public List<Object> SELECT() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Object> productos = new ArrayList<Object>();
        
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String descripcion = rs.getString("descripcion");
                double costo = rs.getDouble("costo");
                producto = new Producto(codigo, descripcion, costo);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        
        return productos;
        
    }



    /**
     * Este metodo tiene como objetivo recuperar de la
     * base de datos un regisro mediante su identificador.
     * 
     * @param id identificador del producto que se desea recuperar.
     * 
     * @return Objeto del tipo producto con base a su id proporcionado.
     */
    
    @Override
    public Object SELECT_BY_ID(Object id) {
       //seleccionar un producto por su ID
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int idProducto = (int) id;
        Producto producto = null;
        
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT_BY_ID);
            pst.setInt(1, idProducto);
            rs = pst.executeQuery();
            
            rs.next();
            int codigo = rs.getInt("codigo");
            String descripcion = rs.getString("descripcion");
            double costoUnitario = rs.getDouble("costo");
            producto = new Producto(codigo, descripcion, costoUnitario);
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
                    
        }
        return producto;
        
    }



    
}
