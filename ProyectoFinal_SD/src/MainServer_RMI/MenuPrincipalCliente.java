/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainServer_RMI;

import java.rmi.*;
import java.util.*;
import RMI.*;
import RPC.*;
import Sockets.*;

/**
 *
 * @author leond
 */
public class MenuPrincipalCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try{
            //Al objeto turista lo localizamos por el nombre que le dimos
            MenuPrincipal menu = (MenuPrincipal) Naming.lookup("rmi://localhost/ServicioMenu");
            
            //Lectura de teclado
            Scanner entradaTeclado = new Scanner(System.in);
            
            //Bandera para continuar la ejecucion
            boolean salir = false;
            
            //Ciclo de ejecucion
            while(!salir){
                //Lectura de la request
                int eleccion;
                
                
                //Bucle para ingresar la opcion de servidor
                do{
                    try{
                        System.out.println("===Bienvenido al servidor===");
                        System.out.println(menu.menu());
                        System.out.print("Ingresa tu eleccion: ");
                        eleccion = entradaTeclado.nextInt();
                        break; //Si el num fue valido, sale del bucle
                    }
                    catch(InputMismatchException e){
                        System.err.println("[!] ERROR: No ha ingresado un numero");
                        entradaTeclado.nextLine(); //Se limpia el bufer de entrada
                    }
                }while(true);
                
                //Eleccion del servidor
                switch (eleccion){
                    case 1:
                        Sockets.Servidor.main(args);
                        Sockets.Cliente.main(args);
                        break;
                    case 2:
                        
                        break;
                        
                    case 3:
                        
                        
                        break;
                    case 4:
                        salir = true;
                        break;
                    
                    default:
                        System.err.println("[!] Opcion invalida, introduce un numero valido");
                        break;
                }
                
                
                
               // System.out.println("[*] ¿De que ciudad quieres conocer los lugares turisticos? "
                //+ menu.menu());
                //String request = entradaTeclado.nextLine();
                //request.toUpperCase();
                
                //Resultado
                //System.out.println(turista.leerArchivoCadena(request.trim() +
                  //      ".txt"));
                
                //Continuar?
                //System.out.println("[*] ¿Quieres continuar? (SI / NO)");
                //String confirmacion = entradaTeclado.nextLine();
                
                //if(confirmacion.equalsIgnoreCase("NO") || confirmacion.equalsIgnoreCase("ADIOS")){
                  //  flag = false;
                //}
                //else if(confirmacion.equalsIgnoreCase("SI")){
                  //  continue;
                //}
                //else{
                  //  System.err.println("[!] Opcion invalida!");
                    //System.out.println("[info] Asumiremos que quieres continuar.");
               // }
            }
            //Despedida
            System.out.println("[*] Hasta pronto. =D");
        }
        catch (Exception e){
            System.err.println("[!] Error al realizar la operacion: " + e);
            e.printStackTrace();
        }
    }
    
}
