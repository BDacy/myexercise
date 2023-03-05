package A_daily_topic.mouth2;

/**
 * @BelongsPackage: A_daily_topic.mouth2
 * @Author: yca
 * @CreateTime: 2023-03-05  10:08
 * @Description:
 *          1599. 经营摩天轮的最大利润
 *          https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/
 */
public class d5 {
    class Solution {
        public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
            // 直接模拟
            int res = -1;
            int wait = 0;
            int idx = 0;
            int sum = 0;
            int tmp = 0;
            while(wait > 0 || idx < customers.length){
                wait += idx < customers.length ? customers[idx] : 0;
                int up = Math.min(4, wait);
                wait -= up;
                tmp += up * boardingCost - runningCost;
                idx++;
                if(tmp > sum){
                    sum = tmp;
                    res = idx;
                }
            }
            return res;
        }
    }
}