package operacionesArchivos;

import domain.Palabra;
import java.io.*;
import java.util.StringTokenizer;

public class Archivo {

    public static String buscar(String nombre, String palabra) {

        String identificador = null;
        File archivo = new File(nombre);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {

                StringTokenizer st = new StringTokenizer(lectura, ",");
                String id = st.nextToken();
                String significado = st.nextToken();

                if (palabra.equals(significado)) {

                    identificador = id;
                    break;
                }

                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return identificador;

    }

    public static Palabra traducir(String nombre, String iden) {
        Palabra palabra = null;
        File archivo = new File(nombre);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {

                StringTokenizer st = new StringTokenizer(lectura, ",");
                String id = st.nextToken();
                String significado = st.nextToken();

                if (iden.equals(id)) {

                    palabra = new Palabra(significado);
                    break;
                }

                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return palabra;

    }

}
