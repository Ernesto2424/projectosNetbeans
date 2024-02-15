
import java.util.*;


public class Main {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Item i0= new Item();
        Item i1= new Item("ESPADA","METAL",100,100,100,100);
        Personaje p1 = new Personaje();
        p1.setNombre("NETO");
        p1.setHabilidad(100);
        p1.setEnergia(100);
        
        
        p1.setItem(i1);
        System.out.println(p1.convierteACadena());
        
        
        
        
    }
    
    
    
}
