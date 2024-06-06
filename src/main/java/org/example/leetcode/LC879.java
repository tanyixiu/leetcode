package org.example.leetcode;

public class LC879 {
//    https://leetcode.cn/problems/profitable-schemes/description/

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

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int j = 0; j <= n; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i <= profit.length; i++) {
            int worker_i = group[i - 1];
            int profit_i = profit[i - 1];
            for (int j = n; j >= worker_i; j--) {
                for (int k = minProfit; k >= 0; k--) {
//                    这里要注意两点: k>=0,而不是平常的k>=profit_i
//                    取模也需要先相加，再取模
                    dp[j][k] = (dp[j][k] + dp[j - worker_i][Math.max(k - profit_i, 0)]) % mod;
                }
            }
        }
        return dp[n][minProfit];
    }
}

/*
 * thinking:
 * -. 找到确定的容量边界j: 这里有两个 n, minProfit
 *
 * dp[i][j][k]:
 * i -- 表示从1-i个group中选择任意个
 * j -- 使得其中总工人数不超过 j, j <=n
 * k -- 使得其中产生的profit必须不低于 k, k>=minProfit
 * v -- 满足情况的组合有多少个
 *
 * when 不能选 i (何时不能选? --> 选了 i 就超过了容量 --> vi.worker > j)
 * 则 dp[i][j][k] = dp[i-1][j][k]
 *
 * when 可以选 i
 * 方案1: 不选 i,则 --> dp[i-1][j][k]
 * 方案2: 要选 i,则 --> dp[i-1][j-vi.worker][k-vi.profit] + 1 ，如果当前vi.profit已经>k了，我只需要前面的情况的 profit 大于等于 0 就可以
 *                --> dp[i-1][j-vi.worker][max(k-vi.profit,0)] + 1
 * 题目要求可以用的组合数，则我可以选方案 1，也可以选方案 2
 * 则: dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-vi.worker][max(k-vi.profit,0)] + 1
 *
 * 初始化 dp[0][j][k]/dp[i][0][k]/dp[i][j][0]:
 * --> dp[0][j][k]: 一个都不选，只有dp[0][0][0] = 1，其他的看情况
 * --> dp[i][0][k]: 不选工人, 只有dp[0][0][0] = 1，其他的看情况
 * --> dp[i][j][0]: 只要有利润，则都为 1
 *
 *
 * 则滚动数组:
 *      dp[j][k] += dp[j-vi.worker][max(k-vi.profit,0)] + 1
 * -. j,k 倒序遍历
 * -. 注意结果先加再取模
 * -. 循环的时候注意k可以>=0, 而不是平时的k >= profit_i
 *
 */
