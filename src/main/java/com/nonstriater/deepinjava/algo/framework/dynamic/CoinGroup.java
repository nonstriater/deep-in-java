package com.nonstriater.deepinjava.algo.framework.dynamic;

/**
 * 凑零钱问题
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，
 * 再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额
 * 如果不可能凑出，算法返回 -1
 *
 * 思路：
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

    //递归解法，处理重叠子问题
    int dp2(int[] coins, int amount) {

        return 0;
    }

}
