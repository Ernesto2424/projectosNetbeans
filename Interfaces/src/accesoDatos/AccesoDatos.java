package accesoDatos;

public interface AccesoDatos {

/*
    una clase abstracta se debe usar mas que nada en la herencia
    es decir cuando las caracteristicas de clases son parecidas
    
    uina interfaz se debe usar cunado el comportamniento es parecido
    */

    //UNA CONSTANTE LLEVA "public static final" variable = #valor;
    int MAX_REGISTROS = 10;
    
    void insertar();
    
    void listar();
    
    void actualizar();
    
    void eliminar();
    
    
}
