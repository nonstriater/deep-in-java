package com.nonstriater.deepinjava.algo.search;

/**
 * 简单的二分查找
 */
public class BinSearch {

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6,7};

        System.out.println(binarySearch(nums, nums.length, 3));
        System.out.println(binarySearch(nums, nums.length, 6));

        System.out.println(binarySearch(nums, nums.length, 8));
    }

    /**
     * @param A
     * @param length
     * @param target
     * @return
     */
    public static int binarySearch(int[] A, int length,  int target){
        int mid ;
        int low = 0;
        int high = length -1;
        while (low < high) {
            mid = (low + high) / 2;
            if (A[mid] > target) {
                high = mid-1;
            } else if (A[mid] == target) {
                return A[mid];
            }else if (A[mid] < target) {
                low = mid + 1; //不+1的话， 会有个bug： 可能 死循环
            }
        }
        return -1;
    }
}
