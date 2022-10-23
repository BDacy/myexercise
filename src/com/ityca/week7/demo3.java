package com.ityca.week7;
//242. 有效的字母异位词
public class demo3 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] record=new int[26];
            for (char c : s.toCharArray()) {
                record[c-'a']++;
            }
            for (char c : t.toCharArray()) {
                record[c-'a']--;
            }
            for (int i : record) {
                if (i!=0)
                    return false;
            }
            return true;
        }
    }
}
