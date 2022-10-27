package A_daily_topic.week8;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-27  17:05
 * @Description:
 *          1822. 数组元素积的符号
 *          https://leetcode.cn/problems/sign-of-the-product-of-an-array/
 */
public class day4_1 {
    class Solution {
        public int arraySign(int[] nums) {
            int a = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)return 0;
                if (nums[i] < 0)
                    a *= -1;
            }
            return a;
        }
    }
}