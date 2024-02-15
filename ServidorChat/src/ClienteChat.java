
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClienteChat {
    private static int port = 1001;
private static String host = "localhost";
public static void main (String[] args) throws IOException
{
try
{
Socket server = new Socket(host, port);
PrintWriter salida = new PrintWriter(server.getOutputStream(), true);
BufferedReader entrada = new BufferedReader(new
InputStreamReader(server.getInputStream()));
BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
String mensajeServidor;
String mensajeConsola;
mensajeServidor = entrada.readLine();
while (!mensajeServidor.equalsIgnoreCase("ADIOS"))
{
System.out.println("servidor>> " + mensajeServidor);
System.out.print("cliente>> ");
mensajeConsola = teclado.readLine();
salida.println(mensajeConsola);
}
server.close();

}
catch (UnknownHostException e) {System.err.println(e);}}
    
}
