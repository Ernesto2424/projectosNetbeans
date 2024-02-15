
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class ServidorChat {
  
  private static int port = 1001;
public static void main(String[] args) throws IOException {
try {
ServerSocket servidor = new ServerSocket(port);
Socket cliente = servidor.accept();
String direccion = cliente.getInetAddress().getCanonicalHostName();
BufferedReader entrada = new BufferedReader(new
InputStreamReader(cliente.getInputStream()));
PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
salida.println("Aceptando conexión con " + direccion);
String mensajeDelCliente;
String mensajeConsola;
boolean terminado = false;
		while (!terminado) 
		{       mensajeDelCliente = entrada.readLine();
			System.out.println("cliente>> " + mensajeDelCliente);
			System.out.print("servidor>> ");
			mensajeConsola = teclado.readLine();
			salida.println(mensajeConsola);
                        if (mensajeDelCliente.trim().equals("ADIOS"))
		terminado = true;
		}
} catch (IOException e) {System.err.println(e);}}

}