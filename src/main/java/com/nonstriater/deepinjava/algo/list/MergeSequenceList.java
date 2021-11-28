package com.nonstriater.deepinjava.algo.list;

import java.util.Arrays;

/**
 * 合并2个有序数组
 * A = [4,5,6,8]
 * B = [1,2,7]
 * 合并后
 * A = [1,2,4,5,6,7,8]
 * //尾部向头部扫描，将大的值放在尾部
 */
public class MergeSequenceList {

    public static void main(String[] args){
        int[] a = new int[7];
        a[0]=4;
        a[1]=5;
        a[2]=6;
        a[3]=8;

        System.out.println(a.length);//7

        int[] b = new int[]{1,2,7};

        System.out.println(Arrays.toString(a));
        mergeSequenceList(a, 4 ,b);
        System.out.println(a); //[[I@30c028cc]
        System.out.println(Arrays.asList(a)); //[[I@30c028cc]
        System.out.println(Arrays.toString(a));
    }

    //尾部向头部扫描，将大的值放在尾部
    static void mergeSequenceList(int[] a, int aSize , int[] b){

        int len_a = a.length -1;

        int index_a = aSize -1;
        int index_b = b.length -1;

        while (index_a >= 0 && index_b >= 0) {

            //2个指针都有值时
            if (a[index_a] >= 0 && b[index_b] >= 0) {
                if (a[index_a] > b[index_b]) {
                    a[len_a--] = a[index_a--];
                }else{
                    a[len_a--] = b[index_b--];
                }
            }

            //a 无值，b有值 ； 把剩下b放好
            if (index_a < 0 &&  index_b >= 0) {
                while (index_b >= 0) {
                    a[len_a--] = b[index_b--];
                }
            }

            //a 有值，b无值; 把剩下a放好
            if (index_a >=0 &&  index_b < 0) {
                while (index_b >= 0) {

                }
            }
        }
    }

}
