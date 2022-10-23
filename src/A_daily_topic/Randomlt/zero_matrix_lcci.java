package A_daily_topic.Randomlt;

/**
 * @Auther: yca
 * @Date: 2022/09/30/17:03
 * @Description:
 *          面试题 01.08. 零矩阵
 *          https://leetcode.cn/problems/zero-matrix-lcci/
 */
public class zero_matrix_lcci {
    class Solution {
        public void setZeroes(int[][] matrix) {
            //模拟
            int rowSize = matrix.length;
            int colSize = matrix[0].length;

            boolean[] rowMark = new boolean[rowSize];//第几行
            boolean[] colMark = new boolean[colSize];//第几列
            //遍历数组
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (matrix[i][j]==0){
                        rowMark[i]=true;
                        colMark[j]=true;
                    }
                }
            }
            //变成0
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                   if (rowMark[i] || colMark[j])
                       matrix[i][j] = 0;
                }
            }
        }
    }
}
