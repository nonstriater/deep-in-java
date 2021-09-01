package com.nonstriater.deepinjava.algo.numerical;

import java.util.Objects;

public class IPUtil {

    public static void main(String[] args){

        System.out.println(intToIp(3));
        System.out.println(intToIp(128));
        System.out.println(intToIp(257)); //0.0.1.1
        System.out.println(intToIp(1000));//0.0.3.232

        System.out.println(ipToInt("10.25.3.232"));//169411560
        System.out.println(ipToInt("0.0.1.1"));//257
        System.out.println(ipToInt("0.0.3.232"));//1000

    }

    /**
     *  257 -> 0.0.1.1
     * @param ip
     * @return
     */
    public static String intToIp(int ip) {
        StringBuilder buf = new StringBuilder();
        buf.append(ip >>> 24); // >>> 移位以后用0填充高位；
        buf.append('.');
        buf.append(0xff & (ip >>> 16));//右移16位以后，取低8 bit
        buf.append('.');
        buf.append(0xff & (ip >>> 8));
        buf.append('.');
        buf.append(0xff & ip);//取低 8 bit
        return buf.toString();
    }

    /**
     * 0.0.1.1 -> 257
     * @param ip
     * @return
     */
    public static int ipToInt(String ip) {
        Objects.requireNonNull(ip);
        int ret = 0;
        int unit = 0; //每一段算整数用
        int index = 0; //第几段； 还可以做 异常检查用
        boolean dot = true; //上一个是否为. ；
        for (int i = 0; i < ip.length(); i++) {
            char c = ip.charAt(i);
            if (c == '.') {
                if (dot) {
                    index = -1;
                    break;
                }
                index++;
                ret = ret << 8 | unit; //ret 左移8bit， 低 8 bit 填充 unit
                dot = true;
                unit = 0;
            } else if (c >= '0' && c <= '9') {
                dot = false;
                unit = unit * 10 + (c - 48); // (c-'0') 如果记不得 '0' 编码是 48
                if (unit > 255) {
                    index = -1;
                    break;
                }
            } else {
                index = -1;
                break;
            }
        }
        if (dot || index != 3) {
            throw new IllegalArgumentException("Invalid ip: " + ip);
        }
        ret = ret << 8 | unit;
        return ret;
    }

}
