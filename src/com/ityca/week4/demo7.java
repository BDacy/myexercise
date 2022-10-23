package com.ityca.week4;

import java.util.Arrays;

//58. 最后一个单词的长度
public class demo7 {
    public static void main(String[] args) {
        String s="   fly me   to   the moon  ";
        System.out.println(Solution.lengthOfLastWord(s));
    }
    class Solution {
        public static int lengthOfLastWord(String s) {
//            输入：s = "   fly me   to   the moon  "
//            输出：4
            String[] s1 = s.split(" ");
            return s1[s1.length-1].length();
        }
    }
}
