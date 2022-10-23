package A_daily_topic.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: yca
 * @Date: 2022/09/29/9:17
 * @Description:
 *          51. N 皇后
 *          https://leetcode.cn/problems/n-queens/
 */
public class day4 {
    class Solution {
        public List<List<String>> res = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            String s ="e";
            char[][] ChessBoard = new char[n][n];
            //初始化
            for (char[] chars : ChessBoard) {
                Arrays.fill(chars,'.');
            }
            backtrack(0,ChessBoard,n);
            return res;
        }
        public void backtrack(int row,char[][] ChessBoard,int n){
            if (row == n){
                //收集结果
                res.add(charArrayToStringList(ChessBoard,n));
                return;
            }
            for (int col = 0; col < n; col++) {
                if (isValid(ChessBoard,col,row,n)){
                    ChessBoard[row][col] = 'Q';
                    backtrack(row+1,ChessBoard,n);
                    ChessBoard[row][col] = '.';
                }
            }
        }

        public boolean isValid(char[][] ChessBoard,int col,int row,int n){
            //检查列
            for (int i = 0; i < n; i++) {
                if (ChessBoard[i][col]=='Q')return false;
            }
            //检查左上
            for (int i = row-1, j = col-1; i>=0 && j>=0; i--,j--) {
                if (ChessBoard[i][j]=='Q')return false;
            }
            //检查右上
            for (int i = row-1, j = col+1; i>=0 && j<n ; i--,j++) {
                if (ChessBoard[i][j]=='Q')return false;
            }
            return true;
        }
        public List<String> charArrayToStringList(char[][] ChessBoard,int n){
            List<String> list = new ArrayList<>(n);
            for (char[] chars : ChessBoard) {
                list.add(String.valueOf(chars));
            }
            return list;
        }
    }
}
