package A_daily_topic.week16;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @BelongsPackage: A_daily_topic.week16
 * @Author: yca
 * @CreateTime: 2022-12-25  08:30
 * @Description:
 *          264. 丑数 II
 *          https://leetcode.cn/problems/ugly-number-ii/
 */
public class day7 {
    class Solution {
        int[] nums = new int[]{2,3,5};
        public int nthUglyNumber(int n) {
            Set<Long> set = new HashSet<>();
            Queue<Long> pq = new PriorityQueue<>();
            set.add(1L);
            pq.add(1L);
            for (int i = 1; i <= n; i++) {
                long x = pq.poll();
                if (i == n) return (int)x;
                for (int num : nums) {
                    long t = num * x;
                    if (!set.contains(t)) {
                        set.add(t);
                        pq.add(t);
                    }
                }
            }
            return -1;
        }
    }

}