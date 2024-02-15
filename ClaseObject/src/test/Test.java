package test;

import domain.Empleado;
import domain.Escritor;
import domain.TipoEscritura;

public class Test {
    public static void main(String[] args) {
        Empleado empleado;
        empleado = new Escritor("Ernesto", 1000, TipoEscritura.CLASICO);
        System.out.println(empleado.obtenerDetalles());
        
        //estamos convirtiendo una referencia del tipo padre a hijo (Downcasting)
        //((Escritor)empleado).getTipoEscritura();
        //esta es otra forma 
        Escritor escritor = (Escritor) empleado;
        
        //estamos convirtiendo una referencia del tipo hijo a padre (Upcasting)
        Empleado empleado2 = escritor;
        System.out.println(empleado2.getNombre());
        System.out.println(empleado2.obtenerDetalles());
    }
    
}
