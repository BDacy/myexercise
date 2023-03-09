package A_daily_topic.mouth2;

/**
 * @BelongsPackage: A_daily_topic.mouth2
 * @Author: yca
 * @CreateTime: 2023-03-09  08:51
 * @Description:
 *          2379. 得到 K 个黑块的最少涂色次数
 *          https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 */
public class d9 {
    class Solution {
        public int minimumRecolors(String blocks, int k) {
            // 窗口大小为k的滑动窗口
            int l = 0;
            int r = 0;
            int cntW = 0;
            // 初始化窗口
            for(; r < k; r++){
                if(blocks.charAt(r) == 'W')cntW++;
            }
            int res = Math.min(k, cntW);
            // 窗口移动
            while(r < blocks.length()){
                if(blocks.charAt(r++) == 'W')cntW++;
                if(blocks.charAt(l++) == 'W')cntW--;
                res = Math.min(res, cntW);
                if(res == 0)break;
            }
            return res;
        }
    }
}