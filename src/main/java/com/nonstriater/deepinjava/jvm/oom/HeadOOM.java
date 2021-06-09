package com.nonstriater.deepinjava.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * Dumping heap to java_pid40074.hprof ...
 * Heap dump file created [19966301 bytes in 0.024 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */
public class HeadOOM {
    private static final Integer SIZE = 1*1024*1028;

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    static class OOMObject {
        private byte[] str ;

        OOMObject(){
            str = new byte[1*1024*1028];
        }
    }
}
