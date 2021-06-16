package com.nonstriater.deepinjava.base.strings;

/**
 * 如果常量池中存在当前字符串, 就会直接返回当前字符串. 如果常量池中没有此字符串, 会将此字符串放入常量池中后, 再返回
 */
public class Intern {

    public static void main(String[] args){

        test1();

        test2();

        test3();

        test4();
    }


    private static void test1(){
        String str1 = "string";
        String str2 = new String("string");
        String str3 = str2.intern();//会先在常量池中找是否有"string"字符串,如果池中已经有了，直接返回该字符串的引用

        System.out.println(str1==str2);
        System.out.println(str1==str3);//true
    }

    private static void test2(){
        String str1 = "str01";
        String str2 = new String("str") + new String("01");
        str2.intern();
        System.out.println(str2 == str1);
    }

    private static void test3(){
        String str2 = new String("str")+new String("01");
        str2.intern();//java1.7后,在常量池找不到对应的字符串，则不会再将字符串拷贝到常量池，而只是在常量池中生成一个对原字符串的引用
        String str1 = "str01";
        System.out.println(str2==str1);
    }

    private static void test4(){
        String baseStr = "baseStr";
        final String baseFinalStr = "baseStr";

        String str1 = "baseStr01";
        String str2 = "baseStr"+"01";
        String str3 = baseStr + "01";
        String str4 = baseFinalStr+"01";
        String str5 = new String("baseStr01").intern();

        System.out.println(str1 == str2);//true, str1和str2都指向常量池中的同一引用地址
        System.out.println(str1 == str3);//false, stringBuilder.append()生成
        System.out.println(str1 == str4);//true, 编译时就进行了替换，等同于字面量赋值
        System.out.println(str1 == str5);//true,在常量池中已经有"baseStr01"字符串
    }

}
