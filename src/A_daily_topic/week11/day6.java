package A_daily_topic.week11;

/**
 * @BelongsPackage: A_daily_topic.week11
 * @Author: yca
 * @CreateTime: 2022-11-19  10:43
 * @Description:
 *          202. 快乐数
 *          https://leetcode.cn/problems/happy-number/
 *          1732. 找到最高海拔
 *          https://leetcode.cn/problems/find-the-highest-altitude/
 */
public class day6 {
    public class Solution {
        public boolean isHappy(int n) {
            int low = n;
            int fast = squareSum(n);
            while (low != fast){
                low = squareSum(low);
                fast = squareSum(squareSum(fast));
            }
            return low == 1;
        }
        private int squareSum(int n){
            int res = 0;
            while (n > 0){
                int tmp = n % 10;
                res += tmp * tmp;
                n /= 10;
            }
            return res;
        }

        public int largestAltitude(int[] gain) {
            int high = 0;
            int cur = 0;
            for (int i : gain) {
                cur += i;
                if (cur > high)high = cur;
            }
            return high;
        }
    }
}