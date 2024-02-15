/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Ernesto F.
 */
public interface Formato {
    
    List<String> leerArchivo(String nombreArchivo) throws IOException;

    void escribirArchivo(String nombreArchivo, List<String> lineas) throws IOException;
    
}
