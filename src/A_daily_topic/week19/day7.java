package A_daily_topic.week19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsPackage: A_daily_topic.week19
 * @Author: yca
 * @CreateTime: 2023-01-15  20:23
 * @Description:
 *          349. 两个数组的交集
 *          https://leetcode.cn/problems/intersection-of-two-arrays/
 *          2293. 极大极小游戏
 *          https://leetcode.cn/problems/min-max-game/
 */
public class day7 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            boolean[] val = new boolean[1001];
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for(int num : nums1){
                val[num] = true;
            }

            for(int num : nums2){
                if(val[num] && !set.contains(num)){
                    list.add(num);
                    set.add(num);
                }
            }

            int[] res = new int[list.size()];
            for(int i = 0; i < res.length; i++){
                res[i] = list.get(i);
            }
            return res;

        }

        public int minMaxGame(int[] nums) {
            // 模拟
            int n = nums.length;
            while((n = nums.length) > 1){
                int[] tmp = new int[nums.length / 2];
                for(int i = 0; i < tmp.length; i++){
                    if(i % 2 == 0)tmp[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
                    else tmp[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
                nums = tmp;
            }
            return nums[0];
        }
    }
}