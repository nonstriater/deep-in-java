package com.nonstriater.deepinjava.base.strings;

public class String5 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "a";
        String s3 = "bc";
        String s4 = "a" + "bc";

        System.out.println(s1 == s2+s3); //false
        System.out.println(s1 == s4); //true
    }
}
