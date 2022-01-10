package com.nonstriater.deepinjava.algo.list.stock;

/**
 *  给定一个数组，第i个元素是第i天的价格；
 *  设计一个算法(交易策略) ，计算你能获得的最大收益，你最多可以完成 k 笔交易；
 *  比如： [3,2,6,5,1,3]
 *  k =1 , 第2天买入 2块钱，  第3天卖出 6块，利润 6-2 = 4块 是最大利润
 *  k= 2 (可以交易2次) ,   [2,6] + [1,3] 是最大利润
 *  DP table 动态规划问题
 *
 *  几个注意点：
 *  1. 这个问题跟 和之差最大 还不一样，股票问题 必须买小卖大
 *  2. 是否可以递归写法？
 *  3. 动态规划
 */
public class BestChance {

    public static void main(String[] args) {

        int[] list = {3,2,6,5,1,3};

        System.out.println(maxProfitK1(list));
    }

    /**
     * 暴力解法
     * @param prices
     * @return
     */
    public static int maxProfitK1AC(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int ret = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                ret = (ret > (prices[j] - prices[i])) ? ret : (prices[j] - prices[i]);
                //ret = Math.max(ret, prices[j] - prices[i]);
            }
        }

        return ret;
    }

    /**
     * 难度 easy
     * 动态规划，一次遍历
     * 思路： 我们只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：
     * 如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？当考虑完所有天数之时，我们就得到了最好的答案。
     * 示例： [3,2,6,5,1,3]
     * 视频讲解： https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/
     * @param prices
     * @return
     */
    public static int maxProfitK1_2(int[] prices) {

        int minprice = Integer.MAX_VALUE; //记录一个历史最低价格; 第 i 天卖出股票能得到的利润就是prices[i] - minprice
        int maxprofit = 0; //最大利润

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];//记录历史最低价格
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


    public static int maxProfitK1(int[] prices) {

        int n = prices.length;
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);

            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;

    }

    // 空间复杂度优化版本
    int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }

}
