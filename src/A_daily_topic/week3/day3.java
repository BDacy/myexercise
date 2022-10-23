package A_daily_topic.week3;

/**
 * @Auther: yca
 * @Date: 2022/09/21/21:02
 * @Description:
 *          62. 不同路径
 *          https://leetcode.cn/problems/unique-paths/
 */
public class day3 {
    class Solution {
        public int uniquePaths(int m, int n) {
            //1. 递归
            //2. 数学计算，实际上是排列组合问题，起点到终点的总共向左向下的次数一样
            long ans = 1;
            for (int x = n, y = 1; y < m; ++x, ++y) {
                ans = ans * x / y;
            }
            return (int) ans;
        }
    }
}
