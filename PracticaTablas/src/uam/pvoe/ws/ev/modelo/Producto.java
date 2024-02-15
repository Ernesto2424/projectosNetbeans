
package uam.pvoe.ws.ev.modelo;


public class Producto {
    
    public Producto(){}
    
    private String id;
    private String nombre;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
    
    
    
}
