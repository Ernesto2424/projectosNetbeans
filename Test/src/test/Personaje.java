/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Personal
 */
public class Personaje {
    
    public Personaje(){}
    
    public Personaje(String n, double e, double s){
        this.nombre=n;
        this.energia=e;
        this.salud=s;
    }
    
    private String nombre;
    public String getNombre(){
      return this.nombre;  
    }
    public void setNombre(String n){
        this.nombre=n;
    }
    
    
    private double salud;
    public double getSalud(){
        return this.salud;
    }
    public void setSalud(double s){
        this.salud=s;
    }
    
    
    private double energia;
    public double getEnergia(){
        return this.energia;
    }
    
    
    public void setEnergia(double e){
        this.energia=e;
    }
    
    
    
    public void saltar(double altura){
        if(this.energia>0){
            System.out.println("saltando" +altura+ "metros");
        }
         
     }
    
    public void correr(double distancia){
        if(this.energia>10){
            System.out.println("corriendo" +distancia+ "metros");
        }
    
    }
    
    public String covierteACadena(){
        return "Nombre: "+this.nombre+" |Energia: "+this.energia+" | Salud:"+this.salud;
        
    }
   
    
}
   
   
