package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-19  15:00
 * @Description:
 *          剑指 Offer 11. 旋转数组的最小数字
 *          https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/?favorite=xb9nqhhg
 */
public class q11 {
    class Solution {
        public int minArray(int[] numbers) {
            int l = 0, r = numbers.length - 1;
            while (l < r) {
                int m = l + r >> 1;
                if (numbers[m] > numbers[r]) l = m + 1;
                else if (numbers[m] < numbers[r]) r = m;
                else r--;
            }
            return numbers[l];
        }
    }
}