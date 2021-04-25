package com.thread.communication;

import java.util.concurrent.CyclicBarrier;

/**
 * 线程 A B C 各自开始准备，直到三者都准备完毕 (reach a common barrier point) ，然后再同时运行
 */
public class CyclicBarrierDemo {

    CyclicBarrier cb = new  CyclicBarrier(3);
}
