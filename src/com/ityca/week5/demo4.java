package com.ityca.week5;
//367. 有效的完全平方数
public class demo4 {
    public static void main(String[] args) {
        int num=808201;
        System.out.println(Solution.isPerfectSquare(num));
    }
    class Solution {
        public static boolean isPerfectSquare(int num) {
            if (num==1)return true;
            int left=0;
            int right=num/2;
            int mid=(left+right)/2;
            while (left<=right){
                mid=(left+right)/2;
               long temp=(long) mid*mid;
                if (temp<num){
                    left=mid+1;
                }else if (temp>num){
                    right=mid-1;
                }else {
                    return true;
                }
            }
            return false;
        }
    }
}
