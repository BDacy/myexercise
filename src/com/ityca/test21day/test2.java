package com.ityca.test21day;
//74. 搜索二维矩阵
public class test2 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //从矩阵的右上角出发，一步步做比较
            //比target大的往左走，比target小的往下走
            int down= matrix.length;//定义下边界
            int left=0;//定义左边界
            int a=0;
            int b=matrix[0].length-1;
            boolean res=false;
            while (a<down&&b>left){
                if (matrix[a][b]>target){
                    //向左走
                    b--;
                }else if (matrix[a][b]<target){
                    //向下走
                    a++;
                }else {
                    res=true;
                    break;
                }
            }
            return true;
        }
    }
}
