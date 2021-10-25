package com.nonstriater.deepinjava.algo.string.search;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复子串 （滑动串口， 难度 中等）
 * 给一个字符串，找出不包含有重复字符的最长子串的长度
 * 如 ”abcabbcbb“ 输出 3
 */
public class LongestSubString {

    public static void main(String[] args){

        String s = "afbcbb";
        System.out.println(longestSubString(s.toCharArray()));

    }

    public static int longestSubString(char[] s){
        int left = 0, right = 0;
        int res = 0; // 记录最长结果

        Map<Character, Integer> window = new HashMap<Character, Integer>();
        //Set<Character> window = new HashSet<>();
        while (right < s.length) {
            Character c = s[right];
            //窗口变大
            right++;
            //window.put(c, right++);
            //window[c]++;
            window.put(c, window.getOrDefault(c, 0)+1); //java写的麻烦,不一定记得这个api

            if (window.get(c) > 1) {
                //判断左侧窗口是否要收缩
                char d = s[left];
                left ++;
                window.put(d, window.get(d)-1);
            }

            // 在这里更新答案
            res = res > (right-left) ? res: (right-left);

        }
        return res;
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


    /**
     * 方法二：
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
     * 我们定义不重复子串的开始位置为 start，结束位置为 end； [start, end] 可理解为滑动窗口
     * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
     * 无论是否更新 start，都会更新其 map 数据结构和结果 max。
     * 时间复杂度：O(n)
     *
     * @param s 字符串参数
     * @return int 长度
     * @author guanpengchn
     * @link https://leetcode-cn.com/problems/two-sum/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
     */
    public static int lengthOfLongestSubstringMethod2(String s) {

        // max 表示所求的最大长度
        int max = 0;

        /* Map 中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
         * 同一个字符 key，在 map 中只存在一个。当重复时更新它的值。
         */
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        /* start 指向不重复子串的第一个字符的下标。
         * 当存在重复字符时 start 指向后面一个重复字符，指向下一个不重复子串的第一个字符的下标
         */
        for (int start = 0, end = 0; end < s.length(); end++) {

            char c = s.charAt(end);

            if (map.containsKey(c)) {

                /* 如果含有重复字符串，将滑动窗户的开始位置更新，后移
                 * map.get(c) 的值表示该出现重复的字符，上一次出现时下标+1
                 * 什么时候会出现 start<map.get(c)？
                 * 答：map.get(c) 该重复字符出现的位置不一定，如果重复字符出现的顺序和之前一样，
                 * 比如：abcabcd，先重 a，再重 b
                 * 什么时候会出现 start>map.get(c)？
                 * 答：第二次出现重复时，如果重复的字符在第一次出现重复的字符前面
                 * 比如 abba，先重 b，再重 a。出现 a 重复时，start 为 2 > map.get('a') 为 1
                 */
                start = Math.max(map.get(c), start);
            }

            /* 不管是否重复这里都会执行
             * 每次执行判断一次滑动窗口长度是否超过当前最大长度，是则更新
             * end - start + 1 表示滑动窗口长度，子串长度，不重复子串最短也为 1
             * 为什么要 + 1？
             * 当 start 和 end 指向一个是元素时，下标一样，end-start 为 0，此时存在一个不重复子串为 1 个元素
             * 当 end 指向 start 后面相邻一个，end-start 为 1，此时不重复子串为 2 个元素
             */
            max = Math.max(max, end - start + 1);

            /* 不管是否重复这里都会执行
             * 如果不重复，会新添加一个 key，值为：位置下标+1
             * 如果重复，会更新这个 key 对应的值为：后面又重复出现的该字符的位置下标+1
             */
            map.put(c, end + 1);
        }

        return max;
    }



}
