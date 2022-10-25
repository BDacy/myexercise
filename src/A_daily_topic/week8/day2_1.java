package A_daily_topic.week8;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsPackage: A_daily_topic.week8
 * @Author: yca
 * @CreateTime: 2022-10-25  08:49
 * @Description:
 *          934. 最短的桥
 *          https://leetcode.cn/problems/shortest-bridge/
 */
public class day2_1 {
    public static void main(String[] args) {
        int grid[][] = {{0,1},{1,0}};
//        int grid[][] = {{0,1,0},{0,0,0},{0,0,1}};
        System.out.println(Solution.shortestBridge(grid));
    }
    class Solution {
        public static int xlength;//行数
        public static int ylength;//列数
        public static Deque<Integer[]> deque = new LinkedList<>();
        public static int shortestBridge(int[][] grid) {
            xlength = grid.length;
            ylength = grid[0].length;
            for (int i = 0; i < xlength; i++) {
                for (int j = 0; j < ylength; j++) {
                    if (grid[i][j]==1) {
                        dfs(grid, i, j);
                        return bfs(grid);
                    }
                }
            }
           return -1;
        }
        public static void dfs(int[][] grid,int x,int y){
            if (x < 0||x >= xlength||y < 0||y >= ylength)return;
            if (grid[x][y] == 1){
                deque.addLast(new Integer[]{x,y});
                grid[x][y] = -1;
                dfs(grid,x-1,y);//上
                dfs(grid,x+1,y);//下
                dfs(grid,x,y-1);//左
                dfs(grid,x,y+1);//右
            }
        }
        public static int bfs(int[][] grid){
            int step = 0;
            while (!deque.isEmpty()){
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    Integer[] pop = deque.removeFirst();
                    int x = pop[0];
                    int y = pop[1];
                    if (check(grid,x-1,y)
                            ||check(grid,x+1,y)
                            ||check(grid,x,y-1)
                            ||check(grid,x,y+1))
                        return step;
                }
                step++;
            }
            return step;
        }
        public static boolean check(int[][] grid,int x, int y){
            if (x < 0||x >= xlength||y < 0||y >= ylength)return false;
            if (grid[x][y] == 1)return true;
            else if (grid[x][y] == 0){
                deque.addLast(new Integer[]{x,y});
                grid[x][y] = -1;
            }
            return false;
        }
    }
}