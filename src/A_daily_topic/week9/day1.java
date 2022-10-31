package A_daily_topic.week9;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsPackage: A_daily_topic.week9
 * @Author: yca
 * @CreateTime: 2022-10-31  16:36
 * @Description:
 *          1647. 字符频次唯一的最小删除次数
 *          https://leetcode.cn/problems/minimum-deletions-to-make-character-frequencies-unique/
 *          481. 神奇字符串
 *          https://leetcode.cn/problems/magical-string/
 */
public class day1 {
    class Solution {
        public int minDeletions(String s) {
            char[] cs = s.toCharArray();
            int[] dics = new int[26];
            for (int i = 0; i < cs.length; i++) {
                dics[cs[i] - 'a']++;
            }
            int ans = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < dics.length; i++) {
                int cur = dics[i];
                while (cur != 0 && !set.add(cur)) {
                    cur--;
                    ans++;
                }
            }
            return ans;
        }
        public int magicalString(int n) {
            int[] nums = new int[n + 2];
            nums[0] = 1;
            nums[1] = 2;
            int low = 1;
            int high = 1;
            int cur = 1;
            while (high < n){
                if (cur == 1)cur = 2;
                else cur = 1;
                if (nums[low] == 1){
                    nums[high] = cur;
                    high++;
                }
                else{
                    nums[high] = cur;
                    nums[high+1] = cur;
                    high += 2;
                }
                low++;
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1)res++;
            }
            return res;
        }
    }
}