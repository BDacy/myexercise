package com.ityca.week3;
//504. 七进制数
//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
public class demo1 {
//    输入: num = 100
//    输出: "202"
//    输入: num = -7
//    输出: "-10"
public static void main(String[] args) {
    int num=100;
    System.out.println(Solution.convertToBase7(num));
}
class Solution {
    public static String convertToBase7(int num) {
        StringBuilder res = new StringBuilder();
        int temp=num;
        while (temp!=0){
            res.insert(0,Math.abs(temp%7));
            temp/=7;
        }
        if (num<0)
            res.insert(0,'-');
        return res.toString();
    }
}
}
