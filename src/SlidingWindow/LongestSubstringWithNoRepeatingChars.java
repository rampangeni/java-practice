package SlidingWindow;

/*
 * Variable Window
 */

import java.util.HashMap;

public class LongestSubstringWithNoRepeatingChars {
    public static void main(String[] args) {
        String inputString = "pwwkew";

        int startIndex = 0;
        int endIndex = 0;
        int result = 0;
        HashMap<Character, Integer> tempMap = new HashMap<>();
        while(endIndex < inputString.length()) {
            Character endChar = inputString.charAt(endIndex);
            if (tempMap.containsKey(endChar)) {
                Integer count = tempMap.get(endChar);
                tempMap.put(endChar, count+1);
            } else {
                tempMap.put(endChar, 1);
            }

            if (tempMap.size() == endIndex - startIndex + 1) {
                result = Math.max(result, endIndex - startIndex + 1);
                endIndex++;
            } else if (tempMap.size() < endIndex - startIndex + 1) {
                while (tempMap.size() < endIndex - startIndex + 1) {
                    Character startChar = inputString.charAt(startIndex);
                    if (tempMap.containsKey(startChar)) {
                        Integer count = tempMap.get(startChar);
                        if (count == 1) {
                            tempMap.remove(startChar);
                        } else {
                            tempMap.put(startChar, count-1);
                        }
                    }
                    startIndex++;
                }
                endIndex++;
            }
        }

        System.out.println(result);
    }
}
