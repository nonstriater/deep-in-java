package com.nonstriater.deepinjava.base.strings;

/**
 * 字符串连接运算符 +  优先级
 */
public class String3 {

    public static void main(String[] args){

        String a = 1 + 2 + " equals 3";
        System.out.println(a); //3 equals 3

        String b = "12 eqauls " + 1 + 2;
        System.out.println(b);//12 eqauls 12

    }
}
