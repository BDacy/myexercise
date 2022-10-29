package A_daily_topic.week8;

import java.util.List;
import java.util.Stack;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-29  10:53
 * @Description:
 *          1773. 统计匹配检索规则的物品数量
 *          https://leetcode.cn/problems/count-items-matching-a-rule/
 *          2210. 统计数组中峰和谷的数量
 *          https://leetcode.cn/problems/count-hills-and-valleys-in-an-array/
 */
public class day6_1 {
    class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int res = 0;
            int idx = -1;
            if (ruleKey.equals("type"))idx = 0;
            else if (ruleKey.equals("color"))idx = 1;
            else if (ruleKey.equals("name"))idx = 2;
            for (List<String> item : items) {
                if (item.get(idx).equals(ruleValue))
                    res++;
            }
            return res;
        }
        public int countHillValley(int[] nums) {
            int cnt = 0;
            int length = nums.length;
            for (int i = 1; i < length - 1; i++) {
                int mid = nums[i];
                int lowFlag = 0;
                int highFlag = 0;
                for (int j = i-1; j >= 0 ; j--) {
                    if (nums[j] > mid){
                        highFlag++;
                        break;
                    }else if (nums[j] < mid){
                        lowFlag++;
                        break;
                    }
                }
                for (int j = i+1; j < length ; j++) {
                    if (nums[j] > mid){
                        highFlag++;
                        break;
                    }else if (nums[j] < mid){
                        lowFlag++;
                        break;
                    }
                }
                if (highFlag == 2 || lowFlag == 2){
                    if (nums[i] != nums[i-1])
                    cnt++;
                }
            }
            return cnt;
        }
    }
}