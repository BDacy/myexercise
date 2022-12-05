package A_daily_topic.week14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsPackage: A_daily_topic.week14
 * @Author: yca
 * @CreateTime: 2022-12-05  12:40
 * @Description:
 *          1046. 最后一块石头的重量
 *          https://leetcode.cn/problems/last-stone-weight/
 */
public class day1 {
    class Solution {
        public int lastStoneWeight(int[] stones) {
            // 模拟
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int i = 0; i < stones.length; i++) {
                priorityQueue.add(stones[i]);
            }
            while (priorityQueue.size() >= 2){
                int a = priorityQueue.poll();
                int b = priorityQueue.poll();
                if (Math.abs(a - b) != 0)
                priorityQueue.add(Math.abs(a - b));
            }
            if (priorityQueue.isEmpty())return 0;
            return priorityQueue.peek();
        }
    }
}