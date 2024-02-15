
public class Pelicula {
    
    private String nombre;
    private String genero;
    private String descripcion;
    private double duracion;
    
    
    public Pelicula(){}
    public Pelicula(String n, String g, String des, double du){
        this.nombre=n;
        this.genero=g;
        this.descripcion=des;
        this.duracion=du;
    }
    
    
    public String getNombre(){
        return this.nombre;
    }
    public String getGenero(){
        return this.genero;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public double getDuracion(){
        return this.duracion;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setGenero(String g) {
        this.genero = g;
    }

    public void setDescripcion(String des) {
        this.descripcion = des;
    }

    public void setDuracion(double du) {
        this.duracion = du;
    }
    
   public String CovierteCadena(){
       return "Nombre: " +this.nombre + " Genero: "+this.genero + " Descripcion: " + this.descripcion + " Duracion: " +this.duracion;
   }
    
    
    
}
    
    
        
       
    
    
    
    
    
    
    

