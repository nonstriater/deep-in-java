package com.company;

/**
 * 装箱 & 拆箱
 */
public class box {

    public static void main(String[] args) {
        /**
         * 看源码知道：ValueOf(i) 创建 Integer 对象的时候, 如果数值在 [-128, 127] 之间时，
         * 返回的 是 IntegerCache 中已经存在的对象的引用； 否则新建一个 Integer 对象
         * Float 的 ValueOf(i) 直接 new 一个新对象返回
         */
        Integer i1 = 10;
        Integer i2 = 10;

        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1 == i2); //同一个对象
        System.out.println(i3 == i4); //不同对象
    }


}
