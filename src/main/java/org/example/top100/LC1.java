package org.example.top100;

import java.util.HashMap;

public class LC1 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer result = map.getOrDefault(target - nums[i], null);
            if (result != null) {
                return new int[] {result, i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
