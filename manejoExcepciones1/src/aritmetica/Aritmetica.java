package aritmetica;

import exepcion.OperacionExcepcion;

public class Aritmetica {

public static int division(int numerado, int denominador)
            {
    if (denominador == 0){
        //throw - arrojar
        throw  new OperacionExcepcion("DIVISION ENTRE CERO");
    }
    return numerado / denominador;
}

    
}
