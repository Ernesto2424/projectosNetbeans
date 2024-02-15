/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos;

public class Hilo4 extends Thread {

    @Override
    public void run() {
        
        String tipoNum = "";
        if(Hilo3.numPalabras%2==0){
           tipoNum = "PAR";
        }else{
            tipoNum = "IMPAR";
        }
        
        System.out.println("el numero de palabras en archivo es: "+tipoNum);



    }

    
}
