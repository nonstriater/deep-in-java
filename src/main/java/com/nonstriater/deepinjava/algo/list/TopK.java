package com.nonstriater.deepinjava.algo.list;

import java.util.PriorityQueue;

/**
 * top-K 大
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 示例 输入: [3,2,1,5,6,4] 和 k = 2，输出: 5
 * 给出两个升序数组A、B和长度m、n，求第k个大的
 *
 * 思路：
 * 1：排序后，再求 k 大 ； logN
 * 2：小根堆，大小K
 */
public class TopK {


    public static void main(String[] args){

        int[] nums = new int[]{3,2,1,5,6,4};

        System.out.println("k=" + findMaxK(nums, 2));

    }

    /**
     * 小根堆实现
     */
    public static int findMaxK(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> (a-b) );

        for (int i = 0; i <nums.length ; i++) {
            //取出前k个元素放入 PQ 中
            if (i < k) {
                pq.add(nums[i]);
                continue;
            }

            Integer head = pq.peek();
            if (head < nums[i]) {//维护 priorityQueue 中元素只有k个
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.poll();
    }

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
