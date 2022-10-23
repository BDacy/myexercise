package com.ityca.week5;
//69. x 的平方根
public class demo3 {
    public static void main(String[] args) {
        int x=2;
        System.out.println(Solution.mySqrt(x));
    }
    class  Solution {
        public static int mySqrt(int x) {
            if (x==0)return 0;
            if (x==1||x==2||x==3)return 1;
            int left=0;
            int right=x/2;
            int mid = 0;
            while (left<=right){
                mid=left+(right-left)/2;
                if (mid>x/mid){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
            return left-1;
        }
    }
}
