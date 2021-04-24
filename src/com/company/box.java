package com.company;

/**
 * 装箱 & 拆箱
 */
public class box {

    public static void main(String[] args) {

        //test1();
        test2();
    }

    public static void test1(){
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

    public static void test2(){
        int i = 40;
        int i0 = 40;
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        Double d1=1.0;
        Double d2=1.0;

        System.out.println("i=i0\t" + (i == i0));
        System.out.println("i1=i2\t" + (i1 == i2));

        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3)); //栈上拆箱
        System.out.println("i4=i5\t" + (i4 == i5)); //new 的对象在堆上，false
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));
        System.out.println("d1=d2\t" + (d1==d2)); //false

        System.out.println();
    }


}
