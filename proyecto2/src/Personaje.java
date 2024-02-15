
public class Personaje {
    private String nombre;
    double salud;
    double habilidad;
    
    public Personaje(){}
    public Personaje(String n, double s, double h){
                       this.nombre=n;
                       this.salud=s;
                       this.habilidad=h;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public double getSalud(){
        return this.salud;
    }
    public double getHabilidad(){
        return this.habilidad;
    }
    
    public void setNombre(String n){
        this.nombre=n;
    }
    public void setSalud(double s){
        this.salud=s;
    }
    public void setHabilidad(double h){
        this.habilidad=h;
    }
    
    
    
    
    
    
    public String ConvierteCadena(){
        return " Nombre: " +this.nombre + " Salud: "  +this.salud+ " Habilidad: " + this.habilidad + " ";
    }
    
}
