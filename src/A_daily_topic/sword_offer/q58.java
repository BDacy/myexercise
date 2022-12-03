package A_daily_topic.sword_offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-03  19:20
 * @Description:
 *          剑指 Offer 58 - I. 翻转单词顺序
 *          https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/?favorite=xb9nqhhg
 */
public class q58 {
    class Solution {
        public String reverseWords(String s) {
            String str = s.trim();
            if (str.equals(""))return str;
            Deque<String> stack = new ArrayDeque<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' '){
                    int start = i;
                    while (i < str.length() && str.charAt(i) != ' ') i++;
                    int end = i;
                    stack.addFirst(str.substring(start, end));
                }
            }
            StringBuilder ans = new StringBuilder();
            while (!stack.isEmpty()){
                ans.append(stack.pollFirst()).append(" ");
            }
            return ans.substring(0,ans.length() - 1);
        }
    }
}