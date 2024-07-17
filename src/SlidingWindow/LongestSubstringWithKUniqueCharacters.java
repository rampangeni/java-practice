package SlidingWindow;

import java.util.HashMap;

/*
 * Variable Window
 */

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        String inputString = "aabacbebebe";
        int uniqueCharsK = 3;

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

            int currentCount = tempMap.size();
            if (currentCount < uniqueCharsK) {
                endIndex++;
            } else if (currentCount == uniqueCharsK) {
                result = Math.max(result, endIndex - startIndex + 1);
                endIndex++;
            } else if (currentCount > uniqueCharsK) {
                while (currentCount > uniqueCharsK) {
                    Character startChar = inputString.charAt(startIndex);
                    if (tempMap.containsKey(startChar)) {
                        Integer count = tempMap.get(startChar);
                        if (count == 1) {
                            tempMap.remove(startChar);
                        } else {
                            tempMap.put(startChar, count-1);
                        }
                    }
                    currentCount = tempMap.size();
                    startIndex++;
                }
                endIndex++;
            }
        }

        System.out.println(result);
    }
}
