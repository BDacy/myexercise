package A_daily_topic.mouth1;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-17  08:49
 * @Description:
 *          1139. 最大的以 1 为边界的正方形
 *          https://leetcode.cn/problems/largest-1-bordered-square/
 */
public class d17 {
    // 前缀和 判断四条边的长度
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] rs = new int[m][n + 1]; // 每行的前缀和
            int[][] cs = new int[n][m + 1]; // 每列的前缀和
            // 计算前缀和
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rs[i][j + 1] = rs[i][j] + grid[i][j];
                    cs[j][i + 1] = cs[j][i] + grid[i][j];
                }
            }
            for (int d = Math.min(m, n); d > 0; d--){
                for (int i = 0; i <= m - d; i++) {
                    for (int j = 0; j <= n - d; j++) {
                        if (rs[i][j + d] - rs[i][j] == d &&
                                rs[i + d - 1][j + d] - rs[i + d - 1][j] == d &&
                                cs[j][i + d] - cs[j][i] == d &&
                                cs[j + d - 1][i + d] - cs[j + d - 1][i] == d)
                            return d * d;
                    }
                }
            }
            return 0;
        }
    }
}