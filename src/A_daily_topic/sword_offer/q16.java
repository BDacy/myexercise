package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-21  10:56
 * @Description:
 *          剑指 Offer 16. 数值的整数次方
 *          https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/?favorite=xb9nqhhg
 */
public class q16 {
    class Solution {
        public double myPow(double x, int n) {
            if(x == 0) return 0;
            long b = n;
            double res = 1.0;
            if(b < 0) {
                x = 1 / x;
                b = -b;
            }
            while(b > 0) {
                if((b & 1) == 1) res *= x;
                x *= x;
                b >>= 1;
            }
            return res;
        }
    }
}