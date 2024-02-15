/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.*;

/**
 *
 * @author ernes
 */
public class Ejercicios {

    //1. frecuencia caracteres
    public static Map<Character, Integer> frecuenciaCaracteres(String cadena) {
        Map<Character, Integer> frecuencia = new HashMap<>();

        // Recorrer la cadena para calcular la frecuencia de los caracteres
        for (char caracter : cadena.toCharArray()) {
            // Si el caracter ya está en el mapa, aumentar su frecuencia
            if (frecuencia.containsKey(caracter)) {
                frecuencia.put(caracter, frecuencia.get(caracter) + 1);
            } else {
                // Si es un nuevo caracter, agregarlo al mapa con frecuencia 1
                frecuencia.put(caracter, 1);
            }
        }

        return frecuencia;
    }

    //2.subcadenas
    public static String generarSubstring(String cadena) {
        // Obtener los dos primeros y los dos últimos caracteres de la cadena
        String primerosDosCaracteres = cadena.substring(0, 2);
        String ultimosDosCaracteres = cadena.substring(cadena.length() - 2);

        // Concatenar los dos conjuntos de caracteres obtenidos
        return primerosDosCaracteres + ultimosDosCaracteres;
    }

    //3. cadenas en medio
    public static String insertarCadenaEnMedio(String cadenaOriginal, String cadenaAInsertar, int posicion) {
        // Dividir la cadena original en dos partes en la posición de inserción
        String parteInicial = cadenaOriginal.substring(0, posicion);
        String parteFinal = cadenaOriginal.substring(posicion);

        // Insertar la cadena a insertar entre las dos partes
        return parteInicial + cadenaAInsertar + parteFinal;
    }

    //5. elementos en común
    public static int[] encontrarElementosComunes(int[] arreglo1, int[] arreglo2) {
        HashSet<Integer> conjuntoArreglo1 = new HashSet<>();
        HashSet<Integer> conjuntoElementosComunes = new HashSet<>();

        // Agregar elementos del primer arreglo al HashSet
        for (int num : arreglo1) {
            conjuntoArreglo1.add(num);
        }

        // Verificar y almacenar los elementos comunes del segundo arreglo
        for (int num : arreglo2) {
            if (conjuntoArreglo1.contains(num)) {
                conjuntoElementosComunes.add(num);
            }
        }

        // Convertir HashSet a arreglo de enteros para retornar los elementos comunes
        int[] elementosComunes = new int[conjuntoElementosComunes.size()];
        int index = 0;
        for (int num : conjuntoElementosComunes) {
            elementosComunes[index++] = num;
        }

        return elementosComunes;
    }

    //6. sum
    public static int sum(int[] arreglo) {
        if (arreglo.length < 2) {
            System.out.println("El arreglo no tiene suficientes elementos.");
            return 0;
        }

        // Copiar el arreglo para no modificar el original
        int[] copiaArreglo = Arrays.copyOf(arreglo, arreglo.length);
        Arrays.sort(copiaArreglo);

        // Encontrar el penúltimo elemento más grande
        int penultimoMasGrande = copiaArreglo[copiaArreglo.length - 2];

        // Encontrar el segundo elemento más pequeño
        int segundoMasPequenio = copiaArreglo[1];

        // Calcular la suma de ambos elementos
        return penultimoMasGrande + segundoMasPequenio;
    }
    
    //7. numeros pares  impares
    public static int[] contarParesEImpares(int[] arreglo) {
        int pares = 0;
        int impares = 0;

        // Recorrer el arreglo y contar pares e impares
        for (int numero : arreglo) {
            if (numero % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }

        return new int[]{pares, impares};
    }

    public static String voltearCadena(String cadena) {
        Stack<Character> stack = new Stack<>();

        // Insertar cada carácter de la cadena en la pila
        for (char c : cadena.toCharArray()) {
            stack.push(c);
        }

        // Construir una nueva cadena extrayendo los caracteres de la pila
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static String convertirABinario(int numero) {
        Stack<Integer> pila = new Stack<>();

        // Convertir el número a binario usando la técnica de división entre 2
        while (numero > 0) {
            int residuo = numero % 2;
            pila.push(residuo);
            numero /= 2;
        }

        // Construir la representación binaria extrayendo los elementos de la pila
        StringBuilder representacionBinaria = new StringBuilder();
        while (!pila.isEmpty()) {
            representacionBinaria.append(pila.pop());
        }

        return representacionBinaria.toString();
    }

    public static void main(String[] args) {
        
        System.out.println("Frecuencia caracteres");
        Map<Character, Integer> caracteres = frecuenciaCaracteres("hola mundo desde java");
        for (Map.Entry<Character, Integer> entry : caracteres.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println(key+": "+val);
            
        }
        
        System.out.println("\n Generar subcadenas");
        System.out.println(generarSubstring("oso"));
        System.out.println(generarSubstring("cielo"));
        System.out.println(generarSubstring("universidad"));
        
        System.out.println("\ncadenas en medio");
        System.out.println(insertarCadenaEnMedio("holaMundo", "segundaCadena0", 2));
        
        System.out.println("\n numeros en común");
        int arreglo1[] = {10,5,4,6,8};
        int arreglo2[] = {10,5,1,6,7};
        int arr[] = encontrarElementosComunes(arreglo1, arreglo2);
        for (int i : arr) {
            System.out.println("comunes = " + i);
        }
        
        System.out.println("\n suma");
        System.out.println("la suma es: "+sum(arreglo2));
        
        System.out.println("\n pares e impares");
        int arr2[]=contarParesEImpares(arreglo2);
        System.out.println("pares = " + arr2[0]);
        System.out.println("impares = " + arr2[1]);
        
        System.out.println("\nvoltear cadenas");
        System.out.println(voltearCadena("universidad"));

        System.out.println("\ndecimal a binario");
        System.out.println(convertirABinario(8));
    }

}
