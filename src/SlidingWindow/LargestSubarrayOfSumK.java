package SlidingWindow;

/*
 * Variable Window
 */
public class LargestSubarrayOfSumK {
    public static void main(String[] args) {
        int inputArray[] = {4,1,1,1,2,3,5};
        int sumK = 5;

        int startIndex = 0;
        int endIndex = 0;
        int result = 0;
        int tempSum = 0;

        while(endIndex < inputArray.length) {
            tempSum = tempSum + inputArray[endIndex];
            if (tempSum < sumK) {
                endIndex++;
            } else if (tempSum == sumK) {
                result = Math.max(result, (endIndex - startIndex + 1));
                endIndex++;
            } else if (tempSum > sumK) {
                while(tempSum > sumK) {
                    tempSum = tempSum - inputArray[startIndex];
                    startIndex++;
                }
                endIndex++;
            }
        }

        System.out.println(result);
    }
}