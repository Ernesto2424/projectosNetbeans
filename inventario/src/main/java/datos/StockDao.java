package datos;

import dominio.EntradaSalida;
import dominio.Inventario;
import dominio.Producto;
import interfaces.OperacionesDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Esta clase proporciona los metoos necesarios
 * para la obtencion del stock total
 * 
 * 
 * @author Ernesto F.
 */
public class StockDao implements OperacionesDatos<Object>{
    
    /**
     * variable estatica que nos va a permitir
     * obtener el stock total meiante una consulta SQL.
     */
    
    private static final String SQL_SELECT_STOCK_TOTAL = "SELECT\n" +
"e.codigo_producto,\n" +
"e.total_entrada - COALESCE(s.total_salida,0) AS cantidad_restante\n" +
"FROM\n" +
"(SELECT codigo_producto, SUM(cantidad) AS total_entrada FROM entrada GROUP BY codigo_producto) e\n" +
"LEFT JOIN\n" +
"(SELECT codigo_producto, SUM(cantidad)AS total_salida FROM salida GROUP BY codigo_producto) s\n" +
"ON\n" +
"e.codigo_producto = s.codigo_producto;";

  /**
   * 
   * Este metodo nos va a permitir obtener
   * particularmente una lista de objetos del 
   * tipo EntradaSalida, el objeto contendra un 
   * producto, una cantidad y el importe total
   * el cual va a representar el stock total con el
   * que se cuenta.
   * 
   * 
   * 
   * @return lista de objetos del tipo EntradaSalida.
   * 
   */

   @Override
    public List<Object> SELECT() {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        EntradaSalida stock = null;
        List<Object> inventario = new ArrayList<Object>();
        OperacionesDatos op = new ProductoDao();
        Producto producto = null;
        
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT_STOCK_TOTAL);
            rs = pst.executeQuery();
            while(rs.next()){
                int idProducto = rs.getInt("codigo_producto");
                producto = (Producto) op.SELECT_BY_ID(idProducto);
                int cantidadTotal = rs.getInt("cantidad_restante");
                double importe = Inventario.getImporteInventario(cantidadTotal, producto.getCostoUnitario());
                
                
                stock = new EntradaSalida(producto, cantidadTotal, importe);
                inventario.add(stock);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        
        return inventario;
      
    }

   

    
    
    
    
    
    
    
    
    @Override
    public Object INSERT(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Object SELECT_BY_ID(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    
    
}
