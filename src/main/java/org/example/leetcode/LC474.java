package org.example.leetcode;

public class LC474 {
//    https://leetcode.cn/problems/ones-and-zeroes/description/

//    给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//    请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
//    如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
//
//    示例 1：
//    输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//    输出：4
//    解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//    其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
//
//    示例 2：
//    输入：strs = ["10", "0", "1"], m = 1, n = 1
//    输出：2
//    解释：最大的子集是 {"0", "1"} ，所以答案是 2 。

    int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {

            int[] vi_01 = get01(strs[i - 1]);

            for (int j = m; j >= vi_01[0]; j--) {
                for (int k = n; k >= vi_01[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - vi_01[0]][k - vi_01[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }


    int[] get01(String s) {
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else if (s.charAt(i) == '1') {
                ones++;
            }
        }
        return new int[] {zeros, ones};
    }

}


/*
 * thinking:
 * -. 找到确定的容量边界: m 和 n，有两个
 *
 * dp[i][j][k]:
 * i -- 表示从1-i个字符串中选择任意个
 * j -- 使得其中其0的个数不超过j, j<=m
 * k -- 使得其中其1的个数不超过k, k<=n
 * v -- 满足情况的最大子集的长度
 *
 * when 不能选 i (何时不能选? --> 选了 i 就超过了容量 --> i.zeros > j || i.ones > k)
 * 则 dp[i][j][k] = dp[i-1][j][k]
 *
 * when 可以选 i
 * 方案1: 不选 i,则 --> dp[i-1][j][k]
 * 方案2: 要选 i,则 --> dp[i-1][j-i.zeros][k-i.ones] + 1 --> 不选 i 时的情况+1
 * 比较: 选个数最多的方案
 * 则: dp[i][j] = max(dp[i-1][j] , dp[i-1][j-i.zeros][k-i.ones] + 1)
 *
 * 初始化 dp[0][j][k]/dp[i][0][k]/dp[i][j][0]:
 * --> dp[0][j][k]: 一个都不选，只有dp[0][0][0] = 0，其他的看情况
 * --> dp[i][0][k]: 0 个 0，除非全是 1，也是看情况
 * --> dp[i][j][0]: 0 个 1，除非全是 0，也是看情况
 *
 * 则滚动数组:
 *      dp[j][k] = max(dp[j][k] , dp[j-i.zeros][k-i.ones] + 1)
 * -. j, k 倒序遍历
 */