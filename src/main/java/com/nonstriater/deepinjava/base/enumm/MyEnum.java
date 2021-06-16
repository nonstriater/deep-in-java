package com.nonstriater.deepinjava.base.enumm;

public enum MyEnum {

    Agency1("a1"),//0
    Agency2("a2");//1

    private String name;

    MyEnum(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public boolean contain(String name) {
        return false;
    }
}