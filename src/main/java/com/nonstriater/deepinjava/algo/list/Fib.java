package com.nonstriater.deepinjava.algo.list;

/**
 * Fibonacci数列， 动态规划问题
 * n=0 0
 * n=1,2 f(n) = 1
 * f(n) = f(n-1)+f(n-2)
 */
public class Fib {

    public int fib(int n){
        if (n == 0) return 0;

        //缓存
        int[] dp = new int[n + 1];

        // base case
        dp[0] = 0; dp[1] = 1;

        // 状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    //优化缓存
    public int fib2(int n){
        if (n == 0) return 0;

        //缓存
        int[] dp = new int[n + 1];

        // base case
        dp[0] = 0; dp[1] = 1;

        // 状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
