package org.example.bag;

import org.example.tool.Util;

public class Bag01 {

    private void context() {
//        有N件物品和一个最多能被重量为W 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
//        每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
//
//        作者：代码随想录
//        链接：https://leetcode.cn/circle/discuss/lUki6J/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    //使用 二维数组
    public int getOptimalValue_v2(int[] weights, int[] values, int bagCapacity) {
//        存储模型:
//        用一个二维数组 dp[i][j] 来存储每一种情况的最优解
//        dp[i][j] 表示在前 i 个物品里挑选任意个物品装在容量为 j 的背包，所能装下的最大价值
//        i 表示前面i个物品中任意挑选的物品
//        j 表示背包容量
//        数组的值表示这个包里装下的最优解

//        寻找递推/递归公式:
//        dp[i][j] 表示在前 i 个物品里挑选任意个物品装在容量为 j 的背包，所能装下的最大价值
//        现在你是取的第 i个物品，那么你需要考虑 2 个情况：
//        1. 能不能装下。如果不能装下，就不要装，那么你的包里的东西和前面一样，从(i-1)个物品里挑选任意个，但是容量增加到了 j。这个时候就是:
//           when (j < weight[i]) then dp[i][j] = dp[i-1][j];
//        2. 如果能装下，但是要看装了划不划算，有可能这个物品重量很大，但是价值很低，所以我们就要对比，不装 i 和装 i 时谁的价值大:
//           如果不装 i，上推导过了，它的价值是 dp[i-1][j]
//           如果装 i，就相当于当前价值 = i这个物品的价值 + （背包容量扣除 i这个物品容量之后，从前面i-1个物品里挑选任意个，装下的最大价值）==
//           表示出来就是: dp[i][j] = Max (dp[i-1][j], value[i] + dp[i-1][j-weight[i]])
//        至此，我们得到了这个递推公式。


        int objectNum = weights.length;
        int[][] dp = new int[objectNum + 1][bagCapacity + 1];
//      dp[0][j]表示：从 0 个物品选任意个放进容量为 j 的背包里，你没有物品可以选，那么价值肯定都是 0
//      dp[i][0]表示：从 i 个物品选任意个放进容量为 0 的背包里，你没有背包容量，1 个都装不下，所以价值都为 0

        for (int i = 1; i <= objectNum; i++) {
            for (int j = 1; j <= bagCapacity; j++) {
                if (j < getWeight(weights, i)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], getValue(values, i) + dp[i - 1][j - getWeight(weights, i)]);
                }
            }
        }

        Util.printGrid(dp);
        return dp[objectNum][bagCapacity];
    }

    private static int getWeight(int[] weights, int i) {
        return weights[i - 1];
    }

    private static int getValue(int[] values, int i) {
        return values[i - 1];
    }

    //使用 一维数组
    public int getOptimalValue_v1(int[] weights, int[] values, int bagCapacity) {
//        想象一下, 我现在有 n=bagCapacity+1个背包，这些背包的容量按照从 0 到 bagCapacity 排列好
//        然后我把 i 个物品，一个一个试试能不能在这 n 个包里 (想象每个物品都有 n 份)
//          比如我把第一个物品都放在这个 n 个包里
//          然后我在继续放第二个物品, 一次类推......
//        我要保证每个包都恰好是最后解
//        我们用数组 dp[j]表示 容量为 j 的背包，可以从 i 个物品里挑选任意个放进来，使得这个包里的价值最大
//        那么我们可以推导:
//          我们在防止第 i 个物品的时候，可以不可以放进dp[j]这个包里。
//          如果不可以, 也就是 j的容量装不下 i 物品，也就是当 j < weight[i]的时候，dp[j] 就需要集成上一轮的dp[j]值:
//              dp[j] = dp[j];
//          如果可以，我们就要看装下 i 这个物品是否划算，也就是从比较不装 i 和装 i 的价值谁大:
//              如果是装 i 的，我们就需要知道当背包容量为 j-weight[i]时的最优解,然后再装上 i
//              dp[j] = Max(dp[j],dp[j-weight[i]]+value[i])

        int[] dp = new int[bagCapacity + 1];

//        遍历 i 个物品
        for (int i = 1; i <= weights.length; i++) {
//            遍历背包，不用遍历完所有，只需要遍历容量比当前物品 i 容量大的包就可以了，因为这样才能装得下啊 （装不下的包就不用处理了）
//            注意：这里要反着顺序来遍历背包，因为当你要取当前背包 j 不装 i 物品时的最优解，那个已经计算过了，会重复累加物品 i 的重量
            for (int j = bagCapacity; j >= getWeight(weights, i); j--) {
                dp[j] = Math.max(dp[j], dp[j - getWeight(weights, i)] + getValue(values, i));
            }
            Util.printArray(dp);
        }

        return dp[bagCapacity];
    }
}
