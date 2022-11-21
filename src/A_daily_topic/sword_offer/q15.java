package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-21  10:52
 * @Description:
 *          剑指 Offer 15. 二进制中1的个数
 *          https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/?favorite=xb9nqhhg
 */
public class q15 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if (((1 << i) & n) != 0)ans++;
            }
            return ans;
        }
    }
}