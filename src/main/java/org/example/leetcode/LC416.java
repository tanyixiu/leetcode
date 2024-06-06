package org.example.leetcode;

import org.example.tool.Util;

public class LC416 {

//    https://leetcode.cn/problems/partition-equal-subset-sum/description/


//   给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//    示例 1：
//    输入：nums = [1,5,11,5]
//    输出：true
//    解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//
//    示例 2：
//    输入：nums = [1,2,3,5]
//    输出：false
//    解释：数组不能分割成两个元素和相等的子集。

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
