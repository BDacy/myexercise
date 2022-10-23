package com.ityca.week7;

import java.util.*;

//438. 找到字符串中所有字母异位词
public class demo5 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int n1=s.length();
            int n2=p.length();
            List<Integer> res=new LinkedList<>();
            if (n1<n2) return res;
            int[] scnt=new int[26];
            int[] pcnt=new int[26];
            for (int i=0;i<n2;i++){
                scnt[s.charAt(i)-'a']++;
                pcnt[p.charAt(i)-'a']++;
            }
            if (Arrays.equals(scnt,pcnt))
                res.add(0);
            for (int i=0;i<n1-n2;i++){
                scnt[s.charAt(i)-'a']--;
                scnt[s.charAt(i+n2)-'a']++;
                if (Arrays.equals(scnt,pcnt))
                    res.add(i+1);
            }
            return res;
        }
    }
}
