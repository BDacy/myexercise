package com.ityca.week2;

import java.util.ArrayList;

//670. 最大交换
public class demo1 {
    public static void main(String[] args) {
        int num=1993;
        System.out.println(Solution.maximumSwap(num));
    }
    class Solution {
        public static int maximumSwap(int num) {
//            输入: 2736
//            输出: 7236
            String s=Integer.toString(num);
            char[] chars = s.toCharArray();
            int length= chars.length;
            int flag=0;//标志
            int left;
            int dd = 0;
            for (left=0;left<length-1&&flag==0;left++){
                char max=chars[left];
                for (int right=length-1;right>left;right--){
                    if (max<chars[right]){
                        flag=1;
                        max=chars[right];
                        dd=right;
                    }
                }
                if (flag==1){
                    char temp=chars[left];
                    chars[left]=chars[dd];
                    chars[dd]=temp;
                    return Integer.parseInt(new String(chars));
                }
            }
            return Integer.parseInt(s);
        }
    }
}
