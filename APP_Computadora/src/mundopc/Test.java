package mundopc;

import com.ef.mundopc.*;

public class Test {

    public static void main(String[] args) {
        
        Monitor monitor1 = new Monitor("HP", 250);
        Raton raton1 = new Raton("USB", "HP");
        Teclado teclado1 = new Teclado("INALAMBRICO", "HP");
        Computadora computadora1 = new Computadora("HP 2500", monitor1, teclado1, raton1);
        
        Monitor monitor2 = new Monitor("ACER", 300);
        Raton raton2 = new Raton("INALAM", "LOGITECH");
        Teclado teclado2 = new Teclado("USB", "ACER");
        Computadora computadora2 = new Computadora("ACER E0450", monitor2, teclado2, raton2);
        
        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadora1);
        orden1.agregarComputadora(computadora2);
        orden1.agregarComputadora(computadora1);
        orden1.agregarComputadora(computadora2);
        orden1.agregarComputadora(computadora1);
        orden1.agregarComputadora(computadora2);
        orden1.agregarComputadora(computadora1);
        orden1.agregarComputadora(computadora2);
        orden1.agregarComputadora(computadora1);
        orden1.agregarComputadora(computadora2);
        
        orden1.agregarComputadora(computadora1);
        orden1.agregarComputadora(computadora2);
        orden1.mostrarOrden();
        System.out.println("\n");
        Orden orden2 = new Orden();
        orden2.agregarComputadora(computadora1);
        orden2.agregarComputadora(computadora2);
        orden2.agregarComputadora(computadora1);
        orden2.agregarComputadora(computadora2);
        orden2.agregarComputadora(computadora1);
        orden2.agregarComputadora(computadora2);
        orden2.agregarComputadora(computadora1);
        orden2.agregarComputadora(computadora2);
        orden2.agregarComputadora(computadora1);
        orden2.agregarComputadora(computadora2);
         orden2.agregarComputadora(computadora1);
        orden2.agregarComputadora(computadora2);
        orden2.agregarComputadora(computadora1);
        orden2.agregarComputadora(computadora2);
        orden2.agregarComputadora(computadora1);
        orden2.agregarComputadora(computadora2);
        orden2.agregarComputadora(computadora1);
        orden2.agregarComputadora(computadora2);
        orden2.agregarComputadora(computadora1);
        orden2.agregarComputadora(computadora2);
        orden2.mostrarOrden();
    }


    
}
