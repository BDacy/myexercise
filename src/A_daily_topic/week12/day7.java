package A_daily_topic.week12;

/**
 * @BelongsPackage: A_daily_topic.week12
 * @Author: yca
 * @CreateTime: 2022-11-27  13:12
 * @Description:
 *          1752. 检查数组是否经排序和轮转得到
 *          https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/
 */
public class day7 {
    class Solution {
        public boolean check(int[] nums) {
            int t = 0, n = nums.length;
            for (int i = 1; i < n; i++) {
                if (t > 1) return false; // 如果出现超过1次的“非递增”情况，则直接返回false
                if (nums[i - 1] > nums[i]) t++; // 如果出现“非递增”情况，则t加1
            }
            return t == 0 || (t == 1 && nums[0] >= nums[n - 1]);
        }
    }
}