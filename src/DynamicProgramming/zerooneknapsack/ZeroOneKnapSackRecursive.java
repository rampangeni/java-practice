package DynamicProgramming.zerooneknapsack;

public class ZeroOneKnapSackRecursive {

    public int findMaxProfit(int[] values, int[] weights, int knapsackWeight, int size) {
        if (size == 0 || knapsackWeight == 0) {
            return 0;
        }

        if (weights[size-1] <= knapsackWeight) {
            return Math.max(values[size-1] +
                            findMaxProfit(values, weights, knapsackWeight - weights[size-1], size-1),
                    findMaxProfit(values, weights, knapsackWeight, size-1));
        }

        if (weights[size-1] > knapsackWeight) {
            return findMaxProfit(values, weights, knapsackWeight, size-1);
        }

        return 0;
    }

    public static void main(String[] args) {
        int itemValues[] = {1,4,5,7};
        int itemWeights[] = {1,3,4,5};
        int knapsackWeight = 7;

        ZeroOneKnapSackRecursive recursive = new ZeroOneKnapSackRecursive();
        int profit = recursive.findMaxProfit(itemValues, itemWeights, knapsackWeight, itemValues.length);
        System.out.println("Profit: " + profit);
    }
}
