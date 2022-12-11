package A_daily_topic.sword_offer;

import java.util.Arrays;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-11  09:46
 * @Description:
 *          面试题61. 扑克牌中的顺子
 *          https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/?favorite=xb9nqhhg
 */
public class q61 {
    class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            // 计数0
            int cnt0 = 0;
            int cur = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)cnt0++;
                else if (cur == -1)cur = nums[i];
                else if (cur + 1 == nums[i])cur = nums[i];
                else if (cur == nums[i])return false;
                else if (cnt0 == 0)return false;
                else if (nums[i] - cur - 1 > cnt0)return false;
                else {
                    cnt0 -= nums[i] - cur - 1;
                    cur = nums[i];
                }
            }
            return true;
        }
    }
}