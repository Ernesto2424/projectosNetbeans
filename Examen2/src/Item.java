
public class Item {
    private String nombre;
    private String descripcion;
    private double cantH;
    
    //constructor
    public Item(){}
    public Item(String n, String d, double ch){
        this.nombre=n;
        this.descripcion=d;
        this.cantH=ch;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String d) {
        this.descripcion = d;
    }

    public double getCantH() {
        return this.cantH;
    }

    public void setCantH(double ch) {
        this.cantH = ch;
    }

    @Override
    public String toString() {
        return "Item{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", cantH=" + cantH + '}';
    }
    
    
    
    
}
