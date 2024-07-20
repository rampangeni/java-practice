package DynamicProgramming.zerooneknapsack;

public class ZeroOneKnapSackBottomUp {
    public int findMaxProfit(int[] values, int[] weights, int knapsackWeight, int size) {
        int[][] memoization = new int[size + 1][knapsackWeight + 1];

        for(int n = 0; n <= size; n++) {
            for (int w = 0; w <= knapsackWeight; w++) {
                if (n == 0 || w == 0) {
                    memoization[n][w] = 0;
                } else if (weights[n-1] <= w) {
                    memoization[n][w] = Math.max(values[n-1] + memoization[n-1][w-weights[n-1]], memoization[n-1][w]);
                } else {
                    memoization[n][w] = memoization[n-1][w];
                }
            }
        }

        return memoization[size][knapsackWeight];
    }

    public static void main(String[] args) {
        int itemValues[] = {1,4,5,7};
        int itemWeights[] = {1,3,4,5};
        int knapsackWeight = 7;     

        ZeroOneKnapSackBottomUp bottomUp = new ZeroOneKnapSackBottomUp();
        int profit = bottomUp.findMaxProfit(itemValues, itemWeights, knapsackWeight, itemValues.length);
        System.out.println("Profit: " + profit);
    }
}
