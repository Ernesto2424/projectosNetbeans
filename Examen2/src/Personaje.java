
public class Personaje {
    
    private String nombre;
    private double salud;
    private double energia;
    
    // constructor
    public Personaje(){}
    
    public Personaje(String n, double s, double e){
        this.nombre=n;
        this.salud=s;
        this.energia=e;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public double getSalud() {
        return this.salud;
    }

    public void setSalud(double s) {
        this.salud = s;
    }

    public double getEnergia() {
        return this.energia;
    }

    public void setEnergia(double e) {
        this.energia = e;
    }

    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + nombre + ", salud=" + salud + ", energia=" + energia + '}';
    }
    
    
    
    
    
    
    
    
}
