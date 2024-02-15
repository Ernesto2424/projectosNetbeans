
package proyectoRPC;

/**
 * Hecho con Java JDK 1.8
 * Apache xmlrpc-1.2-b1.jar
 */

/**
 * IMPORTS
 */
import java.io.*;

/**
 * @author 
 * Flores Machuca Ernesto - 2193041595
 * Gutiérrez Ramos Alberto Daniel - 2182003623
 * Vera Fino Cristian Andres - 2231900175
 */
public class logicaServidor {
    
    
    public String leerArchivoCadena(String nombre){
        String resultado = "";
        File archivo = new File(nombre);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while(lectura != null){
                resultado += lectura;
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            //ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        if("".equals(resultado)){
            resultado = "[!] INGRESE UN ESTADO EXISTENTE";
        }
        return resultado;
    }
}
