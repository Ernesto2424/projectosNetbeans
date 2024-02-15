package clases;

import interfaces.Calculadora;
import java.rmi.*;
import java.rmi.registry.*;

public class CalculadoraServidor {

    public static void main(String[] args) {

        try {

            Calculadora c = new CalculadoraImp();
            LocateRegistry.createRegistry(1099);
            Naming.bind("CalculadoraService", c);

            System.out.println("Esperando Conexión del cliente");

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

}
