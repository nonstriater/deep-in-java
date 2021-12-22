package com.nonstriater.deepinjava.algo.string;

import java.util.*;

/**
 * 有效的括号  eazy
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *   左括号必须用相同类型的右括号闭合。
 *   左括号必须以正确的顺序闭合
 *
 * 示例：
 *  输入：s = "()"
 *  输出：true
 *
 *  输入：s = "()[]{}"
 *  输出：true
 *
 *  输入：s = "([)]"
 *  输出：false
 *
 * 思路：遍历给定的字符串 ss
 * 1. 当我们遇到一个左括号时，我们会期望在后续的遍历中，有一个相同类型的右括号将其闭合;  将这个左括号放入栈
 * 2. 当我们遇到一个右括号时，我们需要将一个相同类型的左括号闭合。此时，我们可以取出栈顶的左括号并判断它们是否是相同类型的括号
 *
 * 为了快速判断括号的类型，我们可以使用哈希表存储每一种括号。哈希表的键为右括号，值为相同类型的左括号。
 */
public class validBracket {

    public static void main(String[] args){

        String s = "()[]{}";
        System.out.println(validBracket(s.toCharArray()));

        s = "([)]";
        System.out.println(validBracket(s.toCharArray()));
    }

    public static boolean validBracket(char[] chars){

        //为了快速判断括号的类型
        Map<Character, Character> map = new HashMap<Character, Character>(){
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };

        //栈
        Deque<Character> stack = new LinkedList<>();

        for (char c : chars) {

            if (map.containsKey(c)) {//遇到右括号

                Character top = stack.peek();//取栈顶
                if (top != map.get(c)) {//如果不相等，就返回false
                    return false;
                }

                stack.pop();//出栈
            } else {//遇到左括号
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
