package com.nonstriater.deepinjava.base;

public class equal {

    public static void main(String[] args) {
        String a = new String("ab"); // a 为一个引用
        String b = new String("ab"); // b为另一个引用,对象的内容一样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // JVM先从常量池中查找，如果已经存在，就直接复制给当前引用，没有的话才创建新字符串
        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false，非同一对象
            System.out.println("a==b");
        if (a.equals(b)) // true
            System.out.println("aEQb");
        if (42 == 42.0) { // true , 这是为啥？
            System.out.println("true");
        }
        if (42 == 42L) { // true , 这是为啥？
            System.out.println("true");
        }
        if (42.0 == 42.0) {//true
            System.out.println("42.0 == 42.0 true");
        }
        if (0.3 == 0.3) {//true
            System.out.println("0.3 == 0.3 true");
        }
        if (3*0.1 == 0.3) {//false ； golang 中返回 true
            System.out.println("true");
        }
    }

}
