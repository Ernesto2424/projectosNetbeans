/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author leond
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            int i = 1;
            ServerSocket s = new ServerSocket(1234);
            
            
            while(true){
                
                Socket entrante = s.accept();
                System.out.println("Generando hilo: " +i );
                Runnable r = new ManejadorHilos(entrante, i);
                Thread t = new Thread(r);
                t.start();
                ++i;
                
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        
    }
    
}
