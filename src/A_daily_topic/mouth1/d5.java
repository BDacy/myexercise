package A_daily_topic.mouth1;

import java.util.Arrays;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-10  21:30
 * @Description:
 *          1798. 你能构造出连续值的最大数目
 *          https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/
 */
public class d5 {
    class Solution {
        public int getMaximumConsecutive(int[] coins) {
            int res = 1;
            Arrays.sort(coins);
            for (int i : coins) {
                if (i > res) {
                    break;
                }
                res += i;
            }
            return res;
        }
    }

}