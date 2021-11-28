package com.nonstriater.deepinjava.algo.list;


import java.util.Arrays;

/**
 * 凑零钱的例子 (动态规划)
 * 给定一个面值list ： 1，2，5，7，10； 给定一个 target ： 14， 求 凑齐 target=14 , 最少的零钱数量
 * 思路：动态规划
 */
public class CoinChange {

    public static void main(String[] args){
        int[] coins = new int[]{1,2,5,7,10};
        System.out.println(coinChange2(coins, 14));
    }

    static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // 数组大小为 amount + 1，初始值也为 amount + 1
        // 为啥 dp 数组初始化为 amount + 1 呢?
        // 因为凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币），所以初始化为 amount + 1 就相当于初始化为正无穷
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
