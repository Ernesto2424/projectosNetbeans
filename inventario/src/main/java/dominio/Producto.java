package dominio;

/**
 * Esta clase es considerada del tipo modelo o dominio
 * que contiene las propiedades del objeto Producto con  sus
 * respectivos metodos.
 * 
 * @author Ernesto F.
 */
public class Producto {

    /**
     * Propiedades especificas 
     * del objeto producto.
     */
    
    private int codigo;
    private String descripcion;
    private double costoUnitario;

    /**
     * Metodo Constructor por defecto.
     */
    public Producto() {}
    
    /**
     * Metodo que servira para la obtencion de un Producto.
     * 
     * @param codigo identificador del producto.
     * @param descripcion descripcion del producto.
     * @param costoUnitario costo de cada producto.
     */

    public Producto(int codigo, String descripcion, double costoUnitario) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costoUnitario = costoUnitario;

    }

    /**
     * Metodo que servira para la creación de un nuevo Producto.
     * 
     * @param descripcion descripcion que tendra el nuevo producto.
     * @param costoUnitario costo que tendra el nuevo producto.
     */ 
    
    public Producto(String descripcion, double costoUnitario) {
        this.descripcion = descripcion;
        this.costoUnitario = costoUnitario;
    }
    
    /**
     * Metodo que permite obtener un Producto a traves del id.
     * @param codigo id del prodcuto.
     */
    
    public Producto(int codigo) {
        this.codigo = codigo;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("codigo=").append(codigo);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", costoUnitario=").append(costoUnitario);
        sb.append('}');
        return sb.toString();
    }

}
