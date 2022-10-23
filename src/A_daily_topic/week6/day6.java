package A_daily_topic.week6;

/**
 * @BelongsPackage: A_daily_topic.week6
 * @Author: yca
 * @CreateTime: 2022-10-15  20:32
 * @Description:
 *          443. 压缩字符串
 *          https://leetcode.cn/problems/string-compression/
 */
public class day6 {
    public static void main(String[] args) {
        char[] chars = {'a','a','a','b','b','a','a'};
        int compress = Solution.compress(chars);
        System.out.println(compress);
        for (char aChar : chars) {
            System.out.print(aChar+" ");
        }
    }
    class Solution {
        public static int compress(char[] cs) {
            int n = cs.length;
            int i = 0, j = 0;
            while (i < n) {
                int idx = i;
                while (idx < n && cs[idx] == cs[i]) idx++;
                int cnt = idx - i;
                cs[j++] = cs[i];
                if (cnt > 1) {
                    int start = j, end = start;
                    while (cnt != 0) {
                        cs[end++] = (char)((cnt % 10) + '0');
                        cnt /= 10;
                    }
                    reverse(cs, start, end - 1);
                    j = end;
                }
                i = idx;
            }
            return j;
        }
        static void reverse(char[] cs, int start, int end) {
            while (start < end) {
                char t = cs[start];
                cs[start] = cs[end];
                cs[end] = t;
                start++; end--;
            }
        }
    }
}