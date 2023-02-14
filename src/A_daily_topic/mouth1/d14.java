package A_daily_topic.mouth1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-14  09:09
 * @Description:
 *          1124. 表现良好的最长时间段
 *          https://leetcode.cn/problems/longest-well-performing-interval/
 */
public class d14 {
    class Solution {
        public int longestWPI(int[] hours) {
            // 前缀和加单调栈
            int ans = 0;
            int len = hours.length;
            int[] sum = new int[len + 1];// 前缀和
            Deque<Integer> stack = new ArrayDeque<>();// 单调递减栈，存储下标
            stack.addFirst(0);
            for(int i = 1; i <= len; i++){
                sum[i] = sum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
                if(sum[i] < sum[stack.peekFirst()])stack.addFirst(i);
            }
            for(int i = len; i > 0; i--){
                while(!stack.isEmpty() && sum[i] > sum[stack.peekFirst()])
                    ans = Math.max(ans, i - stack.pollFirst());
            }
            return ans;
        }
    }

}