package mx.com.fm.peliculas.negocio;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.fm.peliculas.datos.AccesoDatos;
import mx.com.fm.peliculas.datos.AccesoDatosImp;
import mx.com.fm.peliculas.domain.Pelicula;
import mx.com.peliculas.excepciones.AccesoDatosEx;
import mx.com.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImp implements CatalogoPeliculas{
    
    private final AccesoDatos datos;
    
  
    
    public CatalogoPeliculasImp(){
    this.datos =  new AccesoDatosImp();
    }

    

  

    @Override
    public void agregarPeliculas(String nombrePelicula) {  
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
            
        }
        
    }

    @Override
    public void listarPelculas() {
        try {
            List lista;
           lista = datos.listar(NOMBRE_ARCHIVO);
           for(Object pelicula: lista){
               System.out.println("pelicula = " + pelicula);
           }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al listar peliculas");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
             resultado = datos.buscar(NOMBRE_ARCHIVO, buscar);
            
        } catch (AccesoDatosEx ex) {
            System.out.println("error al buscar pelicula");
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarArchivo() {
        try {
            if(datos.existe(NOMBRE_ARCHIVO)){
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);
            }else{
                datos.crear(NOMBRE_ARCHIVO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }

    
}
