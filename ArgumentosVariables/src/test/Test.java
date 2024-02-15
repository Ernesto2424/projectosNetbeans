package test;

public class Test {

    public static void main(String[] args) {
        
        imprimirNumeros(1,2,3,4,5);
         imprimirNumeros(8,15,20);
         variosParametros("ERNESTO", 10 ,10, 9);
        
        
    }
    
   public static void imprimirNumeros(int... numeros){
       //int... numeros nos va a indicar que se puede pasar
       //un numero indefinidos de argumentos al metodo
       //nota: la variable numeros de manera interfa funcionara como un arreglo
       for (int i = 0; i < numeros.length; i++) {
           System.out.println(numeros[i]);
       }
       System.out.println("");
   }
   
   public static void variosParametros(String nombre, int... nums){
       System.out.println(nombre);
       imprimirNumeros(nums);
   }
    
}
