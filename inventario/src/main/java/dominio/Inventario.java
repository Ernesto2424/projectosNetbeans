package dominio;

/**
 * Esta clase es considerada del tipo modelo o dominio
 * que contiene las propiedades del objeto Inventario con  sus
 * respectivos metodos.
 * 
 * @author Ernesto F.
 */
public class Inventario {

    /**
     * Propiedades especificas 
     * del objeto Inventario.
     */
    
    private Producto producto;
    private EntradaSalida entradaSalida;

    /**
     * Metodo Constructor por defecto.
     */
    public Inventario() {
    }

    public Inventario(Producto producto) {
        
        this.producto = producto;

    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public EntradaSalida getEntradaSalida() {
        return entradaSalida;
    }

    public void setEntradaSalida(EntradaSalida entradaSalida) {
        this.entradaSalida = entradaSalida;
    }



    /**
     * Metodo que permite calcular el importe total por cada producto.
     * 
     * @param cantidad cantidad existente por cada producto.
     * @param costoUnitario costo unitario por cada producto.
     * @return Multiplicación de la cantidad existente por el precio 
     * de cada producto. 
     */
    public static double getImporteInventario(int cantidad, double costoUnitario) {
        double importe = 0;
        
        importe = cantidad * costoUnitario;
        

        return importe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventario{");
        sb.append("producto=").append(producto);
        sb.append(", entradaSalida=").append(entradaSalida);
        sb.append('}');
        return sb.toString();
    }

}
