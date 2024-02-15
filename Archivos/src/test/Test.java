package test;

import manejoArchivos.ManejoArchivos;
import static manejoArchivos.ManejoArchivos.crearArchivo;

public class Test {

    public static void main(String[] args) {
        //String nombreArchivo = "prueba.txt";
        //crearArchivo(nombreArchivo);
//        
//        ManejoArchivos.escribirArchivo("prueba.txt", "Hola desde java");
//        
//        ManejoArchivos.anexaArchivo("prueba.txt", "nueva info");
//        ManejoArchivos.anexaArchivo("prueba.txt", "nueva informacion reciente");
        
        ManejoArchivos.leerArchivo("prueba.txt");
    
    }   
    
}
