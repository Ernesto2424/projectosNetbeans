package operaciones;

import hilos.*;

/**
 *
 * @author Personal
 */

public class Operacion {

    public static void EjecutarHilos(){
        Hilo1 hilo1 = new Hilo1();
        Hilo2 hilo2= new Hilo2();
        Hilo3 hilo3 = new Hilo3();
        Hilo4 hilo4 = new Hilo4();
        
        hilo1.start();
        hilo2.start();
        while(hilo1.isAlive()){
        
            hilo2.suspend();
            
        }
        hilo2.resume();
        
        while(hilo2.isAlive()){
            
        }
        hilo3.start();
        
        while(hilo3.isAlive()){
            
        }
        hilo4.start();

    }



    
}
