package com.nonstriater.deepinjava.base.io.buffer;

import java.nio.IntBuffer;

public class IntBufferDemo {

    public static void main(String[] args){

        IntBuffer intBuffer = IntBuffer.allocate(2);
        intBuffer.put(1);
        intBuffer.put(12345678);
        intBuffer.flip();//转为读模式
        System.out.println(intBuffer.get());//每当调用一次 get 方法读取数据时, buffer 的读指针都会向前移动一个单位长度

        System.out.println(intBuffer.get());

        intBuffer.clear();

        System.out.println(intBuffer.get());
        System.out.println(intBuffer.get());

    }
}

