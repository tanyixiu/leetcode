package org.example.bag;

import org.example.tool.Util;

public class Bag01 {
    public int maxValueInBag(int[] weights, int[] values, int bagCapacity) {
        int objectNum = weights.length;
        int[][] dp = new int[objectNum][bagCapacity + 1];

        for (int j = bagCapacity; j >= weights[0]; j--) {
            dp[0][j] = dp[0][j - weights[0]] + values[0];
        }

        for (int i = 1; i < objectNum; i++) {
            for (int j = 1; j <= bagCapacity; j++) {
                if (j < weights[i]) {
                    //装不下
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        Util.printGrid(dp);
        return dp[objectNum - 1][bagCapacity];
    }
}
