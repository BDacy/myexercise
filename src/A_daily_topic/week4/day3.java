package A_daily_topic.week4;

/**
 * @Auther: yca
 * @Date: 2022/09/28/14:28
 * @Description:
 *          494. 目标和
 *          https://leetcode.cn/problems/target-sum/
 */
public class day3 {
    class Solution {
        public int count = 0;
        public int findTargetSumWays(int[] nums, int target) {
            backtrack(nums,target,0,0);
            return count;
        }
        public void backtrack(int[] nums, int target, int index, int sum){
            if (index==nums.length){
                if (sum==target)count++;
            }
            else {
                backtrack(nums,target,index+1,sum-nums[index]);
                backtrack(nums,target,index+1,sum+nums[index]);
            }
        }
    }
}
