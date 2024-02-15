package test;

import domain.*;

public class Test {

    public static void main(String[] args) {
        
        //las clases abstractas no pueden ser instanciadas, solo heredadas
        Figura figura = new Rectngulo("Rectangulo");
        figura.dibujar();
    }
    
}
