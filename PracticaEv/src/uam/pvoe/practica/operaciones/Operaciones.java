/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.practica.operaciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.pvoe.practica.modelo.Atractivo;
import uam.pvoe.practica.modelo.Estado;

/**
 *
 * @author
 */
public class Operaciones {
    
    /*Cargar del archivo los estados*/
    public LinkedList<Estado>llenarListaEstados(){
         String cadenaLeida = "";
        FileReader fr;
        LinkedList <Estado> listaEstados = new LinkedList();
        try {
            fr = new FileReader("estados.dat");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {
                Estado estado = new Estado();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                estado.setNombre(st.nextToken());
                estado.setClave(st.nextToken());
                listaEstados.add(estado);
                
                
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
        
        
        return listaEstados;
    }
    
    
    /*Cargar del archivo los atractivos de un estado*/
    public LinkedList<Atractivo>llenarListaAtractivos(String claveEstado){
        LinkedList<Atractivo> listaAtractivos = new LinkedList();        
        String cadenaLeida = "";
        FileReader fr;
        
        try {
            fr = new FileReader("atractivos.dat");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while(cadenaLeida!=null){
                Atractivo atractivo = new Atractivo();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                
                atractivo.setAtractivo(st.nextToken());
                atractivo.setNombre(st.nextToken());
                atractivo.setClave(st.nextToken());
                
                if(atractivo.getClave().compareTo(claveEstado)==0){
                    listaAtractivos.add(atractivo);
                }
                cadenaLeida = archivoLectura.readLine();
                
            }
            archivoLectura.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaAtractivos;
    }
    
    
    
    
}
