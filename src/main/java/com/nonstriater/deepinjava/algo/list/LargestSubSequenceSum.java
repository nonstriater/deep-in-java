package com.nonstriater.deepinjava.algo.list;

/**
 * 最大子序和 ， 难度 easy
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例： 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]， 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6
 *
 * 思路： maxSum保存当前累加的和，如果<0,就把 maxSum 清零 ， max保存最终的最大和;
 */
public class LargestSubSequenceSum {

    public static  void main(String[] args){

        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(largestSubSequenceSum(nums));

    }

    /**
     * BUG: 如果都是负数的实时呢？需要找到最大值返回
     * @param list
     * @return
     */
    public static int largestSubSequenceSum(int[] list){

        int maxSum = 0;
        int temp = 0;

        if (list == null || list.length == 0 ) {
            return 0;
        }

        for (int i=0; i < list.length; i++) {

            temp +=list[i];
            if (temp < 0) {
                temp = 0;
                continue;
            }

            if (temp > maxSum) {
                maxSum = temp;
            }

        }

        return maxSum;

    }

}
