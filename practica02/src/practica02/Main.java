
package practica02;
import java.util.*;


public class Main {
    
      
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int datoEnetero ;
        float datoFlotante = 25.34F;
        double datoDoble = 273.57;
        boolean datoBooleano = true;
        char datoCarater = 'a';
        
        //System.out.println("Un entero: " + datoEnetero);
        System.out.println("Un flotante: " + datoFlotante);
        System.out.println("Un doble: " + datoDoble);
        System.out.println("Un booleano: " + datoBooleano);
        System.out.println("Un caracter: " + datoCarater);
        
        System.out.println("ingrese un entero");
        int datoEntero = sc.nextInt();
        System.out.println("ingrese un flotante");
        datoFlotante = sc.nextFloat();
        System.out.println("ingrese un doble");
        datoDoble = sc.nextDouble();
        System.out.println("ingrese un booleano");
        boolean datoBoolano = sc.nextBoolean();
        
         String cadena = "";
        String cadenaCaracteres = new String();
        String cadenaValor = new String ("valor de la cadena");
        
        
        System.out.println("leyendo cadena con nextLine: ");
        cadena = sc.nextLine();
        System.out.println("leyendo cadena con next (no lee esoacios) ");
        cadenaCaracteres = sc.next();
         
        System.out.println(cadena);
        System.out.println(cadenaCaracteres);
        System.out.println(cadenaValor);
        
    
        
      
    }
    
}
