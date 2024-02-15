
public class Potenciador extends Item {
    private double cantE;
    private double cantSV;
    private double cantSH;
    
    //constructor
    public Potenciador(){}

    public Potenciador(double ce, double sv, double sh, String n, String d, double ch) {
        super(n, d, ch);
        this.cantE = ce;
        this.cantSV = sv;
        this.cantSH = sh;
    }

    public double getCantE() {
        return this.cantE;
    }

    public void setCantE(double ce) {
        this.cantE = ce;
    }

    public double getCantSV() {
        return this.cantSV;
    }

    public void setCantSV(double sv) {
        this.cantSV = sv;
    }

    public double getCantSH() {
        return this.cantSH;
    }

    public void setCantSH(double sh) {
        this.cantSH = sh;
    }

    @Override
    public String toString() {
        
        
        
        return super.toString()+" Potenciador{" + "cantE=" + cantE + ", cantSV=" + cantSV + ", cantSH=" + cantSH + '}';
    }
    
    
    
    
    
    
}
