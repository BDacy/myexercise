package A_daily_topic.mouth2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsPackage: A_daily_topic.mouth2
 * @Author: yca
 * @CreateTime: 2023-03-01  09:10
 * @Description:
 *          2373. 矩阵中的局部最大值
 *          https://leetcode.cn/problems/largest-local-values-in-a-matrix/
 */
public class d1 {
    public static void main(String[] args) {
        int[][] grid = {{20,8,20,6,16,16,7,16,8,10},
                {12,15,13,10,20,9,6,18,17,6},
                {12,4,10,13,20,11,15,5,17,1},
                {7,10,14,14,16,5,1,7,3,11},{16,2,9,15,9,8,6,1,7,15},{18,15,18,8,12,17,19,7,7,8},{19,11,15,16,1,3,7,4,7,11},
                {11,6,5,14,12,18,3,20,14,6},{4,4,19,6,17,12,8,8,18,8},{19,15,14,11,11,13,12,6,16,19}};
        int[][] local = Solution.largestLocal(grid);
        for (int i = 0; i < local.length; i++) {
            System.out.println(Arrays.toString(local[i]));
        }
    }
    class Solution {
        public static int[][] largestLocal(int[][] grid) {
            // 两次单调队列？

            int n = grid.length;
            int idx = 0;
            int[][] maxGrid = new int[n][n - 2];
            for (int i = 0; i < n; i++) {
                Deque<Integer> deque = new ArrayDeque<>();
                for (int j = 0; j < 3; j++) {
                    while (!deque.isEmpty() && deque.peekLast() < grid[i][j]){
                        deque.pollLast();
                    }
                    deque.addLast(grid[i][j]);
                }
                maxGrid[i][idx++] = deque.peekFirst();
                for (int j = 0; j < n - 3; j++) {
                    if (grid[i][j] == deque.peekFirst())deque.pollFirst();
                    while (!deque.isEmpty() && deque.peekLast() < grid[i][j + 3]){
                        deque.pollLast();
                    }
                    deque.addLast(grid[i][j + 3]);
                    maxGrid[i][idx++] = deque.peekFirst();
                }
                idx = 0;
            }
            int[][] res = new int[n - 2][n - 2];
            // 第二次单调队列
            for (int i = 0; i < n - 2; i++) {
                Deque<Integer> deque = new ArrayDeque<>();
                for (int j = 0; j < 3; j++) {
                    while (!deque.isEmpty() && deque.peekLast() < maxGrid[j][i]){
                        deque.pollLast();
                    }
                    deque.addLast(maxGrid[j][i]);
                }
                res[idx++][i] = deque.peekFirst();
                for (int j = 0; j < n - 3; j++) {
                    if (maxGrid[j][i] == deque.peekFirst())deque.pollFirst();
                    while (!deque.isEmpty() && deque.peekLast() < maxGrid[j + 3][i]){
                        deque.pollLast();
                    }
                    deque.addLast(maxGrid[j + 3][i]);
                    res[idx++][i] = deque.peekFirst();
                }
                idx = 0;
            }
            return res;
        }
    }
}