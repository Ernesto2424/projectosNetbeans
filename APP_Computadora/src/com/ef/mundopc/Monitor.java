package com.ef.mundopc;

public class Monitor {
    private final int idMonitor;
    private String marca;
    private double tamano;
    private static int contadorMonitores;
    
    private Monitor(){
        this.idMonitor = ++Monitor.contadorMonitores;
    }
    public Monitor(String marca, double tamano){
        this();
        this.marca=marca;
        this.tamano=tamano;
    }

    public int getIdMonitor() {
        return this.idMonitor;
    }

   

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamaño() {
        return this.tamano;
    }

    public void setTamaño(double tamaño) {
        this.tamano = tamaño;
    }

   
    
    

    @Override
    public String toString() {
        return "Monitor{" + "idMonitor=" + idMonitor + ", marca=" + marca + ", tama\u00f1o=" + tamano + '}';
    }
    
    
}
