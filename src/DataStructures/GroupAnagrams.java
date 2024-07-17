package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 */

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            char[] tempArray = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String tempString = new String(tempArray);
            if (map.containsKey(tempString)) {
                map.get(tempString).add(strs[i]);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                map.put(tempString, tempList);
            }
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.addAll(Collections.singleton(map.get(entry.getKey())));
        }

        return result;
    }

    public static void main(String[] args) {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = new ArrayList<>();

        result = groupAnagrams(strs);

        System.out.println(result);
    }
}
