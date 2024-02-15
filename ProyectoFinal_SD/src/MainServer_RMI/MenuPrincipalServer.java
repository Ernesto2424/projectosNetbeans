/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainServer_RMI;

import java.rmi.*;
import java.rmi.registry.*;

/**
 *
 * @author leond
 */
public class MenuPrincipalServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            //Objeto del servicio de turismo
            MenuPrincipal menu = new MenuPrincipalImpl();
            
            //Creacion del registro
            LocateRegistry.createRegistry(1099);
            
            //Ligamos el objeto al nombre que le demos
            Naming.bind("ServicioMenu", menu);
            
            //Info de server
            System.out.println("[*] Servidor principal listo para recibir operaciones.");
        }
        catch (Exception e){
            System.err.println("[!] Error al iniciar el servidor: " + e);
            e.printStackTrace();
        }
    }
    
}
