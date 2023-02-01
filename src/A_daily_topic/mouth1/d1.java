package A_daily_topic.mouth1;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-01  17:09
 * @Description:
 *          2325. 解密消息
 *          https://leetcode.cn/problems/decode-the-message/
 */
public class d1 {
    class Solution {
        public String decodeMessage(String key, String message) {
            char[] m = new char[26];
            boolean[] visited = new boolean[26];
            int idx = 0;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (c == ' ')continue;
                if (!visited[c - 'a']){
                    m[c - 'a'] = (char) ('a' + idx++);
                    visited[c - 'a'] = true;
                }
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char c = message.charAt(i);
                if (c == ' ')res.append(c);
                else res.append(m[c - 'a']);
            }
            return res.toString();
        }
    }
}