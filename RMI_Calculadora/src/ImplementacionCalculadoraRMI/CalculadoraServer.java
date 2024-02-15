
package ImplementacionCalculadoraRMI;
import java.rmi.*;
import java.rmi.registry.*;
/**
 *
 * @author Gutiérrez Ramos Alberto Daniel - 2182003623
 */
public class CalculadoraServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Servidor s1 = new Servidor();
        s1.iniciarServidor();
        
       
        
    }
    
}
