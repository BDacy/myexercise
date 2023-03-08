package A_daily_topic.mouth2;

/**
 * @BelongsPackage: A_daily_topic.mouth2
 * @Author: yca
 * @CreateTime: 2023-03-08  09:09
 * @Description:
 *          剑指 Offer 47. 礼物的最大价值
 *          https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class d8 {
    class Solution {
        public int maxValue(int[][] grid) {
            // 动态规划
            int m = grid.length;
            int n = grid[0].length;
            int[][] vals = new int[m][n];
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += grid[0][i];
                vals[0][i] = sum;
            }
            sum = 0;
            for(int i = 0; i < m; i++){
                sum += grid[i][0];
                vals[i][0] = sum;
            }
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    int val1 = vals[i - 1][j] + grid[i][j];
                    int val2 = vals[i][j - 1] + grid[i][j];
                    vals[i][j] = Math.max(val1, val2);
                }
            }
            return vals[m - 1][n - 1];
        }
    }
}