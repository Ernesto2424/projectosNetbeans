
package proyecto;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author leond
 */
public class Cliente {

    public static void main(String[] args) {
        
        try 
        {
            //creando la conexion del cliente
            Socket conexion = new Socket("localhost", 1234);
            
            //Para escribir en pantalla
            PrintWriter salidaPantalla = new PrintWriter(conexion.getOutputStream(), true);
            
            //Para capturar datos entrantes del server
            Scanner entrada = new Scanner(conexion.getInputStream());
            
            //Para capturar el teclado
            Scanner entradaTeclado = new Scanner(System.in);
            
            //Bandera
            boolean bandera = true;
             System.out.println(entrada.nextLine());
                
            //Ejecucion del programa
            while(bandera)
            {
                //Recibe la instruccion (1)
            
//                System.out.println(entrada.nextLine());
//                
                //Lectura del teclado
                String ciudad = entradaTeclado.nextLine();
                
                //Enviando la ciudad (2)
                salidaPantalla.println(ciudad);
                
                //Recibe la respuesta (3)
                System.out.println(entrada.nextLine());
                
                //Enviando confirmacion (4)
                ciudad = entradaTeclado.nextLine();
                
                //Terminando la conexion (5)
                if(ciudad.compareToIgnoreCase("ADIOS") == 0 || ciudad.compareToIgnoreCase("N") == 0
                        || ciudad.compareToIgnoreCase("NO") == 0)
                {
                    bandera = false;
                }
            }
            //Cerrando conexiones
            entrada.close();
            salidaPantalla.close();
            conexion.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
