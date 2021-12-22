package com.nonstriater.deepinjava.algo.queue;

/**
 * 用栈实现队列（简单）: 用2个栈 来实现
 *  入队操作:
 *      1 先将存放数据的栈弹入 辅助栈
 *      2 再把需加入的新元素压入数据栈底
 *      3 最后把 辅助栈 中的元素弹出依次压入数据栈，这样保证了新加入的元素
 *  出队操作： 直接出栈弹出即可
 *
 * 用队列实现栈（简单）:
 *      进栈操作：
 *      出栈操作：
 */
public class StackQueue {

    /** 添加元素到队尾 */
    public void push(int x){}

    /** 删除队头的元素并返回 */
    public int pop(){
        return 0;
    }

    /** 返回队头元素 */
    public int peek(){
        return 0;
    }

    /** 判断队列是否为空 */
    public boolean empty(){
        return false;
    }

}
