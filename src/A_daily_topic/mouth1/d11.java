package A_daily_topic.mouth1;

import java.util.Arrays;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-11  09:34
 * @Description:
 *          2335. 装满杯子需要的最短总时长
 *          https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/
 */
public class d11 {
    class Solution {
        public int fillCups(int[] amount) {
            // 贪心+分类讨论
            Arrays.sort(amount);
            int x = amount[0];
            int y = amount[1];
            int z = amount[2];
            if(x + y <= z)return z;
            else{
                int t = x + y - z;
                return z + (int)Math.ceil(t * 1.0 / 2);
            }
        }
    }
}