package A_daily_topic.week19;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week19
 * @Author: yca
 * @CreateTime: 2023-01-12  13:55
 * @Description:
 *          316. 去除重复字母
 *          https://leetcode.cn/problems/remove-duplicate-letters/
 *          1807. 替换字符串中的括号内容
 *          https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/
 */
public class day4 {
    class Solution {
        public String removeDuplicateLetters(String s) {
            // 首先对字母进行计数
            int[] cnt = new int[26];
            int m = s.length();
            for(int i = 0; i < m; i++){
                char c = s.charAt(i);
                cnt[c - 'a']++;
            }

            // 搞一个单调栈
            Deque<Character> stack = new ArrayDeque<>();
            boolean[] val = new boolean[26];
            // 从左到右遍历
            for(int i = 0; i < m; i++){
                char c = s.charAt(i);
                if(val[c - 'a']){
                    cnt[c - 'a']--;
                    continue;
                }
                else{
                    while(!stack.isEmpty() && stack.peekFirst() > c){
                        // 如果该字母唯一则直接入栈
                        if(cnt[stack.peekFirst() - 'a'] == 1)break;
                        else{
                            // 否则去掉并个数减一
                            val[stack.peekFirst() - 'a'] = false;
                            cnt[stack.pollFirst() - 'a']--;
                        }
                    }
                    stack.addFirst(c);
                    val[c - 'a'] = true;
                }
            }
            StringBuilder res = new StringBuilder();
            while(!stack.isEmpty()){
                res.append(stack.pollLast());
            }
            return res.toString();
        }

        public String evaluate(String s, List<List<String>> knowledge) {
            Deque<String> stack = new ArrayDeque<>();
            Map<String,String> map = new HashMap<>();
            for (List<String> list : knowledge) {
                map.put(list.get(0), list.get(1));
            }
            int m = s.length();
            int last = 0;
            for (int i = 0; i < m; i++) {
                char c = s.charAt(i);
                if (c == '('){
                    stack.addFirst(s.substring(last, i));
                    int idx = i + 1;
                    while (idx < m && s.charAt(idx) != ')')idx++;
                    String substring = s.substring(i + 1, idx);
                    String tmp = map.getOrDefault(substring, "?");
                    stack.addFirst(tmp);
                    i = idx;
                    last = i + 1;
                }
            }
            stack.addFirst(s.substring(last));
            StringBuilder res = new StringBuilder();
            while (!stack.isEmpty()){
                res.append(stack.pollLast());
            }
            return res.toString();
        }
    }
}