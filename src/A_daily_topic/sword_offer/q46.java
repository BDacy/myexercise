package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2023-02-13  16:15
 * @Description:
 *          剑指 Offer 46. 把数字翻译成字符串
 *          https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class q46 {
    class Solution {
        public int translateNum(int num) {
            // 设置两个数组cnt1和cnt2
            // cnt1[i] 表示第i个数字作为一个数字翻译时，前i个数字翻译的种数
            // cnt2[i] 表示第i个数字作为二个数字翻译时，前i个数字翻译的种数
            String str = Integer.toString(num);
            int len = str.length();
            if(len == 1)return 1;
            int[] cnt1 = new int[len];
            int[] cnt2 = new int[len];
            cnt1[0] = 1;
            cnt2[0] = 0;
            for(int i = 1;i < len; i++){
                char c2 = str.charAt(i);
                char c1 = str.charAt(i - 1);
                cnt1[i] = cnt1[i - 1] + cnt2[i - 1];
                if(c1 == '1' || (c1 == '2' && c2 <= '5')){
                    if(i == 1)cnt2[i] = 1;
                    else cnt2[i] = cnt1[i - 2] + cnt2[i - 2];
                }
            }
            return cnt1[len - 1] + cnt2[len - 1];

        }
    }
}