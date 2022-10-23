package com.ityca.week5;

import java.util.LinkedList;
import java.util.List;

//682. 棒球比赛
public class demo7 {
    public static void main(String[] args) {
        String[] ops={"-42","90","82","+","C","-21","43","D","D","-32","-98","83","D","-86","68","68","D","C","C","7"};
        System.out.println(Solution.calPoints(ops));
    }
    class Solution {
        public static int calPoints(String[] ops) {
            //输入：ops = ["5","2","C","D","+"]
            //输出：30
            List<String> stack=new LinkedList<>();
            for (String op : ops) {
                switch (op.charAt(0)){
                    //移除前一个
                    case 'C':
                        stack.remove(stack.size()-1);
                        break;
                    //添上前一个翻倍的值
                    case 'D':
                        stack.add(String.valueOf(Integer.parseInt(stack.get(stack.size()-1))*2));
                        break;
                    //添上前两个相加的值
                    case '+':
                        stack.add(String.valueOf(Integer.parseInt(stack.get(stack.size()-1))
                                +Integer.parseInt(stack.get(stack.size()-2))));
                        break;
                    default:
                        stack.add(op);
                }
            }
            int res=0;
            for (String s : stack) {
                res+=Integer.parseInt(s);
            }
            return res;
        }
    }
}
