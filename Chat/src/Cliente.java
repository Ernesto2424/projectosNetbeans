
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
try {
Socket servidor = new Socket("127.0.0.1",8189);
DataInputStream entrada = new DataInputStream(servidor.getInputStream());            
DataOutputStream salida = new DataOutputStream(servidor.getOutputStream());
String mensajeEntrada = "";
String mensajeSalida = "";
BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
do {
mensajeEntrada = entrada.readUTF();
System.out.println(mensajeEntrada);
mensajeSalida = consola.readLine();
salida.writeUTF(mensajeSalida);
}while(!mensajeSalida.equalsIgnoreCase("ADIOS"));
servidor.close();
}catch(IOException e) {e.printStackTrace(); }
}
    
}
/*System.out.println("servidor>> " + mensajeServidor);
System.out.print("cliente>> ");
mensajeConsola = teclado.readLine();
salida.println(mensajeConsola);*/
