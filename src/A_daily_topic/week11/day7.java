package A_daily_topic.week11;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsPackage: A_daily_topic.week11
 * @Author: yca
 * @CreateTime: 2022-11-20  09:42
 * @Description:
 *          139. 单词拆分
 *          https://leetcode.cn/problems/word-break/
 *          799. 香槟塔
 *          https://leetcode.cn/problems/champagne-tower/
 */
public class day7 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            // 类似于动态规划
            Set<String> set = new HashSet<>(wordDict);
            boolean[] valid = new boolean[s.length() + 1];
            valid[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (valid[j] && set.contains(s.substring(j, i))) {
                        valid[i] = true;
                    }
                }
            }
            return valid[s.length()];
        }

        public double champagneTower(int poured, int query_row, int query_glass) {
            // 动态规划- dp算法
            // waters[i][j] 表示到达这里的水的总量：
            double[][] waters = new double[query_row + 10][query_row + 10];
            waters[0][0] = poured;
            for (int i = 0; i < query_row + 1; i++) {
                for (int j = 0; j <= i; j++) {
                    if (waters[i][j] <= 1)continue;
                    waters[i + 1][j] += (waters[i][j] - 1)/2;
                    waters[i + 1][j + 1] += (waters[i][j] - 1)/2;
                }
            }
            return Math.min(waters[query_row][query_glass], 1);
        }
    }
}