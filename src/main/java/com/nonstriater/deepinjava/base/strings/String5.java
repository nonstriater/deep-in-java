package com.nonstriater.deepinjava.base.strings;

/**
 * 字符串连接运算符 +
 * 常量优化机制 : 如果 = 表达式右边全部是常量， 编译器会计算出 = 右边的表达式结果， “abc”
 */
public class String5 {
    public static void main(String[] args) {

        test1();

        test2();
    }

    //常量优化机制 : 如果 = 表达式右边全部是常量， 编译器会计算出 = 右边的表达式结果， “abc”
    private static void test1(){
        String str = "a" + "b";
        String str2 = "ab";

        System.out.println(str == str2);//true
    }

    private static void test2(){

        String s1 = "abc";
        String s2 = "a";
        String s3 = "bc";
        String s4 = "a" + "bc";

        System.out.println(s1 == s2+s3); //false
        System.out.println(s1 == s4); //true
    }
}
