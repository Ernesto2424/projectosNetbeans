
public class Reparacion extends Trabajo {
    
    private float preciomaterial;

    public Reparacion(float preciomaterial, String descripcion, int horas, boolean finalizado) {
        super(descripcion, horas, finalizado);
        this.preciomaterial = 0;
    }

    public float getPreciomaterial() {
        return preciomaterial;
    }

    public void setPreciomaterial(float preciomaterial) {
        
        if(isFinalizado()){
            System.out.println("Ya no se puede modificar el precio del material");
        }else{
        this.preciomaterial = preciomaterial;    
        }
        
    }

    @Override
    public String toString() {
        return super.toString() + " Reparacion{" + "preciomaterial=" + preciomaterial + '}';
    }
    
    
    
    
    
}
