package com.ityca.day1;

import java.util.ArrayList;
import java.util.List;

public class demo1 {
    public static void main(String[] args) {

    }
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list=new ArrayList<>();
            //定义边界
            Integer line1=0;//行的上边界
            Integer line2=matrix.length-1;//行的下边界
            Integer column1=0;//列的左边界
            Integer column2=matrix[0].length-1;//列的右边界
            //进行遍历操作
            while (true) {
                //1.向右遍历
                for(int i=column1;i<=column2;i++)
                    list.add(matrix[line1][i]);
                if(++line1>line2)break;//边界交错退出
                //2.向下遍历
                for(int i=line1;i<=line2;i++)
                    list.add(matrix[i][column2]);
                if(--column2<column1)break;
                //3.向左遍历
                for(int i=column2;i>=column1;i--)
                    list.add(matrix[line2][i]);
                if(--line2<line1)break;
                //4.向上遍历
                for (int i=line2;i>=line1;i--)
                    list.add(matrix[i][column1]);
                if (++column1>column2)break;
            }
            return list;
        }
    }
}
