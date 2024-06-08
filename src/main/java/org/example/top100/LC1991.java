package org.example.top100;

import java.util.Arrays;

public class LC1991 {
    public int findMiddleIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int left_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sum - 2 * left_sum) {
                return i;
            }
            left_sum += nums[i];
        }
        return -1;
    }
}
