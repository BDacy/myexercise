package com.ityca.week2;
//258. 各位相加
public class demo8 {
    public static void main(String[] args) {
        int num=990;
        System.out.println(Solution.addDigits(num));
    }
    class Solution {
        public static int addDigits(int num) {
            if (num<10)return num;
            else {
                int temp;
                int res=0;
                while (num>0){
                    temp=num%10;
                    res+=temp;
                    num=num/10;
                }
                return addDigits(res);
            }

        }
    }
}
