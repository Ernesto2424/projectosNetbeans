package Dominio;

import java.util.Date;

public class Cliente extends Persona{
    
    private int idCliente;
    private static int contadorCliente;
    private Date fechaRegistro;
    private boolean vip;
    
    public Cliente(){}
    
    public Cliente(String nombre, char genero, int edad, String direccion, Date fechaRegistro, boolean vip){
        super(nombre, genero, edad, direccion);
         this.idCliente = ++Cliente.contadorCliente; 
        this.fechaRegistro = fechaRegistro;
        this.vip = vip;    
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isVip() {
        return this.vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return   "" + super.toString() +  " Cliente{" + "idCliente=" + idCliente + ", fechaRegistro=" + fechaRegistro + ", vip=" + vip + '}';
    }
    
    
    
    
    
}
