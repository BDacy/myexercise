package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-21  11:16
 * @Description:
 *          剑指 Offer 17. 打印从1到最大的n位数
 *          https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class q17 {
    class Solution {
        public int[] printNumbers(int n) {
            int k = 1;
            for(int i = 0;i < n;i++ ){
                k *= 10;
            }
            int[] res = new int[k - 1];
            for(int i = 0; i < k - 1;i++){
                res[i] = i + 1;
            }
            return res;
        }
    }
}