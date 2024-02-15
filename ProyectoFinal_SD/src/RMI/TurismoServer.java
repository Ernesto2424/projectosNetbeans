/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.*;
import java.rmi.registry.*;

/**
 *
 * @author leond
 */
public class TurismoServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            //Objeto del servicio de turismo
            Turismo turista = new TurismoImpl();
            
            //Creacion del registro
            LocateRegistry.createRegistry(1100);
            
            //Ligamos el objeto al nombre que le demos
            Naming.bind("ServicioTurismo", turista);
            
            //Info de server
            System.out.println("[*] Servicio de turismo listo para recibir operaciones.");
        }
        catch (Exception e){
            System.err.println("[!] Error al iniciar el servidor: " + e);
            e.printStackTrace();
        }
        
    }
}
