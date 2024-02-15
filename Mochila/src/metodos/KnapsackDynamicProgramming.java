/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ernes
 */
public class KnapsackDynamicProgramming {
    public static void main(String[] args) {
        //b. w = [22, 10, 9, 7] p = [12, 9, 9, 6]   M = 25
        
        int[] weights = {1,2,3,4,5};
        int[] values = {15,20,25,40,50};
        int capacity = 6;

        int[] result = knapsackDynamicProgramming(weights, values, capacity);
        System.out.println("Programación Dinámica - Maximum Value: " + result[0]);
        System.out.println("Programación Dinámica - Selected Items: " + result[1]);
    }

    public static int[] knapsackDynamicProgramming(int[] weights, int[] values, int capacity) {
        int n = weights.length;
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
        List<Integer> selectedItems = new ArrayList<>();
        int w = capacity;
        for (int i = n; i > 0 && maxProfit > 0; i--) {
            if (maxProfit != dp[i - 1][w]) {
                selectedItems.add(i - 1);
                maxProfit -= values[i - 1];
                w -= weights[i - 1];
            }
        }

        int[] result = new int[2];
        result[0] = dp[n][capacity];
        result[1] = selectedItems.size();
        return result;
    }
}
