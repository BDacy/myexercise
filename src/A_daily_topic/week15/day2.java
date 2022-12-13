package A_daily_topic.week15;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsPackage: A_daily_topic.week15
 * @Author: yca
 * @CreateTime: 2022-12-13  09:27
 * @Description:
 *          1576. 替换所有的问号
 *          https://leetcode.cn/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 *          1832. 判断句子是否为全字母句
 *          https://leetcode.cn/problems/check-if-the-sentence-is-pangram/
 */
public class day2 {
    class Solution {
        public String modifyString(String s) {
            // 模拟
            int len = s.length();
            char[] chars = s.toCharArray();
            if (chars[0] == '?')
                if (len == 1)return "a";
                else for (int i = 0; i < 26; i++)
                    if (chars[1] != 'a' + i){
                        chars[0] = (char) ('a' + i);
                        break;
                    }
            for (int i = 1; i < len - 1; i++)
                if (chars[i] == '?')
                    for (int j = 0; j < 26; j++)
                        if (chars[i - 1] != 'a' + j && chars[i + 1] != 'a' + j)
                        {
                            chars[i] = (char) ('a' + j);
                            break;
                        }
            if (chars[len - 1] == '?'){
                for (int i = 0; i < 26; i++)
                    if (chars[len - 2] != 'a' + i){
                        chars[len - 1] = (char) ('a' + i);
                        break;
                    }
            }
            return new String(chars);
        }

        public static boolean checkIfPangram(String sentence) {
            int len = sentence.length();
            if (len < 26)return false;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 26; i++) {
                set.add(sentence.charAt(i));
            }
            for (int i = 26; i < len; i++) {
                set.add(sentence.charAt(i));
                if (set.size() == 26)return true;
            }
            return set.size() == 26;
        }
    }

    public static void main(String[] args) {
        String str = "uwqohxamknblecdtzpisgvyfjr";
        System.out.println(Solution.checkIfPangram(str));
    }
}