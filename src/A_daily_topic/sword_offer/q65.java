package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-10  19:13
 * @Description:
 *          剑指 Offer 65. 不用加减乘除做加法
 *          https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/?favorite=xb9nqhhg
 */
public class q65 {
    class Solution {
        public int add(int a, int b) {
//            return a+b;
            while (b != 0){
                int c = (a & b) << 1;
                a ^= b;
                b = c;
            }
            return a;
        }
    }
}