
public class Trabajo {
    
    private static int id;
    private String descripcion;
    private int horas;
    private boolean finalizado;
    
    public Trabajo(){};

    public Trabajo(String descripcion, int horas, boolean finalizado) {
       this.id = id;
        this.descripcion = descripcion;
        this.horas = horas;
        this.finalizado = finalizado;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Trabajo.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        
        if(isFinalizado()){
            System.out.println("el numero de horas no se puede cambiar");
        }else{
        this.horas = horas;    
        }
        
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    
    public float precioTrabajo(){
        return horas * 200;
    }

    @Override
    public String toString() {
        return "Trabajo{"+ " id: " +id + " descripcion=" + descripcion + ", horas=" + horas + ", finalizado=" + finalizado + '}';
    }
    
    
    
    
    
}
