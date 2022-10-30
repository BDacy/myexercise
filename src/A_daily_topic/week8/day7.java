package A_daily_topic.week8;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-30  08:44
 * @Description:
 *          283. 移动零
 *          https://leetcode.cn/problems/move-zeroes/
 *          784. 字母大小写全排列
 *          https://leetcode.cn/problems/letter-case-permutation/
 *          2299. 强密码检验器 II
 *          https://leetcode.cn/problems/strong-password-checker-ii/
 */
public class day7 {
    public static void main(String[] args) {
        String password = "@Aa1a1a1";
        System.out.println(Solution.strongPasswordCheckerII(password));
    }
    class Solution {
        public void moveZeroes(int[] nums) {
            //双指针
            int idx = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0){
                    nums[idx] = nums[i];
                    idx++;
                }
            }
            for (int i = idx; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        List<String> list = new ArrayList<>();
        public List<String> letterCasePermutation(String s) {
            char[] charArray = s.toCharArray();
            find(s,0, charArray);
            return list;
        }
        public void find(String s,int idx, char[] charArray){
            if (idx >= s.length()){
                list.add(new String(charArray));
                return;
            }
            char c = s.charAt(idx);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                charArray[idx] = Character.toLowerCase(charArray[idx]);
                find(s,idx+1,charArray);
                charArray[idx] = Character.toUpperCase(charArray[idx]);
                find(s,idx+1,charArray);
            }else
                find(s,idx+1,charArray);
        }

        public static boolean strongPasswordCheckerII(String password) {
            String specialChars = "!@#$%^&*()-+";

            boolean lowCase = false;
            boolean upCase = false;
            boolean numCase = false;
            boolean specialCase = false;
            if (password.length() < 8)return false;
            char lastChar = ' ';
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (c >= 'a' && c <= 'z')lowCase = true;
                if (c >= 'A' && c <= 'Z')upCase = true;
                if (c >= '0' && c <= '9')numCase = true;
                if (specialChars.contains(String.valueOf(c)))specialCase = true;
                if (lastChar == c) return false;
                lastChar = c;
            }
            if (lowCase && upCase && numCase &&specialCase)
                return true;
            return false;
        }
    }
}