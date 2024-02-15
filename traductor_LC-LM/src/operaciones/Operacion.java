package operaciones;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Operacion {
    
    static String nombreArchivoResultado = "resultado.txt";
    static String nombreArchivoEntrada = "entrada.txt";
    
    public static char[] leerArhivo() {
        
        File archivo = new File(Operacion.nombreArchivoEntrada);
        String lectura = null;
        char[] cadena = new char[1000];
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            lectura = entrada.readLine();
            for (int i = 0; i < lectura.length(); ++i) {
                cadena[i] = lectura.charAt(i);
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        return cadena;
        
    }
    
    public static void escribirArchivo(String informacion) {
        File archivo = new File(Operacion.nombreArchivoResultado);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(informacion);
            salida.close();
            System.out.println("se ha escrito en el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }        
    }
    
    public static void traducir() {
        char[] entrada = new char[Operacion.leerArhivo().length];
        entrada = Operacion.leerArhivo();
        String resultado = "";
        int pa_abre = 0;
        int pa_cierra = 0;
        char igual = '=';
        char r1 = '\\';
        char r2 = '/';
        char suma = '+';
        char resta = '-';
        char mul = '*';
        char div = ':';
        char potencia = '^';
        char parentesis_abre = '(';
        char parentesis_cierra = ')';
        String logaritmo = "log";
        
        for (int i = 0; i < entrada.length; ++i) {
            
            char caracter = entrada[i];
            if (caracter == '\n') {
                break;
            }
            if (caracter == 'l' && entrada[i + 1] == 'o' && entrada[i + 2] == 'g' && entrada[i + 3] == '_') {
                resultado += logaritmo;
                i += 5;
            } else if (caracter == parentesis_cierra) {
                resultado += parentesis_cierra;
                ++pa_cierra;
            } else if (caracter == parentesis_abre) {
                resultado += parentesis_abre;
                ++pa_abre;
            } else if (caracter == div) {
                resultado += '/';
            } else if (caracter == mul) {
                resultado += mul;
            } else if (caracter == resta) {
                resultado += resta;
            } else if (caracter == suma) {
                resultado += suma;
            } else if (caracter == r1 && entrada[i + 2] == r2) {
                resultado += "sqrt(" + entrada[i + 3] + ")";
                i += 4;
            } else if (caracter == igual) {
                resultado += igual;
                
            } else if (entrada[i] == potencia) {
                resultado += "pow(" + caracter + " , ";
                
                if (i + 2 == parentesis_abre) {
                    
                    i += 2;
                } else {
                    resultado += entrada[i + 2];
                    i += 2;
                }
                
            } else {
                resultado += caracter;
            }
            
        }
        if (pa_abre == pa_cierra) {
            // System.out.println(resultado);
            escribirArchivo(resultado);
        } else {
            System.out.println("Error en parentesis");
        }
        
    }
    
}
