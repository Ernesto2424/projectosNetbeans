package mx.com.gm.ventas;

public class Orden {

private final int idOrden;
private Producto productos[];

private static int contadorOrden;

private static final int MAX_PRODUCTOS = 10;
private int contadorProductos;


public Orden(){
    this.idOrden = ++Orden.contadorOrden;
    this.productos = new Producto[Orden.MAX_PRODUCTOS];
}

    public int getIdOrden() {
        return this.idOrden;
    }

    

    public Producto[] getProducto() {
        return this.productos;
    }

    public void setProducto(Producto[] producto) {
        this.productos = producto;
    }
    
    public void agregarProducto(Producto producto){
        if(this.contadorProductos < Orden.MAX_PRODUCTOS){
            this.productos[this.contadorProductos++] = producto;
        }else{
            System.out.println("Se ha superado el maximo de productos");
        }
    }
    
    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < this.contadorProductos; i++) {
           total+= this.productos[i].getPrecio();
           
        }
        return total;
    }
    
    public void mostarOrden(){
        System.out.println("Id Orden: "+this.idOrden+"\n");
        System.out.println("Productos:");
        for (int i = 0; i < this.contadorProductos; i++) {
            System.out.println(this.productos[i]);
        }
        
        System.out.println("\nTotal Orden: $"+this.calcularTotal());
    }

    






    
}
