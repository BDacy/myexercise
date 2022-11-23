package A_daily_topic.week12;

/**
 * @BelongsPackage: A_daily_topic.week12
 * @Author: yca
 * @CreateTime: 2022-11-23  11:10
 * @Description:
 *          153. 寻找旋转排序数组中的最小值
 *          https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
 *          1742. 盒子中小球的最大数量
 *          https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/
 */
public class day3 {
    class Solution {
        public int findMin(int[] nums) {
            int length = nums.length;
            int l = 0;
            int r = length - 1;
            while (l < r){
                int mid = l + r >> 1;
                if (nums[mid] > nums[r]){
                    l = mid + 1;
                }else if (nums[mid] < nums[r])
                    r = mid;
                else r--;
            }
            return nums[l];
        }

        public int countBalls(int lowLimit, int highLimit) {
            // 暴力模拟
            int[] cnt = new int[46];
            for (int i = lowLimit; i <= highLimit; i++) {
                int num = i;
                int sum = 0;
                while (num > 0){
                    sum += num % 10;
                    num /= 10;
                }
                cnt[sum]++;
            }
            int maxValue = 0;
            for (int i = 0; i < 46; i++) {
                if (maxValue < cnt[i])maxValue = cnt[i];
            }
            return maxValue;
        }
    }
}