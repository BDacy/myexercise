package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2023-02-13  15:56
 * @Description:
 *          剑指 Offer 43. 1～n 整数中 1 出现的次数
 *          https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/?favorite=xb9nqhhg
 */
public class q43 {
    class Solution {
        public int countDigitOne(int n) {
            int length = String.valueOf(n).length();
            int cnt = 0;
            for (int i = 0; i < length; i++) {
                int mod = (int) Math.pow(10, i);
                int a = n / mod;
                int b = n % mod;
                int i1 = a % 10;
                if (i1 > 1) cnt += (a / 10 + 1) * mod;
                else if (i1 == 1) cnt += (a / 10) * mod + (b + 1);
                else cnt += (a / 10) * mod;
            }
            return cnt;
        }
    }
}