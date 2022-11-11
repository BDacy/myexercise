package A_daily_topic.week10;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week10
 * @Author: yca
 * @CreateTime: 2022-11-11  12:00
 * @Description:
 *          722. 删除注释
 *          https://leetcode.cn/problems/remove-comments/
 *          1704. 判断字符串的两半是否相似
 *          https://leetcode.cn/problems/determine-if-string-halves-are-alike/
 */
public class day5 {
    class Solution {
        public List<String> removeComments(String[] source) {
            boolean inBlock = false;
            StringBuilder newline = new StringBuilder();
            List<String> ans = new LinkedList<>();
            for (String line: source) {
                int i = 0;
                char[] chars = line.toCharArray();
                if (!inBlock) newline = new StringBuilder();
                while (i < line.length()) {
                    if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                        inBlock = true;
                        i++;
                    } else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                        inBlock = false;
                        i++;
                    } else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                        break;
                    } else if (!inBlock) {
                        newline.append(chars[i]);
                    }
                    i++;
                }
                if (!inBlock && newline.length() > 0) {
                    ans.add(new String(newline));
                }
            }
            return ans;
        }
        public boolean halvesAreAlike(String s) {
            char[] chars = {'a','e','i','o','u','A','E','I','O','U'};
            Set<Character> set = new HashSet<>();
            for (char aChar : chars) set.add(aChar);
            String s1 = s.substring(0, s.length() / 2);
            String s2 = s.substring(s.length() / 2);
            int cnt = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (set.contains(s1.charAt(i)))cnt++;
            }
            for (int i = 0; i < s2.length(); i++) {
                if (set.contains(s2.charAt(i)))cnt--;
            }
            return cnt == 0;
        }
    }
}