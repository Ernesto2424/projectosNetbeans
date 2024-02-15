package domain;

public class Palabra {

    private int id;
    private String significado;

    public Palabra() {
    }

    public Palabra(String significado) {
        this.significado = significado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    @Override
    public String toString() {
        return this.significado;
    }

}
