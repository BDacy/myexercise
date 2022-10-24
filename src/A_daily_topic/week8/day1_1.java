package A_daily_topic.week8;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-24  17:32
 * @Description:
 *          915. 分割数组
 *          https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
 */
public class day1_1 {

    class Solution {
        public int partitionDisjoint(int[] nums) {
            int[] min_num = new int[nums.length];//记录从左到右当前最大的数
            int min = nums[nums.length-1];
            for (int i = nums.length-1; i >= 0; i--) {
                if (nums[i] < min) min = nums[i];
                min_num[i] = min;
            }
            int max = 0;
            int idx = nums.length - 1;
            for (int i = 0; i < nums.length-1; i++) {
                if (max < nums[i])
                    max = nums[i];
                if (max <= min_num[i+1]){
                    idx = i+1;
                    break;
                }
            }
            return idx;
        }
    }
}