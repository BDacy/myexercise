package A_daily_topic.sword_offer;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-30  11:07
 * @Description:
 *          剑指 Offer 49. 丑数
 *          https://leetcode.cn/problems/chou-shu-lcof/?favorite=xb9nqhhg
 */
public class q49 {
    class Solution {
        public int nthUglyNumber(int n) {
            int[] ugly = new int[]{2,3,5};
            PriorityQueue<Long> queue = new PriorityQueue<>();
            Set<Long> set = new HashSet<>();
            queue.add(1L);
            while (n-- > 0){
                Long poll = queue.poll();
                if (n == 0)return Math.toIntExact(poll);
                for (int num : ugly) {
                    long data = num * poll;
                    if (data <= 0)continue;
                    if (!set.contains(data)){
                        set.add(data);
                        queue.add(data);
                    }
                }
            }
            return -1;

        }
    }
}