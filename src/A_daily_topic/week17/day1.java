package A_daily_topic.week17;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.week17
 * @Author: yca
 * @CreateTime: 2022-12-26  13:43
 * @Description:
 *          387. 字符串中的第一个唯一字符
 *          https://leetcode.cn/problems/first-unique-character-in-a-string/
 *          1759. 统计同构子字符串的数目
 *          https://leetcode.cn/problems/count-number-of-homogenous-substrings/
 */
public class day1 {
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> frequency = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            }
            for (int i = 0; i < s.length(); ++i) {
                if (frequency.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }

        public int countHomogenous(String s) {
            int mod = (int) (1e9 + 7);
            int res = 0;
            int n = s.length();
            int idx = 1;
            char cur = s.charAt(0);
            int cnt = 1;
            while (idx < n){
                if (s.charAt(idx) == cur){
                    cnt++;
                }else {
                    res += (long)(cnt + 1) * cnt / 2 % mod;
                    res %= mod;
                    cnt = 1;
                    cur = s.charAt(idx);
                }
                idx++;
            }
            res += (long)(cnt + 1) * cnt / 2 % mod;
            res %= mod;
            return res;
        }
    }
}