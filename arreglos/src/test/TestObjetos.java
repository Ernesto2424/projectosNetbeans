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
    
    public static void main(String[] args) {
        
        Persona arr[] = new Persona[3];
        
        for(int i=0; i<arr.length; ++i){
            arr[i] = new Persona("Persona"+i);
           
        }
        
        for(int i=0; i<arr.length; ++i){
            System.out.println(arr[i]);
        }
        
        
        
        
    }
    
}
