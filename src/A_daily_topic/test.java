package A_daily_topic;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic
 * @Author: yca
 * @CreateTime: 2022-10-20  17:27
 * @Description:
 *
 */
public class test {
    class Solution {
        public int distinctAverages(int[] nums) {
            Set<Double> set = new HashSet<>();
            Arrays.sort(nums);
            int left = 0;
            int right = nums.length - 1;
            while (left < right){
                double v = 1. * (nums[left] + nums[right]) / 2;
                set.add(v);
                left++;
                right--;
            }
            return set.size();
        }
        public int countGoodStrings(int low, int high, int zero, int one) {
            int[] dp = new int[high + 1];
            int max = Math.max(zero, one);
            int min = Math.min(zero, one);
            int ans = 0;
            for (int i = 0; i < min; i++) {
                dp[i] = 0;
            }
            dp[min] = 1;
            if (min == max) dp[min] = 2;
            else {
                for (int i = min + 1; i < max; i++) {
                    dp[i] = dp[i - min];
                }
                dp[max] = dp[max - min] + 1;
            }

            for (int i = max + 1; i <= high; i++) {
                dp[i] = dp[i - zero] + dp[i - one];
            }
            for (int i = low; i <= high; i++) {
                ans += dp[i];
            }
            return ans;
        }

    }
}