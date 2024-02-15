
public class Persona {
    
    private String nombre;
    private String ap;
    private String am;
    private String rfc;
    private String dir;
    
    public Persona(){}
    public Persona(String nombre, String ap, String am, String rf, String dir){
        this.nombre=nombre;
        this.ap=ap;
        this.am=am;
        this.rfc = rf;
        this.dir=dir;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return   "NOMBRE: " + nombre + "\n APELLIDO PATERNO: " + ap + "\n APELLIDO MATERNO: " + am + "\n RFC: " + rfc + "\n DIRECCION: " + dir ;
    }
    
    
    
}
