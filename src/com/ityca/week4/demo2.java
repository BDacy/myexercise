package com.ityca.week4;
//面试题 01.06. 字符串压缩
public class demo2 {
    public static void main(String[] args) {
        String S="abbccd";
        System.out.println(Solution.compressString(S));
    }
    class Solution {
        public static String compressString(String S) {
            if (S.equals("")) return S;
//            输出："a2b1c5a3"
            StringBuilder res=new StringBuilder();
            char[] chars = S.toCharArray();
            int cnt=1;//计数器
            int n=S.length();
            for (int i=0;i<n-1;i++){
                if (chars[i]==chars[i+1]){
                    cnt++;
                }else{
                    res.append(chars[i]);
                    res.append(cnt);
                    cnt=1;
                }
            }
            res.append(chars[n-1]);
            res.append(cnt);
            if (res.length()<=S.length())
            return res.toString();
            else
                return S;
        }
    }
}
