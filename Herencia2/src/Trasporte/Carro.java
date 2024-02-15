
package Trasporte;


public class Carro extends Vehiculo {
    
    private String nombre;
    private int estado;
    private double velocidad;
    
    public Carro(){}

    public Carro(String nombre, int estado, double velocidad, String marca, String modelo, String tipo) {
        super(marca, modelo, tipo);
        this.nombre = nombre;
        this.estado = estado;
        this.velocidad = velocidad;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return super.toString()+" Carro{" + "nombre=" + nombre + ", estado=" + estado + ", velocidad=" + velocidad + '}';
    }
    
    
    
    
    
    
}
