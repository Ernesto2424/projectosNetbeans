/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author ernes
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {100, 50, 200, 75, 150, 25, 175, 15, 225, 90, 40, 125, 85, 55, 30, 110, 65, 180, 70, 120, 10, 160, 35, 190, 80};

        System.out.println("Arreglo original:");
        printArray(arr);

        heapSort(arr);

        System.out.println("\nArreglo ordenado (HeapSort):");
        printArray(arr);
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Construye un heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extrae elementos uno por uno del heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            int swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

