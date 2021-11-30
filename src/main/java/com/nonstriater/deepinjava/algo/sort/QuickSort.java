package com.nonstriater.deepinjava.algo.sort;

/**
 * 快排
 */
public class QuickSort {

    public static void main(String[] args){

        int[] nums = new int[]{4,1,2,9,3};
        for (int i=0; i< nums.length; i++) {
            System.out.println(nums[i]);
        }

        qsort(nums, 0, nums.length-1);

        for (int i=0; i< nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    static void qsort(int[] nums, int left, int right){

        if (left < right) {
            int i = partition(nums, left, right);

            qsort(nums, left, i-1);
            qsort(nums, i+1, right);

        }
    }

    //4,1,2,9,3
    static int partition(int[] nums, int left, int right){

        int pivot = nums[right];//尾部节点
        int end = right;

        right--;
        while (left < right) {

            if (nums[left] <= pivot) {
                left ++ ;
                continue;
            }

            //swap left & right
            swap(nums, left, right);
            right--;

        }

        int i = 0;
        if (nums[left] <= pivot) {
            //swap left+1 & pivot
           i = left +1;
        } else {//swap left & pivot
           i =  left ;
        }

        swap(nums, i, end);

        return i;
    }


    static void swap(int[] nums, int left , int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}
