
public class Item {
    private String nombre;
    private String descripcion;
    private double salud;
    private double habilidad;
    
    public Item(){}
    public Item(String n, String d, double s, double h){
        this.nombre=n;
        this.descripcion=d;
        this.salud=s;
        this.habilidad=h;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSalud() {
        return salud;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public double getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(double habilidad) {
        this.habilidad = habilidad;
    }

    @Override
    public String toString() {
        return "Item{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", salud=" + salud + ", habilidad=" + habilidad + '}';
    }
    
    
    
    
}
