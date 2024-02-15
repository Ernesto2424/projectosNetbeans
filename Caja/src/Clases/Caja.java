
package Clases;


public class Caja {
   
private int largo;
private int ancho;
private int alto;
 
  public Caja(){}
   public Caja(int largo, int ancho, int alto) {
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getLargo() {
        return this.largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return this.ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return this.alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    public int getVolume(){
        int volume;
        volume = this.largo * this.ancho * this.alto;
        return volume;
    }

   


    
}
