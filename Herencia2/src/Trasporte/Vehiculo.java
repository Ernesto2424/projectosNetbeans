
package Trasporte;


public class Vehiculo {
    
    
    
    protected String marca;
    protected String modelo;
    protected String tipo;
    
    public Vehiculo(){}

    public Vehiculo(String marca, String modelo, String tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void avanza(){
        
    }
    
    public void frena(){
        
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipo + '}';
    }
    
    
    
    
}
