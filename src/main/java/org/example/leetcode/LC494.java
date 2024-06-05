package org.example.leetcode;

import java.util.Arrays;

public class LC494 {

    /*
     * thinking:
     *
     *
     * 输入：nums = [1,1,1,1,1], target = 3, 输出：5
     * 把数组分成两组，一组全部用+，一组全部用-
     * 那这个题目又回到了 之前的类似416的题目：分割等和子集（中等）
     * 只不过这次不是等分
     *
     * 假设选组一组数的和 是 x, （以后前面全部用 +）
     * 另一组数的和是 y ，（以后前面全部用 -）
     * 则:
     * --> x + y = sum(nums)
     * --> x - y = target
     * --> x = (sum + target)/2  --> x 必须是偶数，而且是正数
     * 则题目可以演变成，从 数组中选取任意个数，使得其和为x
     *
     * 定义 dp[i][j]: 从 i 个数中选取任意个数，装载容量为 j 的背包里，是否使得和恰好为j的个数
     * i --> 表示从 i 个数组中选的集合
     * j --> 表示容量为 j
     * value --> true 表示个数
     *
     * v[i] > j --> 则放不下，那d[i][j] = d[i-1][j]
     * v[i] <=j 则可以放下，d[i-1][j-v[i]] + d[i-1][j]
     * 注意初始化，d[0][0]在 0 个数中选，使得和为 0，那就刚好不选, 所以dp[0][0]=1
     *
     * 演变成滚动数组dp[j]
     * v[i] > j --> 则放不下，那dp[j]=dp[j]
     *
     * v[i] <=j 则可以放下，dp[j-v[i]] || dp[j]
     *
     * */

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 != 0 | (sum + target) < 0) {
            return 0;
        }
        int x = (sum + target) / 2;
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            int vi = nums[i - 1];
            for (int j = x; j >= vi; j--) {
                dp[j] += dp[j - vi];
            }
        }
        return dp[x];
    }
}
