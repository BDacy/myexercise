package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-22  10:19
 * @Description:
 *          剑指 Offer 47. 礼物的最大价值
 *          https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/?favorite=xb9nqhhg
 */
public class q47 {
    class Solution {
        public int maxValue(int[][] grid) {
            // 动态规划
            int m = grid.length, n = grid[0].length;
            for(int j = 1; j < n; j++) // 初始化第一行
                grid[0][j] += grid[0][j - 1];
            for(int i = 1; i < m; i++) // 初始化第一列
                grid[i][0] += grid[i - 1][0];
            for(int i = 1; i < m; i++)
                for(int j = 1; j < n; j++)
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            return grid[m - 1][n - 1];
        }
    }

}