package A_daily_topic.week13;


/**
 * @BelongsPackage: A_daily_topic.week13
 * @Author: yca
 * @CreateTime: 2022-11-28  10:32
 * @Description:
 *          191. 位1的个数
 *          https://leetcode.cn/problems/number-of-1-bits/
 *          813. 最大平均值和的分组
 *          https://leetcode.cn/problems/largest-sum-of-averages/
 */
public class day1 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int cnt = 0;
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0)cnt++;
            }
            return cnt;
        }
        public int hammingWeight1(int n) {
            int ret = 0;
            while (n != 0) {
                n &= n - 1;
                ret++;
            }
            return ret;
        }


        public double largestSumOfAverages(int[] nums, int m) {
            int n = nums.length;
            double[] sum = new double[n + 10];
            for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
            double[][] f = new double[n + 10][m + 10];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= Math.min(i, m); j++) {
                    if (j == 1) {
                        f[i][1] = sum[i] / i;
                    } else {
                        for (int k = 2; k <= i; k++) {
                            f[i][j] = Math.max(f[i][j], f[k - 1][j - 1] + (sum[i] - sum[k - 1]) / (i - k + 1));
                        }
                    }
                }
            }
            return f[n][m];
        }
    }
}