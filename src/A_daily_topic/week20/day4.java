package A_daily_topic.week20;

/**
 * @BelongsPackage: A_daily_topic.week20
 * @Author: yca
 * @CreateTime: 2023-01-19  00:14
 * @Description:
 *          343. 整数拆分
 *          https://leetcode.cn/problems/integer-break/
 *          2299. 强密码检验器 II
 *          https://leetcode.cn/problems/strong-password-checker-ii/
 */
public class day4 {
    class Solution {
        public int integerBreak(int n) {
            if (n <= 3) {
                return n - 1;
            }
            int quotient = n / 3;
            int remainder = n % 3;
            if (remainder == 0) {
                return (int) Math.pow(3, quotient);
            } else if (remainder == 1) {
                return (int) Math.pow(3, quotient - 1) * 4;
            } else {
                return (int) Math.pow(3, quotient) * 2;
            }
        }

        public boolean strongPasswordCheckerII(String password) {
            if(password.length() < 8)return false;
            String s = "!@#$%^&*()-+";
            boolean flag2=false,flag3=false,flag4=false,flag5=false,flag6 = false;
            for(int i = 0; i < password.length(); i++){
                char c = password.charAt(i);
                if(c >= 'a' && c <= 'z')flag2 = true;
                if(c >= 'A' && c <= 'Z')flag3 = true;
                if(c >= '0' && c <= '9')flag4 = true;
                if(s.contains(c + ""))flag5 = true;
                if(i < password.length() - 1 && c == password.charAt(i + 1))return false;
            }
            return flag5 && flag4 && flag3 && flag2;
        }
    }
}