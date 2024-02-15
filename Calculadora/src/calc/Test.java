
package calc;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        double l,ba,h,r;
        double a ,b;
       
       // ba = sc.nextDouble();
       // h = sc.nextDouble();
       // r = sc.nextDouble();
       
        Calculadora c1 = new Calculadora();
         a = sc.nextDouble();
        b = sc.nextDouble();
      // l = sc.nextDouble(); 
        //System.out.println("El area del cuadrado es : " + c1.AreaCuadrado(l)+ " U");
        double res =0;
       try{
        System.out.println(c1.división(a, b));   
       }catch (Exception ex){
           System.out.println("division entre cero no es valida");
       }
               
        
         
        
        
        
        
    }
    
    
}
