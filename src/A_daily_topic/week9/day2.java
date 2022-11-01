package A_daily_topic.week9;

/**
 * @BelongsPackage: A_daily_topic.week9
 * @Author: yca
 * @CreateTime: 2022-11-01  08:30
 * @Description:
 *          1615. 最大网络秩
 *          https://leetcode.cn/problems/maximal-network-rank/
 *          1662. 检查两个字符串数组是否相等
 *          https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/
 */
public class day2 {
    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            int[] cnt = new int[n + 1];
            int[][] connect = new int[n][n];
            for (int i = 0; i < roads.length; i++) {
                cnt[roads[i][0]]++;
                cnt[roads[i][1]]++;
                connect[roads[i][0]][roads[i][1]] = 1;
                connect[roads[i][1]][roads[i][0]] = 1;
            }
            int maxVal = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    maxVal = Math.max(maxVal, cnt[i] + cnt[j] - connect[i][j]);
                }
            }
            return maxVal;
        }
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < word1.length; i++) {
                sb1.append(word1[i]);
            }
            for (int i = 0; i < word2.length; i++) {
                sb2.append(word2[i]);
            }
            return sb1.toString().equals(sb2.toString());
        }
    }
}