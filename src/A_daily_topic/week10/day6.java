package A_daily_topic.week10;

/**
 * @BelongsPackage: A_daily_topic.week10
 * @Author: yca
 * @CreateTime: 2022-11-12  09:17
 * @Description:
 *          1143. 最长公共子序列
 *          https://leetcode.cn/problems/longest-common-subsequence/
 *          790. 多米诺和托米诺平铺
 *          https://leetcode.cn/problems/domino-and-tromino-tiling/
 *          1138. 字母板上的路径
 *          https://leetcode.cn/problems/alphabet-board-path/
 *          1529. 最少的后缀翻转次数
 *          https://leetcode.cn/problems/minimum-suffix-flips/
 */
public class day6 {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            //动态规划
            int m = text1.length();
            int n = text2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int max = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else
                        dp[i][j] = max;
                }
            }
            return dp[m][n];
        }

        static final int MOD = 1000000007;
        public int numTilings(int n) {
            int[][] dp = new int[n + 1][4];
            dp[0][3] = 1;
            for (int i = 1; i <= n; i++) {
                dp[i][0] = dp[i - 1][3];
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
                dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
                dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
            }
            return dp[n][3];
        }

        public String alphabetBoardPath(String target) {
            char[] word = target.toCharArray();
            StringBuilder ans = new StringBuilder();
            int x = 0, y = 0;
            for (int i = 0; i < word.length; i++) {
                char c = word[i];
                int r = (c - 'a') / 5;
                int l = (c - 'a') % 5;
                int dy = r - x;
                int dx = l - y;
                if (c == 'z'){
                    if (dx > 0) ans.append("R".repeat(dx));
                    else ans.append("L".repeat(-dx));
                    if (dy > 0) ans.append("D".repeat(dy));
                    else ans.append("U".repeat(-dy));
                }
                else {
                    if (dy > 0) ans.append("D".repeat(dy));
                    else ans.append("U".repeat(-dy));
                    if (dx > 0) ans.append("R".repeat(dx));
                    else ans.append("L".repeat(-dx));
                }
                ans.append('!');
                x = r;
                y = l;
            }
            return ans.toString();
        }

        public int minFlips(String target) {
            char[] tmp = {'1','0'};
            int idx = 0;
            int ans = 0;
            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) == tmp[idx % 2]){
                    ans++;
                    idx++;
                }
            }
            return ans;
        }
    }
}