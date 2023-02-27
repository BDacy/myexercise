package A_daily_topic.mouth1;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-27  13:37
 * @Description:
 *          1144. 递减元素使数组呈锯齿状
 *          https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/
 */
public class d27 {
    class Solution {
        public int movesToMakeZigzag(int[] nums) {
            return Math.min(help(nums, 0), help(nums, 1));
        }

        public int help(int[] nums, int pos) {
            int res = 0;
            for (int i = pos; i < nums.length; i += 2) {
                int a = 0;
                if (i - 1 >= 0) {
                    a = Math.max(a, nums[i] - nums[i - 1] + 1);
                }
                if (i + 1 < nums.length) {
                    a = Math.max(a, nums[i] - nums[i + 1] + 1);
                }
                res += a;
            }
            return res;
        }
    }
}