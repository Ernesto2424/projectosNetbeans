
public class Jefe extends Personaje{
    private Arma arma;
    
    public Jefe(){}

    public Jefe(Arma arma, String n, double s, double e) {
        super(n, s, e);
        this.arma = arma;
    }
    
    
    public Arma getArma(){
        return this.arma;
    }
    public void setArma(Arma a){
        this.arma=a;
    }

    @Override
    public String toString() {
        return super.toString()+" Jefe{" + "arma=" + arma + '}';
    }
    
    
    
}
