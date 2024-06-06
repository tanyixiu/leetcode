package org.example.leetcode;

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
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        if (sum % 2 != 0 || max > sum / 2) {
            return false;
        }

        int capacity = sum / 2;
        boolean[] dp = new boolean[capacity + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            int num_i = nums[i - 1];
            for (int j = capacity; j >= num_i; j--) {
                dp[j] |= dp[j - num_i];
            }
        }
        return dp[capacity];
    }


    /*
     * thinking:
     * -. 找到确定的容量边界: sum/2
     * -. 拆成两个数组，输入数组的长度必须大于等于2
     * -. sum 必须是偶数，不然分不开
     * -. 若 max> sum/2, 则分不动，另外一边的数组必定小于容量
     *
     * dp[i][j]:
     * i -- 表示从1-i个字符串中选择任意个
     * j -- 使得其中其和恰好为j, j<=sum/2
     * v -- 是否恰好装得下 true/false
     *
     * when 不能选 i (何时不能选? --> 选了 i 就超过了容量 --> nums[i]>j)
     * 则 dp[i][j] = dp[i-1][j]
     *
     * when 可以选 i
     * 方案1: 不选 i,则 --> dp[i-1][j]
     * 方案2: 要选 i,则 --> dp[i-1][j-nums[i]]
     * 只要方案 1 或者方案 2 其中一个恰好装得下就行
     * 则: dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
     *
     * 初始化 dp[0][j]/d[i][0]:
     * --> dp[0][j]: 一个数都不选，使得和敲好为j --> dp[0][0] = true
     * --> dp[i][0]: 选任意个，除非每个数都为0，但题目给出是正整数 --> dp[0][0] = true
     *
     * 则滚动数组:
     *      dp[j] |= dp[i-1][j-nums[i]]
     * -. j 倒序遍历
     */
}
