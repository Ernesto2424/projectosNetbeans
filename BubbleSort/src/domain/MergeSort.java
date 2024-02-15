/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author ernes
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {100, 50, 200, 75, 150, 25, 175, 15, 225, 90, 40, 125, 85, 55, 30, 110, 65, 180, 70, 120, 10, 160, 35, 190, 80};

        System.out.println("Arreglo original:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("\nArreglo ordenado (MergeSort):");
        printArray(arr);
    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            int mid = n / 2;
            int[] left = new int[mid];
            int[] right = new int[n - mid];

            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, n - mid);

            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0, k = 0;

        while (i < nL && j < nR) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < nL) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < nR) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
