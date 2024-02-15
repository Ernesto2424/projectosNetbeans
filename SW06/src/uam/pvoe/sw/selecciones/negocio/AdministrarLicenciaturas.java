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
import uam.pvoe.sw.selecciones.clases.Licenciatura;

/**
 *
 * @author
 */
public class AdministrarLicenciaturas {
    
    
      public LinkedList<Licenciatura> listaLicenciaturas() {
        String cadenaLeida = "";
        FileReader fr;
        LinkedList <Licenciatura> listaLicenciaturas = new LinkedList();
        try {
            fr = new FileReader("licenciaturas.dat");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {
                Licenciatura licenciatura = new Licenciatura();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                licenciatura.setClave(st.nextToken());
                licenciatura.setNombre(st.nextToken());
                listaLicenciaturas.add(licenciatura);
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
        
        return listaLicenciaturas;
    }
    
    
    
}
