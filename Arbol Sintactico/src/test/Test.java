package test;

import modulos.*;

public class Test {

    public static void main(String[] args) {

//        String[] token = Operaciones.tokens ("5 * ( 10 + 7 )");
//        
//        for(int i=0; i<token.length; ++i){
//            System.out.print(token[i] +" ");
//        }
//        for(int i=0; arr[i]!= null; ++i){
//            System.out.println("i = " + arr[i]);
//        }
        String[] arr = Operaciones.arbol(Operaciones.tokens("5 * ( 10 + 7 )"));

        System.out.println("    " + arr[0] + "     ");
        for (int i = 1; arr[i] != null; ++i) {

            System.out.println(arr[i]);

        }

    }

}
