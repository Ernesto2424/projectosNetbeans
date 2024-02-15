
package ImplementacionCalculadoraRMI;
import java.rmi.*;
import java.util.Scanner;
/**
 *
 * @author Gutiérrez Ramos Alberto Daniel - 2182003623
 */
public class CalculadoraCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cliente c1 = new Cliente();
        c1.iniciarCliente();
       
         Cliente c2 = new Cliente();
        c2.iniciarCliente();
        
    }
    
}
