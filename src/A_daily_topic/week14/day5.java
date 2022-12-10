package A_daily_topic.week14;

/**
 * @BelongsPackage: A_daily_topic.week14
 * @Author: yca
 * @CreateTime: 2022-12-09  12:43
 * @Description:
 *          233. 数字 1 的个数
 *          https://leetcode.cn/problems/number-of-digit-one/
 *          1780. 判断一个数字是否可以表示成三的幂的和
 *          https://leetcode.cn/problems/check-if-number-is-a-sum-of-powers-of-three/
 */
public class day5 {
    class Solution {
        // 计算每个位数上的贡献，分类讨论
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

        public boolean checkPowersOfThree(int n) {
            // 换成3进制
            while (n > 0){
                if (n % 3 == 2)return false;
                n = n / 3;
            }
            return true;
        }
    }
}