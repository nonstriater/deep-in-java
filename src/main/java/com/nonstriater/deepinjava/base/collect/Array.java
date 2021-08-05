package com.nonstriater.deepinjava.base.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Array {

    private  static class Person {
        String name;
        int age;
        String habit;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getHabit() {
            return habit;
        }

        public void setHabit(String habit) {
            this.habit = habit;
        }
    }

    public static void main(String[] args){

        {
            List<Person> ppls = new LinkedList<>();
            Person p1 = new Person();
            p1.setName("lily");
            p1.setAge(20);
            ppls.add(p1);

            Person p2 = new Person();
            p2.setName("lucy");
            p2.setAge(25);
            ppls.add(p2);

            System.out.println(ppls);

            ppls.removeIf(person -> {
                if (person.getName().equals("lucy")) {
                    return true;
                }

                person.setHabit("reading");
                return false;
            });

            System.out.println(ppls);

        }

        {
            List<String> ids = new ArrayList<>(10);
            System.out.println(ids.size()); //有个 private int size 变量标记容量大小
            ids.add("1");
            ids.add("4");
            ids.add("7");
            ids.add(2,"hi");//先 拿这里的 index（3） 与 size 比较，超过就抛异常
            System.out.println(ids);
        }

        {
            List<String> ids = Arrays.asList("1","2","3");
            List<String> newIds = ids.stream().filter(x -> !x.equals("2")).collect(Collectors.toList());
            System.out.println(ids);
            System.out.println(newIds);
        }

        {
            List<String> ids = new LinkedList<>(Arrays.asList("1","2","3")) ;
            List<String> newIds = ids.stream().filter(x -> ! x.equals("2")).collect(Collectors.toList());
            System.out.println(ids);
            System.out.println(newIds);
        }

    }


}
