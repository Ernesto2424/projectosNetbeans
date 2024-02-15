
public class Potenciador extends Item{
    private double cant_fuerza;
    private double velocidad;
    
    public Potenciador(){}

    public Potenciador(double cant_fuerza, double velocidad, String n, String d, double s, double h) {
        super(n, d, s, h);
        this.cant_fuerza = cant_fuerza;
        this.velocidad = velocidad;
    }
    
    
    

    public double getCant_fuerza() {
        return cant_fuerza;
    }

    public void setCant_fuerza(double cant_fuerza) {
        this.cant_fuerza = cant_fuerza;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return super.toString() + " Potenciador{" + "cant_fuerza=" + cant_fuerza + ", velocidad=" + velocidad + '}';
    }
    
    
    
    
}
