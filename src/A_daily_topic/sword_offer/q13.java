package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2023-01-10  12:35
 * @Description: 面试题13. 机器人的运动范围
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class q13 {
    class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            return dfs(0, 0, m, n, k, visited);
        }

        private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
            if (i < 0 || i >= m || j < 0 || j >= n
                    || (i % 10 + i / 10 + j % 10 + j / 10 > k
                    || visited[i][j])) return 0;
            visited[i][j] = true;
            return dfs(i - 1, j, m, n, k, visited) + dfs(i + 1, j, m, n, k, visited) +
                    dfs(i, j - 1, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited) + 1;
        }
    }
}