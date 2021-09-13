package com.nonstriater.deepinjava.algo.string.search;

import org.apache.commons.collections.map.LinkedMap;

import java.util.Map;

/**
 * 给一个字符串，找出不包含有重复字符的最长子串的长度
 * 如 ”abcabbcbb“ 输出 3
 */
public class LongestSubString {

    public static void main(String[] args){

        String s = "abcabbcbb";
        System.out.println(longestSubString(s.toCharArray()));

    }

    //java字符串处理时，字典定义 map<char, int> 不太方便
    int lengthOfLongestSubstring(char[] s) {
        return 0;
        //unordered_map<char, int> window;
        //Map<String, Integer> window = new LinkedMap();

//        int left = 0, right = 0;
//        int res = 0; // 记录结果
//        while (right < s.length) {
//            char c = s[right];
//            right++;
//            // 进行窗口内数据的一系列更新
//            window[c]++;
//            // 判断左侧窗口是否要收缩
//            while (window[c] > 1) {
//                char d = s[left];
//                left++;
//                // 进行窗口内数据的一系列更新
//                window[d]--;
//            }
//            // 在这里更新答案
//            res = max(res, right - left);
//        }
//        return res;
    }

    //not work!!!!
    public static int longestSubString(char[] s){
        int left = 0, right = 0;
        int res = 0; // 记录结果

        while (right++ < s.length) {
            //窗口变大
            char c = s[right];

            char d = s[left];
            // 判断左侧窗口是否要收缩
            if(d == c) {
                left ++;
            }

            // 在这里更新答案
            res = res > (right - left) ? res: (right - left) ;
        }
        return res;
    }
}
