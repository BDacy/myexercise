package A_daily_topic.week5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: yca
 * @Date: 2022/10/02/10:00
 * @Description:
 *          75. 颜色分类
 *          https://leetcode.cn/problems/sort-colors/
 */
public class day1 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        Solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    class Solution {
        public static void sortColors(int[] nums) {
            int [] list = new int[]{0,0,0};
            for (int num : nums) {
                if (num==0)list[0]++;
                if (num==1)list[1]++;
                if (num==2)list[2]++;
            }
            int start = 0;
            for (int i = 0; i < 3; i++) {
                int cnt = list[i];
                for (int j = start; j < start+cnt; j++) {
                    nums[j] = i;
                }
                start += cnt;
            }
        }
    }
}
