package DynamicProgramming;

public class ZeroOneKnapSackTopDown {
    // 8 -> knapsackWeight + 1
    // 5 -> itemValues.length + 1
    public int[][] memoizationTable = new int[8][5];

    public int findMaxProfit(int[] values, int[] weights, int[][] memoization) {
        for(int w = 0; w < 8; w++) {
            for (int n = 0; n < 5; n++) {
                if (n == 0 || w == 0) {
                    memoization[w][n] = 0;
                }
            }
        }

        for(int w = 1; w < 8; w++) {
            for (int n = 1; n < 5; n++) {
                if (weights[n-1] <= w) {
                    memoization[w][n] = Math.max(values[n-1] + memoization[w-weights[n-1]][n-1], memoization[w][n-1]);
                } else {
                    memoization[w][n] = memoization[w][n-1];
                }
            }
        }

        return memoization[7][4];
    }

    public static void main(String[] args) {
        int itemValues[] = {1,4,5,7};
        int itemWeights[] = {1,3,4,5};
        int knapsackWeight = 7;     

        ZeroOneKnapSackTopDown zeroOneKnapSackRecursive = new ZeroOneKnapSackTopDown();
        int profit = zeroOneKnapSackRecursive.findMaxProfit(itemValues, itemWeights,
                zeroOneKnapSackRecursive.memoizationTable);
        System.out.println("Profit: " + profit);
    }
}
