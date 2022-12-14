package A_daily_topic.week15;

/**
 * @BelongsPackage: A_daily_topic.week15
 * @Author: yca
 * @CreateTime: 2022-12-14  20:59
 * @Description:
 *          190. 颠倒二进制位
 *          https://leetcode.cn/problems/reverse-bits/
 */
public class day3 {
    public class Solution {
        public int reverseBits(int n) {
            int rev = 0;
            for (int i = 0; i < 32 && n != 0; ++i) {
                rev |= (n & 1) << (31 - i);
                n >>>= 1;
            }
            return rev;
        }
    }
}