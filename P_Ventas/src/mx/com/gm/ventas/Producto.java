package mx.com.gm.ventas;

public class Producto {

    private final int idProducto;
    private String nombre;
    private double precio;
    
    private static int  contadorProductos;
    
    private Producto(){
    this.idProducto = ++Producto.contadorProductos;
    }
    
    public Producto(String nombre, double precio){
        this(); //manda a llamar al constructor vacio para inicializar el id
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdProducto() {
        return this.idProducto;
    }

   

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return    this.nombre + " $" + this.precio ;
    }
    
    
    
    
    
}
