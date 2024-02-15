
package test;


public class Persona {
    
    private String nombre;
    private int edad;
    private double peso;
    private double altura;
    private double salud;
    private double energia;
    
    //Estos metodos sirven para inicializar una clase
    //Método constructor debe tener el mismo nombre de la clase;
    public Persona(){}//por defecto
    
    public Persona(String n){
        this.nombre=n;
    }
    
    public Persona(String n, int e){
        this.nombre=n;
        this.edad=e;
    }
    
    public Persona(String n, int e, double p, double a, double s, double en){
        this.nombre=n;
        this.edad=e;
        this.peso=p;
        this.altura=a;
        this.salud=s;
        this.energia=en;
                
    }
    
    
  public String getNombre(){
      return this.nombre;
  }
  public void setNombre(String n){
      this.nombre=n;
  }  
  
  public int getEdad(){
      return this.edad;
  }
  public void setEdad(int e){
      this.edad=e;
  }
  
  public double getPeso(){
      return this.peso;
  }
  public void setPeso(double p){
      this.peso=p;
  }
  
  public double getAltura(){
      return this.altura;
  }
  public void setAltura(double a){
      this.altura=a;
  }
  
  public double getSalud(){
      return this.salud;
  }
  public void setSalud(double s){
      this.salud=s;
  }
  
  public double getEnergia(){
      return this.energia;
  }
  public void setEnergia(double en){
      this.energia=en;
  }
    
    
}
