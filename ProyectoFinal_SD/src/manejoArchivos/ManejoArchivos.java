/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author leond
 */
public class ManejoArchivos {
    public static String leerArchivoCadena(String nombre){
    String resultado = "";
    File archivo = new File(nombre);
    try {
        BufferedReader entrada = new BufferedReader(new FileReader(archivo));
        String lectura = entrada.readLine();
        while(lectura != null){
            resultado+=lectura;
            //System.out.println("lectura = " + lectura);
            lectura = entrada.readLine();
        }
        entrada.close();
    } catch (FileNotFoundException ex) {
        //ex.printStackTrace(System.out);
    } catch (IOException ex) {
        ex.printStackTrace(System.out);
    }
    if("".equals(resultado)){
        resultado = "INGRESE UN ESTADO EXISTENTE";
    }
    return resultado;
    
}
}
