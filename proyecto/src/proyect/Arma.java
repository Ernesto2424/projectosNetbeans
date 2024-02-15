
package proyect;


public class Arma {
    
    private String nombre;
    private String descripcion;
    private double cantdaño;
    private double canthabilidad;
    
    //constructor
    Arma(){}
    Arma(String n, String d, double cd, double ch){
        this.nombre=n;
        this.descripcion=d;
        this.cantdaño=cd;
        this.canthabilidad=ch;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public String gerDescripcion(){
        return this.descripcion;
    }
    public double getCantdaño(){
        return this.cantdaño;
    }
    public double getCanthabilidad(){
        return this.canthabilidad;
    }
    
    public void setNombre(String n){
        this.nombre=n;
    }
    public void setDescripcion(String d){
        this.descripcion=d;
    }
    public void setCantDaño(double cd){
        this.cantdaño=cd;
    }
    public void setCantHabilidad(double ch){
        this.canthabilidad=ch;
    }
    
    
}
