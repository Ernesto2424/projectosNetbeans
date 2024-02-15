/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caja;

import Clases.Caja;
import java.util.*;

/**
 *
 * @author Personal
 */
public class Test {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
    int largo, alto, ancho;
    System.out.println("INGRESE LARGO: ");
    largo = sc.nextInt();
    System.out.println("INGRESE ALTO: ");
    alto = sc.nextInt();
    System.out.println("INGRESE ANCHO: ");
    ancho = sc.nextInt();
    Caja caja1 = new Caja(largo, ancho, alto);
    System.out.println("EL VOLUMEN DE LA CAJA ES: "+caja1.getVolume());
   
    }
    
}
