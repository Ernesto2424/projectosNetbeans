
package proyect;


public class Personaje {
    
    protected String nombre;
    protected double vida;
    protected String [] herramientas = new String [10];

    //constructor
    public Personaje(){}
    
    public Personaje(String n, double v){
        this.nombre=n;
        this.vida=v;
        
        
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public double getVida(){
        return this.vida;
    }
    
    public String [] getHerramientas(){
        return this.herramientas;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }
    public void setVida(double v){
        this.vida=v;
    }
    
    public void setHerramientas(String[] h){
        this.herramientas=h;
    }
    
    public void atacar(){
        
    }
    public void cubrir(){
        
    }
    public void agachar(){
        
    }
    public void saltar(){
        
    }
    public void curar(){
        
    }
    
    









    
}



