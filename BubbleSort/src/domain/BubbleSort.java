/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author ernes
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {100, 50, 200, 75, 150, 25, 175, 15, 225, 90, 40, 125, 85, 55, 30, 110, 65, 180, 70, 120, 10, 160, 35, 190, 80};
        
        System.out.println("Arreglo original:");
        printArray(arr);
        
        bubbleSort(arr);
        
        System.out.println("\nArreglo ordenado (Bubble Sort):");
        printArray(arr);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambiar arr[j] y arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Si no hubo intercambios en este pase, el arreglo ya está ordenado
            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

