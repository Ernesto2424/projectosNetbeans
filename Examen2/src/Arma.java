
public class Arma extends Item{
    private double cantDaño;
    
    //constructor
    public Arma(){}

    public Arma(double cd, String n, String d, double ch) {
        super(n, d, ch);
        this.cantDaño = cd;
    }

    public double getCantDaño() {
        return this.cantDaño;
    }

    public void setCantDaño(double cd) {
        this.cantDaño = cd;
    }

    @Override
    public String toString() {
        return super.toString()+ " Arma{" + "cantDa\u00f1o=" + cantDaño + '}';
    }
    
    
    
    
    

    
    
    
}
