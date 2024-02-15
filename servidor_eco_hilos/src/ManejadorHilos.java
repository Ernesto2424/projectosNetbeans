
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ManejadorHilos implements Runnable{
    
    private Socket entrante;
    private int contador;
    
    public ManejadorHilos(Socket entrante, int contador){
        this.entrante = entrante;
        this.contador = contador;
    }

    @Override
    public void run() {
        
     try
     {
         DataInputStream entrada = new DataInputStream(entrante.getInputStream());
         DataOutputStream salida = new DataOutputStream(entrante.getOutputStream());
         
         salida.writeUTF("Escriba ADIOS para finalizar");
         
         boolean terminado = false;
         
         while(!terminado){
             String linea = entrada.readUTF();
             salida.writeUTF("ECO: "+linea);
             if(linea.trim().equalsIgnoreCase("ADIOS"));
             terminado = true;
         }
         entrante.close();
     }
     catch(IOException e)
     {
         e.printStackTrace();
     }
     
    }
    
    
}
