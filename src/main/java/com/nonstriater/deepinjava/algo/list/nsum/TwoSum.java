package com.nonstriater.deepinjava.algo.list.nsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 寻找 2 个数之和， 返回他们的数组下标
 */
public class TwoSum {

    public static void main(String[] args){

        int[] a = {1,3,5, 7, 9};

        int[] ret = twoSum(a, 12);
        System.out.printf("%d %d", ret[0], ret[1]);
    }

    /**
     * 寻找 2 个数之和
     * @param nums
     * @param target
     *
     * C 语言函数签名
     * int findaddends(int *data,int length,int sum,int *a,int *b);
     */
    public static int[] twoSum(int[] nums, int target){

        int[] res =new int[2];

        //空间换时间
        Map<Integer, Integer> map= new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];

            //不能是一个数 两倍 加和 为  target
            if(map.containsKey(temp) && map.get(temp) != i){
                res[0] = map.get(temp);
                res[1] = i;
            }
        }

        return res;
    }

}