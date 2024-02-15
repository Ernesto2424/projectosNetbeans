import java.util.*;

public class JohnsonTrotterPermutations {
    public static void generatePermutations(int[] arr) {
        int n = arr.length;
        int[] dir = new int[n];
        for (int i = 0; i < n; i++) {
            dir[i] = -1; // Todas las direcciones inicialmente a la izquierda
        }

        processPermutation(arr);

        int mobileElement, mobileIndex, temp;
        boolean found = true;

        while (found) {
            found = false;

            // Encuentra el elemento móvil más grande
            mobileElement = Integer.MIN_VALUE;
            mobileIndex = -1;
            for (int i = 0; i < n; i++) {
                if ((dir[i] == -1 && i > 0 && arr[i] > arr[i - 1] && arr[i] > mobileElement) ||
                        (dir[i] == 1 && i < n - 1 && arr[i] > arr[i + 1] && arr[i] > mobileElement)) {
                    mobileElement = arr[i];
                    mobileIndex = i;
                    found = true;
                }
            }

            // Si se encontró un elemento móvil, intercámbialo
            if (found) {
                if (dir[mobileIndex] == -1) {
                    temp = arr[mobileIndex];
                    arr[mobileIndex] = arr[mobileIndex - 1];
                    arr[mobileIndex - 1] = temp;

                    temp = dir[mobileIndex];
                    dir[mobileIndex] = dir[mobileIndex - 1];
                    dir[mobileIndex - 1] = temp;
                } else {
                    temp = arr[mobileIndex];
                    arr[mobileIndex] = arr[mobileIndex + 1];
                    arr[mobileIndex + 1] = temp;

                    temp = dir[mobileIndex];
                    dir[mobileIndex] = dir[mobileIndex + 1];
                    dir[mobileIndex + 1] = temp;
                }

                // Cambia la dirección de todos los elementos mayores que el móvil
                for (int i = 0; i < n; i++) {
                    if (arr[i] > mobileElement) {
                        dir[i] = -dir[i];
                    }
                }

                processPermutation(arr);
            }
        }
    }

    private static void processPermutation(int[] arr) {
        // Procesa la permutación actual (puedes imprimir, almacenar, etc.)
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
int[] arr = {1, 2, 3, 4, 5};
generatePermutations(arr);
    }
}
