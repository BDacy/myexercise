package A_daily_topic.weekGame;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.weekGame
 * @Author: yca
 * @CreateTime: 2022-12-04  10:15
 * @Description:
 */
public class w322 {
    class Solution {
        public boolean isCircularSentence(String sentence) {
            String[] s = sentence.split(" ");
            char first = s[0].charAt(0);
            char c1 = s[0].charAt(s[0].length() - 1);
            char c2;
            char last = s[s.length - 1].charAt(s[s.length - 1].length() - 1);
            for (int i = 1; i < s.length; i++) {
                if (c1 != s[i].charAt(0))return false;
                c1 = s[i].charAt(s[i].length() - 1);
            }
            return first == last;
        }

        public long dividePlayers(int[] skill) {
            int length = skill.length;
            Arrays.sort(skill);
            int last = skill[0] + skill[length - 1];
            for (int i = 1; i < length / 2; i++) {
                if (last != skill[i] + skill[length - i - 1])return -1;
            }
            long ans = 0;
            for (int i = 0; i < length / 2; i++) {
                ans += (long) skill[i] * skill[length - i - 1];
            }
            return ans;
        }

        Map<Integer, PriorityQueue<Integer[]>> map = new HashMap<>();
        boolean[] val;
        int min = Integer.MAX_VALUE;
        public int minScore(int n, int[][] roads) {
            // 构造图

            for (int[] road : roads) {
                PriorityQueue<Integer[]> queue = map.getOrDefault(road[0], new PriorityQueue<>(Comparator.comparingInt(o -> o[1])));
                queue.add(new Integer[]{road[1],road[2]});
                map.put(road[0],queue);

                PriorityQueue<Integer[]> queue1 = map.getOrDefault(road[1], new PriorityQueue<>(Comparator.comparingInt(o -> o[1])));
                queue1.add(new Integer[]{road[0],road[2]});
                map.put(road[1],queue1);
            }
            val = new boolean[n + 1];
            val[1] = true;
            // 连通遍历
            bfs(1);
            // 找出与1连通的最小值
            for (int[] road : roads) {
                if (road[2] < min && val[road[0]])min = road[2];
            }
            return min;
        }
        private void bfs(int node){
            val[node] = true;
            PriorityQueue<Integer[]> queue = map.get(node);
            for (Integer[] data : queue) {
                if (!val[data[0]])bfs(data[0]);
            }
        }
    }
}