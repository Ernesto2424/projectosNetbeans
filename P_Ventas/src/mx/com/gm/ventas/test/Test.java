package mx.com.gm.ventas.test;

import mx.com.gm.ventas.*;

public class Test {
    
    public static void main(String[] args) {
        Producto producto1 = new Producto("camisa", 50.00);
        Producto producto2 = new Producto("pantalon", 100.00);
        Producto producto3 = new Producto("calcetines", 30.00);
        Producto producto4 = new Producto("short", 150.00);
        Producto producto5 = new Producto("blusa", 80.00);
        Producto producto6 = new Producto("playera ", 99.40);
        Producto producto7 = new Producto("tennnis", 500.00);
        Producto producto8 = new Producto("zapatos", 450.80);
        Producto producto9 = new Producto("sueter", 130.00);
        Producto producto10 = new Producto("chaleco", 85.50);
        
        Orden orden1 = new Orden();
        Orden orden2 = new Orden();
        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);
        
        orden2.agregarProducto(producto3);
        orden2.agregarProducto(producto2);
        orden2.agregarProducto(producto6);
        orden2.agregarProducto(producto6);
        orden2.agregarProducto(producto6);
        orden2.agregarProducto(producto6);
        orden2.agregarProducto(producto6);
        orden2.agregarProducto(producto6);
          
        
        orden1.mostarOrden();
        System.out.println("\n");
        orden2.mostarOrden();
    }
    
}
