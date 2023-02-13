package A_daily_topic.sword_offer;

import java.util.Arrays;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2023-02-13  21:54
 * @Description:
 *          剑指 Offer 60. n个骰子的点数
 *          https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/
 */
public class q60 {
    class Solution {
        public double[] dicesProbability(int n) {
            double[] start = new double[6];
            Arrays.fill(start, 1.0 / 6);
            for (int i = 2; i <= n; i++) {
                double[] tmp = new double[5 * i + 1];
                for (int j = 0; j < start.length; j++) {
                    for (int k = 0; k < 6; k++) {
                        tmp[j + k] += start[j] / 6.0;
                    }
                }
                start = tmp;
            }
            return start;
        }
    }
}