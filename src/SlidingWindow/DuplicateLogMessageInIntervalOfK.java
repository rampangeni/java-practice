package SlidingWindow;

// # A program produces a lot of logs that are duplicate which makes debugging very difficult.

// # TS:          Message
// # (in sec)
// # —            ————————
// # 10:      Message 1
// # 13:      Message 2
// # 14:      Message 3
// # 14:      Message 4
// # 18:      Message 5
// # 19:      Message 1
// # 22:      Message 2

// # Please write code to that can print duplicate messages received in the log in a 10 second sliding window in real-time.
// For the above example the output will be:
// # Message 1
// # Message 2

// # Assume that the timestamp is always increasing.

import java.util.HashMap;

public class DuplicateLogMessageInIntervalOfK {
    static int interval = 10;
    public static void printDuplicateMessage(Integer[] TS, String[] message) {
        HashMap<String,Integer> hashMap = new HashMap<>();

        int startIndex = 0;
        int endIndex = 0;
        while(endIndex < TS.length) {
            hashMap.put(message[endIndex], hashMap.getOrDefault(message[endIndex],0)+1);
            if (TS[endIndex] - TS[startIndex] < interval) {
                int count = hashMap.get(message[endIndex]);
                if (count > 1) {
                    System.out.println("[" + TS[startIndex] + " , " + TS[endIndex] +"] Message: " + message[endIndex]);
                }
            } else {
                while(TS[endIndex] - TS[startIndex] >= interval) {
                    int count = hashMap.get(message[startIndex]);
                    if (count <= 1) {
                        hashMap.remove(message[startIndex]);
                    } else {
                        hashMap.put(message[startIndex], hashMap.get(message[startIndex])-1);
                    }
                    startIndex++;
                }
            }
            endIndex++;
        }
    }

    public static void main(String[] args) {
        Integer[] TS = {10,   13,  14,  14,  18,  19,  22};
        //Integer[] TS =    {10,  13,  14,  14,  23,  25,  30};
        //Integer[] TS =    {10,  20,  29,  31,  32,  33,  34};
        String[] message={"M1","M2","M2","M4","M5","M1","M4"};
        printDuplicateMessage(TS, message);
    }
}
