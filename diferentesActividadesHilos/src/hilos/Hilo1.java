/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos;

import java.util.Scanner;

public class Hilo1 extends Thread {

    /**
     * el primer hilo tiene como objetivo solictiar una palabra al usuario para
     * que posteriormente esta misma sea procesada entonces debemos guardar esta
     * palabra!
     */
    
    public static String palabra = "";

    @Override
    public void run() {

        Scanner sc = new Scanner(System.in);
        palabra = sc.nextLine();
        //System.out.println("Esta es la palabra a buscar: " +Hilo1.palabra.toUpperCase());

    }

}
