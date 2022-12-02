package A_daily_topic.week13;

/**
 * @BelongsPackage: A_daily_topic.week13
 * @Author: yca
 * @CreateTime: 2022-12-02  14:45
 * @Description:
 *          27. 移除元素
 *          https://leetcode.cn/problems/remove-element/
 *          1769. 移动所有球到每个盒子所需的最小操作数
 *          https://leetcode.cn/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 */
public class day5 {
    class Solution {
        public static int removeElement(int[] nums, int val) {
            //双指针法，快慢指针
            int low=0;
            int fast=0;
            int n=nums.length;
            while (fast<n){
                if (nums[fast]!=val){
                    nums[low]=nums[fast];
                    low++;
                }
                fast++;
            }
            return low;
        }

        public int[] minOperations(String boxes) {
            // 模拟
            char[] chars = boxes.toCharArray();
            int[] ans = new int[boxes.length()];
            for (int i = 0; i < boxes.length(); i++) {
                int cnt = 0;
                for (int j = 0; j < chars.length; j++) {
                    if (j == i)continue;
                    if (chars[j] == '1')cnt += Math.abs(j - i);
                }
                ans[i] = cnt;
            }
            return ans;
        }
    }
}