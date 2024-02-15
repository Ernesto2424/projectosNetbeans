package test;

import domain.Empleado;

public class Test {

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Ernesto", 5000);
        Empleado empleado2 = new Empleado("Ernesto", 5000);
        
        //se compara la referencia de memoria
        if(empleado1 == empleado2){
            System.out.println("tienen la misma referencia");
        }else{
            System.out.println("tienen distinta referencia en memoria");
        }
        
        //equals compara el contenido
        if(empleado1.equals(empleado2)){
            System.out.println("son iguales en contenido");
        }else{
            System.out.println("son distintos en contenido");
        }
        
        if(empleado1.hashCode() == empleado2.hashCode()){
            System.out.println("son iguales en has");
            System.out.println(empleado1.hashCode());
            System.out.println(empleado2.hashCode());
        }else{
            System.out.println("aon distinos en has");
            System.out.println(empleado1.hashCode());
            System.out.println(empleado2.hashCode());
        }
            
    }
    
}
