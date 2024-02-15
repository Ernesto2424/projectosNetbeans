
public class ReparacionMecanica extends Reparacion{

    public ReparacionMecanica(float preciomaterial, String descripcion, int horas, boolean finalizado) {
        super(preciomaterial, descripcion, horas, finalizado);
    }
    
    
    //parte fija mas el costo del mateerial * 0.1
    
    public float PrecioTrabajo(){
        return (float) (super.precioTrabajo() + this.getPreciomaterial() * 1.1);
    }
    
}
