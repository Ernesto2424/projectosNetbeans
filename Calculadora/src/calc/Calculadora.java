
package calc;

public class Calculadora {
    
    private final double pi = 3.1416;
    
    public Calculadora(){}
    
    public double suma(double a, double b){
        return a+b;
    }
    public double resta(double a, double b){
        return a-b;
    }
    public double multiplicacion(double a, double b){
        return a*b;
    }
    public double división(double a, double b){
        double res = 0;
        try{
            res = a/b;
        }catch(Exception ex){
            System.out.println(ex);
            System.out.println("División no valida");
            res=-1;
        }finally{
            
            return res;
        }
    }
    
    public double AreaCirculo(double r){
        return pi*r*r;
    }
    public double AreaCuadrado(double l){
        return l*l;
    }
    public double AreaTriangulo(double b, double h){
        return (b*h)/2;
    }
    
    
    
    
}
