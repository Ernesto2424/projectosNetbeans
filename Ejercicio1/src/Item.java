
public class Item {
    
    private String nombre;
    private String descripcion;
    private double canthabilidad;
    private double cantsaltovertical;
    private double cantsaltohorizontal;
    private double cantenergia;
    
    //constructor
    public Item(){}

    public Item(String n, String d, double cantha, double cantv, double canth, double cante) {
        this.nombre = n;
        this.descripcion = d;
        this.canthabilidad = cantha;
        this.cantsaltovertical = cantv;
        this.cantsaltohorizontal = canth;
        this.cantenergia = cante;
    }
   
    
    public String getnombre(){
        return this.nombre;
    }
    
    public String getdescripcion(){
        return this.descripcion;
        
    }
    
    public double getcanthabilidad(){
        return this.canthabilidad;
    }
    
    public double getcantsaltovertical(){
        return this.cantsaltovertical;
    }
    
    public double getcantsaltohorizontal(){
        return this.cantsaltohorizontal;
    }
    
    public double getcantenergia(){
        return this.cantenergia;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setDescripcion(String d) {
        this.descripcion = d;
    }

    public void setCanthabilidad(double cantha) {
        this.canthabilidad = cantha;
    }

    public void setCantsaltovertical(double cantv) {
        this.cantsaltovertical = cantv;
    }

    public void setCantsaltohorizontal(double canth) {
        this.cantsaltohorizontal = canth;
    }

    public void setCantenergia(double cante) {
        this.cantenergia = cante;
    }
    
    public String toString(){
        return "Nombre: "+this.nombre + " Descripcion: "+this.descripcion + " CantHabilidad: "+this.canthabilidad
                       + " CantSVertical: "+this.cantsaltovertical + " CantSHorizontal: "+this.cantsaltohorizontal
                       + " CantEnergia: "+this.cantenergia;
    }
    
    
    
}
