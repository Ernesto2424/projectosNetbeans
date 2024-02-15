/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

/**
 *
 * @author ernes
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KnapsackDynamicProgrammingLarge {
    public static void main(String[] args) {
        try {
            // Leer datos del archivo
            BufferedReader br = new BufferedReader(new FileReader("MochilaGrande.txt"));
            String[] firstLine = br.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]); // Número de items
            int capacity = Integer.parseInt(firstLine[1]); // Capacidad de la mochila

            int[] weights = new int[n];
            int[] values = new int[n];

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                weights[i] = Integer.parseInt(line[0]);
                values[i] = Integer.parseInt(line[1]);
            }

            br.close();

            // Resolver el problema con programación dinámica
            int[][] dp = new int[n + 1][capacity + 1];

            for (int i = 1; i <= n; i++) {
                for (int w = 1; w <= capacity; w++) {
                    if (weights[i - 1] <= w) {
                        dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }

            int maxProfit = dp[n][capacity];
            System.out.println("Maximum Value: " + maxProfit);

            // Recuperar los elementos seleccionados
            int w = capacity;
            for (int i = n; i > 0 && maxProfit > 0; i--) {
                if (maxProfit != dp[i - 1][w]) {
                    System.out.println("Item " + i + " - Weight: " + weights[i - 1] + " - Value: " + values[i - 1]);
                    maxProfit -= values[i - 1];
                    w -= weights[i - 1];
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
