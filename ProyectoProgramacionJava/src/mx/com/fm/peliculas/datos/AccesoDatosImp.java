package mx.com.fm.peliculas.datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import mx.com.fm.peliculas.domain.Pelicula;
import mx.com.peliculas.excepciones.AccesoDatosEx;
import mx.com.peliculas.excepciones.EscritutaDatosEx;
import mx.com.peliculas.excepciones.LecturaDatosEx;

public class AccesoDatosImp implements AccesoDatos{

    @Override
    public boolean existe(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        File archivo = new File(nombre);
        List<Pelicula> lista =new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while(linea != null){
                Pelicula pelicula = new Pelicula(linea);
                lista.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al listar peliculas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
             throw new LecturaDatosEx("Error al leer datos" + ex.getMessage());
            
        }
        
        return lista;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscritutaDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscritutaDatosEx("Error al escribir en el archivo" +ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {

        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int indice = 1;
            linea = entrada.readLine();
            while(linea!=null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                   resultado = "Pelicula "+linea+" encontrada en el indice "+indice;
                   break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al buscar pelicula"+ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al buscar pelicula"+ex.getMessage());
        }
        
        
        return resultado;
        
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
       File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Error al crear el archivo "+ex.getMessage());
        }
        
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
       if(archivo.exists())
        archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }

   
    
}
