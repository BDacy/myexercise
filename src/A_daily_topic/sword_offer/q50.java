package A_daily_topic.sword_offer;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-03  19:37
 * @Description:
 *          剑指 Offer 50. 第一个只出现一次的字符
 *          https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/?favorite=xb9nqhhg
 */
public class q50 {
    class Solution {
        public char firstUniqChar(String s) {
            String str = s.trim();
            if (str.equals(""))return ' ';
            int[] val = new int[26];
            Deque<Character> deque = new ArrayDeque<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (val[c - 'a'] == 0)
                    deque.addLast(c);
                val[c - 'a']++;
            }
            while (!deque.isEmpty()){
                char c = deque.pollFirst();
                if (val[c - 'a'] == 1)return c;
            }
            return ' ';
        }
        // 计数数组
        public char firstUniqChar1(String s) {
            int[] count = new int[26];
            char[] chars = s.toCharArray();
            for (char c : chars) count[c - 'a']++;
            for (char c : chars) {
                if (count[c - 'a'] == 1) return c;
            }
            return ' ';
        }
    }
}