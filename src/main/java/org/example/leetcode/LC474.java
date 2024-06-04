package org.example.leetcode;

public class LC474 {
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
