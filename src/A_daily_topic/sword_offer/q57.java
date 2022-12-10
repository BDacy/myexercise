package A_daily_topic.sword_offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-10  18:50
 * @Description:
 *          剑指 Offer 57 - II. 和为s的连续正数序列
 *          https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class q57 {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            // 滑动窗口
            int left = 1;
            int right = 1;
            int cur = 1;
            List<int[]> ans = new ArrayList<>();
            while (left <= right && right < target){
                if (cur > target){
                    cur -= left;
                    left++;
                }
                else if (cur < target){
                    right++;
                    cur += right;
                }else {
                    int[] tmp = new int[right - left + 1];
                    for (int i = left; i <= right; i++) {
                        tmp[i - left] = i;
                    }
                    ans.add(tmp);
                    cur -= left;
                    left++;
                }
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
}