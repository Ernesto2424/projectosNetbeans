
public class Carga extends Auto{

    private String opcion;
    private int toneladas;
  
    public Carga(){}
    public Carga(String opcion, String placas, int dias) {
        super(placas, dias);
        this.opcion = opcion;
    }
    
    public Carga(String opcion, String placas, int dias, int toneladas) {
        super(placas, dias);
        this.opcion = opcion;
        this.toneladas = toneladas;
    }
    
    public String getOpcion(){
        return this.opcion;
    }
    
    public void setOpcion(String opcion){
        this.opcion=opcion;
    }
    
    public int getToneladas(){
        return this.toneladas;
    }
    
    public void setToneladas(int toneladas){
        this.toneladas=toneladas;
    }
    
    public float precioCamioneta(){
        return (this.getDias() * 800) + 5000;
    }
    
    public float precioCamion(){
        return (this.getDias() * 800) + (this.getToneladas() * 300);
    }

    @Override
    public String toString() {
        return super.toString() + "opcion: " + opcion+"\n" + "toneladas: " + toneladas + "\n";
    }
    
    public String toString2(){
        return super.toString() + "opcion: "+ opcion + "\n";
    }
  }
