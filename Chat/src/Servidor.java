
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
 public static void main(String[] args) {
try {
ServerSocket servidor = new ServerSocket(8189);
Socket cliente = servidor.accept();
DataInputStream entrada = new DataInputStream(cliente.getInputStream());
DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
salida.writeUTF("Escriba ADIOS para salir");
boolean terminado = false;
while (!terminado)
{
String linea = entrada.readUTF();
salida.writeUTF("Eco: " + linea);
if (linea.trim().equals("ADIOS"))
terminado = true;
}
cliente.close();
}
catch (IOException e) {e.printStackTrace();}
    
}    
} 
/* mensajeDelCliente = entrada.readLine();
    System.out.println("cliente>> " + mensajeDelCliente);
    System.out.print("servidor>> ");
    mensajeConsola = teclado.readLine();
    salida.println(mensajeConsola);*/
