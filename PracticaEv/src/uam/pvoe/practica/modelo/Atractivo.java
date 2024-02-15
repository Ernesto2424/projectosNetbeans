/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.practica.modelo;

/**
 *
 * @author
 */
public class Atractivo {
    
    private String nombre;
    private String atractivo;
    private String clave;

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAtractivo() {
        return atractivo;
    }

    public void setAtractivo(String atractivo) {
        this.atractivo = atractivo;
    }

    @Override
    public String toString() {
        return   this.nombre ;
    }
    
    
    
    
    
    
}
