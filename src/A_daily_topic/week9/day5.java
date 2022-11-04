package A_daily_topic.week9;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage: A_daily_topic.week9
 * @Author: yca
 * @CreateTime: 2022-11-04  10:21
 * @Description:
 *          754. 到达终点数字
 *          https://leetcode.cn/problems/reach-a-number/
 *          887. 鸡蛋掉落
 *          https://leetcode.cn/problems/super-egg-drop/
 */
public class day5 {
    class Solution {
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        public int reachNumber(int target) {
            if (target < 0)target = -target;
            if (target == 0)return 0;
            int cnt = 0;
            int cur = 0;
            while (cur < target || (cur - target) % 2 == 1)
                cur += ++cnt;
            return cnt;
        }

        public int superEggDrop(int k, int n) {
            return dp(k,n);
        }
        public int dp(int k, int n) {
            if (!memo.containsKey(n * 100 + k)) {
                int ans;
                if (n == 0) {
                    ans = 0;
                } else if (k == 1) {
                    ans = n;
                } else {
                    int lo = 1, hi = n;
                    while (lo + 1 < hi) {
                        int x = (lo + hi) / 2;
                        int t1 = dp(k - 1, x - 1);
                        int t2 = dp(k, n - x);

                        if (t1 < t2) {
                            lo = x;
                        } else if (t1 > t2) {
                            hi = x;
                        } else {
                            lo = hi = x;
                        }
                    }
                    ans = 1 + Math.min(Math.max(dp(k - 1, lo - 1), dp(k, n - lo)), Math.max(dp(k - 1, hi - 1), dp(k, n - hi)));
                }

                memo.put(n * 100 + k, ans);
            }

            return memo.get(n * 100 + k);
        }
    }
}