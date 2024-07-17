package SlidingWindow;

/*
 * Fixed Window
 */

public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int numbers[] = {2,5,1,8,2,9,1};
        int k = 3;

        int startIndex = 0;
        int endIndex = 0;
        int currentSum = 0;
        int max = 0;
        while(endIndex < numbers.length) {
            currentSum = currentSum + numbers[endIndex];
            if (endIndex - startIndex + 1 < k) {
                endIndex++;
            } else if (endIndex - startIndex + 1 == k) {
                max = Math.max(max, currentSum);
                currentSum = currentSum - numbers[startIndex];
                startIndex++;
                endIndex++;
            }
        }

        System.out.println("MAX: " + max);
    }
}
