package A_daily_topic.week6;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsPackage: A_daily_topic.week6
 * @Author: yca
 * @CreateTime: 2022-10-16  11:18
 * @Description:
 *          9. 回文数
 *          https://leetcode.cn/problems/palindrome-number/
 */
public class day7 {
    class Solution {
        public boolean isPalindrome(int x) {
            if(x<0)return false;
            String s = String.valueOf(x);
            int left = 0;
            int right = s.length()-1;
            while (left<=right){
                if (s.charAt(left)!=s.charAt(right))return false;
                left++;
                right--;
            }
            return true;
        }
    }
}