import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Servidor {
    public static void main(String[] args) {
        // crear el Server socket
        ServerSocket server;
        DataOutputStream salida;
        DataInputStream entrada;
        
        
        try {    
            server = new ServerSocket(1080);
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
        
        
        
    }
    
}
