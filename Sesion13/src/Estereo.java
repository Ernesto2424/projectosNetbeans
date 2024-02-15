
public class Estereo {
    
    private String nombre;
    private String marca;
    private double potencia;
    
    
    public Estereo(){}
    public Estereo(String n, String m, double p){
     this.nombre=n;
     this.marca=m;
     this.potencia=p;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getMarca() {
        return this.marca;
    }

    public double getPotencia() {
        return this.potencia;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setMarca(String m) {
        this.marca = m;
    }

    public void setPotencia(double p) {
        this.potencia = p;
    }

    @Override
    public String toString() {
        return "Estereo{" + "nombre=" + nombre + ", marca=" + marca + ", potencia=" + potencia + '}';
    }
    
    
    
    
    
    
    
    
}
