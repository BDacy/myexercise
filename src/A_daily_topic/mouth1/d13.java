package A_daily_topic.mouth1;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-13  14:34
 * @Description:
 *          1234. 替换子串得到平衡字符串
 *          https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
 */
public class d13 {
    class Solution {
        public int balancedString(String s) {
            int[] cnt = new int[4];
            String t = "QWER";
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                cnt[t.indexOf(s.charAt(i))]++;
            }
            int m = n / 4;
            if (cnt[0] == m && cnt[1] == m && cnt[2] == m && cnt[3] == m) {
                return 0;
            }
            int ans = n;
            for (int i = 0, j = 0; i < n; ++i) {
                cnt[t.indexOf(s.charAt(i))]--;
                while (j <= i && cnt[0] <= m && cnt[1] <= m && cnt[2] <= m && cnt[3] <= m) {
                    ans = Math.min(ans, i - j + 1);
                    cnt[t.indexOf(s.charAt(j++))]++;
                }
            }
            return ans;
        }
    }
}