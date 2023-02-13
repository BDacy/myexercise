package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2023-02-13  15:16
 * @Description:
 *          剑指 Offer 44. 数字序列中某一位的数字
 *          https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 */
public class q44 {
    class Solution {
        public int findNthDigit(int n) {
            if(n == 0)return 0;
            long start = 1;// 起始节点
            int digit = 1;// 位数
            long count = 9;// 该位数下有多少个数字
            // 找出n所在数位
            while(n > count){
                n -= count;
                start *= 10;
                digit += 1;
                count = 9 * start * digit;
            }
            // 找出所在数位中的第几个数
            long num = start + (n - 1) / digit; // 2.
            return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
        }
    }
}