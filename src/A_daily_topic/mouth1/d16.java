package A_daily_topic.mouth1;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-16  10:22
 * @Description:
 *          2341. 数组能形成多少数对
 *          https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
 */
public class d16 {
    class Solution {
        public int[] numberOfPairs(int[] nums) {
            int[] cnt = new int[101];
            for (int num : nums) {
                cnt[num]++;
            }
            int ans = 0;
            for (int j : cnt) {
                ans += j >> 1;
            }
            return new int[]{ans, nums.length - ans * 2};
        }
    }
}