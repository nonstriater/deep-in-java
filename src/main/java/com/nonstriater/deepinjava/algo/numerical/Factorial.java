package com.nonstriater.deepinjava.algo.numerical;

/**
 * 阶乘
 * 难点是 大数阶乘（比如 10w 阶乘， 50的阶乘已经65位了），需要通过字符串的方式来计算
 * 比如  50! = 50*49*48..*1
 * 思路：将乘数与被乘数的低位到高位依次相乘，加上每位计算的进位数，依次得到每一位的结果。
 * 结果低位先确定高位后确定, 每位数乘法运算后的结果
 *
 *
 * 示例：234*12
 * 先计算12*4=48，得temp=48+0=48
 * 留下8，进位数为4
 * 接着计算12*3=36，得temp=36+4=40
 * 留下0，进位数为4
 * 继续计算12*2=24，得temp=24+4=28
 * 留下8，进位数为2
 * 最后被乘数乘完，进位数为2，直接放置。
 * 得到的结果为2808。
 *
 * 就算知道思路，组织写出来代码也有一定难度
 */
public class Factorial {

    public static void main(String[] args){

        System.out.printf( "%s", factorial(100000));
    }

    /**
     * 1*2=2, 将2存到a[0]中
     * 接下来是用a[0]*3 , 将6储存在a[0]中
     * 接下来是用a[0]*4, 那么24%10==4存到a[0]中，24/10==2存到a[1]中
     * 接下来是用a[0]*5, a[1]*5+num
     * ...
     * 接下来是用a[0]*45, a[1]*45+num
     * @param n
     * @return
     */
    public static int[] factorial(int n){
        int[] ret = new int[1000];

        if (n <= 1 ) {
            ret[0] = 1;
            return ret;
        }

        int result_cnt = 1;// 记录结果的位数，初始化为1
        int temp ;  //临时变量，用来存储每位数乘法运算后的结果
        int digtal = 1;
        for (int i=1 ; i<n ; i ++) {

            //ret[] 每一位 相乘  i , 低位先确定高位后确定
            int num_index = 0;//临时变量数组的索引
            int carry = 0; //进位
            for (int j = result_cnt-1;  j>=0; j--) {
                temp = ret[j] * i + carry;
                carry = temp / 10;
                ret[num_index] = temp % 10;
                num_index++;
            }

            while (carry != 0) { //进位数， 也可能是2位以上，所以这里要用 while 处理
                ret[digtal] = carry % 10;
                carry /= carry;
                digtal++;
            }

        }

        return ret;
    }
}




