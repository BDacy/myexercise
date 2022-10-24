package A_daily_topic.week8;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-24  22:16
 * @Description:
 *          136. 只出现一次的数字
 *          https://leetcode.cn/problems/single-number/
 */
public class day1_2 {
    class Solution{
        public int singleNumber(int[] nums){
            int length = nums.length;
            int temp = 0;
            for (int i = 0; i < length; i++) {
                temp = temp^nums[i];
            }
            return temp;
        }

    }
}