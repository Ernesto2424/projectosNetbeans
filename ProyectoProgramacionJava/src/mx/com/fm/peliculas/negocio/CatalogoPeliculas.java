package mx.com.fm.peliculas.negocio;

public interface CatalogoPeliculas {
    
    String NOMBRE_ARCHIVO = "peliculas.txt";

    void agregarPeliculas(String nombrePelicula);
    
    void listarPelculas();
    
    void buscarPelicula(String buscar);
    
    void iniciarArchivo();
}
