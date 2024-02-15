
public class Clientes {
    private String nombre;
    private int edad;
    private String direccion;
    private String telefono;
    private Cuentas cuenta;
    
    //constructor
    Clientes(){}
    Clientes(String n, int e, String d, String t){
        this.nombre=n;
        this.edad=e;
        this.direccion=d;
        this.telefono=t;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public int getEdad(){
        return this.edad;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public String getTelefono(){
       return this.telefono;
    }
    public Cuentas getCuenta(){
        return this.cuenta;
    }
    
    
    public void setNombre(String n){
        this.nombre=n;
    }
    public void setEdad(int e){
        this.edad=e;
    }
    public void setDireccion(String d){
        this.direccion=d;
    }
    public void setTelefono(String t){
        this.telefono=t;
    }
    public void setCuenta(Cuentas cu){
        this.cuenta=cu;
    }
    
    public String convierteCadena(){
        return "NOMBRE: "+this.nombre + " EDAD: "+this.edad + " DIRECCION: "+this.direccion
                + " TELEFONO: "+this.telefono + " CUENTA: "+this.cuenta.convierteCadena2();
    }
    
    
}
