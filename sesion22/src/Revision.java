
public class Revision extends Trabajo {

    public Revision(String descripcion, int horas, boolean finalizado) {
        super(descripcion, horas, finalizado);
    }
    
    public float precioTrabajo(){
        return super.precioTrabajo() + this.getHoras() * 20;
    }
    
    
    
}
