package ImplementacionCalculadoraRMI;



import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Personal
 */
public class Servidor {
    static int numServidor = 1099;
    static int name = 0;
    
   
    
    
    
    public void iniciarServidor(){
        
        
         // TODO code application logic here
        
        //DEBE de estar rodeado de un try y catch para evitar poner los throws
        try{
            numServidor++;
            
            //Objeto de la calculadora
            Calculadora calc = new CalculadoraImpl();
            
            //Creamos registro
            LocateRegistry.createRegistry(1099);
            
            //Ligamos el objeto al nombre que le demos
            Naming.bind("ServicioCalculadora", calc);
            
            //Info de server
            System.out.println("[*] Calculadora lista para recibir operaciones.");
        }
        catch (Exception e){
            System.err.println("[!] Error al iniciar el servidor: " + e);
            e.printStackTrace();
        }
        
    }
    
}
