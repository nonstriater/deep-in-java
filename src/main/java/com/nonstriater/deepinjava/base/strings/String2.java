package com.nonstriater.deepinjava.base.strings;

public class String2 {

    int a ;
    String b;

    public static void main(String[] args){

        test1();
    }

    private static void test1(){
        String2 str = new String2();
        str.a = 12;
        str.b = "233";

        String s = String.format("str:%s", str);
        System.out.println(s);
    }

    private void test2(){



    }

}
