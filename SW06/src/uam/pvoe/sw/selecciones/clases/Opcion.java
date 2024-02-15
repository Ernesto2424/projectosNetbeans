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
public class Opcion {
    
    
    private String llave;
    private String valor;
    
    public Opcion(String k, String v){
        this.llave = k;
        this.valor = v;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

   


    
}
