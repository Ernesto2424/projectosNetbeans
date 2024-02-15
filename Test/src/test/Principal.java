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
public class Principal {
    
    public static void main(String[] args){
        Personaje p1 = new Personaje();
        Personaje p2 = new Personaje("Mario", 100, 100);
        
        System.out.println(p1);
        System.out.println(p2.covierteACadena());
    }
    
    
}
