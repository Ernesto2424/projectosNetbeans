package test;
 
import Dominio.Cliente;
import Dominio.Empleado;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
//        Empleado empleado1 = new Empleado("Ernesto", 5000.0);
//        System.out.println(empleado1);
//          Empleado empleado2 = new Empleado("Mariana", 4000.0);
//        System.out.println(empleado2);

        Cliente cliente = new Cliente("Ernesto", 'M', 21, "mi direccion", new Date(), true);
        Cliente cliente2 = new Cliente("Ernesto", 'M', 21, "mi direccion", new Date(), true);
        System.out.println(""+cliente+"\n"+cliente2);
    }

    
}
