package A_daily_topic.week12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @BelongsPackage: A_daily_topic.week12
 * @Author: yca
 * @CreateTime: 2022-11-26  12:23
 * @Description:
 *          237. 删除链表中的节点
 *          https://leetcode.cn/problems/delete-node-in-a-linked-list/
 *          882. 细分图中的可到达节点
 *          https://leetcode.cn/problems/reachable-nodes-in-subdivided-graph/
 */
public class day6 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public void deleteNode(ListNode node) {
            ListNode cur = node;
            while (cur.next.next != null){
                cur.val = cur.next.val;
                cur = cur.next;
            }
            cur.val = cur.next.val;
            cur.next = null;
        }

        public int reachableNodes(int[][] edges, int maxMoves, int n) {
            List<int[]>[] g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<int[]>());
            for (var e : edges) {
                int u = e[0], v = e[1], cnt = e[2];
                g[u].add(new int[]{v, cnt + 1});
                g[v].add(new int[]{u, cnt + 1}); // 建图
            }

            var dist = dijkstra(g, 0); // 从 0 出发的最短路

            int ans = 0;
            for (int d : dist)
                if (d <= maxMoves) // 这个点可以在 maxMoves 步内到达
                    ++ans;
            for (var e : edges) {
                int u = e[0], v = e[1], cnt = e[2];
                int a = Math.max(maxMoves - dist[u], 0);
                int b = Math.max(maxMoves - dist[v], 0);
                ans += Math.min(a + b, cnt); // 这条边上可以到达的节点数
            }
            return ans;
        }

        // Dijkstra 算法模板
        // 返回从 start 到每个点的最短路
        private int[] dijkstra(List<int[]>[] g, int start) {
            var dist = new int[g.length];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;
            var pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
            pq.offer(new int[]{start, 0});
            while (!pq.isEmpty()) {
                var p = pq.poll();
                int x = p[0], d = p[1];
                if (d > dist[x]) continue;
                for (var e : g[x]) {
                    int y = e[0];
                    int newDist = d + e[1];
                    if (newDist < dist[y]) {
                        dist[y] = newDist;
                        pq.offer(new int[]{y, newDist});
                    }
                }
            }
            return dist;
        }
    }
}