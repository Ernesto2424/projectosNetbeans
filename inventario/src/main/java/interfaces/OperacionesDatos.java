package interfaces;

import java.util.List;

/**
 * Interfaz generica que contiene metodos
 * para la insercción y recuperación de datos
 * de una BD.
 * 
 * @author Ernesto F.
 * @param <T> Interfaz generica para las clases DAO
 */
public interface OperacionesDatos <T>{
    
    /**
     * Este metodo sirve para la insercción de datos
     * del objeto que sea pasado como parametro.
     * 
     * @param objeto recibe un objeto de cualquier tipo.
     * @return regresa un objeto para la comprobación de la inserccion.
     */
    T INSERT(T objeto);
    
    
    /**
     * Recupera registros y los guarda en una lista.
     * 
     * @return Lista de objetos de cualquier tipo. 
     */
    List<T> SELECT();
    
    /**
     * Recupera un registro a traves de su identificador.
     * 
     * @param id identificador del objeto a recuperar.
     * 
     * @return Objeto con base a su identificador (id).
     */
     T SELECT_BY_ID(T id);
    
}
