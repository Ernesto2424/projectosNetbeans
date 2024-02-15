/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPC;

import org.apache.xmlrpc.XmlRpcClient;
import java.util.*;

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
        try{
            //Se crea cliente en localhost
            XmlRpcClient cliente = new XmlRpcClient("http://localhost/");
            
            //Vector para los parametros
            Vector <String> params = new Vector<String>();
            
            //Scanner de teclado
            Scanner entradaTeclado = new Scanner(System.in);
            
            //Bandera para continuar con la ejecucion
            boolean flag = true;
            
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
            //Despedida
            System.out.println("[SERVER] Hasta pronto. =D");
        }
        catch(Exception e){
            System.err.println("[!] Error en el cliente: " + e);
            e.printStackTrace();
        }
        
    }
    
}
