package A_daily_topic.Randomlt;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: yca
 * @Date: 2022/09/28/14:49
 * @Description:
 *          1935. 可以输入的最大单词数
 *          https://leetcode.cn/problems/maximum-number-of-words-you-can-type/
 *          easy
 */
public class maximum_number_of_words_you_can_type {
    class Solution {
        public int canBeTypedWords(String text, String brokenLetters) {
            //获取不能输入的字母
            Set<Character> set = new HashSet<>();
            for (char c : brokenLetters.toCharArray()) {
                set.add(c);
            }
            //将文本划分为单词数组
            String[] words = text.split(" ");
            int count = 0;
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    if (set.contains(c)){
                        count--;
                        break;
                    }
                }
                count++;
            }
            return count;
        }
    }
}
