
public class Auto {
    
    private String placas;
    private int dias;
    public Auto(){}
    public Auto(String placas, int dias) {
        this.placas = placas;
        this.dias = dias;
    }
    
    public String getPlacas() {
        return this.placas;
    }

    public void setPlacas(String placa) {
        this.placas = placa;
    }

    public int getDias() {
        return this.dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "Auto:\n" + "placas: " + placas+"\n" + "dias: " + dias+"\n";
    }    
}
