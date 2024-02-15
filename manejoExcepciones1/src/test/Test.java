package test;

import aritmetica.Aritmetica;
import exepcion.OperacionExcepcion;

public class Test {

    public static void main(String[] args) {
       
        int resultado =0;
        try {
        resultado = Aritmetica.division(10, 0);
         System.out.println(resultado);
        }catch(OperacionExcepcion e){
            System.out.println("ocurrio un error del tipo operacion excpction");
        }catch (Exception e) {
            System.out.println("No se puede dividir entre cero");
            e.printStackTrace(System.out);
            System.out.println(e.getMessage());
            
        }
        finally{
            System.out.println("se reviso la divison entre cero");
        }
       
        
        
    }
    
}
