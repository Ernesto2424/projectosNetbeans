
public class Auto {
    
    private String nombre;
    private int estado;
    private String color;
    private double velocidad;
    
    private Estereo estereos[] = new Estereo[10];
    private Motor motor;
    private LLanta llantas[] = new LLanta[4]; 

    public Auto(){
    this.motor=new Motor();
    for(int i=0; i<4; ++i){
        this.llantas[i]= new LLanta();
    }
    }
    public Auto(String n, int e, String c, double v) {
        
        this.nombre = n;
        this.estado = e;
        this.color = c;
        this.velocidad = v;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstado() {
        return estado;
    }

    public String getColor() {
        return color;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public Estereo[] getEstereos() {
        return estereos;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setEstado(int e) {
        this.estado = e;
    }

    public void setColor(String c) {
        this.color = c;
    }

    public void setVelocidad(double v) {
        this.velocidad = v;
    }

    public void setEstereos(Estereo[] est) {
        this.estereos = est;
    }
    
    public boolean agregaEstereo(Estereo e){
       for(int i = 0; i <this.estereos.length; ++i){
           if(this.estereos[i]==null){
               this.estereos[i]=e;
           }
       }
        return true;
        
    }
    
    public boolean eliminaEstereo(int pos){
        for(int i = 0; i<this.estereos.length; ++i){
            if(this.estereos[i]==null){
                this.estereos[i-1]=null;
            }
        }
        return true;
        
    }
    
    
    
    
    
}
