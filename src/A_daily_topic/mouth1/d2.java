package A_daily_topic.mouth1;

import java.util.*;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-02  10:07
 * @Description:
 *          717. 1 比特与 2 比特字符
 *          https://leetcode.cn/problems/1-bit-and-2-bit-characters/
 *          1129. 颜色交替的最短路径
 *          https://leetcode.cn/problems/shortest-path-with-alternating-colors/
 */
public class d2 {
    class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            int n = bits.length;
            int idx = 0;
            while(idx < n - 1){
                idx += bits[idx] + 1;
            }
            return idx == n - 1;
        }

        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            // BFS
            List<Integer>[][] graph = new List[2][n];
            // 初始化
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = new ArrayList<>();
                }
            }
            for (int[] redEdge : redEdges) {
                graph[0][redEdge[0]].add(redEdge[1]);
            }
            for (int[] blueEdge : blueEdges) {
                graph[1][blueEdge[0]].add(blueEdge[1]);
            }
            // 初始化最小路径距离
            int[][] dist = new int[2][n];
            for (int i = 0; i < 2; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0] = 0;
            dist[1][0] = 0;
            // 初始化队列
            Queue<int[]> q = new ArrayDeque<>();
            // 第一个元素表示下一条边的颜色
            // 第二个表示节点表示
            q.offer(new int[]{0, 0});
            q.offer(new int[]{1, 0});

            while (!q.isEmpty()){
                int[] poll = q.poll();
                int color = poll[0];
                int x = poll[1];
                // 转换另一种颜色的边
                for (int y : graph[1 - color][x]) {
                    // 条件成立，说明已经有最小路径
                    if (dist[1 - color][y] != Integer.MAX_VALUE) continue;
                    // 不成立的话，结果为上一个加1
                    dist[1 - color][y] = dist[color][x] + 1;
                    q.offer(new int[]{1 - color, y});// 转换颜色，下一个节点入队
                }
            }
            for (int i = 0; i < n; i++) {
                dist[0][i] = Math.min(dist[0][i], dist[1][i]);
                if (dist[0][i] == Integer.MAX_VALUE)
                    dist[0][i] = -1;
            }
            return dist[0];
        }
    }
}