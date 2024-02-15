
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorEcoHilos {
    
    public static void main(String[] args) {
        
        try{
            int clienteId = 1;
            ServerSocket servidor = new ServerSocket(8189);
            
            while(true){
                Socket cliente = servidor.accept();
                
                System.out.println("generando hilos "+clienteId);
                Runnable proceso = new ManejadorHilos(cliente, clienteId);
                
                Thread hilo = new Thread(proceso);
                hilo.start();
                clienteId++;
                
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }        
        
        
    }
    
}
