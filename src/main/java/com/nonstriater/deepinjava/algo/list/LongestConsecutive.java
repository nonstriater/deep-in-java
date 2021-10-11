package com.nonstriater.deepinjava.algo.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度 ；
 * 输入: [100, 4, 200, 1, 3, 2] ， 输出: 4
 */
public class LongestConsecutive {


    public static  void main(String[] args){

        int [] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));

    }

    public static int longestConsecutive(int[] nums) {

        //容器
        Set<Integer> set = new HashSet<>();
        for (int n : nums){
            set.add(n);
        }

        int longestLen = 0;
        for (int i = 0 ;i < nums.length ; i++){

            int x = nums[i];

            //set中查找
            int currentLen = 1;
            while (set.contains(x-1)){
                x = x - 1;
                currentLen++;
            }

            if (currentLen > longestLen)
                longestLen = currentLen;
        }
        return longestLen;

    }

}
