package domain;

public class Numero {

    private String tipoDato;
    private int entero;
    private int decimal;

    public Numero() {
    }

    public Numero(String tipoDato, int entero, int decimal) {
        this.tipoDato = tipoDato;
        this.entero = entero;
        this.decimal = decimal;
    }

    public Numero(String tipoDato, int entero) {
        this.tipoDato = tipoDato;
        this.entero = entero;

    }

    public String toStringFlotante() {
        return this.tipoDato + ": (" + this.entero + "," + this.decimal + ')';
    }

    public String toStringEntero() {
        return this.tipoDato + ": (" + this.entero + ", null)";
    }

}
