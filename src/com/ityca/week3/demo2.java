package com.ityca.week3;
//1732. 找到最高海拔
public class demo2 {
    public static void main(String[] args) {
        int[] gain={-4,-3,-2,-1,4,3,10};
        System.out.println(Solution.largestAltitude(gain));
    }
    class Solution {
        public static int largestAltitude(int[] gain) {
            int max=0;
            int now=0;;
            for (int i : gain) {
                now+=i;
                if (now>max)
                    max=now;
            }
            return max;
        }
    }
}
