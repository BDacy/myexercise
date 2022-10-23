package com.ityca.week8;

import java.util.Arrays;

//一周的全部写在一起算了
public class Week8 {
    public static void main(String[] args) {
        String s="aba";
        System.out.println(Solution.repeatedSubstringPattern(s));
    }
    static class Solution {
        //344. 反转字符串
        public static void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;
            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }

        //541. 反转字符串 II
        public static String reverseStr(String s, int k) {
            StringBuffer res = new StringBuffer();
            int length = s.length();
            int start = 0;
            while (start < length) {
                StringBuffer temp = new StringBuffer();
                if (length - start >= 2 * k) {
                    temp.append(s.substring(start, start + k));
                    temp = temp.reverse();
                    res.append(temp);
                    res.append(s.substring(start + k, start + 2 * k));
                    start += 2 * k;
                } else if (length - start >= k && length - start < 2 * k) {
                    temp.append(s.substring(start, start + k));
                    temp = temp.reverse();
                    res.append(temp);
                    res.append(s.substring(start + k));
                    break;
                } else if (length - start < k) {
                    temp.append(s.substring(start));
                    temp = temp.reverse();
                    res.append(temp);
                    break;
                }
            }
            return res.toString();
        }

        //541.反转字符串 II 美化版
        public static String reverseStr1(String s, int k) {
            StringBuffer res = new StringBuffer();
            int length = s.length();
            int start = 0;
            while (start < length) {
                // 找到k处和2k处
                StringBuffer temp = new StringBuffer();
                // 与length进行判断，如果大于length了，那就将其置为length
                int firstK = (start + k > length) ? length : start + k;
                int secondK = (start + (2 * k) > length) ? length : start + (2 * k);

                //无论start所处位置，至少会反转一次
                temp.append(s.substring(start, firstK));
                res.append(temp.reverse());

                // 如果firstK到secondK之间有元素，这些元素直接放入res里即可。
                if (firstK < secondK) { //此时剩余长度一定大于k。
                    res.append(s.substring(firstK, secondK));
                }
                start += (2 * k);
            }
            return res.toString();
        }

        //剑指 Offer 05. 替换空格
        public static String replaceSpace(String s) {
            //双指针法
            if (s == null || s.length() == 0)
                return s;
            //得到空格数
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    sb.append("  ");
                }
            }
            if (sb.length() == 0)
                return s;
            //左右指针
            int left = s.length() - 1;
            s += sb.toString();
            int right = s.length() - 1;
            char[] chars = s.toCharArray();
            while (left != right) {
                if (chars[left] == ' ') {
                    chars[right--] = '0';
                    chars[right--] = '2';
                    chars[right] = '%';
                } else
                    chars[right] = chars[left];
                left--;
                right--;
            }
            return new String(chars);
        }

        //151. 颠倒字符串中的单词
        public String reverseWords(String s) {
            //1.去除首尾以及中间多余空格
            StringBuilder sb = removeSpace(s);
            //2.翻转整个字符串
            ReverseStr(sb, 0, sb.length() - 1);
            //3.翻转每个单词
            ReverseEachWord(sb);
            return sb.toString();
        }
        private StringBuilder removeSpace(String s) {
            // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
            int start = 0;
            int end = s.length() - 1;
            while (s.charAt(start) == ' ') start++;
            while (s.charAt(end) == ' ') end--;
            StringBuilder sb = new StringBuilder();
            while (start <= end) {
                char c = s.charAt(start);
                if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(c);
                }
                start++;
            }
            // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
            return sb;
        }
        public void ReverseStr(StringBuilder sb, int start, int end) {
            // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
            while (start < end) {
                char temp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, temp);
                start++;
                end--;
            }
            // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
        }
        private void ReverseEachWord(StringBuilder sb) {
            int start = 0;
            int end = 1;
            int n = sb.length();
            while (start < n) {
                while (end < n && sb.charAt(end) != ' ') {
                    end++;
                }
                ReverseStr(sb, start, end - 1);
                start = end + 1;
                end = start + 1;
            }
        }
        //剑指 Offer 58 - II. 左旋转字符串
        public String reverseLeftWords(String s, int n) {
            StringBuilder sb =new StringBuilder(s);
            //1.先全部翻转
            ReverseStr1(sb,0,s.length()-1);
            //2.后n个局部翻转
            ReverseStr1(sb,s.length()-n,sb.length()-1);
            //3.剩余的前面几个字母翻转
            ReverseStr1(sb,0,s.length()-n-1);
            return sb.toString();
        }
        public void ReverseStr1(StringBuilder sb,int start,int end){
            //双指针法
            while (start<end){
                char temp=sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end,temp);
                start++;
                end--;
            }
        }
        //28. 实现 strStr()
        public static int strStr(String haystack, String needle) {
            //KMP太难了，我们使用滑动窗口
            int n=needle.length();
            if (n==0)return 0;
            int m=haystack.length();
            if (n>m)return -1;
            //寻找第一个相同的字母
            for (int i = 0; i < m; i++) {
                int temp=i;//记录地址，用来回溯
                int j=0;
                while (i<m&&haystack.charAt(i)==needle.charAt(j)){
                    i++;
                    j++;
                    if (j==n)return temp;
                }
                i=temp;
            }
            return -1;
        }
        //459. 重复的子字符串
        public static boolean repeatedSubstringPattern(String s) {
            //滑动窗口，
            String str=s+s;
            String temp=str.substring(1, str.length() - 1);
            return temp.contains(s);
        }
    }
}
