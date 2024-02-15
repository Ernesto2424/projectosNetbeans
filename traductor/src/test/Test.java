package test;

import domain.Palabra;
import java.util.Scanner;
import java.util.StringTokenizer;
import operacionesArchivos.Archivo;

public class Test {

    public static int cuentaPalabras(String cadena) {
        String[] palabras = cadena.trim().split(" +");
        return palabras.length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String es = "es.txt";
        String in = "in.txt";
        String palabra = "";
        String identidicador;
        Palabra p = null;

        while (palabra!=null) {

            System.out.print("INGRESE PALABRA A TRADUCIR:");
            palabra = sc.nextLine();
            if(palabra.equals("")){
                break;
            }

            StringTokenizer st = new StringTokenizer(palabra, " ");
            for (int i = 0; i < cuentaPalabras(palabra); ++i) {

                String tokPalabra = st.nextToken();

                identidicador = Archivo.buscar(es, tokPalabra);
                if (identidicador != null) {
                    p = Archivo.traducir(in, identidicador);
                    System.out.print(p.toString() + " ");
                } else {
                    identidicador = Archivo.buscar(in, tokPalabra);
                    if (identidicador != null) {
                        p = Archivo.traducir(es, identidicador);
                        System.out.print(p + " ");
                    } else {
                        System.out.print(tokPalabra+" ");
                    }

                }

            }

            System.out.println(" ");

        }
        
            
      

    }

}
