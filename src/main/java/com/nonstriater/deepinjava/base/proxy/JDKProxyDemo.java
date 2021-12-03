package com.nonstriater.deepinjava.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyDemo {

    private static class Student implements Person{
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public void giveTask() {
            System.out.println(name + "交语文作业");
        }
    }


    private static class StuHandler<T> implements InvocationHandler {

        T target ;

        public StuHandler(T target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("aop逻辑织入，代理执行" + method.getName() + "方法");
            return method.invoke(target, args);
        }
    }


    public static void main(String[] args){

        Person non = new Student("xiaoming");
        InvocationHandler invocationHandler =  new StuHandler<Person>(non);

        Person stuProxy =  (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, invocationHandler);
        stuProxy.giveTask();
    }


}
