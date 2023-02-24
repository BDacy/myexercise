package A_daily_topic.mouth1;

import java.util.Arrays;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-24  10:05
 * @Description:
 *          2357. 使数组中所有元素都等于零
 *          https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/
 */
public class d24 {
    class Solution {
        public int minimumOperations(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            int cur = 0;
            for(int i = 0; i < nums.length; i++){
                if(cur != nums[i]){
                    cur = nums[i];
                    res++;
                }
            }
            return res;
        }
    }
}