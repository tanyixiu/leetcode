package org.example.leetcode;

import java.util.Arrays;

public class LC494 {

    //    https://leetcode.cn/problems/target-sum/
//    给你一个非负整数数组 nums 和一个整数 target 。
//
//    向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//    例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//
//    返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//
//
//
//    示例 1：
//
//    输入：nums = [1,1,1,1,1], target = 3
//    输出：5
//    解释：一共有 5 种方法让最终目标和为 3 。
//            -1 + 1 + 1 + 1 + 1 = 3
//            +1 - 1 + 1 + 1 + 1 = 3
//            +1 + 1 - 1 + 1 + 1 = 3
//            +1 + 1 + 1 - 1 + 1 = 3
//            +1 + 1 + 1 + 1 - 1 = 3
//
//    示例 2：
//
//    输入：nums = [1], target = 1
//    输出：1
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum() + target;
        if (total % 2 != 0 || total < 0) {
            return 0;
        }
        int capacity = total / 2;
        int[] dp = new int[capacity + 1];

        dp[0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            int vi = nums[i - 1];
            for (int j = capacity; j >= vi; j--) {
                dp[j] += dp[j - vi];
            }
        }
        return dp[capacity];
    }
}


/*
 * thinking:
 * -. 找到确定的容量边界j:
 *      假如数组所有元素相加，则和为 sum。
 *      假如把所有前面可以放+的元素，他们和为 x，把所有元素前面放-的元素，他们和为 y，则 x+y=sum, x-y=target
 *      于是 x = (sum+target)/2，这是一个确定的边界，可以用它做容量
 * -. sum+target需要是一个偶数，不然 x 会是小数，就没有情况可以划分了
 * -. x>=0
 * -. 则题目可以演变成：从数组里选取任意个数，是其和为j，可以选多少个组合
 *
 * dp[i][j]:
 * i -- 表示从1-i个数字中选择任意个
 * j -- 使得其中数字之和刚好为j，j<=(sum+target)/2
 * v -- 满足情况的组合有多少个
 *
 * when 不能选 i (何时不能选? --> 选了 i 就超过了容量 --> vi > j)
 * 则 dp[i][j] = dp[i-1][j]
 *
 * when 可以选 i
 * 方案1: 不选 i,则 --> dp[i-1][j]
 * 方案2: 要选 i,则 --> dp[i-1][j-vi]
 * 题目要求可以用的组合数，则我可以选方案 1，也可以选方案 2
 * 则: dp[i][j] = dp[i-1][j] + dp[i-1][j-vi]
 *
 * 初始化 dp[0][j]/dp[i][0]:
 * --> dp[0][j]: 一个都不选，只有dp[0][0] = 1，其他的看情况
 * --> dp[j][0]: 选任意个，和为 0，只有dp[0][0] = 1，其他的看情况
 *
 * 则滚动数组:
 *      dp[j] += [j-vi]
 * -. j 倒序遍历
 */
