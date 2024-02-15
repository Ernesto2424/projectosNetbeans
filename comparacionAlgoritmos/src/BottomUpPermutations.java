import java.util.*;

public class BottomUpPermutations {
    public static void generatePermutations(int[] arr) {
        Arrays.sort(arr); // Ordena el array inicial si no está ordenado
        int n = arr.length;
        boolean finished = false;

        while (!finished) {
            // Procesa la permutación actual
            processPermutation(arr);

            // Encuentra el mayor índice i tal que arr[i] < arr[i+1]
            int i = n - 2;
            while (i >= 0 && arr[i] >= arr[i + 1]) {
                i--;
            }

            if (i == -1) {
                finished = true; // Todas las permutaciones generadas
            } else {
                // Encuentra el mayor índice j tal que arr[i] < arr[j]
                int j = n - 1;
                while (arr[j] <= arr[i]) {
                    j--;
                }

                // Intercambia arr[i] y arr[j]
                swap(arr, i, j);

                // Invierte el orden de los elementos desde i+1 hasta el final
                reverse(arr, i + 1, n - 1);
            }
        }
    }

    private static void processPermutation(int[] arr) {
        // Procesa la permutación actual (puedes imprimir, almacenar, etc.)
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
int[] arr = {1, 2, 3, 4, 5};
        generatePermutations(arr);
    }
}

