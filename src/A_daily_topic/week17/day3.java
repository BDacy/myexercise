package A_daily_topic.week17;

/**
 * @BelongsPackage: A_daily_topic.week17
 * @Author: yca
 * @CreateTime: 2022-12-28  11:45
 * @Description:
 *          130. 被围绕的区域
 *          https://leetcode.cn/problems/surrounded-regions/
 *          1750. 删除字符串两端相同字符后的最短长度
 *          https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/
 */
public class day3 {
    class Solution {
        int n, m;

        public void solve(char[][] board) {
            n = board.length;
            if (n == 0) {
                return;
            }
            m = board[0].length;
            for (int i = 0; i < n; i++) {
                dfs(board, i, 0);
                dfs(board, i, m - 1);
            }
            for (int i = 1; i < m - 1; i++) {
                dfs(board, 0, i);
                dfs(board, n - 1, i);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
                return;
            }
            board[x][y] = 'A';
            dfs(board, x + 1, y);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x, y - 1);
        }

        public int minimumLength(String s) {
            // 双指针模拟
            int n = s.length();
            if(n == 1)return 1;
            int left = 0;
            int right = n - 1;
            while (left < right){
                char c1 = s.charAt(left);
                if (c1 != s.charAt(right))break;
                while (c1 == s.charAt(right) && left < right)right--;
                while (c1 == s.charAt(left) && left <= right)left++;
            }
            if(left > right) return 0;
            return right - left + 1;
        }
    }
}