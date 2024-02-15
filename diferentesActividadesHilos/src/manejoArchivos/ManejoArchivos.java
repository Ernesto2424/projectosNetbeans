package manejoArchivos;

import java.io.*;
import hilos.*;





public class ManejoArchivos {

public static void crearArchivo(String nombre){
    File archivo = new File(nombre);
    try {
        PrintWriter salida = new PrintWriter(archivo);
        salida.close();
        System.out.println("se ha creado el archivo");
    } catch (FileNotFoundException ex) {
        ex.printStackTrace(System.out);
    }
}

public static void escribirArchivo(String nombre, String informacion){
   File archivo = new File(nombre);
    try {
        PrintWriter salida = new PrintWriter(archivo);
        salida.println(informacion);
        salida.close();
        System.out.println("se ha escrito en el archivo");
    } catch (FileNotFoundException ex) {
        ex.printStackTrace(System.out);
    } 
}

public static void anexaArchivo(String nombre, String contenido){
    File archivo = new File(nombre);
    try {
        PrintWriter salida = new PrintWriter(new FileWriter(archivo,true));
        salida.println(contenido);
        salida.close();
        System.out.println("se ha anexado informacion al archivo");
    } catch (FileNotFoundException ex) {
        ex.printStackTrace(System.out);
    } catch (IOException ex) {
        ex.printStackTrace(System.out);
    } 
}

public static void leerArchivo(String nombre){
    
    boolean encontrada = false;
    String operacionRealizada = "";
    
    File archivo = new File(nombre);
    try {
        BufferedReader entrada = new BufferedReader(new FileReader(archivo));
        String lectura = entrada.readLine();
        while(lectura != null){
            if(lectura.equalsIgnoreCase(Hilo1.palabra)){
                encontrada = true;
                break;
            }
            //System.out.println("lectura = " + lectura);
            lectura = entrada.readLine();
        }
        entrada.close();
    } catch (FileNotFoundException ex) {
        ex.printStackTrace(System.out);
    } catch (IOException ex) {
        ex.printStackTrace(System.out);
    }
    
    if(encontrada==true){
        operacionRealizada = "palabra ya existente";
    }else{
        ManejoArchivos.anexaArchivo("palabras.txt", Hilo1.palabra);
        operacionRealizada = "Se anexo una nueva palabra al documento";
    }
    
    System.out.println(operacionRealizada);
}


public static int leerArchivoContar(String nombre){
    int numPalabras = 0;
    File archivo = new File(nombre);
    try {
        BufferedReader entrada = new BufferedReader(new FileReader(archivo));
        String lectura = entrada.readLine();
        while(lectura != null){
            ++numPalabras;
            //System.out.println("lectura = " + lectura);
            lectura = entrada.readLine();
        }
        entrada.close();
    } catch (FileNotFoundException ex) {
        ex.printStackTrace(System.out);
    } catch (IOException ex) {
        ex.printStackTrace(System.out);
    }
    
   // System.out.println("numero de palabras en archivo: "+numPalabras);
    return numPalabras;
    
}


    
}
