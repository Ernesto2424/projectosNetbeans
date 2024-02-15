package operaciones;

import domain.Numero;

public class Operacion implements Operaciones{

    public static void reconocimiento(String cadenaNumeros) {

        String entero = "";
        String decimal = "";
        char caracter;
        boolean punto = false;

        for (int i = 0; i < cadenaNumeros.length(); ++i) {
            caracter = cadenaNumeros.charAt(i);

            if (Character.isDigit(caracter)) {

                if (punto == false) {
                    entero += caracter;
                } else {
                    decimal += caracter;

                }

            } else {

                if (Character.compare(caracter, '.') == 0 && punto == false) {
                    punto = true;
                }

            }

        }  //fin del ciclo

        if (entero.isEmpty() && decimal.isEmpty()) {
            System.out.println("CADENA NO ACEPTADA :(");
        } else {
            Numero numero;
            if (entero.isEmpty()) {
                entero = "0";
            }
            int p1 = Integer.parseInt(entero);

            if (!decimal.isEmpty()) {
                int p2 = Integer.parseInt(decimal);
                numero = new Numero("Flotante", p1, p2);
                System.out.println(numero.toStringFlotante());
            } else {
                numero = new Numero("Entero", p1);
                System.out.println(numero.toStringEntero());
            }

        }

    }

    @Override
    public void reconocimiento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

}
