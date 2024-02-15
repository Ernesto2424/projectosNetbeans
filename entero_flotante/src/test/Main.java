package test;

import java.util.Scanner;
import operaciones.Operacion;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String cadena;
        for (int i = 0; i < 3; ++i) {
            System.out.print("INGRESE CADENA:");
            cadena = sc.nextLine();
            Operacion.reconocimiento(cadena);
            System.out.println("");
        }

    }

}
