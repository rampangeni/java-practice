package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Fixed Window
 */

public class CountOccurrencesOfAnagrams {
    public static void main(String[] args) {
        String inputString = "forxxorfxdofr";
        String subString = "for";
        int k = subString.length();

        int startIndex = 0;
        int endIndex = 0;
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> subStringMap = new HashMap<>();
        subString.chars().forEach(element -> {
            if (subStringMap.containsKey((char)element)) {
                Integer count = subStringMap.get(element);
                subStringMap.put((char)element, count+1);
            } else {
                subStringMap.put((char)element, 1);
            }
        });
        System.out.println("Substring Map: " + subStringMap);
        HashMap<Character, Integer> tempMap = new HashMap<>();
        while (endIndex < inputString.length()) {
            Character endChar = inputString.charAt(endIndex);
            if (tempMap.containsKey(endChar)) {
                Integer count = tempMap.get(endChar);
                tempMap.put(endChar, count+1);
            } else {
                tempMap.put(endChar, 1);
            }

            if (endIndex - startIndex + 1 < k) {
                endIndex++;
            } else if (endIndex - startIndex + 1 == k) {
                if (tempMap.equals(subStringMap)) {
                    result.add(inputString.substring(startIndex, endIndex+1));
                }
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
                endIndex++;
            }
        }

        System.out.println(result);
    }
}
