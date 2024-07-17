package DataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 **/

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = target - first;

            if (map.containsKey(second)) {
                if (first == second) {
                    if (map.get(first).size() == 1) {
                        continue;
                    }
                    return new int[]{map.get(first).get(0), map.get(first).get(1)};
                } else {
                    return new int[]{map.get(first).get(0), map.get(second).get(0)};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        int[] result = TwoSum.twoSum(nums, target);
        System.out.println(result[0] +" "+ result[1]);
    }
}
