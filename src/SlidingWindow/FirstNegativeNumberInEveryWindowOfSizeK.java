package SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Fixed Window
 */

public class FirstNegativeNumberInEveryWindowOfSizeK {
    public static void main(String[] args) {
        Integer numbers[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        Queue<Integer> queue = new LinkedList<>();

        int startIndex = 0;
        int endIndex = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while(endIndex < numbers.length) {
            if (numbers[endIndex] < 0) {
                queue.add(numbers[endIndex]);
            }
            if (endIndex - startIndex + 1 < k) {
                endIndex++;
            } else if (endIndex - startIndex + 1 == k) {
                if (!queue.isEmpty()) {
                    result.add(queue.peek());
                } else {
                    result.add(0);
                }
                if (numbers[startIndex] == queue.peek()) {
                    queue.remove();
                }
                startIndex++;
                endIndex++;
            }
        }

        System.out.println(result);
    }
}
