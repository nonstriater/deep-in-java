package com.nonstriater.deepinjava.base.collect;

import java.util.LinkedList;
import java.util.List;

//LinkedList
public class QueueDemo {

    public static void main(String[] args){

        //add 队尾加元素，队列满就会抛异常
        //remove
        {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.remove(1);
            System.out.println(list);

            list.remove(Integer.valueOf(3));
            System.out.println(list);
        }

        //offer 队尾加元素， 队列满就会null
        //pull  队头出元素
        {
            LinkedList<Integer> list = new LinkedList<>();
            list.offer(1);
            list.offer(2);
            list.offer(3);
            System.out.println(list.peek());//1

            list.poll();
            System.out.println(list.peek());//2
        }

    }

}
