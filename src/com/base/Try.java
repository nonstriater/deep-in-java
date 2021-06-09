package com.base;

public class Try {

    public static void main(String[] args){

        System.out.println(testTry(2));
        System.out.println(testTry2(2));
        System.out.println(testTry3(2));
    }

    public static int testTry(int i){
        try {
            return i*i;
        } catch (Exception e) {

        } finally {//finally是在return后面的表达式运算后执行的,所以函数返回值是 在finally执行前确定的;
            System.out.println("finally");
            i = 5;
        }
        return 0;
    }




    /**
     * finally中最好不要包含return，否则程序会提前退出,返回值不是try或catch中保存的返回值
     * @param i
     * @return
     */
    public static int testTry2(int i){
        try {
            return i*i;
        } catch (Exception e) {

        } finally {
            System.out.println("finally");
            return 5;
        }
    }

    public static int testTry3(int i){
        try {
            return i++;
        } catch (Exception e) {

        } finally {//finally是在return后面的表达式运算后执行的,所以函数返回值是 在finally执行前确定的;
            System.out.println("finally, i=" + String.valueOf(i));
        }
        return 0;
    }

    public static int f(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                return 0;
            }
        }
    }

}
