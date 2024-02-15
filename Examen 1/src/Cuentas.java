
public class Cuentas {
    
    /* principio de ocultacion: 
    ya que he declarado los atributos 
    privados */
    
    private String numcuenta;
    private String tipocuenta;
    private double saldo;
    
    /* Sobrecarga de metodos: ya que he declarado
    dos metodos con el mismo nombre, la diferiencia
    es en los parametros que reciben */
    
    Cuentas(){}
    Cuentas(String nc, String tc, double s){
        this.numcuenta=nc;
        this.tipocuenta=tc;
        this.saldo=s;
    }
    
    /*encapsulamiento: ya que he declarado
    los metodos publicos para tener acceso
    a los datos pero primero se declararon los
    datos, como privados*/

    public String getNumcuenta() {
        return this.numcuenta;
    }

    public String getTipocuenta() {
        return this.tipocuenta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setNumcuenta(String nc) {
        this.numcuenta = nc;
    }

    public void setTipocuenta(String tc) {
        this.tipocuenta = tc;
    }

    public void setSaldo(double s) {
        this.saldo = s;
    }
    
    public String convierteCadena2(){
        
        return "NUMERO DE CUENTA:"+this.numcuenta + " TIPO DE CUENTA:"+this.tipocuenta
                                  + " SALDO:"+this.saldo;
    }
    
    
            
    
}
