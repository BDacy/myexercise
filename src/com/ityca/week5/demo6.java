package com.ityca.week5;
//844. 比较含退格的字符串
public class demo6 {
    class Solution {
        //也可以使用双指针，两个字符串从后到前进行扫描，
        // 遇到‘#’就计数器+1，其他减一并比较计数器为0时两个指针指的字符是否相同到结束
        //这里懒的写，自己去题解看把，嘿嘿
        public boolean backspaceCompare(String s, String t) {
//            输入：s = "ab#c", t = "ad#c"
//            输出：true
            //栈的思想
            String s1=res(s);
            String s2=res(t);
            if (s1.equals(s2))return true;
            return false;
        }
        public String res(String s){
            int index=-1;//记录字符串长度指针
            StringBuilder ans=new StringBuilder();
            int n=s.length();
            for (int i=0;i<n;i++){
                if (s.charAt(i)!='#'){
                    ans.append(s.charAt(i));
                    index++;
                }else{
                    if (index==-1)continue;
                    ans.deleteCharAt(index--);
                }
            }
            return ans.toString();
        }
    }
}
