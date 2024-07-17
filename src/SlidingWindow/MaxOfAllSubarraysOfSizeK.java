package SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Fixed Window
 */

public class MaxOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int inputArray[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int startIndex = 0;
        int endIndex = 0;
        Queue<Integer> myQueue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        while(endIndex < inputArray.length) {
            myQueue.add(inputArray[endIndex]);
            while(!myQueue.isEmpty() && myQueue.peek() < inputArray[endIndex]) {
                myQueue.remove();
            }
            if (endIndex - startIndex + 1 < k) {
                endIndex++;
            } else if (endIndex - startIndex + 1 == k) {
                result.add(myQueue.peek());
                if (myQueue.peek() == inputArray[startIndex]) {
                    myQueue.remove();
                }
                startIndex++;
                endIndex++;
            }
        }
        System.out.println(result);
    }
}
