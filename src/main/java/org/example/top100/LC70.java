package org.example.top100;

public class LC70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                dp[j] = dp[j - 1] + dp[j - 2];
            }
        }
        return dp[n];
    }
}
