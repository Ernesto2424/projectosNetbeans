/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPC;

import org.apache.xmlrpc.WebServer;

/**
 *
 * @author leond
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            //Mensaje de servidor
            System.out.println("[*] Iniciando el servidor ...");
            
            //Declaracion del servidor
            WebServer server = new WebServer(80);
            
            //Instancia de los procedimientos
            logicaServidor proc = new logicaServidor();
            
            //Nombre del servidor y donde se encuentran sus procedimientos
            server.addHandler("Turismo", proc);
            
            //Se inicia server
            server.start();
        }
        catch(Exception e){
            System.err.println("[!] Error en el servidor: " + e);
            e.printStackTrace();
        }
        
    }
    
}
