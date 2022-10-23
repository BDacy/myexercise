package com.ityca.day1;
//1706. 球会落何处
//注意边界的处理哦
public class demo7 {
    public static void main(String[] args) {
        int [][]grid={{1,1,1,1,1,1}};
        System.out.println(grid[0].length);
        System.out.println(grid.length);
    }
    class Solution {
        public static int[] findBall(int[][] grid) {
            if (grid==null)return null;
            //获取列长即为小球的数量
            int colums= grid[0].length;
            int [] res=new int[colums];
            //从做到右计算球的轨迹
            for (int i=0;i<colums;i++){
                int a=0;
                int b=i;
                while (a<grid.length){
                    if(grid[a][b]==1){//向右走
                        if (b+1==colums||grid[a][b+1]==-1){
                            b=-1;
                            break;
                        }else {//向右下走
                            b++;
                        }
                    }else {//向左走
                        if(b-1==-1||grid[a][b-1]==1){
                            b=-1;
                            break;
                        }else {//向左下方走
                            b--;
                        }
                    }
                    a++;
                }
                res[i]=b;
            }
            return res;
        }
    }
}
