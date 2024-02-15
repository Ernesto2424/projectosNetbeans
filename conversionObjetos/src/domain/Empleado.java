/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;

/**
 *
 * @author Personal
 */
public class Empleado {
    
    private String nombre;
    private double sueldo;

    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    public String obtenerDetalles(){
        return "nombre: " +this.nombre + ", sueldo: "+this.sueldo;
    }
    
    @Override
    public int hashCode(){
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.sueldo));
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Empleado other = (Empleado) obj;
        if(Double.doubleToLongBits(this.sueldo) != Double.doubleToLongBits(other.sueldo)){
            return false;
        }
        
        if(!Objects.equals(this.nombre, other.nombre)){
            return false;
        }
                
        return true;
        
        
    }
            
    
}
