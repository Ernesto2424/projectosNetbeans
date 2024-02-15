
public class Heroe extends Personaje{

    private double velocidad;
    private double habilidad;
    private double longitudSaltoH;
    private double longitudSaltoV;
    private Potenciador potencia [] = new Potenciador[5];

    //constructor
    public Heroe(){}

    public Heroe(double v, double h, double sh, double sv, String n, double s, double e ) {
        super(n, s, e);
        this.velocidad = v;
        this.habilidad = h;
        this.longitudSaltoH = sh;
        this.longitudSaltoV = sv;
    }
    

    public double getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(double v) {
        this.velocidad = v;
    }

    public double getHabilidad() {
        return this.habilidad;
    }

    public void setHabilidad(double h) {
        this.habilidad = h;
    }

    public double getLongitudSaltoH() {
        return this.longitudSaltoH;
    }

    public void setLongitudSaltoH(double lh) {
        this.longitudSaltoH = lh;
    }

    public double getLongitudSaltoV() {
        return this.longitudSaltoV;
    }

    public void setLongitudSaltoV(double lv) {
        this.longitudSaltoV = lv;
    }

    public Potenciador[] getPotencia() {
        return this.potencia;
    }

    public void setPotencia(Potenciador[] pot) {
        this.potencia = pot;
    }
    
    public boolean enfrentaJefe(Jefe je){
        
        Arma gun = je.getArma();
        double e = je.getEnergia();
        double s = je.getSalud();
        
        while(e>75 && s>60){
            e--;
            s--;
        }
        
        return false;
    }
    
    public void equipaItem(Potenciador pot){
        for(int i=0; i<5; ++i){
            this.potencia[i]=pot;
        }
        
    }
    
    public void agregaItem(Potenciador pot){
       for(int i=0; i<this.potencia.length; ++i){
           if(this.potencia[i]==null){
               this.potencia[i]=pot;
           }
       }
    }
    public void eliminaItem(Potenciador pot){
        for(int i=0; i<this.potencia.length; ++i){
            if(this.potencia==null){
                this.potencia[i-1]=null;
            }
        }
        
    }

    @Override
    public String toString() {
        String n = " ";
        for(int i=0; i<5; ++i){
            n=n+this.potencia[i]+ " ";
        }
        return super.toString()+" Heroe{" + "velocidad=" + velocidad + ", habilidad=" + habilidad + ", longitudSaltoH=" + longitudSaltoH + ", longitudSaltoV=" + longitudSaltoV + ", potencia=" + n + '}';
    }
    

      
    
    
    
}
