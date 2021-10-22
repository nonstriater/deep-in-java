package com.nonstriater.deepinjava.algo.string.search;

import org.apache.commons.collections.map.LinkedMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复子串 （滑动串口， 难度 中等）
 * 给一个字符串，找出不包含有重复字符的最长子串的长度
 * 如 ”abcabbcbb“ 输出 3
 */
public class LongestSubString {

    public static void main(String[] args){

        String s = "abcabbcbb";
        System.out.println(longestSubString(s.toCharArray()));

    }



    //java字符串处理时，字典定义 map<char, int> 不太方便
    //map<Character, int>
    //Map<Character, Integer> window = new HashMap<>();
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
//
//            // 在这里更新答案
//            res = max(res, right - left);
//        }
//        return res;
    }

    //not work!!!!
    public static int longestSubString(char[] s){
        int left = 0, right = 0;
        int res = 0; // 记录结果

        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length) {
            char c = s[right];
            //窗口变大
            right++;

            //判断左侧窗口是否要收缩
            char d = s[left];
            if(d == c) {
                left ++;
            }

            // 在这里更新答案
            res = res > (right - left) ? res: (right - left) ;
        }
        return res;
    }
}
