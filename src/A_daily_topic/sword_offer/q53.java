package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-03  19:59
 * @Description:
 *          剑指 Offer 53 - I. 在排序数组中查找数字 I
 *          https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/?favorite=xb9nqhhg
 *          剑指 Offer 53 - II. 0～n-1中缺失的数字
 *          https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/?favorite=xb9nqhhg
 */
public class q53 {
    class Solution {
        public int search(int[] nums, int target) {
            // 先二分然后左右扩散或者持续二分然后相减计数
            int left = 0;
            int right = nums.length - 1;
            int cnt = 0;
            while (left <= right){
                int mid = left + right >> 1;
                if (nums[mid] > target){
                    right = mid - 1;
                }else if (nums[mid] < target){
                    left = mid + 1;
                }else {
                    //向左找
                    cnt++;
                    int i = mid;
                    while (--i >= 0 && nums[i] == target)cnt++;
                    i = mid;
                    while (++i < nums.length && nums[i] == target)cnt++;
                    return cnt;
                }
            }
            return cnt;
        }
        public int missingNumber(int[] nums) {
            // 二分
            int left = 0;
            int right = nums.length - 1;
            while (left <= right){
                int mid = left + right >> 1;
                if (nums[mid] == mid){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}