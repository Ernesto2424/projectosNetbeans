
package herencias;

public class Futbolista extends Persona{
    private String pos;
    private double habilidad;
    private int num;
    
    public Futbolista(){}

    public Futbolista(String pos, double habilidad, int num, 
                      String nombre, int edad, String genero, double peso, double salud) {
        super(nombre, edad, genero, peso, salud);
        this.pos = pos;
        this.habilidad = habilidad;
        this.num = num;
        
        
    }

    public String getPos() {
        return pos;
    }

    public double getHabilidad() {
        return habilidad;
    }

    public int getNum() {
        return num;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public void setHabilidad(double habilidad) {
        this.habilidad = habilidad;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Futbolista{" + "Nombre =" +super.nombre + " pos=" + pos + ", habilidad=" + habilidad + ", num=" + num + '}';
    }
    
    
    
    
    
}
