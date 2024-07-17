package DynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapSackMemoization {
    // 8 -> knapsackWeight + 1
    // 5 -> itemValues.length + 1
    public int[][] memoizationTable = new int[8][5];

    public int findMaxProfit(int[] values, int[] weights, int knapsackWeight, int size, int[][] memoization) {
        if (size == 0 || knapsackWeight == 0) {
            return 0;
        }

        if (memoization[knapsackWeight][size] > 0) {
            return memoization[knapsackWeight][size];
        }

        if (weights[size-1] <= knapsackWeight) {
            return memoization[knapsackWeight][size] = Math.max(values[size-1] +
                            findMaxProfit(values, weights, knapsackWeight - weights[size-1], size-1,
                                    memoization),
                    findMaxProfit(values, weights, knapsackWeight, size-1, memoization));
        }

        if (weights[size-1] > knapsackWeight) {
            return memoization[knapsackWeight][size] = findMaxProfit(values, weights, knapsackWeight, size-1, memoization);
        }

        return 0;
    }

    public static void main(String[] args) {
        int itemValues[] = {1,4,5,7};
        int itemWeights[] = {1,3,4,5};
        int knapsackWeight = 7;

        ZeroOneKnapSackMemoization zeroOneKnapSackRecursive = new ZeroOneKnapSackMemoization();
        int profit = zeroOneKnapSackRecursive.findMaxProfit(itemValues, itemWeights,
                knapsackWeight, itemValues.length, zeroOneKnapSackRecursive.memoizationTable);
        System.out.println("Profit: " + profit);
    }
}
