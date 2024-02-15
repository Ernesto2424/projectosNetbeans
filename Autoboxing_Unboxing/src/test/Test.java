package test;

public class Test {

    public static void main(String[] args) {
        /*
        clases envolventes de tipos primitivos
        int - Integer
        long - Long
        double - Double
        float - Float
     
        la diferiecnia entre un tipo y una clase es que la clase contiene
        metodos y atributos
        */
        
        Integer varibale = 10; //Autoboxing
        System.out.println("varibale = " + varibale.doubleValue()); //cambia de entero a double
        int variable2 = varibale; //Unboxing
        System.out.println("variable2 = " + variable2);
        
        
    }
    
}
