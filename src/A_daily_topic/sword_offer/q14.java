package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-19  16:03
 * @Description:
 *          剑指 Offer 14- I. 剪绳子
 *          https://leetcode.cn/problems/jian-sheng-zi-lcof/?favorite=xb9nqhhg
 */
public class q14 {
    class Solution {
        public int cuttingRope(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for(int i = 3; i < n + 1; i++){
                for(int j = 2; j < i; j++){
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }
            return dp[n];
        }
        public int cuttingRope1(int n) {
            if(n < 4){
                return n - 1;
            }
            int res = 1;
            while(n > 4){
                res *= 3;
                n -= 3;
            }
            return res * n;
        }
        public int cuttingRope_II(int n) {
            int mod = (int) (1e9+7);
            if(n < 4){
                return n - 1;
            }
            long res = 1;
            while(n > 4){
                res = 3 * res % mod ;
                n -= 3;
            }
            return (int) (res * n % mod);
        }
    }
}