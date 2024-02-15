
package Trasporte;


public class Bicicleta extends Vehiculo{
    
    
    private int rodada;
    private String color;
    
    Bicicleta(){}

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Bicicleta(int rodada, String color, String marca, String modelo, String tipo) {
        super(marca, modelo, tipo);
        this.rodada = rodada;
        this.color = color;
    }

    

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    

    @Override
    public String toString() {
        return  super.toString()+" Bicicleta{"  + ", rodada=" + rodada + ", color=" + color + '}';
    }
    
    
    
    
}
