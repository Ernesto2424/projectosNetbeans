/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.sw.selecciones.negocio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import uam.pvoe.sw.selecciones.clases.Alumno;

/**
 *
 * @author
 */
public class AdministrarAlumnos {
    
    
    public LinkedList<Alumno> listaPorCarrera(String claveLicenciatura){
        
        LinkedList<Alumno> listaAlumnos = new LinkedList(); 
        
        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("alumnos.dat");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {
                Alumno alumno = new Alumno();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                
                alumno.setMatricula(st.nextToken());
                alumno.setNombre(st.nextToken());
                alumno.setPrimerApellido(st.nextToken());
                alumno.setSegundoApellido(st.nextToken());
                alumno.setLicenciatura(st.nextToken());
                
                if(alumno.getLicenciatura().compareTo(claveLicenciatura) == 0){
                    listaAlumnos.add(alumno);
                    
                }
                
               
                cadenaLeida = archivoLectura.readLine();
            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }
        
        
        return listaAlumnos;
        
    }
    
}
