package com.ityca.day1;
//537. 复数乘法
public class demo6 {
    public static void main(String[] args) {
        String num1="1+-1i";
        String num2="1+-1i";
        System.out.println(Solution.complexNumberMultiply(num1,num2));
    }
    class Solution {
        public static String complexNumberMultiply(String num1, String num2) {
//            num1 = "1+1i", num2 = "1+1i"=>"0+2i"
            //将字符串分割成三部分
            //比如num1划分成"1","1","i"
            String[] s1 = num1.split("\\+|i");
            String[] s2 = num2.split("\\+|i");
            //提取数字部分
            int a1 = Integer.parseInt(s1[0]);
            int a2 = Integer.parseInt(s1[1]);
            int b1 = Integer.parseInt(s2[0]);
            int b2 = Integer.parseInt(s2[1]);
            //相乘
            int A = a1 * b1 - a2 * b2;
            int B = a1 * b2 + a2 * b1;
            String res = A + "+" + B + "i";
            return res;
        }
    }
}
