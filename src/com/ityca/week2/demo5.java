package com.ityca.week2;
//1672.最富有客户的资产总量
public class demo5 {
    class Solution {
        public int maximumWealth(int[][] accounts) {
            int max=0;
            int sum;
            for (int i=0;i<accounts.length;i++){
                sum=0;
                for (int j=0;j<accounts[0].length;j++){
                    sum+=accounts[i][j];
                }
                if (sum>max)
                    max=sum;
            }
            return max;
        }
    }
}
