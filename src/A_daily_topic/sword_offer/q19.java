package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2023-02-13  15:17
 * @Description:
 *          剑指 Offer 19. 正则表达式匹配
 *          https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof/?favorite=xb9nqhhg
 */
public class q19 {
    class Solution {
        public boolean isMatch(String A, String B) {
            int n = A.length();
            int m = B.length();
            boolean[][] f = new boolean[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    //分成空正则和非空正则两种
                    if (j == 0) {
                        f[i][j] = i == 0;
                    } else {
                        //非空正则分为两种情况 * 和 非*
                        if (B.charAt(j - 1) != '*') {
                            if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                                f[i][j] = f[i - 1][j - 1];
                            }
                        } else {
                            //碰到 * 了，分为看和不看两种情况
                            //不看
                            if (j >= 2) {
                                f[i][j] |= f[i][j - 2];
                            }
                            //看
                            if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                                f[i][j] |= f[i - 1][j];
                            }
                        }
                    }
                }
            }
            return f[n][m];
        }
    }
}