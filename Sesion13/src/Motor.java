
public class Motor {
 
    private String nombre;
    private String marca;
    private int numcil;
    private double numhp;

    public Motor(String nombre, String marca, int numcil, double numhp) {
        this.nombre = nombre;
        this.marca = marca;
        this.numcil = numcil;
        this.numhp = numhp;
    }

    public Motor(){}

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public int getNumcil() {
        return numcil;
    }

    public double getNumhp() {
        return numhp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNumcil(int numcil) {
        this.numcil = numcil;
    }

    public void setNumhp(double numhp) {
        this.numhp = numhp;
    }

    @Override
    public String toString() {
        return "Motor{" + "nombre=" + nombre + ", marca=" + marca + ", numcil=" + numcil + ", numhp=" + numhp + '}';
    }
    
    
    
    
    
}
