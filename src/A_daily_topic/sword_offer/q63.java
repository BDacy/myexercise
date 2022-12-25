package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-25  10:07
 * @Description:
 *          剑指 Offer 63. 股票的最大利润
 *          https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class q63 {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length == 0)return 0;
            int min = prices[0];
            int res = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > min){
                    if(prices[i] - min > res)res = prices[i] - min;
                }else{
                    min = prices[i];
                }
            }
            return res;
        }
    }
}