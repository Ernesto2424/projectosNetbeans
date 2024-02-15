
package herencias;


public class Persona {
    
    protected String nombre;
    protected int edad;
   protected String genero;
    protected double peso;
    protected double salud;
    
    public Persona(){}

    public Persona(String nombre, int edad, String genero, double peso, double salud) {
        super();
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
        this.salud = salud;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public double getPeso() {
        return peso;
    }

    public double getSalud() {
        return salud;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", genero=" + genero + ", peso=" + peso + ", salud=" + salud + '}';
    }
    
    
    
}
