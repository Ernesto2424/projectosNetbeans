
package proyecto;
import java.net.*;
import java.io.*;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leond
 */
public class Servidor {

    public static void main(String[] args) {
        try {
            //Creacion del servidor
            ServerSocket servidor = new ServerSocket(1234);
            
            //Info a la consola
            System.out.println("[*] Servidor en línea en el puerto: " + servidor.getLocalPort());
            int contador_hilo = 1;
            int hilos_activos = 0;
            
            //bandera
            boolean bandera = true;
            
            //El servidor estara online siempre
            while(bandera){
                
                //Aceptando clientes
                Socket cliente = servidor.accept();
                
                //Aviso de generacion de hilos
                System.out.println("[Info] Generando Hilo "+ contador_hilo + ".");
                
                //Se crea una variable ejecutable
                Runnable ejecutar = new ManejadorHilos(cliente, contador_hilo);
                
                //Creacion del hilo
                Thread hilo = new Thread(ejecutar);
                
                //Iniciamos el hilo
                hilo.start();
                
                //Avanzamos el contador
                contador_hilo++;
                
                /* NO FUNCIONA
                hilos_activos = Thread.activeCount();
                
                //Condicion para salir del servidor -> falta la condicion para salir del servidor
                if(hilos_activos > 1)
                {
                    System.out.println("Hilos activos: " + hilos_activos);
                    bandera = true;
                }
                else if(hilos_activos == 1)
                {
                    bandera = false;
                    servidor.close();
                }*/
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hasata pronto");
        }
    }
}
