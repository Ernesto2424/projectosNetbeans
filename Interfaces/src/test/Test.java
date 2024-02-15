package test;

import accesoDatos.*;

public class Test {

    public static void main(String[] args) {
        AccesoDatos datos = new Implementacion();
        imprimir(datos);
        System.out.println("");
        datos = new ImplementacionOracle();
        imprimir(datos);
    }

    public static void imprimir(AccesoDatos datos){
        datos.listar();
    }
    
}
