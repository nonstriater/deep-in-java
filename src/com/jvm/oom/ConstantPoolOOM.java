package com.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -XX:PermSize=1M -XX:MaxPermSize=1M
 *
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=1M; support was removed in 8.0
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=1M; support was removed in 8.0
 */
public class ConstantPoolOOM {

    public static void main(String[] args){
        //避免回收
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

}
