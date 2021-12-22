package com.nonstriater.deepinjava.algo.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 以数组形式返回答案。



 示例 1：
 输入：nums = [8,1,2,2,3]
 输出：[4,0,1,1,3]
 解释：
 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 对于 nums[1]=1 不存在比它小的数字。
 对于 nums[2]=2 存在一个比它小的数字：（1）。
 对于 nums[3]=2 存在一个比它小的数字：（1）。
 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。

 示例 2：
 输入：nums = [6,5,4,8]
 输出：[2,1,0,3]

 示例 3：
 输入：nums = [7,7,7,7]
 输出：[0,0,0,0]


 思路1：暴力求解 N^2
 思路2：排序 N*logN, 需要记录原来的索引
 思路3：辅助空间 + 排序   N*logN

 输入：nums = [8,1,2,2,3]
 输出：[4,0,1,1,3]
 */
public class StatSmallNum {

    public static void main(String[] args){

        int[] nums = new int[]{8,1,2,2,3};
        int[] ret = statNum(nums);
        for (int i = 0; i <  ret.length ; i++) {
            System.out.println(nums[i] + "cnt:" + ret[i]);
        }
        ret = statNum2(nums);
        for (int i = 0; i <  ret.length ; i++) {
            System.out.println(nums[i] + "cnt:" + ret[i]);
        }


        nums = new int[]{7,7,7,7,7};
        ret = statNum(nums);
        for (int i = 0; i <  ret.length ; i++) {
            System.out.println(nums[i] + "cnt:" + ret[i]);
        }
        ret = statNum2(nums);
        for (int i = 0; i <  ret.length ; i++) {
            System.out.println(nums[i] + "cnt:" + ret[i]);
        }

    }

    // 暴力解法
    public static  int[] statNum(int[] nums){

        int[] ret = new int[nums.length];
        for(int i=0; i< nums.length; i++) {
            int tmp = 0; //次数
            for(int j=0; j< nums.length; j++) {
                if(nums[i] > nums[j]) {
                    ret[i] = ++tmp;
                }
            }
        }

        return ret;
    }


    /**
     排序+ 空间辅助
     输入：nums = [8,1,2,2,3]
     输出：[4,0,1,1,3]

     [1,2,2,3,8]
     [7,7,7,7]

     num:cnt
     1:0
     2:1
     2:1
     3:3
     8:4
     **/
    public static int[] statNum2(int[] nums){

        int length = nums.length;
        int ret[] = Arrays.copyOf(nums, length);//拷贝一份，用于排序

        Map<Integer, Integer> window = new HashMap<>();
        Arrays.sort(ret);

        //记录window map:
        for(int i=0; i <length; i++ ){
            if(i==0){
                window.put(ret[i], 0);
            } else if(ret[i] > ret[i-1]) {
                window.put(ret[i], i);// 2: 1
            } else if(ret[i] == ret[i-1]) {//不需要这个，数据元素一样的时候会有bug
                //window.put(ret[i], i-1);//2: 1
            }
        }

        //打印
        for(int i=0; i <length; i++ ){
            ret[i] = window.get(nums[i]);
        }

        return ret;
    }
}
