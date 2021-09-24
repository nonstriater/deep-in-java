package com.nonstriater.deepinjava.algo.search;

/**
 * 单调非递减数组, 指定一个数,  返回最小下标
 * 单调非递减数组 ： 就是 有序（有重复数字的）递增数组
 *
 * 在排序数组中查找元素的第一个和最后一个位置（中等）
 * 难点： 细节是魔鬼，mid 加一还是减一，while 里到底用 <= 还是 <
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3,3,7};
        //System.out.println(binarySearchLowerBound(nums, 3, nums.length));

        System.out.println(leftBinarySearch(nums, 3));

    }

    /**
     * 二分查找
     * @param A
     * @param target
     * @param n 数组长度
     * @return  索引index
     */
    public static int binarySearchLowerBound(int[] A, int target, int n){
        int low = 0, high = n, mid;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(target <= A[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if(low < A.length && A[low] == target)
            return low;
        else
            return -1;
    }

    public static int leftBinarySearch(int[] A, int target){
        int low = 0, high = A.length, mid;

        while(low < high){
            mid = low + (high - low) / 2;

            if(target < A[mid]){
                high = mid ;
            }else if (target == A[mid]) {
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

}
