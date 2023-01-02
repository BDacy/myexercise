package A_daily_topic.week18;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @BelongsPackage: A_daily_topic.week18
 * @Author: yca
 * @CreateTime: 2023-01-02  11:49
 * @Description:
 *          1293. 网格中的最短路径
 *          https://leetcode.cn/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 *          1801. 积压订单中的订单总数
 *          https://leetcode.cn/problems/number-of-orders-in-the-backlog/
 */
public class day1 {
    class Solution {
        public int shortestPath(int[][] grid, int k) {
            int[][] dd = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};// 上 下 左 右
            // BFS + 队列
            Queue<Dest> queue = new ArrayDeque<>();
            int m = grid.length;
            int n = grid[0].length;
            int minstep = 0;
            if (m == 1 && n == 1)return minstep;
            boolean[][][] visited = new boolean[m][n][k + 1];
            visited[0][0][k] = true;
            queue.add(new Dest(0,0,k));

            while (!queue.isEmpty()){
                minstep++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Dest dest = queue.poll();
                    // 剪枝
                    if (m - dest.x - 1 + n - dest.y <= dest.rest)return minstep + m - dest.x  + n - dest.y - 3;
                    for (int[] d : dd) {
                        int dx = d[0];
                        int dy = d[1];
                        int nx = dx + dest.x;
                        int ny = dy + dest.y;
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n)continue;
                        // 搜索到直接返回
                        if (nx == m - 1 && ny == n - 1)return minstep;
                        // 如果穿越障碍次数满了
                        if (grid[nx][ny] == 1 && dest.rest <= 0)continue;
                        // 正常运行
                        int nrest = grid[nx][ny] == 1 ? dest.rest - 1 : dest.rest;
                        // 四个方向是不是走过
                        if (!visited[nx][ny][nrest]){
                            // 没走过现在走
                            visited[nx][ny][nrest] = true;
                            queue.add(new Dest(nx, ny, nrest));
                        }
                    }
                }
            }
            // 搜索不到
            return -1;
        }

        class Dest{
            int x,y;
            int rest;

            public Dest(int x, int y, int rest) {
                this.x = x;
                this.y = y;
                this.rest = rest;
            }
        }

        public int getNumberOfBacklogOrders(int[][] orders) {
            int mod = (int) (1e9 + 7);
            // 两个优先队列
            PriorityQueue<int[]> sell = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);//小顶堆
            PriorityQueue<int[]> buy = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);// 大顶堆

            for (int[] order : orders) {
                if (order[2] == 0){
                    // 采购订单 buy,看最小堆sell
                    int num = order[1];
                    while (num > 0){
                        if (sell.isEmpty()){
                            buy.add(new int[]{order[0],num});
                            break;
                        }
                        int[] peek = sell.peek();
                        if (peek[0] <= order[0]){
                            if (num >= peek[1]){
                                sell.poll();
                                num = num - peek[1];
                            }else{
                                peek[1] -= num;
                                break;
                            }
                        }else {
                            buy.add(new int[]{order[0], num});
                            break;
                        }
                    }
                }else {
                    // 销售订单 sell,看大顶堆buy
                    int num = order[1];
                    while (num > 0){
                        if (buy.isEmpty()){
                            sell.add(new int[]{order[0], num});
                            break;
                        }
                        int[] peek = buy.peek();
                        if (peek[0] >= order[0]){
                            if (num >= peek[1]){
                                buy.poll();
                                num = num - peek[1];
                            }else{
                                peek[1] -= num;
                                break;
                            }
                        }else {
                            sell.add(new int[]{order[0], num});
                            break;
                        }
                    }
                }
            }
            long res = 0;
            for (int[] order : buy) {
                res += order[1];
            }
            for (int[] order : sell) {
                res += order[1];
            }
            return (int) (res % mod);
        }
    }
}