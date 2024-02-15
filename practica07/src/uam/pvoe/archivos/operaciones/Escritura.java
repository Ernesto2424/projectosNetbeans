
package uam.pvoe.archivos.operaciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import uam.pvoe.archivos.clases.Alumno;

public class Escritura {
    
    public void escribir(String nombreArchivo, Alumno alumno){
        
        System.out.println("Escribiendo informacion el el archivo");
        
        try {
            FileWriter fw = new FileWriter(nombreArchivo);
            BufferedWriter archivoEscritura = new BufferedWriter(fw);
            String almacenar = alumno.toString();
            archivoEscritura.write(almacenar);
            archivoEscritura.flush();
            archivoEscritura.close();
        } catch (Exception e) {
            System.out.println("ERROR AL ESCRIBIR");
        }
        
        
    }
    
}
