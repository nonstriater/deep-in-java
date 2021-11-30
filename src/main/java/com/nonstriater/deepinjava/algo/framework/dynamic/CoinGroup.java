package com.nonstriater.deepinjava.algo.framework.dynamic;

import java.util.Arrays;

/**
 * 凑零钱问题
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，
 * 再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额
 * 如果不可能凑出，算法返回 -1
 *
 * 给定一个面值list ： 1，2，4，5，7，10； 给定一个 target ： 14， 求 凑齐 target=14 , 最少的零钱数量
 * 思路：动态规划
 *
 *
 */
public class CoinGroup {

    public static void main(String[] args){

        CoinGroup c = new CoinGroup();
        int[] coins = new int[]{1,2,4,5,7,10};

        System.out.println(c.coinChange(coins, 14));
        System.out.println(c.coinChange(coins, 15));
        System.out.println(c.coinChange(coins, 16));
        System.out.println(c.coinChange(coins, 17));
    }


    int coinChange(int[] coins, int amount) {
        // 题目要求的最终结果是 dp(amount)
        return dp(coins, amount);
    }

    //递归解法，没有处理重叠子问题
    int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;

            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    //递归解法，处理重叠子问题, 使用 dp[amount+1] 备忘录
    //1,2,4,5,7,10
    int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // 数组大小为 amount + 1，初始值也为 amount + 1
        // 为啥 dp 数组初始化为 amount + 1 呢，因为凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币）
        // 所以初始化为 amount + 1 就相当于初始化为正无穷
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

}
