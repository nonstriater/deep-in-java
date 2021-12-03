package com.nonstriater.deepinjava.algo.list;

/**
 * 最大子序和  难度 easy
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例： 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]， 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6
 *
 * 为啥不能用滑动窗口：数组中的数字可以是负数； 不知道什么时机去收缩左侧窗口
 * 思路：
 * maxSum保存当前累加的和，如果<0,就把 maxSum 清零 ， max保存最终的最大和;
 * 动态规划
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

        int maxSum = 0;// max保存最终的最大和
        int temp = 0;

        if (list == null || list.length == 0 ) {
            return 0;
        }

        for (int i=0; i < list.length; i++) {

            temp +=list[i];
            if (temp < 0) { //如果<0,就把 maxSum 清零
                temp = 0;
                continue;
            }

            if (temp > maxSum) {
                maxSum = temp;
            }
        }

        return maxSum;

    }

    /**
     * 使用动态规划模板实现
     * dp[i] 表示 nums[i] 为结尾的「最大子数组和」
     * dp[n-1] 就是 nums 的「最大子数组和」
     *
     * // 要么自成一派，要么和前面的子数组合并； 状态转移
     *
     *
     * 状态压缩：注意到 dp[i] 仅仅和 dp[i-1] 的状态有关
     *
     * @param nums
     * @return
     */
    public static int largestSubSequenceSum2(int[] nums){

        int n = nums.length;
        if (n == 0) return 0;

        // base case
        int dp_0 = nums[0];
        int dp_1 = 0;
        int res = dp_0;

        for (int i = 1; i < n; i++) {
            // dp[i] = max(nums[i], nums[i] + dp[i-1])
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;

            // 顺便计算最大的结果,保存到 res
            res = Math.max(res, dp_1);
        }

        return res;

    }

}
