package com.nonstriater.deepinjava.base;

public class Test1 {

    public static void main(String[] args){
//        {
//            Long lng = null;
//            System.out.println(10-lng);
//        }

        {
            MyEnum e = MyEnum.Agency1;
            System.out.println(e.name());//Agency1
            System.out.println(e.ordinal());//0
            System.out.println(MyEnum.valueOf("Agency1"));
            System.out.println(MyEnum.valueOf("a1"));
            System.out.println(MyEnum.valueOf("ab"));
        }
    }

}
