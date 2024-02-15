
public class Personaje {

    private String nombre;
    private double salud;
    private double energia;
    private String herramientas[]=new String[10];
    private double velocidad;
    private double habilidad;
    private double longitudsaltohorizontal;
    private double longitudsaltovertical;
    private Item[] items =new Item[5];
    
    //constructor
    public Personaje(){}
    
    public Personaje(String n, double s, double e, String[] h, double v, double hb, double lh, double lv){
        this.nombre=n;
        this.salud=s;
        this.energia=e;
        this.herramientas=h;
        this.velocidad=v;
        this.habilidad=hb;
        this.longitudsaltohorizontal=lh;
        this.longitudsaltovertical=lv;
        
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getSalud() {
        return this.salud;
    }

    public double getEnergia() {
        return this.energia;
    }

    public String[] getHerramientas() {
        return this.herramientas;
    }

    public double getVelocidad() {
        return this.velocidad;
    }

    public double getHabilidad() {
        return this.habilidad;
    }

    public double getLongitudsaltohorizontal() {
        return this.longitudsaltohorizontal;
    }

    public double getLongitudsaltovertical() {
        return this.longitudsaltovertical;
    }
    
    public Item[] getItem(){
        return this.items;
    }
    

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setSalud(double s) {
        this.salud = s;
    }

    public void setEnergia(double e) {
        this.energia = e;
    }

    public void setHerramientas(String[] h) {
        this.herramientas = h;
    }

    public void setVelocidad(double v) {
        this.velocidad = v;
    }

    public void setHabilidad(double hb) {
        this.habilidad = hb;
    }

    public void setLongitudsaltohorizontal(double lh) {
        this.longitudsaltohorizontal = lh;
    }

    public void setLongitudsaltovertical(double lv) {
        this.longitudsaltovertical = lv;
    }
    
    public void setItem(Item[] i){
        this.items=i;
    }
    
    
    public void inicializaHerramientas(){
        
    }
    
    public void agregaHerramienta(Item itm, int pos){
        
    }
    
    
    public void equipaItem(int pos){
        
    }
    
    
    
    public String convierteACadena(){
        String n="";
        for(int j=0; j<5; ++j){
            n=n+this.items[j];
        }
        return "Nombre: "+this.nombre + " Salud: "+this.salud + " Energia: "+this.energia
                + " ITEM Herramientas:[["+n.toString() + "]] Velocidad:"+this.velocidad + " Habilidad:"+this.habilidad
                + " Longitud horizontal: "+this.longitudsaltohorizontal + " Longitud Vertical: "+this.longitudsaltovertical
                + " ITEM: "+this.items.toString();
    }

    void setItem(Item i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
}
