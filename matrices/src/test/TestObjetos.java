/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Persona;

/**
 *
 * @author Personal
 */
public class TestObjetos {
    
    public static void imprimir(Object matriz[][]){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("equipo "+i+" : "+matriz[i][j]);
            }
        }
    }
    
    public static void main(String[] args) {
        
        Persona arr[][] = new Persona[2][3];
        
        arr[0][0] = new Persona("Ernesto");
        arr[0][1] = new Persona("karla");
        arr[0][2] = new Persona("mariana");
        
        arr[1][0] = new Persona("Luis");
        arr[1][1] = new Persona("Pedro");
        arr[1][2] = new Persona("marcos");
        
        imprimir(arr);
       
        
       
        
       
        
        
        
        
    }
    
    
    
}
