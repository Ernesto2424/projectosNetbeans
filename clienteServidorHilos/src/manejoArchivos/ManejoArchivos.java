package manejoArchivos;

import java.io.*;





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
    File archivo = new File(nombre);
    try {
        BufferedReader entrada = new BufferedReader(new FileReader(archivo));
        String lectura = entrada.readLine();
        while(lectura != null){
            System.out.println("lectura = " + lectura);
            lectura = entrada.readLine();
        }
        entrada.close();
    } catch (FileNotFoundException ex) {
        ex.printStackTrace(System.out);
    } catch (IOException ex) {
        ex.printStackTrace(System.out);
    }
    
}

public static String leerArchivoCadena(String nombre){
    String resultado = null;
    File archivo = new File(nombre);
    try {
        BufferedReader entrada = new BufferedReader(new FileReader(archivo));
        String lectura = entrada.readLine();
        while(lectura != null){
            resultado+=lectura + "\n";
            //System.out.println("lectura = " + lectura);
            lectura = entrada.readLine();
        }
        entrada.close();
    } catch (FileNotFoundException ex) {
       // ex.printStackTrace(System.out);
    } catch (IOException ex) {
        ex.printStackTrace(System.out);
    }
    return resultado;
    
}
    
}
