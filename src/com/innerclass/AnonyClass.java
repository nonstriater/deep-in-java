package com.innerclass;

//匿名内部类实现回调功能，常见的如 Runnable 接口创建线程
public class AnonyClass {

    public void test(InnerInterfaceDemo demo){
        System.out.println("hello, anony class");
    }

    public static void main(String[] args){
        final String title =  "title1";
        AnonyClass ac = new AnonyClass();
        ac.test(new InnerInterfaceDemo() {//使用匿名内部类的方式将接口对象作为参数
            @Override
            public void test() {
                //  title =  "title2"; //编译报错，匿名内部内不能修改局部变量的值
                System.out.println("接口实现");
            }
        });
    }
}
