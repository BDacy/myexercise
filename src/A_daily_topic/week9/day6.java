package A_daily_topic.week9;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsPackage: A_daily_topic.week9
 * @Author: yca
 * @CreateTime: 2022-11-05  09:24
 * @Description:
 *          125. 验证回文串
 *          https://leetcode.cn/problems/valid-palindrome/description/
 *          1106. 解析布尔表达式
 *          https://leetcode.cn/problems/parsing-a-boolean-expression/
 */
public class day6 {
    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(Solution.isPalindrome(s));
    }

    //    "race a car"
    class Solution {
        public static boolean isPalindrome(String s) {
            //直接在原字符串上利用双指针进行操作
            int low = 0;
            int high = s.length() - 1;
            while (low < high) {
                while (low < high && Check(s.charAt(low)))
                    low++;
                while (low < high && Check(s.charAt(high)))
                    high--;
                if (low < high)
                    if (Character.toLowerCase(s.charAt(low)) == Character.toLowerCase(s.charAt(high))) {
                        low++;
                        high--;
                    } else return false;
            }
            return true;
        }

        public static boolean Check(char c) {
            return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9');
        }

        public boolean parseBoolExpr(String expression) {
            //放括号和‘t’和‘f’
            Deque<Character> deque1 = new LinkedList<>();
            //放运算符
            Deque<Character> deque2 = new LinkedList<>();
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == ',') continue;
                else if (c == '(' || c == 't' || c == 'f')
                    deque1.addLast(c);
                else if (c == '&' || c == '|' || c == '!')
                    deque2.addLast(c);
                else {
                    // c == ')'
                    Character op = deque2.pollLast();
                    if (op == '!') {
                        Character c1 = deque1.pollLast();
                        deque1.pollLast();
                        deque1.addLast(c1 == 't' ? 'f' : 't');
                    } else if (op == '&') {
                        //and运算有一个false则结果为false
                        Character c1 = 't';
                        while (deque1.peekLast() != '(')
                            if (deque1.pollLast() == 'f') c1 = 'f';
                        //去掉'('
                        deque1.pollLast();
                        deque1.addLast(c1);
                    } else if (op == '|') {
                        //or运算有一个true则结果为true
                        Character c1 = 'f';
                        while (deque1.peekLast() != '(')
                            if (deque1.pollLast() == 't') c1 = 't';
                        //去掉'('
                        deque1.pollLast();
                        deque1.addLast(c1);
                    }
                }
            }
            return deque1.pollLast() == 't';
        }
    }
}