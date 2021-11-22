package com.nonstriater.deepinjava.algo.string.search;

/**
 * 最长回文子串（难度 中等）
 * 回文是指正着读和倒着读，结果一些样，比如abcba或abba
 *
 * 示例 1：输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：输入：s = "cbbd"
 * 输出："bb"
 *
 * 思路1: 暴力
 *
 * 思路2: 动态规划 ,  s[i,j] 是子串，
 * 如果 S[i+1,j-1]是回文串，那么只要 S[ i ] == S[ j ] ，就可以确定 S[i,j] 也是回文串了。
 * 需要额外的空间O（N^2)，算法复杂度也是O(N^2)
 *
 * 思路3: 中心扩展，可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可
 * 把给定的字符串的每一个字母当做中心，向两边扩展，这样来找最长的子回文串。要考虑 aba, abba，这样长度为基数or偶数
 * 算法复杂度为O(N^2)；
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    /**
     * 中心扩展的思路
     * 由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有
     * n +（n-1）个中心
     * @param s
     * @return
     */
    public static String longestHW(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);//基数长度字符串
            int len2 = expandAroundCenter(s, i, i+1);//偶数长度字符串

            int len = Math.max(len1, len2);//取大结果
            if (len > end - start) {
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // 返回以 s[l] 和 s[r] 为中心的最长回文串
    public static  int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return (R-1) - (L+1) + 1;
    }



    /**
     * 动态规划思路：
     * 二维数组  boolean[][] dp = new boolean[n][n];
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        //bad case
        int n = s.length();
        if(n == 0 || n==1){
            return s;
        }

        //定义二位数组存储值，记录索引 i 和索引 j之间的元素是不是回文的
        ////初始化全部都是false
        boolean[][] dp = new boolean[n][n];

        int start = 0; //回文串的开始位置
        int max = 1; //回文串的最大长度
        for(int i=0; i<n;i++) {
            dp[i][i]=true;  //1个元素的肯定是true，这个回文没有什么太多意义，适合三个元素回文

            //下面两个紧挨的元素相同的也变为true,之后就可以从三个开始找，这个情况适合四个元素的回文
            if(i<n-1 && s.charAt(i) == s.charAt(i+1)){//n-1是为了防止s.charAt(i+1)发生越界异常
                dp[i][i+1] = true;
                start = i; //如果最后没有大于三的，那么最长就是2个元素的
                max=2;
            }
        }

        for (int l=3;l<=n;l++){ //l表示检索的子串长度，等于3表示先检索长度为3的子串
            for(int i =0; i+l-1 < n; i++){
                int j = l+i-1; //终止字符位置
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]==true){
                    dp[i][j] = true;
                    start = i;
                    max = l;
                }
            }
        }

        return s.substring(start,start + max);
    }

}
