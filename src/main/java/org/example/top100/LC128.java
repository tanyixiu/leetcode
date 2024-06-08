package org.example.top100;

import java.util.Arrays;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int max = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                len++;
                if (len >= max) {
                    max = len;
                }
            } else {
                len = 1;
            }
        }
        return max;
    }
}
