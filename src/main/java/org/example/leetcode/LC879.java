package org.example.leetcode;

public class LC879 {

//    集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
//
//    第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
//
//    工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
//
//    有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。

//    示例 1：
//
//    输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
//    输出：2
//    解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
//    总的来说，有两种计划。
//
//    示例 2：
//
//    输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
//    输出：7
//    解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
//    有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
//

    /*
     * thinking:
     *
     * 本题描述：
     * 从i个工作中选任意个，放进容量f(x)的背包里，所得到的最大的价值(组合)
     * 这里的容量有 2 个，一个是容量是 j 个人，一个容量是产生的最小利益必须是 k
     * 则：
     * v = dp[i][j][k]
     * i: 从 i 个工作中选任意个
     * j: 使得从事的工人总数不能超过 j
     * k: 且使得产生的利益最小是 k
     * v: 所得到的最大组合数 （满足i,j,k组合的情况有多少种）
     *
     * 不能选第 i 个工作:
     * --> when (group[i] > j) or when (profile[i]<k ?)
     * --> then dp[i][j][k] = dp[i-1][j][k]
     * 能选第 i 个工作:
     * --> 可以不选[i] --> then dp[i-1][j][k]
     * --> 可以  选[i] --> then dp[i-1][j-group[i]][k-profit[i]]
     *
     * 从 i-1 个工作中选择任意个，使得工人总数不超过j-group[i]个，所产生的利益是k-profit[i],
     * k-profit[i]为负数表示什么意思: 表示profit[i]一个情况就能达到 k 的利润，此时前面 i-i 个工作不用创造价值都 ok
     * 则 dp[i-1][j-group[i]][max(0,k-profit[i])]
     *
     * 初始化:
     * d[0][j][k]: 不选工作，使得工人数不超过 j，然后达到的利润最小是 k --> 做不到，除非k=0时,则 d[0][j][0] = 1
     * d[i][0][k]: 选任意个工作，不选人，使得利润最小是 k             --> 做不到，除非k=0时,则 d[i][0][0] = 1
     * d[i][j][0]: 选任意个工作，使得工人数不超过 j，然后达到的利润最小是 0 --> 全都做到，则 d[i][j][0] = 1
     *
     * 所以总结 d[i][j][0] = 1
     *
     * 然后再空间优化，把 3 维数组滚动为 2 维数组
     */


    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = (int) 1e9 + 7;

        int[][] dp = new int[n + 1][minProfit + 1];
        for (int j = 0; j <= n; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i <= profit.length; i++) {
            int worker_i = group[i - 1];
            int profit_i = profit[i - 1];
            for (int j = n; j >= 1; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    if (worker_i > j) {
                        dp[j][k] = dp[j][k];
                    } else {
                        int count_without_i = dp[j][k];
                        int count_with_i = dp[j - worker_i][Math.max(0, k - profit_i)];
                        dp[j][k] = (count_without_i + count_with_i) % mod;
                    }
                }
            }
        }

        return dp[n][minProfit] % mod;
    }

    public int profitableSchemes_v2(int n, int minProfit, int[] group, int[] profit) {
        int mod = (int) 1e9 + 7;

        int[][][] dp = new int[profit.length + 1][n + 1][minProfit + 1];
        for (int i = 0; i <= profit.length; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int i = 1; i <= profit.length; i++) {
            int worker_i = group[i - 1];
            int profit_i = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (worker_i > j) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        int count_without_i = dp[i - 1][j][k];
                        int count_with_i = dp[i - 1][j - worker_i][Math.max(0, k - profit_i)];
                        dp[i][j][k] = (count_without_i + count_with_i) % mod;
                    }
                }
            }
        }

        return dp[profit.length][n][minProfit] % mod;
    }

    private boolean cannotSelectI(int workerI, int profitI, int totalWorkers, int minProfit) {
        if (workerI > totalWorkers) {
            return false;
        }
        return profitI + minProfit >= 0;
    }
}
