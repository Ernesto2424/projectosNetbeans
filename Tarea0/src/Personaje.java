

public class Personaje {
    
    private String nombre;
    private double salud;
    private double energia;
    private String[] herramientas = new String[10];
    
    //metodo constructor 
    public Personaje(){}
    
    public Personaje(String n, double s, double e){
        this.nombre=n;
        this.salud=s;
        this.energia=e;
       }
    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String n){
        this.nombre=n;
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
    public void setEnergia(double e){
        this.energia=e;
    }
    
    public String[] getHerramientas(){
        return this.herramientas;
        
    }
    public void setHerramientas(String[] h){
        this.herramientas=h;
    }
    
    public void agregaItem(String it, int pos ){
        this.herramientas[pos]= it;
    }
    
    
    
    public String convierteACadena(){
        String n="";
        for(int a=0; a<10; ++a){
            n=n+this.herramientas[a]+"";
        }
        
        return "Nombre:"+this.nombre + " Salud:"+this.salud 
             + " Energia:"+this.energia + " items:"+n;
    }
    
    
    
    
    
}
