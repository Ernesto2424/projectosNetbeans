/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.*;
import java.util.*;

/**
 *
 * @author leond
 */
public class TurismoCliente {

   public static void iniciarClienteRMI(){
       // TODO code application logic here
        
        try{
            //Al objeto turista lo localizamos por el nombre que le dimos
            Turismo turista = (Turismo) Naming.lookup("rmi://localhost/ServicioTurismo");
            
            //Lectura de teclado
            Scanner entradaTeclado = new Scanner(System.in);
            
            //Bandera para continuar la ejecucion
            boolean flag = true;
            
            //Ciclo de ejecucion
            while(flag){
                //Lectura de la request
                System.out.println("[*] ¿De que ciudad quieres conocer los lugares turisticos? "
                + turista.leerArchivoCadena("ESTADOS.txt"));
                String request = entradaTeclado.nextLine();
                request.toUpperCase();
                
                //Resultado
                System.out.println(turista.leerArchivoCadena(request.trim() +
                        ".txt"));
                
                //Continuar?
                System.out.println("[*] ¿Quieres continuar? (SI / NO)");
                String confirmacion = entradaTeclado.nextLine();
                
                if(confirmacion.equalsIgnoreCase("NO") || confirmacion.equalsIgnoreCase("ADIOS")){
                    flag = false;
                }
                else if(confirmacion.equalsIgnoreCase("SI")){
                    continue;
                }
                else{
                    System.err.println("[!] Opcion invalida!");
                    System.out.println("[info] Asumiremos que quieres continuar.");
                }
            }
            //Despedida
            System.out.println("[*] Hasta pronto. =D");
        }
        catch (Exception e){
            System.err.println("[!] Error al realizar la operacion: " + e);
            e.printStackTrace(System.out);
        }
   }
    
}
