package com.ityca.week2;

import java.util.Arrays;

//螺旋矩阵 II
public class demo3 {
    public static void main(String[] args) {
        int n=1;
        for (n=1;n<=20;n++){
            int [][] res=Solution.generateMatrix(n);
            for (int i=0;i<n;i++){
                System.out.println(Arrays.toString(res[i]));
            }
        }


    }
    class Solution {
        public static int[][] generateMatrix(int n) {
            int[][] res=new int[n][n];
            int line1=0;
            int line2=n-1;
            int col1=0;
            int col2=n-1;
            int num=1;
            while (true){
                //向左走
                for (int i=col1;i<=col2;i++,num++){
                    res[line1][i]=num;
                }
                line1++;
                if (num>n*n)break;
                //向下走
                for (int i=line1;i<=line2;i++,num++){
                    res[i][col2]=num;
                }
                col2--;
                if (num>n*n)break;
                //向左走
                for (int i=col2;i>=col1;i--,num++){
                    res[line2][i]=num;
                }
                line2--;
                if (num>n*n)break;
                for (int i=line2;i>=line1;i--,num++){
                    res[i][col1]=num;
                }
                col1++;
                if (num>n*n)break;
            }
            return res;
        }
    }
}
