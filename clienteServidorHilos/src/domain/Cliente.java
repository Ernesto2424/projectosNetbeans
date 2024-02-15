
package domain;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Ernesto Flores
 */

public class Cliente {
    
    public static void main(String[] args) {
        
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
