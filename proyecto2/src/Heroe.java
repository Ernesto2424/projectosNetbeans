
import java.util.ArrayList;


public class Heroe extends Personaje{
    private double velocidad;
    private double fuerza;
    private int vidas;
    private ArrayList<Potenciador> potencia = new ArrayList<Potenciador>();
    
    public Heroe(){}

    public Heroe(double velocidad, double fuerza, int vidas, String n, double s, double h) {
        super(n, s, h);
        this.velocidad = velocidad;
        this.fuerza = fuerza;
        this.vidas = vidas;
    }

    

    public double getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(double ve) {
        this.velocidad = ve;
    }

    public double getFuerza() {
        return this.fuerza;
    }

    public void setFuerza(double f) {
        this.fuerza = f;
    }

    public int getVidas() {
        return this.vidas;
    }

    public void setVidas(int vi) {
        this.vidas = vi;
    }

    public ArrayList<Potenciador> getPotencia() {
        return this.potencia;
    }

    public void setPotencia(ArrayList<Potenciador> p) {
        this.potencia = p;
    }
    
    public void agregaPot(ArrayList<Potenciador> pot , Potenciador p){
        pot.add(p);
    }
    public void eliminaPot(ArrayList<Potenciador> pot , Potenciador p){
        pot.remove(p);
    }
    
public void ataca(Heroe h){
    if(h.getHabilidad()>getHabilidad()){
       
    }
}


    
    
    
 public String toString() {
        return  "Heroe{ "+super.ConvierteCadena()+ " velocidad:" + this.velocidad + ", fuerza:" + this.fuerza + ", vidas: " + this.vidas + " } ";
    }
    

    public String toString2() {
        return  "Heroe{ "+super.ConvierteCadena()+ " velocidad:" + this.velocidad + ", fuerza:" + this.fuerza + ", vidas:" + this.vidas + ", potenciador:" + this.potencia + '}';
    }

   
    
    
    
}
