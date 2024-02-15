package com.ef.mundopc;

public class Orden {
    
    private int idOrden;
    private Computadora computadoras[];
    
    private static int contadorOrdenes;
    private int contadorComputadoras;
    private static final int MAX_COMPUTADORAS = 10;
    
    public Orden(){
        this.idOrden = ++Orden.contadorOrdenes;
        this.computadoras = new Computadora[Orden.MAX_COMPUTADORAS];
    }
    
    public void agregarComputadora(Computadora computadora){
        if(this.contadorComputadoras < Orden.MAX_COMPUTADORAS){
            this.computadoras[this.contadorComputadoras++]= computadora;
        }else{
            System.out.println("Ha excedido el maximo de computadoras (10)");
        }
    }
    
    public void mostrarOrden(){
        System.out.println("Id Orden: "+this.idOrden+"\n");
        System.out.println("Computadoras en la orden: ");
        for (int i = 0; i < this.contadorComputadoras; i++) {
            System.out.println(this.computadoras[i]);
        }
    }
    
}
