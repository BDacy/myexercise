package A_daily_topic.mouth2;

/**
 * @BelongsPackage: A_daily_topic.mouth2
 * @Author: yca
 * @CreateTime: 2023-03-06  10:52
 * @Description:
 *          1653. 使字符串平衡的最少删除次数
 *          https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
 */
public class d6 {
    class Solution {
        public int minimumDeletions(String s) {
            // 前缀和与后缀和
            int n = s.length();
            int[] as = new int[n + 1];
            int[] bs = new int[n + 1];
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == 'b'){
                    bs[i + 1] = bs[i] + 1;
                }else bs[i + 1] = bs[i];
            }
            for(int i = n - 1; i >= 0; i--){
                if(s.charAt(i) == 'a')
                    as[i] = as[i + 1] + 1;
                else as[i] = as[i + 1];
            }
            int min = n;
            for(int i = 0; i <= n; i++){
                min = Math.min(min, as[i] + bs[i]);
            }
            return min;
        }
    }
}