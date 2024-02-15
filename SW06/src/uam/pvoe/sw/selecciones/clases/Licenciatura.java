/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.sw.selecciones.clases;

/**
 *
 * @author
 */
public class Licenciatura {
    
    private String clave;
    private String nombre;

    public String getClave() {
        return clave;
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
    
    
   public String toString(){
       String mensaje = "";
       mensaje = nombre;
       return mensaje;
   } 
    
}
