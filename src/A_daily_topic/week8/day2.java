package A_daily_topic.week8;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-25  08:36
 * @Description:
 *          303. 区域和检索 - 数组不可变
 *          https://leetcode.cn/problems/range-sum-query-immutable/
 */
public class day2 {
    class NumArray {
        private final int[] nums;
        public NumArray(int[] nums) {
            this.nums = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                this.nums[i] = sum;
            }
        }

        public int sumRange(int left, int right) {
            if (left>0)
            return nums[right] - nums[left-1];
            else return nums[right];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}