package clases;

import interfaces.Calculadora;
import java.rmi.*;
import java.util.Scanner;

public class CalculadoraCliente {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Calculadora c = (Calculadora) Naming.lookup("rmi://localhost/CalculadoraService");

            System.out.println("Primer Valor:");
            int a = sc.nextInt();
            System.out.println("Segundo Valor:");
            int b = sc.nextInt();

            System.out.println("SUMA: " + c.suma(a, b));

            System.out.println("RESTA: " + c.resta(a, b));

            System.out.println("MULTIPLICACIÓN: " + c.mul(a, b));

            System.out.println("DIVISIÓN: " + c.div(a, b));

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

}
