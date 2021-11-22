package com.nonstriater.deepinjava.algo.list;

/**
 * 统计数字出现的次数
 *
 * 给定一个无序数组，长度为n，每个元素都属于范围[1,n]之间，使用时间复杂度O(n)+空间复杂度O(1)的方法，求得每个元素的出现次数。
 * 比如给定数组[1,2,2,3,5,3]，最后的结果就是类似于1:1,2:2,3:2,5:1的形式，表示1出现了1次，2出现了2次，3出现了2次，5出现了1次。
 * 1 2 2 0 1
 *
 * 遍历思路：通过当前位置的数找到对应的下标位置，如果为正数，说明还没有被访问到，需要交换并置为-1，
 * 若为负数，需要减去1，若找到的下标不为自己，则把当前位置设为0，之后继续遍历
 *
 // 数组举例
 int[] arr = {2, 5, 5, 2, 3};
 /*
 1、遍历数组，第一个arr[0]=2，然后看下标为2的元素是arr[2]=5。
 2、把arr[2]对应的5赋值给arr[0]，然后arr[2]就设置为-1
 3、然后重复整个过程直到结束
 它的整个变化过程就是这样
 - {2, 5, 5, 2, 3}
 - 5, [-1], 5, 2, 3
 - 3, [-1], 5, 2, [-1]
 - 5, [-1], [-1], 2, [-1]
 - [0], [-1], [-1], 2, [-2]
 - [0], [-2], [-1], [0], [-2]
 这个结果表示：1有0个，2有2个，3有一个，4有0个，5有2个
 */

public class StatNumber {

    public static void main(String args){
        int[] nums = new int[]{2,5,5,2,3};
        statNumber(nums);

        for (int i : nums) {
            System.out.println(i + "出现次数：" + nums[i]);
        }
    }

    //{2, 5, 5, 2, 3}
    public static void statNumber(int[] nums){
        int index = 0;
        while (index < nums.length) {

            if (nums[index] < 0) {
                index ++ ;
                continue;
            }

            int temp =  nums[index] -1;
            if (nums[temp] > 0) {
                nums[temp] = -1;
            }


        }

    }

}
