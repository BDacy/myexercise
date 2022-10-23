package A_daily_topic.week1;

/**
 * @Auther: yca
 * @Date: 2022/09/12/14:30
 * @Description:
 *          42. 接雨水
 *          https://leetcode.cn/problems/trapping-rain-water/
 */
public class day7 {
    public static void main(String[] args) {
    }
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (height[left] < height[right]) {
                    ans += leftMax - height[left];
                    ++left;
                } else {
                    ans += rightMax - height[right];
                    --right;
                }
            }
            return ans;
        }
    }
}
