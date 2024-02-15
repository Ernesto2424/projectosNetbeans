/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author leond
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            
            Socket conexion = new Socket("localhost", 1234);
            
            PrintWriter salida = new PrintWriter(conexion.getOutputStream(), true);
            Scanner entrada = new Scanner(conexion.getInputStream());
            
            Scanner teclado = new Scanner(System.in);
            
            //recive instruccion
            System.out.println(entrada.nextLine());
            
            boolean sigue = true;
            
            while(sigue){
                
                //lectura desde teclado
                String palabra = teclado.nextLine();
                
                salida.println(palabra);
                
                System.out.println(entrada.nextLine());
                
                if(palabra.compareTo("ADIOS") == 0)
                    sigue = false;
                
                
            }
            
            
                entrada.close();
                salida.close();
                conexion.close();
            
            
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        
    }
    
}
