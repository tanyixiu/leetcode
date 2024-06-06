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
            int[] si = get01(strs[i - 1]);
            int zeros = si[0];
            int ones = si[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
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
            } else {
                ones++;
            }
        }
        int[] my01 = new int[2];
        my01[0] = zeros;
        my01[1] = ones;
        return my01;
    }

}

/*
 * thinking:
 *
 * dp[i][j][k]:
 * i -- 表示从1-i个字符串中选择任意个
 * j -- 使得其中 0的个数不超过j
 * k -- 使得其中 1的个数不超过k
 * v -- 得到的最大子集个数
 *
 * when 不能选 i --> 选了 i 就会超 --> strs[i].zeros > j || strs[i].ones > k
 * 则 dp[i][j][k] = dp[i-1][j][k]
 *
 * when 可以选 i
 * 则 dp[i-1][j][k] 或者 dp[i][j-strs[i].zeros][k-strs[i].ones]+1
 * 选 i 最大个数是 x
 * 不选 i 最大个数 y
 * 选i 和不选i都可以满足要求，那就 max(x,y+1)
 *

 */
