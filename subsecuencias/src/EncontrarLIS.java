/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ernes
 */
public class EncontrarLIS {
    
      public static int LIS(int[] arr) {
        int n = arr.length;
        
        // Inicializar un arreglo para almacenar la longitud de la LIS para cada índice
        int[] LIS = new int[n];
        
        // La LIS de un solo elemento es siempre 1
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
        }

        // Calcular la LIS para cada elemento del arreglo
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Verificar si el elemento actual es mayor y la LIS hasta ahora es menor
                if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        // Encontrar la longitud máxima de la LIS
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (LIS[i] > max) {
                max = LIS[i];
            }
        }

        return max;
    }
      
      public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int[] arr2 = {0,8,4,12,2,10,6,4,1,9,5,13,3,11,7,15};
        int[] arr4 = {15, 8, 2, 19, 5, 10, 14, 3, 12, 7, 17, 20, 1, 6, 18, 11, 4, 9, 13, 16};
        int result = LIS(arr4);
        System.out.println("Longitud de la subsecuencia mas larga: " + result);
    }
    
}
