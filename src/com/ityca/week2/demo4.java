package com.ityca.week2;
//1523. 在区间范围内统计奇数数目
public class demo4 {
    class Solution {
        public int countOdds(int low, int high) {
            if (low%2==1||high%2==1){
                return (high-low)/2+1;
            }else {
                return (high-low)/2;
            }
        }
    }
}
