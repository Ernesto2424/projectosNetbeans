
package Trasporte;


public class Test {
    
    public static void main(String[] args){
        
        Bicicleta b = new Bicicleta(20, "rojo", "montauin", "g15", "montaña");
        //System.out.println(b);
        Carro c = new Carro("Suburban", 10, 1500, "CHEVROLET", "2015", "Deportivo");
        //System.out.println(c);
        c.avanza();
        b.avanza();
        
        Vehiculo v[ ] = new Vehiculo[2];
        v[0]=b;
        v[1]=c;
        System.out.println(v[0]);
        System.out.println(v[1]);
        
        
        
    } 
    
}
