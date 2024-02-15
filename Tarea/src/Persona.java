/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Personal
 */
public class Persona {
    
    private String nombre;
    private int edad;
    
    
    
    //metodo constructor
    public Persona(){}
    public Persona(String n, int e){
        this.nombre=n;
        this.edad=e;
    }
   
    
    public String getNombre(){
       return this.nombre;
    }
    
    public void setNombre(String n){
        n=this.nombre;
    }
    
    public int getEdad(){
        return this.edad;
    }
    
    public void setEdad(int e){
        e=this.edad;
    }
    
    public String convierteACadena(){
      return "Nombre:"+this.nombre + " Edad:"+this.edad;  
    }
    
    
}
