package A_daily_topic.week17;

/**
 * @BelongsPackage: A_daily_topic.week17
 * @Author: yca
 * @CreateTime: 2022-12-27  12:51
 * @Description:
 *          10. 正则表达式匹配
 *          https://leetcode.cn/problems/regular-expression-matching/
 *          2027. 转换字符串的最少操作次数
 *          https://leetcode.cn/problems/minimum-moves-to-convert-string/
 */
public class day2 {
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

            boolean[][] f = new boolean[m + 1][n + 1];
            f[0][0] = true;
            for (int i = 0; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        f[i][j] = f[i][j - 2];
                        if (matches(s, p, i, j - 1)) {
                            f[i][j] = f[i][j] || f[i - 1][j];
                        }
                    } else {
                        if (matches(s, p, i, j)) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
            return f[m][n];
        }

        public boolean matches(String s, String p, int i, int j) {
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }

        public int minimumMoves(String s) {
            int idx = 0;
            int n = s.length();
            int res = 0;
            while(idx < n){
                char c = s.charAt(idx);
                if(c == 'X'){
                    idx+=3;
                    res++;
                }
                else idx++;
            }
            return res;
        }
    }
}