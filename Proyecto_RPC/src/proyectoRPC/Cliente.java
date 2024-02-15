
package proyectoRPC;

/**
 * Hecho con Java JDK 1.8
 * Apache xmlrpc-1.2-b1.jar
 */

/**
 * IMPORTS
 */
import org.apache.xmlrpc.XmlRpcClient;
import java.util.*;

/**
 * @author 
 * Flores Machuca Ernesto - 2193041595
 * Gutiérrez Ramos Alberto Daniel - 2182003623
 * Vera Fino Cristian Andres - 2231900175
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
                System.out.println("[*] ¿De que ciudad quieres conocer los lugares turisticos? "
                + estadosPrompt);
                String request = entradaTeclado.nextLine();
                request.toUpperCase(); //Pasamos a mayusculas la entrada
                params.addElement(request.trim() + ".txt"); //Se añade la entrada al vector de parametros
                
                //Resultado
                Object resultRequest = cliente.execute("Turismo.leerArchivoCadena", params); //Ejecucion de la funcion
                String lugares = resultRequest.toString();
                System.out.println("[*] Los lugares son: " + lugares);
                params.clear(); //Limpiamos el vector
                
                //Continuar?
                System.out.println("[*] ¿Quieres continuar? (SI / NO)?");
                String confirmacion = entradaTeclado.nextLine();
                
                if(!confirmacion.equalsIgnoreCase("SI")){
                    flag = false;
                }
                
            }
        }
        catch(Exception e){
            System.err.println("[!] Error en el cliente: " + e);
            e.printStackTrace();
        }
       
    }
    
}
