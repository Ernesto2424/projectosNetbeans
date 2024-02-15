package modulos;

import java.util.StringTokenizer;

public class Operaciones {

    public static int cuenta(String str) {

        String[] palabras = str.trim().split(" ");

        return palabras.length;

    }

    public static String[] tokens(String expresion) {

        int palabras = Operaciones.cuenta(expresion);
        int j = 0;
        //System.out.println(palabras);
        String tokens[] = new String[palabras];
        
        
        StringTokenizer st = new StringTokenizer(expresion, " ");
        for (int i = 0; i < palabras; ++i) {
            String temp = st.nextToken();
            if (Character.isDigit(temp.charAt(0))) {
                tokens[j] = "num";
                ++j;
            } else {
                tokens[j] = temp;
                ++j;
            }
        }

        return tokens;

    }

    public static String[] arbol(String tokens[]) {

        int i = 0;
        String arreglo[] = new String[20];
        arreglo[i] = "<EXP>";

        if (tokens[1].equals("+")) {
            arreglo[1] = "<EXP> + <EXP>";

        } else if (tokens[1].equals("*")) {
            arreglo[1] = "<EXP> * <EXP>";

        }
        arreglo[2] = tokens[0];

        if (tokens[2].equals("(")) {
            arreglo[3] = "( <EXP> )";
        }

        if (tokens[4].equals("+")) {
            arreglo[4] = "<EXP> + <EXP>";

        } else if (tokens[4].equals("*")) {
            arreglo[4] = "<EXP> * <EXP>";
        }
        arreglo[5] = tokens[0];
        arreglo[6] = tokens[0];

        return arreglo;
    }

}
