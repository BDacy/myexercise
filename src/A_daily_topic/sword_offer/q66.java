package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-25  10:14
 * @Description:
 *          剑指 Offer 66. 构建乘积数组
 *          https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/?favorite=xb9nqhhg
 */
public class q66 {
    class Solution {
        public int[] constructArr(int[] a) {
            int length = a.length;
            if(length == 0)return a;
            int[] b1 = new int[length];
            int[] b2 = new int[length];
            b1[0] = a[0];
            for (int i = 1; i < length; i++) {
                b1[i] = b1[i - 1] * a[i];
            }
            b2[length - 1] = a[length - 1];
            for (int i = length - 2; i >= 0 ; i--) {
                b2[i] = b2[i + 1] * a[i];
            }
            int[] res = new int[length];
            res[0] = b2[1];
            res[length - 1] = b1[length - 2];
            for (int i = 1; i < length - 1; i++) {
                res[i] = b1[i - 1] * b2[i + 1];
            }
            return res;
        }
    }
}