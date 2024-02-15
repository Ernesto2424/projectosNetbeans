
package uam.pvoe.ws.ev.modelo;

public class Cliente {
    
    public Cliente(){}
    
    private String id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return this.apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return this.apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    @Override
    public String toString() {
        return  nombre + " " + apellidoP + " " + apellidoM ;
    }
    
    
    
    
    
}
