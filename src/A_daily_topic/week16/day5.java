package A_daily_topic.week16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.week16
 * @Author: yca
 * @CreateTime: 2022-12-23  08:14
 * @Description:
 *          169. 多数元素
 *          https://leetcode.cn/problems/majority-element/
 *          2011. 执行操作后的变量值
 *          https://leetcode.cn/problems/final-value-of-variable-after-performing-operations/
 */
public class day5 {
    class Solution {
        public int majorityElement(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int res = 0;
            int cnt = 0;
            for (Integer key : map.keySet()) {
                if (map.get(key) > cnt){
                    res = key;
                    cnt = map.get(key);
                }
            }
            return res;
            // 排序法
//            Arrays.sort(nums);
//            return nums[nums.length >> 1];
        }
        public int finalValueAfterOperations(String[] operations) {
            // 遍历
            int res = 0;
            for (String operation : operations) {
                if (operation.charAt(1) == '+')res++;
                if (operation.charAt(1) == '-')res--;
            }
            return res;
        }
    }
}
