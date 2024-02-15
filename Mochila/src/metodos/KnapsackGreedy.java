/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

/**
 *
 * @author ernes
 */
import java.util.ArrayList;
import java.util.List;

public class KnapsackGreedy {
    public static void main(String[] args) {
        //c. w = [55,10,47,5,4,50,8,61,85,87] p = [95,4,60,32,23,72,80,62,65,46] M= 269 
        int[] weights = {55,10,47,5,4,50,8,61,85,87};
        int[] values = {95,4,60,32,23,72,80,62,65,46};
        int capacity = 269;

        int[] result = knapsackGreedy(weights, values, capacity);
        System.out.println("Enfoque Ávido - Maximum Value: " + result[0]);
        System.out.println("Enfoque Ávido - Selected Items: " + result[1]);
    }

    public static int[] knapsackGreedy(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        double[] valuePerWeight = new double[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            valuePerWeight[i] = (double) values[i] / weights[i];
            indices[i] = i;
        }

        // Sort items by value per weight ratio in descending order
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (valuePerWeight[i] < valuePerWeight[j]) {
                    double tempVPW = valuePerWeight[i];
                    valuePerWeight[i] = valuePerWeight[j];
                    valuePerWeight[j] = tempVPW;
                    int tempIndex = indices[i];
                    indices[i] = indices[j];
                    indices[j] = tempIndex;
                }
            }
        }

        int maxProfit = 0;
        int currentWeight = 0;
        List<Integer> selectedItems = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int itemIndex = indices[i];
            if (currentWeight + weights[itemIndex] <= capacity) {
                selectedItems.add(itemIndex);
                maxProfit += values[itemIndex];
                currentWeight += weights[itemIndex];
            }
        }

        int[] result = new int[2];
        result[0] = maxProfit;
        result[1] = selectedItems.size();
        return result;
    }
}
