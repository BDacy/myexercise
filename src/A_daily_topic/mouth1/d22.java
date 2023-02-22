package A_daily_topic.mouth1;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-22  20:42
 * @Description:
 *          1140. 石子游戏 II
 *          https://leetcode.cn/problems/stone-game-ii/
 */
public class d22 {
    class Solution {
        public int stoneGameII(int[] piles) {
            // 动态规划
            int len = piles.length;
            // dp[i][M] 表示从piles[i]先开始取的人在M的条件下取得最多石子
            int[][] dp = new int[len][len + 1];
            int sum = 0; // 从后到前的总和，后缀值
            for(int i = len - 1; i >= 0; i--){
                sum += piles[i];// 计算后缀值
                for(int M = 1; M <= len; M++){
                    if(len - i <= 2 * M)dp[i][M] = sum;// 如果可以取完就取完
                    else{
                        for(int x = 1; x <= 2 * M; x++){// 不可以取完就找出所有取值下的最大值
                            dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                        }
                    }
                }
            }
            return dp[0][1];
        }
    }
}