
public class ReparacionExterna extends Reparacion {

    public ReparacionExterna(float preciomaterial, String descripcion, int horas, boolean finalizado) {
        super(preciomaterial, descripcion, horas, finalizado);
    }
    
    
    public float precioTrabajo(){
        return (float) (super.precioTrabajo() + this.getPreciomaterial() * 1.3);
    }
    
}
