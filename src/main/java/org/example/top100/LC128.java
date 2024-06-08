package org.example.top100;

import java.util.HashSet;
import java.util.Set;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int len = 1;
        int maxLen = 1;

        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            for (int i = 1; i <= set.size(); i++) {
                if (set.contains(num + i)) {
                    len++;
                } else {
                    maxLen = Math.max(len, maxLen);
                    len = 1;
                    break;
                }
            }
        }
        return maxLen;
    }
}
