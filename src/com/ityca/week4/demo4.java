package com.ityca.week4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//402. 移掉 K 位数字
public class demo4 {
    class Solution {
        public String removeKdigits(String num, int k) {
//            输入：num = "1432219", k = 3
//            输出："1219"
            //将字符串从左到右进行扫描，维护一个单调栈，使栈单调递增
            char[] chars = num.toCharArray();
            Deque<Character> deque=new LinkedList<>();
            deque.add(chars[0]);
            int n=chars.length;
            for (int i=1;i<n;i++){
                while (!deque.isEmpty()&&deque.peekLast()>chars[i]&&k>0){
                    deque.pollLast();
                    k--;
                }
                deque.add(chars[i]);
            }
            for (int i = 0; i < k; ++i) {
                deque.pollLast();
            }

            StringBuilder res = new StringBuilder();
            boolean leadingZero = true;
            while (!deque.isEmpty()) {
                char temp = deque.pollFirst();
                if (leadingZero && temp == '0') {
                    continue;
                }
                leadingZero = false;
                res.append(temp);
            }
            return res.length() == 0 ? "0" : res.toString();
        }
    }
}
