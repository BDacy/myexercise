package A_daily_topic.week8;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-29  10:18
 * @Description:
 *          410. 分割数组的最大值
 *          https://leetcode.cn/problems/split-array-largest-sum/
 */
public class day6 {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        System.out.println(Solution.splitArray(nums,2));
    }
    class Solution {
        public static int splitArray(int[] nums, int m) {
            int left = 0, right = 0;
            for (int i = 0; i < nums.length; i++) {
                right += nums[i];
                if (left < nums[i]) {
                    left = nums[i];
                }
            }
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (check(nums, mid, m)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public  static boolean check(int[] nums, int x, int m) {
            int sum = 0;
            int cnt = 1;
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] > x) {
                    cnt++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            return cnt <= m;
        }
    }
}