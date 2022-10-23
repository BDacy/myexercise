package A_daily_topic.Randomlt;

/**
 * @Auther: yca
 * @Date: 2022/09/28/15:00
 * @Description:
 *          1832. 判断句子是否为全字母句
 *          https://leetcode.cn/problems/check-if-the-sentence-is-pangram/
 *          easy
 */
public class check_if_the_sentence_is_pangram {
    class Solution {
        public boolean checkIfPangram(String sentence) {
            int length = sentence.length();
            if (length<26)return false;
            int[]letters=new int[26];
            for (int i = 0; i < length ; i++) {
                letters[sentence.charAt(i)-'a']++;
            }
            for (int i = 0; i < 26 ; i++) {
                if(letters[i]<1){
                    return false;
                }
            }
            return true;
        }
    }
}
