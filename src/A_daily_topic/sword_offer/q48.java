package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2023-02-13  16:52
 * @Description:
 *          剑指 Offer 48. 最长不含重复字符的子字符串
 *          https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class q48 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 滑动窗口
            int max = 1;
            // 数组模拟哈希表
            boolean[] val = new boolean[128];
            int l = 0;
            int r = 1;
            int len = s.length();
            if(len == 0)return 0;
            if(len == 1)return 1;
            val[s.charAt(0)] = true;
            while(r < len){
                if(val[s.charAt(r)]){
                    while(l <= r){
                        val[s.charAt(l)] = false;
                        if(s.charAt(l++) == s.charAt(r))break;
                    }
                }
                val[s.charAt(r)] = true;
                r++;
                max = Math.max(max, r - l);
            }
            return max;
        }
    }
}