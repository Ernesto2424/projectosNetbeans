
public class Pasajero extends Auto{
    private String opcion;
    private int acientos;
    
    public Pasajero(){}

    public Pasajero(String opcion, String placas, int dias, int acientos) {
        super(placas, dias);
        this.opcion = opcion;
        this.acientos=acientos;
    }
    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    
    public int getAcientos(){
        return this.acientos;
    }
    
    public void setAcientos(int acientos){
        this.acientos = acientos; 
    }
    
    public float precioMovil(){
        return (this.getDias() * 800) + (200 * this.getAcientos());
    }
    
    public float preciomicro(){
        return (this.getDias() * 800) + (100 * this.getAcientos());
    }

    @Override
    public String toString() {
        return super.toString()  + "opcion: " + opcion+"\n" + "acientos: " + acientos +"\n" ;
    }   
}
