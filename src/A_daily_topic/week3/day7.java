package A_daily_topic.week3;

/**
 * @Auther: yca
 * @Date: 2022/09/25/9:22
 * @Description:
 *          96. 不同的二叉搜索树
 *          https://leetcode.cn/problems/unique-binary-search-trees/
 */
public class day7 {
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;

            for(int i = 2; i < n + 1; i++)
                for(int j = 1; j < i + 1; j++)
                    dp[i] += dp[j-1] * dp[i-j];

            return dp[n];
        }
    }
}
