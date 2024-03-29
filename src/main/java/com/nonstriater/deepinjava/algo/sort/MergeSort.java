package com.nonstriater.deepinjava.algo.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 1 将一个数组分成大小相同的子数组
 * 2 将各个子数组都排好序
 * 3 然后 merge n个有序数组
 */
public class MergeSort {

    public static void main(String[] args){
        int[] list = new int[]{5,3,8,1,4,33,12};

        System.out.println(Arrays.toString(list));
        mergeSort(list, 0 , list.length);
        System.out.println(Arrays.toString(list));
    }

    public static void mergeSort(int[] list, int low, int high){

        //先分成2半，左边， 右边 排好序，再 merge
        int mid = (low + high) / 2;
        mergeSort(list, low, mid);
        mergeSort(list, mid+1, high);

        // 合并两个排好序的子数组
        merge(list, low, mid, high);

    }

    /**
     * 合并2个有序数组
     * @param list
     * @param low
     * @param middle
     * @param high
     */
    private static void merge(int[] list, int low, int middle , int high) {

    }



}
