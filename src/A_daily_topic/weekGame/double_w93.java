package A_daily_topic.weekGame;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.weekGame
 * @Author: yca
 * @CreateTime: 2022-12-10  22:10
 * @Description:
 */
public class double_w93 {
    class Solution {
        public int maximumValue(String[] strs) {
            int ans = 0;
            for (String str : strs) {
                boolean flag = false;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) > '9' || str.charAt(i) < '0'){
                        flag = true;
                        break;
                    }
                }
                if (flag)ans = Math.max(ans, str.length());
                else ans = Math.max(ans, Integer.parseInt(str));
            }
            return ans;
        }

        public int maxStarSum(int[] vals, int[][] edges, int k) {
            // 构图，遍历
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            for (int[] edge : edges) {
                PriorityQueue<Integer> queue = map.getOrDefault(edge[0], new PriorityQueue<>((o1, o2) -> o2 - o1));
                queue.add(vals[edge[1]]);
                map.put(edge[0], queue);
                PriorityQueue<Integer> queue1 = map.getOrDefault(edge[1], new PriorityQueue<>((o1, o2) -> o2 - o1));
                queue1.add(vals[edge[0]]);
                map.put(edge[1], queue1);
            }
            // 找最大值
            int max = vals[0];
            for (int val : vals) {
                if (max < val) max = val;
            }
            for (Integer node : map.keySet()) {
                PriorityQueue<Integer> priorityQueue = map.get(node);
                int up = Math.min(priorityQueue.size(), k);
                int sum = vals[node];
                for (int i = 0; i < up; i++) {
                    if (priorityQueue.peek() < 0)break;
                    sum += priorityQueue.poll();
                }
                max = Math.max(max, sum);
            }
            return max;
        }
    }
}