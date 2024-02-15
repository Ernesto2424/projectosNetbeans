package test;

import domain.Persona;

public class Test {
  
    public static void main(String[] args) {
        //el ciclo ForEach es un ciclo for mejorado
        //forma tradicional, el mejorado ya no usa un contador
//        for (int i = 0; i < 10; i++) {
//            
//        }
 
 int arr[] = {5,7,8,9};
 //para recorrer el arreglo haremos lo siguiente
 //dentro del for se debe crear una variable del tipo del arreglo
 // desspues de los dos puntos, poner el arreglo a iterar (recorrer)
 for(int variable: arr){
     System.out.println("variable = " + variable);
 }
 
        Persona brr[] = {new Persona("ernesto"), new Persona("karla"), new Persona("mariana")};
        for(Persona persona: brr){
            System.out.println(persona);
        }
 
 

    }
    
    
    
    
    
}
