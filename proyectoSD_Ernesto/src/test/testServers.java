/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Personal
 */
public class testServers {
    
    public static void main(String[] args) {
        
        RMI.TurismoServer.iniciarServidorRMI();
        Sockets.Servidor.iniciarServidorSockets();
    }
    
    
}
