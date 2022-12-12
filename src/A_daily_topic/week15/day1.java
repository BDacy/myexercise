package A_daily_topic.week15;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @BelongsPackage: A_daily_topic.week15
 * @Author: yca
 * @CreateTime: 2022-12-12  09:11
 * @Description:
 *          1162. 地图分析
 *          https://leetcode.cn/problems/as-far-from-land-as-possible/
 *          1781. 所有子字符串美丽值之和
 *          https://leetcode.cn/problems/sum-of-beauty-of-all-substrings/
 */
public class day1 {
    class Solution {
        public int maxDistance(int[][] grid) {
            int[] dx = new int[]{0,0,1,-1};
            int[] dy = new int[]{1,-1,0,0};
            // BFS 陆地先入队，然后bfs，最后一个就是最远的
            Queue<int[]> queue = new ArrayDeque<>();
            int n = grid.length;
            int m = grid[0].length;
            boolean[][] val = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1){
                        queue.add(new int[]{i, j});
                        val[i][j] = true;
                    }
                }
            }
            int ans = 0;

            while (!queue.isEmpty()){
                int size = queue.size();
                ans++;
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    for (int j = 0; j < 4; j++) {
                        int newx = poll[0] + dx[j];
                        int newy = poll[1] + dy[j];
                        if (newx >= n || newx < 0 || newy < 0 || newy >= m)continue;
                        if (val[newx][newy])continue;
                        if (grid[newx][newy] == 0){
                            queue.add(new int[]{newx, newy});
                            val[newx][newy] = true;
                        }
                    }
                }
            }
            return ans - 1 == 0?-1:ans - 1;
        }

        public int beautySum(String s) {
            int ans = 0;
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                int[] cnt = new int[26];
                for (int j = i; j < n; ++j) {
                    ++cnt[s.charAt(j) - 'a'];
                    int mi = 1000, mx = 0;
                    for (int v : cnt) {
                        if (v > 0) {
                            mi = Math.min(mi, v);
                            mx = Math.max(mx, v);
                        }
                    }
                    ans += mx - mi;
                }
            }
            return ans;
        }
    }
}