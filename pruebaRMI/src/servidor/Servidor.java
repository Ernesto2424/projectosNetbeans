/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import operacion.Operacion;
import operacion.interfaz;

/**
 *
 * @author Personal
 */
public class Servidor {
    
    
    public void iniciarServidor(){
        
        // TODO code application logic here
        
        //DEBE de estar rodeado de un try y catch para evitar poner los throws
        try{
            //Objeto de la calculadora
            interfaz calc = new Operacion();
            
            //Creamos registro
            LocateRegistry.createRegistry(1099);
            
            //Ligamos el objeto al nombre que le demos
            Naming.bind("ServicioCalculadora", (Remote) calc);
            
            //Info de server
            System.out.println("[*] Calculadora lista para recibir operaciones.");
        }
        catch (Exception e){
            System.err.println("[!] Error al iniciar el servidor: " + e);
            e.printStackTrace();
        }
        
    }
    
}
