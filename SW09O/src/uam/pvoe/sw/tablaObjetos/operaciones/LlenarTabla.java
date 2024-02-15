/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.sw.tablaObjetos.operaciones;

import java.util.LinkedList;
import java.util.Vector;
import uam.pvoe.sw.tablaObjetos.modelo.Alumno;
import uam.pvoe.sw.tablaObjetos.modelo.AlumnoExamen;
import uam.pvoe.sw.tablaObjetos.modelo.Examen;
import uam.pvoe.sw.tablaObjetos.modelo.Promedio;


/**
 *
 * @author
 */
public class LlenarTabla {
    
    /*
     * Llena los datos de los títulos de las
     * columnas a partir de los nombres de los
     * exámenes
     */
    public Vector<String>tituloColumnas(){
        Vector<String>listaTitulos = new Vector();
        
        CargaArchivos cargar = new CargaArchivos();
        LinkedList<Examen>listaExamenes = new LinkedList();
        listaExamenes = cargar.listaExamenes();
        
        for(int i=0;i<listaExamenes.size();i++){
            Examen examenAux = listaExamenes.get(i);
            String aux = new String();
            aux = examenAux.getNombre();
            listaTitulos.add(aux);
        }
        
        String alumno = "Alumno";
        listaTitulos.add(0, alumno);
        
        String promedio = "Promedio";
        listaTitulos.add(listaTitulos.size(),promedio);
       
        return listaTitulos;
        
    }
    
    /*
     * Llena los datos de la celda a partir de la
     * información de los alumnos, los exámenes
     * y las calificaciones de cada alumno 
     * para cada examen
     */
    public Vector elementosCelda(){
         Vector filas = new Vector();
         Vector<Object>fila;
          CargaArchivos cargar = new CargaArchivos();
          
         LinkedList<Alumno>listaAlumnos = new LinkedList();
         LinkedList<Examen>listaExamenes = new LinkedList();
         LinkedList<AlumnoExamen>listaCalificaciones = new LinkedList();
  
         int nAlumnos;

         listaAlumnos = cargar.listaAlumnos();
         nAlumnos = listaAlumnos.size();
         
         listaExamenes = cargar.listaExamenes();
         float nExamenes = listaExamenes.size();
         
         listaCalificaciones = cargar.listaCalificaciones();
       
         for(int i=0;i<nAlumnos;i++){
             fila = new Vector();
             
             Alumno alumno = listaAlumnos.get(i);
             
             float promedioAlumno = 0F;
             float sumatoria = 0F;
             fila.add(alumno);
             
             int contadorAux = 0;
             
             for(int j=contadorAux;j<listaCalificaciones.size();j++){
                 
                 AlumnoExamen aluEx = listaCalificaciones.get(j);
                 if(alumno.getMatricula().compareTo(aluEx.getMatricula())==0){
                     AlumnoExamen elemento = new AlumnoExamen();
                    
                     elemento.setId_examen(aluEx.getId_examen());
                     elemento.setMatricula(aluEx.getMatricula());
                     
                     if(aluEx.getCalificacion().compareTo("NA") == 0){
                         elemento.setCalificacion("0");
                     }else{
                         elemento.setCalificacion(aluEx.getCalificacion());
                     }
                     
                     sumatoria += Float.parseFloat(elemento.getCalificacion());
                     promedioAlumno = sumatoria/nExamenes;

                     contadorAux += 1;
                     fila.add(elemento);
                     
                 }
                 aluEx = new AlumnoExamen();
                 
             }
             Promedio promedio = new Promedio();
             promedio.setPromedio(""+promedioAlumno);
             promedio.setMatriculaAlumno(alumno.getMatricula());
             fila.add(promedio);
             
             alumno = new Alumno();
             filas.add(fila);
         }
         
         
         return filas;
        
    }
    
    
}
