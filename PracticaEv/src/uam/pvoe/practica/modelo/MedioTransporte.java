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
public class MedioTransporte {
    
    private String nombre;
        /*Los nombres deberán ser Auto, Autobús, Avión, Auto Rentado*/
          
    private String clave;
        /*Las claves deberán ser AUTO, BUS, AVION, AUTO_R*/
    
    public MedioTransporte(String nombre, String clave){
        this.nombre = nombre;
        this.clave= clave;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
    
}
