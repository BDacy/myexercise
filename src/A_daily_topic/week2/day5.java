package A_daily_topic.week2;

import java.util.Stack;

/**
 * @Auther: yca
 * @Date: 2022/09/16/9:13
 * @Description:
 *          678. 有效的括号字符串
 *          https://leetcode.cn/problems/valid-parenthesis-string/
 */
public class day5 {
    /**
     * 该题也可以使用栈的方式进行解决，维护两个栈，
     * 左括号栈和星号栈，压入的是左括号和星号的下标
     * 从左到右进行扫描，进行不同情况的讨论
     */
    class Solution {
        //这里使用贪心算法
        public boolean checkValidString(String s) {
            int min=0;//左括号的未匹配的最小数
            int max=0;//左括号的未匹配的最大数
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c=='('){
                    min++;
                    max++;
                }else if (c==')'){
                    max--;
                    min=Math.max(min-1,0);
                }else {
                    min=Math.max(min-1,0);
                    max++;
                }
                if (max<0)return false;
            }
            return min==0;
        }
    }
}
