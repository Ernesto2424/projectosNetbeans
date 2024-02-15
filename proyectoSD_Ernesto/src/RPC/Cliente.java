/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPC;

import org.apache.xmlrpc.XmlRpcClient;
import java.util.*;
import RMI.TurismoCliente;


/**
 *
 * @author leond
 */
public class Cliente {

    public static void iniciarClienteRPC(){
        
        
        
        
        
        
        
        
        // TODO code application logic here
        try{
            //Se crea cliente en localhost
            XmlRpcClient cliente = new XmlRpcClient("http://localhost/");
            
            //Vector para los parametros
            Vector <String> params = new Vector<String>();
            
            //Scanner de teclado
            Scanner entradaTeclado = new Scanner(System.in);
            
            boolean salir = false;
            
            while(!salir){
                int opcion;
                
                do {              
                    
                    try {
                        
                        System.out.println("\n-----BIENVENIDO A MI APLICACION-----");
                        System.out.println("SELECCIONE UNA OPCION\n"
                                + "1. activar SOCKET\n"
                                + "2. activar RMI\n"
                                + "3. activar RPC\n"
                                + "4. SALIR\n");
                        
                        opcion = entradaTeclado.nextInt();
                        break;
                        
                        
                    } catch (InputMismatchException e) {
                        e.printStackTrace(System.out);
                    }finally{
                        
                    }
                        
                    } while (true);
                
                
                switch (opcion) {
                    case 1:
                        Sockets.Cliente.iniciarClienteSockets();
                        break;
                    
                    case 2:
                        RMI.TurismoCliente.iniciarClienteRMI();
                        break;
                       
                    case 3:
                        //Bandera para continuar con la ejecucion
            boolean flag = true;
            entradaTeclado.reset();
            //Ciclo de ejecucion
            while(flag){
                //Para obtener los nombres de los archivos
                params.addElement("ESTADOS.txt"); //Se añade el nombre del archivo que contiene los nombres de los estados al vector de parametros
                Object estados = cliente.execute("Turismo.leerArchivoCadena", params); //Ejecucion de la funcion
                String estadosPrompt = estados.toString();
                params.remove("ESTADOS.txt"); //Se elimina la entrada del vector
                
                //Entrada teclado
                System.out.println("[SERVER] ¿De que ciudad quieres conocer los lugares turisticos? "
                + estadosPrompt);
                String request = entradaTeclado.nextLine();
                request.toUpperCase(); //Pasamos a mayusculas la entrada
                params.addElement(request.trim() + ".txt"); //Se añade la entrada al vector de parametros
                
                //Resultado
                Object resultRequest = cliente.execute("Turismo.leerArchivoCadena", params); //Ejecucion de la funcion
                String lugares = resultRequest.toString();
                System.out.println("[SERVER] Los lugares son: " + lugares);
                params.clear(); //Limpiamos el vector
                
                //Continuar?
                System.out.println("[SERVER] ¿Quieres continuar? (SI / NO)?");
                String confirmacion = entradaTeclado.nextLine();
                
                if(confirmacion.equalsIgnoreCase("NO") || confirmacion.equalsIgnoreCase("ADIOS")){
                    flag = false;
                }
                
            }
                   break;
                   
                    case 4:
                     salir = true;
                     break;
                     
                     default:
                         System.out.println("INTRODUCE UN NUMERO VALIDO!!!" );
                        
                }
                
                
                
            }
            
            
            
            
           
            
            //Despedida
            System.out.println("[SERVER] Hasta pronto. =D");
        }
        catch(Exception e){
            System.err.println("[!] Error en el cliente: " + e);
            e.printStackTrace();
        }
        
    }
    
    
    
    
}
