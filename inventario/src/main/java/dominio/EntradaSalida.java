package dominio;

import java.util.Date;

/**
 * Esta clase es considerada del tipo modelo o dominio
 * que contiene las propiedades del objeto EntradaSalida con  sus
 * respectivos metodos, esta clase nos servira para las Entradas asi 
 * como las Salidas del inventario de productos.
 * 
 * @author Ernesto F.
 */

public class EntradaSalida {

     /**
     * Propiedades especificas 
     * del objeto EntradaSalida.
        */
    private Producto producto;
    private int codigo;
    private String fecha;
    private int cantidad;
    private double actual;
    
    public EntradaSalida(){}

    public EntradaSalida(Producto producto, int codigo, String fecha, int cantidad) {
        this.producto = producto;
        this.codigo = codigo;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public EntradaSalida(Producto producto, int codigo, String fecha, int cantidad, int actual) {
        this.producto = producto;
        this.codigo = codigo;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.actual = actual;
    }

    /**
     * Metodo que nos va a permitir obtener el stock total por cada producto.
     * 
     * @param producto producto a mostrar
     * @param cantidad cantidad de piezas existentes de dicho producto.
     * @param actual importe total del producto.
     */
    public EntradaSalida(Producto producto, int cantidad, double actual) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.actual = actual;
    }
    
    
    
    
/**
 * Metodo que servira para la creacion de una Entrada o Salida.
 * @param producto producto del cual se hara el ingreso o la baja
 * @param fecha la fecha en que se realiza dicha operación.
 * @param cantidad numero de prodcutos a ingresar o dar de baja
 */
    public EntradaSalida(Producto producto, String fecha, int cantidad) {
        this.producto = producto;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }
    
    

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getActual() {
        return actual;
    }

    public void setActual(double actual) {
        this.actual = actual;
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EntradaSalida{");
        sb.append("producto=").append(producto);
        sb.append(", codigo=").append(codigo);
        sb.append(", fecha=").append(fecha);
        sb.append(", cantidad=").append(cantidad);
        sb.append('}');
        return sb.toString();
    }

}
