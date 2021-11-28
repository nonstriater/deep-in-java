package com.nonstriater.deepinjava.algo.list;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 示例 输入: [3,2,1,5,6,4] 和 k = 2，输出: 5
 * 给出两个升序数组A、B和长度m、n，求第k个大的
 */
public class TopK {

    //冒泡实现
    public int findK(int[] nums, int k){
        //base case
        if (nums== null || nums.length < k) {
            return -1;
        }

        for(int i=1; i<=k; i++){
            for(int j=0; j<nums.length-i; j++) {
                int next = j+1;
                if(nums[j]> nums[next]){
                    int tmp = nums[j];
                    nums[j] = nums[next];
                    nums[next] = tmp;
                }
            }
        }

        return nums[nums.length-k];
    }



}
