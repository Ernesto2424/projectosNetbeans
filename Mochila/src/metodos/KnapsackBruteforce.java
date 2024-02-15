/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import java.util.ArrayList;
import java.util.List;

public class KnapsackBruteforce {
    public static void main(String[] args) {
        int[] weights = {15, 10, 2, 4};
        int[] values = {30, 25, 2, 6};
        int capacity = 37;

        List<Integer> result = knapsackBruteforce(weights, values, capacity);
        System.out.println("Fuerza Bruta - Selected Items: " + result);
    }

    public static List<Integer> knapsackBruteforce(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int maxProfit = 0;
        List<Integer> maxCombination = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> currentCombination = new ArrayList<>();
            int currentWeight = 0;
            int currentProfit = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    currentCombination.add(j);
                    currentWeight += weights[j];
                    currentProfit += values[j];
                }
            }

            if (currentWeight <= capacity && currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxCombination = new ArrayList<>(currentCombination);
            }
        }

        return maxCombination;
    }
}

