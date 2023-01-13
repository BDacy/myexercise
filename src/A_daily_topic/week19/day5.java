package A_daily_topic.week19;

/**
 * @BelongsPackage: A_daily_topic.week19
 * @Author: yca
 * @CreateTime: 2023-01-13  11:18
 * @Description:
 *          338. 比特位计数
 *          https://leetcode.cn/problems/counting-bits/
 *          2287. 重排字符形成目标字符串
 *          https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
 */
public class day5 {
    class Solution {
        public int[] countBits(int n) {
            // 暴力模拟
            int[] res = new int[n + 1];
            for(int i = 0; i <= n; i++){
                int num = i;
                int cnt = 0;
                for(int j = 0; j < 32; j++){
                    if(((num >> j) & 1) == 1)
                        cnt++;
                }
                res[i] = cnt;
            }
            return res;
        }

        public int rearrangeCharacters(String s, String target) {
            // 计数匹配
            int[] targetCnt = new int[26];// target 的字母计数
            int[] sCnt = new int[26];
            for(int i = 0; i < target.length(); i++){
                targetCnt[target.charAt(i) - 'a']++;
            }
            for(int i = 0; i < s.length(); i++){
                sCnt[s.charAt(i) - 'a']++;
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 26; i++){
                if(targetCnt[i] != 0){
                    min = Math.min(min, sCnt[i] / targetCnt[i]);
                }
            }
            return min;
        }
    }
}