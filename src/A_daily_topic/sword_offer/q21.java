package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-23  11:23
 * @Description:
 *          剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *          https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/?favorite=xb9nqhhg
 */
public class q21 {
    class Solution {
        public int[] exchange(int[] nums) {
            // 双指针
            int length = nums.length;
            int l = 0;
            int r = length - 1;
            while (l < r){
                while (l < r && nums[l] % 2 == 1)l++;
                while (l < r && nums[r] % 2 == 0)r--;
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
                l++;
                r--;
            }
            return nums;
        }
    }
}