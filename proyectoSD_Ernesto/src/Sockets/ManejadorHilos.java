/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import manejoArchivos.*;

/**
 *
 * @author leond
 */
public class ManejadorHilos implements Runnable {

    private Socket entrante;
    private int contador;

    public ManejadorHilos(Socket i, int c) {
        entrante = i;
        contador = c;
    }

    @Override
    public void run() {

        try {

            try {

                InputStream secuenciaEntrada = entrante.getInputStream();
                OutputStream secuenciaSalida = entrante.getOutputStream();
                Scanner in = new Scanner(secuenciaEntrada);

                PrintWriter out = new PrintWriter(secuenciaSalida, true);
                String estados = ManejoArchivos.leerArchivoCadena("ESTADOS.txt");

                out.println("Seleccione un estado: " + estados );

                boolean terminado = false;

                while (!terminado && in.hasNextLine()) {
                    String preg = "     ¿DESEA CONTINUAR?   SI/NO";
                    String linea = in.nextLine();
                    linea.toUpperCase();

                    String doc = ManejoArchivos.leerArchivoCadena(linea.trim() + ".txt");
                    out.println("SERVER: " + doc + " " + preg);
                    String pregunta = in.nextLine();
                    if (pregunta.equalsIgnoreCase("SI")) {
                        out.println("Seleccione un estado: " + estados );
                    } else if (pregunta.equalsIgnoreCase("NO")) {
                        terminado = true;
                        break;
                    }else{
                        terminado = true;
                        break;
                    }

//                    if (linea.trim().equals("ADIOS")) {
//                        terminado = true;
//                        break;
//                    }

                }

            } finally {
                entrante.close();
                System.out.println("Hilo " + contador + " finalizado");
            }
        } catch (IOException e) {
            System.out.println("hasta pronto!");

        }
    }
}
