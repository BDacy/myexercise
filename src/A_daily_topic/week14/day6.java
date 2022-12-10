package A_daily_topic.week14;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsPackage: A_daily_topic.week14
 * @Author: yca
 * @CreateTime: 2022-12-10  17:35
 * @Description:
 *          287. 寻找重复数
 *          https://leetcode.cn/problems/find-the-duplicate-number/
 *          1691. 堆叠长方体的最大高度
 *          https://leetcode.cn/problems/maximum-height-by-stacking-cuboids/
 */
public class day6 {
    class Solution {
        public int findDuplicate(int[] nums) {
            // 可恶，是快慢指针
            int slow = 0;
            int fast = 0;
            slow = nums[slow];
            fast = nums[nums[fast]];
            while (slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            return nums[slow];
        }

        public int maxHeight(int[][] cuboids) {
            int n = cuboids.length;
            // 排序 + 动态规划
            // 可以移动，说明长宽高不限制
            for (int[] cuboid : cuboids) {
                Arrays.sort(cuboid);// 从小到大
            }
            // 对总体排序,从小到大
            Arrays.sort(cuboids, (a, b) -> a[0] == b[0] ? (a[1] == b[1] ? (b[2] - a[2]) : b[1] - a[1]) : b[0] - a[0]);
            // 给定dp，dp[i]表示以第i个长方体为底时的最高高度
            int[] dp = new int[n];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (cuboids[j][1] >= cuboids[i][1] &&
                            cuboids[j][2] >= cuboids[i][2]){
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i] = cuboids[i][2] + dp[i];
            }
            int ans = 0;
            for (int j : dp) {
                ans = Math.max(ans, j);
            }
            return ans;
        }
    }
}