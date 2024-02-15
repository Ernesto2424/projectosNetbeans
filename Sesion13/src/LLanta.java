
public class LLanta {
    
    private String nombre;
    private String marca;
    private int rin;

    public LLanta(){}

    public LLanta(String n, String m, int r) {
        this.nombre = n;
        this.marca = m;
        this.rin = r;
    }
    

    public String getNombre() {
        return this.nombre;
    }

    public String getMarca() {
        return this.marca;
    }

    public int getRin() {
        return this.rin;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setMarca(String m) {
        this.marca = m;
    }

    public void setRin(int r) {
        this.rin = r;
    }

    @Override
    public String toString() {
        return "LLanta{" + "nombre=" + nombre + ", marca=" + marca + ", rin=" + rin + '}';
    }
    
    
    
    
    
    
    
    
    
}
