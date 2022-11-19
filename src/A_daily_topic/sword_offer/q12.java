package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-19  15:22
 * @Description:
 *          剑指 Offer 12. 矩阵中的路径
 *          https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/?favorite=xb9nqhhg
 */
public class q12 {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        String word = "SEE";
        System.out.println(Solution.exist(board,word));
    }
    class Solution {
        static char[] chars;
        static int length;
        static int xlength;
        static int ylength;
        static char[][] aboard;
        public static boolean exist(char[][] board, String word) {
            chars = word.toCharArray();
            length = chars.length;
            xlength = board.length;
            ylength = board[0].length;
            aboard = board;

            // 记录是否走过
            boolean[][] isTrue = new boolean[xlength][ylength];

            // 找出起始点;对每个起始点进行dfs搜索
            for (int i = 0; i < xlength; i++) {
                for (int j = 0; j < ylength; j++) {
                    if (chars[0] == board[i][j])
                        if (dfs(isTrue,i,j,1))return true;
                }
            }
            return false;
        }
        private static boolean dfs(boolean[][] isTrue, int x, int y, int next){
            if (next == length)return true;
            isTrue[x][y] = true;
            char c = chars[next];
            // 搜索上下左右
            if (x - 1 >= 0 && !isTrue[x - 1][y] && aboard[x - 1][y] == c ){
                if (dfs(isTrue, x - 1, y, next + 1)) return true;
            }
            if (x + 1 < xlength && !isTrue[x + 1][y] && aboard[x + 1][y] == c ){
                if (dfs(isTrue, x + 1, y, next + 1)) return true;
            }
            if (y - 1 >= 0 && !isTrue[x][y - 1] && aboard[x][y - 1] == c ){
                if (dfs(isTrue, x, y - 1, next + 1)) return true;
            }
            if (y + 1 < ylength && !isTrue[x][y + 1] && aboard[x][y + 1] == c ){
                if (dfs(isTrue, x, y + 1, next + 1)) return true;
            }
            isTrue[x][y] = false;
            return false;
        }
    }
}