/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author ernes
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {100, 50, 200, 75, 150, 25, 175, 15, 225, 90, 40, 125, 85, 55, 30, 110, 65, 180, 70, 120, 10, 160, 35, 190, 80};

        System.out.println("Arreglo original:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("\nArreglo ordenado (InsertionSort):");
        printArray(arr);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Mover elementos del arreglo[0..i-1] que son mayores que key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

