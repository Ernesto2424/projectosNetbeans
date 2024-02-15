package domain;

public abstract class  Figura {
    private String tipoFigura;
    
    protected Figura(String tipoFigura){
        this.tipoFigura = tipoFigura;
    }
    
    
    public abstract void dibujar();

    public String getTipoFigura() {
        return this.tipoFigura;
    }

    public void setTipoFigura(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    @Override
    public String toString() {
        return "Figura{" + "tipoFigura=" + tipoFigura + '}';
    }
    
}
