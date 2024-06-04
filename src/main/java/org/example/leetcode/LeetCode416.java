package org.example.leetcode;

import org.example.tool.Util;

public class LeetCode416 {

//    https://leetcode.cn/problems/partition-equal-subset-sum/description/

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        int max = nums[0];
        for (int v : nums) {
            sum += v;
            max = v > max ? v : max;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int bagCapacity = sum / 2;

        if (max > bagCapacity) {
            return false;
        }

        boolean[] dp = new boolean[bagCapacity + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = bagCapacity; j >= getValues(nums, i); j--) {
                if (getValues(nums, i) <= j) {
                    dp[j] |= dp[j - getValues(nums, i)];
                }
            }
        }
        return dp[bagCapacity];
    }

    public boolean canPartition_v2(int[] nums) {

        if (nums.length < 2) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int[][] dp = new int[nums.length + 1][sum / 2 + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                dp[i][0] = 1;

                if (getValues(nums, i) > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - getValues(nums, i)] == 1 || dp[i - 1][j] == 1 ? 1 : 0;
                }
            }
        }

        Util.printGrid(dp);
        return dp[nums.length][sum / 2] == 1;
    }

    private int getValues(int[] nums, int i) {
        return nums[i - 1];
    }
}
