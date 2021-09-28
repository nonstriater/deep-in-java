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


    public static int maxProfitK1(int[] list) {

        return 0;
    }

}
