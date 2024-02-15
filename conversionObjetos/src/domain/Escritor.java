package domain;

public class Escritor extends Empleado{
    
    final TipoEscritura tipoEscritura;
    
    public Escritor(String nombre, double sueldo, TipoEscritura tipoEscritura){
        super(nombre, sueldo);
        this.tipoEscritura = tipoEscritura;
    }
    
    // le indica al compilador que se va a rescribir el metodo
    @Override
    public String obtenerDetalles(){
     return super.obtenerDetalles() + ", tipoEscritutra " + tipoEscritura.getDescripcion();  
    }
    public String getTipoEscritura(){
        return this.getTipoEscritura();
    }
    
    
}
