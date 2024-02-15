
package proyecto;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author leond
 */
public class ManejadorHilos implements Runnable
{
    private Socket conexion_entrante;
    private int contador;
    
    //Constructor
    public ManejadorHilos(Socket conexion_entrante, int contador) 
    {
        this.conexion_entrante = conexion_entrante;
        this.contador = contador;
    }
    
    @Override
    public void run()
    {
        try
        {
            try
            {
                //Secuencia de entrada de datos de la conexion
                InputStream secuenciaEntrada = conexion_entrante.getInputStream();

                //Secuencia de salida de datos de la conexino
                OutputStream secuenciaSalida = conexion_entrante.getOutputStream();

                //Para leer lo del teclado
                Scanner entradaTeclado = new Scanner(secuenciaEntrada);

                //Para escribir en pantalla
                PrintWriter salidaPantalla = new PrintWriter(secuenciaSalida, true);

                //Bandera
                boolean bandera = false;
                
                while(!bandera)
                {
                    //Se envia al cliente (1)
                    salidaPantalla.println("[*] ¿De que ciudad quieres conocer los lugares turisticos?");
                    System.out.println("[*] Se mando el prompt al Hilo " + contador); //Info de server
                    
                    //Se recibe la respuesta del cliente (2)
                    String ciudad = entradaTeclado.nextLine();
                    System.out.println("[*] Se recibio la ciudad del Hilo " + contador); //Info de server
                    
                    //Se manda la resupuesta a la solicitud (3)
                    String respuesta = getLugares(ciudad);
                    salidaPantalla.println("[*] Respuesta: "+ ciudad +
                            "\nLugares: "+ respuesta +".");
                    System.out.println("[*] Se enviaron los lugares al Hilo " + contador); //Info de server
                    
                    //Confirmacion de continuacion (4)
                    salidaPantalla.println("[*] ¿Quieres continuar? (SI / NO)");
                    String confirmacion = entradaTeclado.nextLine();
                    
                    //Condicion de salida (5)
                    if(confirmacion.equalsIgnoreCase("N") || confirmacion.equalsIgnoreCase("NO")
                            || confirmacion.equalsIgnoreCase("ADIOS"))
                    {
                        bandera = true;
                    }
                }
                //Despedida
                //salidaPantalla.println("[*] Adios");
            }
            catch(NoSuchElementException ex) //Se arreglo el error del servidor cuando un hilo se cierra
            {
                System.out.println("[*] Cliente con Hilo " + contador + " desconectado."); //Info de server
            }
            finally
            {
                conexion_entrante.close();
                System.out.println("[*] Hilo "+ contador + " finalizado"); //Info de server
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Metodo para obtener los lugares turisticos dependiendo de la ciudad
     * @param ciciudadudad
     * @return lugares
     */
    private String getLugares(String ciudad)
    {
        String lugares = "";
        ciudad = ciudad.toUpperCase();
        
        if(ciudad.equals("CDMX"))
        {
            lugares = "Zocalo, Bellas Artes, Torre Latino";
        }
        else if(ciudad.equals("GUADALAJARA"))
        {
            lugares = "Puerto Vallarte, Tequila, Tlaquepaque";
        }
        else if(ciudad.equals("PUEBLA"))
        {
            lugares = "Atlixco, Africam Safari, Chignahuapan";
        }
        else if(ciudad.equals("VERACRUZ"))
        {
            lugares = "Baluarte de santiago, Boca del rio, Museo del cafe";
        }
        else if(ciudad.equals("HIDALGO"))
        {
            lugares = "Prismas basalticos, Museo de los duendes, Dinoparque";
        }
        else
        {
            lugares = "[!] Esa ciudad no esta en la base de datos";
        }
        return lugares;
    }
}
