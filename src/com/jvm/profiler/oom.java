package com.jvm.profiler;

import java.util.ArrayList;
import java.util.List;

public class oom {
    private static final Integer K = 1024;

    public static void main(String[] args){
        int sizePerOnce = 8 * K * K; //8MB
        List<byte[]> list = new ArrayList<byte[]>();
        for (int i=0; i< K ; i++) {
            System.out.println("JVM分配内存，" + (i+1) + "次");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            list.add(new byte[sizePerOnce]);
        }

    }



}
