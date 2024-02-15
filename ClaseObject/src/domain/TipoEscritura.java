/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Personal
 */
public enum TipoEscritura {
    
    CLASICO("Escritura a mano"),
    MODERNO("Escritua Digital");
    private final String descripcion;
    private TipoEscritura(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    
    
}
