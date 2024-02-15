
public class Jefe extends Personaje{
    private int nivel;
    private Arma arma;
    
    public Jefe(){}

    public Jefe(int nivel, Arma arma, String n, double s, double h) {
        super(n, s, h);
        this.nivel = nivel;
        this.arma = arma;
    }
    
    public void ataca(Personaje p){
        
        if(Jefe.class.isInstance(p)){
            
        }else if(Heroe.class.isInstance(p)){
            
        }
        
        
    }
    
    
    

    @Override
    public String toString() {
        return  super.ConvierteCadena() + " Jefe{" + "nivel=" + nivel + ", arma=" + arma + '}';
    }
    
    
    
    
}


