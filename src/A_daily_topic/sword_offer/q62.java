package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-10  19:10
 * @Description:
 *          剑指 Offer 62. 圆圈中最后剩下的数字
 *          https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/?favorite=xb9nqhhg
 */
public class q62 {
    class Solution {
        public int lastRemaining(int n, int m) {
            return f(n, m);
        }

        public int f(int n, int m) {
            if (n == 1) {
                return 0;
            }
            int x = f(n - 1, m);
            return (m + x) % n;
        }
    }
}