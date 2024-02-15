package mx.com.peliculas.presentacion;

import java.util.Scanner;
import mx.com.fm.peliculas.negocio.CatalogoPeliculas;
import mx.com.fm.peliculas.negocio.CatalogoPeliculasImp;

public class PeliculasPresemtacion {

    public static void main(String[] args) {
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        
        CatalogoPeliculas catalogo = new CatalogoPeliculasImp();
        
        
        
        
        while(opcion != 0){
            System.out.println("Elige una opcion\n"
            +"1. INICIAR CATALOGO DE PELICULAS\n"
            +"2. AGREGAR PELICULA\n"
            + "3. LISTAR PELICULAS\n"
            + "4. BUSCAR PELICULA\n"
            + "0. SALIR");
            
            opcion = Integer.parseInt(sc.nextLine());
            
            switch(opcion){
                case 1: 
                catalogo.iniciarArchivo();
                break;
                
                   case 2: 
                System.out.println("INGRESE NOMBRE DE LA PELICULA");
                String nombrePelicula = sc.nextLine();
                catalogo.agregarPeliculas(nombrePelicula);
                break;
                
                   case 3:
                    catalogo.listarPelculas();
                    break;
                    
                   case 4:
                       System.out.println("INGRESE PELICULA A BUSCAR");
                       String buscar;
                       buscar = sc.nextLine();
                       catalogo.buscarPelicula(buscar);
                       break;
                    
                   case 0:
                       System.out.println("hasta pronto");
                       break;
                       
                    default:
                        System.out.println("opcion no reconocida");
                        break;
            }
            
        }
    }



    
}
