
package proyectoRPC;

/**
 * Hecho con Java JDK 1.8
 * Apache xmlrpc-1.2-b1.jar
 */

/**
 * IMPORTS
 */
import org.apache.xmlrpc.WebServer;

/**
 * @author 
 * Flores Machuca Ernesto - 2193041595
 * Gutiérrez Ramos Alberto Daniel - 2182003623
 * Vera Fino Cristian Andres - 2231900175
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            //Mensaje de servidor
            System.out.println("[*] Iniciando el servidor ...");
            
            //Declaracion del servidor
            WebServer server = new WebServer(80);
            
            //Instancia de los procedimientos
            logicaServidor proc = new logicaServidor();
            
            //Nombre del servidor y donde se encuentran sus procedimientos
            server.addHandler("Turismo", proc);
            
            //Se inicia server
            server.start();
        }
        catch(Exception e){
            System.err.println("[!] Error en el servidor: " + e);
            e.printStackTrace();
        }
        
    }
    
}
