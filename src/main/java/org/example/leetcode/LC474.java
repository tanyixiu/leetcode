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

    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        Char01[] char01s = initChar01Array(strs);

        for (int i = 1; i <= strs.length; i++) {
            Char01 str = char01s[i];
            for (int j = m; j >= str.getNumOf0(); j--) {
                for (int k = n; k >= str.getNumOf1(); k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - str.getNumOf0()][k - str.getNumOf1()] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private static Char01[] initChar01Array(String[] strs) {
        Char01[] char01s = new Char01[strs.length + 1];
        char01s[0] = new Char01("");
        for (int i = 1; i <= strs.length; i++) {
            char01s[i] = new Char01(strs[i - 1]);
        }
        return char01s;
    }

    public static class Char01 {
        private int numOf0 = 0;
        private int numOf1 = 0;

        public Char01(String item) {
            for (Character i : item.toCharArray()) {
                if (i == '0') {
                    numOf0++;
                } else {
                    numOf1++;
                }
            }
        }


        public int getNumOf0() {
            return numOf0;
        }

        public int getNumOf1() {
            return numOf1;
        }
    }
}
