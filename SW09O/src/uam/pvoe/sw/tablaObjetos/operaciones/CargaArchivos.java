/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.sw.tablaObjetos.operaciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import uam.pvoe.sw.tablaObjetos.modelo.Alumno;
import uam.pvoe.sw.tablaObjetos.modelo.AlumnoExamen;
import uam.pvoe.sw.tablaObjetos.modelo.Examen;


/**
 *
 * @author
 */
public class CargaArchivos {
    
    /*Recupera los alumnos del archivo*/
    public LinkedList<Alumno> listaAlumnos(){
        
        LinkedList<Alumno> listaAlumnos = new LinkedList(); 
        
        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("alumnos.txt");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {
                Alumno alumno = new Alumno();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                
                alumno.setMatricula(st.nextToken());
                alumno.setNombre(st.nextToken());
                alumno.setPrimerApellido(st.nextToken());
                alumno.setSegundoApellido(st.nextToken());

                listaAlumnos.add(alumno);
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
    
    /*Recupera los examenes del archivo*/
    public LinkedList<Examen> listaExamenes(){
        
        LinkedList<Examen>listaExamenes = new LinkedList();
        
        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("examenes.txt");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {
                Examen examen = new Examen();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");

                examen.setId_examen(Integer.parseInt(st.nextToken()));
                examen.setNombre(st.nextToken());
                listaExamenes.add(examen);
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
        
        
        return listaExamenes;
        
    }
    
    /*Recupera las calificaciones del archivo*/
    public LinkedList<AlumnoExamen>listaCalificaciones(){
        
        LinkedList<AlumnoExamen>listaCalificaciones = new LinkedList();
        
           String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("alumno_examen.txt");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {
                AlumnoExamen calificacion = new AlumnoExamen();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");

                
                calificacion.setMatricula(st.nextToken());
                calificacion.setId_examen(Integer.parseInt(st.nextToken()));
                calificacion.setCalificacion(st.nextToken());
   
                listaCalificaciones.add(calificacion);
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
        
        
        return listaCalificaciones;
        
    }
    
    
}
