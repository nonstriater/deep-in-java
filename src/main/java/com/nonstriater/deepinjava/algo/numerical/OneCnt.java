package com.nonstriater.deepinjava.algo.numerical;

/**
 * 整数二进制1的个数
 */
public class OneCnt {

    public static void main(String[] args){

        System.out.println(oneCnt(3));

        System.out.println(oneCnt(4));

        System.out.println(oneCnt(15));

    }

    /**
     * 整数二进制1的个数
     * @param value
     */
    public static int oneCnt(int value){
        int ret = 0;
        while (value !=0) {
            value = value & (value-1);
            ret++;
        }
        return ret;
    }
}
