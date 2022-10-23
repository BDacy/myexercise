package A_daily_topic.Randomlt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: yca
 * @Date: 2022/09/28/15:19
 * @Description:
 *          139. 单词拆分
 *          https://leetcode.cn/problems/word-break/
 */
public class word_break {
    public static void main(String[] args) {
        String s = "a";
        List<String> list = new ArrayList<>();
//        list.add("leet");
//        list.add("code");
        list.add("b");
        System.out.println(Solution.wordBreak(s,list));
    }
    class Solution {
        public static boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>();
            for (String word : wordDict) {
                set.add(word);
            }
            boolean[] valid = new boolean[s.length() + 1];
            valid[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (set.contains(s.substring(j,i)) && valid[j]) {
                        valid[i] = true;
                    }
                }
            }
            return valid[s.length()];
        }
    }
}
