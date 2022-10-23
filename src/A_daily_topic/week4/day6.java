package A_daily_topic.week4;

/**
 * @Auther: yca
 * @Date: 2022/10/01/15:30
 * @Description:
 *          413. 等差数列划分
 *          https://leetcode.cn/problems/arithmetic-slices/
 */
public class day6 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,9};
        System.out.println(Solution.numberOfArithmeticSlices(nums));
    }
    class Solution {
        public static int numberOfArithmeticSlices(int[] nums) {
            if (nums.length<3) return 0;
            int start = 0;
            int length = nums.length;
            int res = 0;
            while (start<length-2){
                int left = start;
                int right = left+1;
                int diff = nums[right] - nums[left];
                while (right<length){
                    if (nums[right]-nums[left]==diff) {
                        left++;
                        right++;
                    }else break;
                }
                if (right-start>=3)res+=caculate(right-start);
                start=right-1;
            }
            return res;
        }
        public static int caculate(int cnt){
            int res = 1;
            for (int i = 2; i <= cnt-2; i++) {
                res+=i;
            }
            return res;
        }

    }
}
