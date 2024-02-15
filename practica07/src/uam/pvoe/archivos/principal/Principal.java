package uam.pvoe.archivos.principal;

import uam.pvoe.archivos.clases.Alumno;
import uam.pvoe.archivos.operaciones.Escritura;
import uam.pvoe.archivos.operaciones.Lectura;


public class Principal {
    public static Alumno leerAlumno(){
        Alumno alumno = new Alumno();
        alumno.setNombre("name of student");
        alumno.setIdAlumno(1);
        alumno.setLicenciatura("computing");
        return alumno;

}
    public static void guardarAlumno(Alumno alumno){
        Escritura escribir = new Escritura();
        escribir.escribir("datosAlumnos.txt", alumno);
    }
    
    public static void cargarAlumnos(){
        Lectura leer = new Lectura();
        leer.leer("datosAlumnos.txt");
    }
    public static void main(String[] args) {
        Alumno alumno;
        alumno=leerAlumno();
        guardarAlumno(alumno);
        cargarAlumnos();
        
    }
    
}


