
package test;
/**
 * IMPORTS.
 */
import org.apache.xmlrpc.XmlRpcClient;
import java.util.*;
import RMI.TurismoCliente;
import RPC.*;

/**
 *
 * @author leond
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Se intenta crear el client principal RPC
        try{
            //Se crea cliente en localhost
            XmlRpcClient cliente = new XmlRpcClient("http://localhost/");
            
            //Vector para los parametros
            Vector <String> params = new Vector<String>();
            
            //Scanner de teclado
            Scanner entradaTeclado = new Scanner(System.in);
            
            //Bandera para salir del bucle del menu
            boolean salir = false;
            
            //Bucle para mostrar el menu
            while(!salir){
                int opcion;
                
                //Bucle para ingresar la opcion de servidor
                do 
                {              
                    try {
                        //Menu
                        System.out.println("===BIENVENIDO A MI APLICACION===");
                        System.out.println("SELECCIONE UNA OPCION\n"
                                + "1. Activar SOCKET\n"
                                + "2. Activar RMI\n"
                                + "3. Activar RPC\n"
                                + "4. SALIR\n");
                        
                        opcion = entradaTeclado.nextInt();
                        break; //Si el num fue valido, sale del bucle
                        
                        
                    } 
                    //Si no fue un numero...
                    catch (InputMismatchException e) { 
                        System.err.println("[!] ERROR: No ha ingresado un numero");
                        entradaTeclado.nextLine(); //Se limpia el bufer de entrada
                    }
                        
                } while (true);
                
                //Eleccion del servidor
                switch (opcion) {
                    case 1:
                        //Inicia cliente de sockets
                        Sockets.Cliente.iniciarClienteSockets();
                        break;
                    
                    case 2:
                        //Inicia cliente RMI
                        RMI.TurismoCliente.iniciarClienteRMI();
                        break;
                       
                    case 3:
                        //Inicia cliente RPC
                        RPC.Cliente.iniciarClienteRPC();
                        break;
                   
                    case 4:
                        //Cambiamos el estado de la bandera para salir
                        salir = true;
                        break;
                    //Si no se ingresa una opcion valida, entonces ...
                    default:
                         System.err.println("[!] ERROR: Introduce un numero valido!" );
                         System.out.println();
                }
                
            }
            
            //Despedida
            System.out.println("[*] Hasta pronto. =D");
        }
        catch(Exception e){ //Fallo de creacion de cliente RPC
            System.err.println("[!] Error en el cliente: " + e);    //Mostrando el motivo del fallo
            e.printStackTrace();    //Motivo del fallo
        }
    }
    
}
