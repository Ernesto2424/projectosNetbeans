
public class Arma extends Item{
    private double daño;
    
    public Arma(){}

    public Arma(double daño, String n, String d, double s, double h) {
        super(n, d, s, h);
        this.daño = daño;
    }

    @Override
    public String toString() {
        return super.toString() +" Arma{" + "da\u00f1o=" + daño + '}';
    }
    
    
        
    
    
}
