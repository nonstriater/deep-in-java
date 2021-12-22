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

    /**
     * 快排
     * @param nums
     * @param left
     * @param right
     */
    static void qsort(int[] nums, int left, int right){

        if (left < right) {
            //先分成2半，左边 < 右边
            int i = partition(nums, left, right);

            qsort(nums, left, i-1);
            qsort(nums, i+1, right);

        }
    }

    /**
     *  排序 [left, right] , 找到索引i， 使得 i左边 < i右边
     *  思路：选 尾部节点 作为 pivot， 移动元素，使得 左边的元素 小于  pivot， 右边的大于  pivot
     *
     * 如： 4,1,2,9,3 ，  pivot是 3
     * 遍历，数据移动过程：
     * 9,1,2,4,3
     * 9,1,2,4,3
     * 2,1,9,4,3
     * 2,1,3,4,9
     */

    static int partition(int[] nums, int left, int right){

        int pivot = nums[right];//选 尾部节点 作为 pivot
        int end = right;

        right--;
        while (left < right) {

            if (nums[left] <= pivot) {//左指针右移
                left ++ ;
                continue;
            }

            //swap left & right
            swap(nums, left, right);
            right--; //右指针左移

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
