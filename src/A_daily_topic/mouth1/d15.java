package A_daily_topic.mouth1;

/**
 * @BelongsPackage: A_daily_topic.mouth1
 * @Author: yca
 * @CreateTime: 2023-02-15  09:39
 * @Description:
 *          1250. 检查「好数组」
 *          https://leetcode.cn/problems/check-if-it-is-a-good-array/
 */
public class d15 {
    /*
求最大公约数是否为1.
裴蜀定理:
若a,b是整数,且gcd(a,b)=d，那么对于任意的整数x,y,ax+by都一定是d的倍数，
特别地，一定存在整数x,y，使ax+by=d成立。
 a,b互质的充要条件是存在整数x,y使ax+by=1.
*/
    class Solution {
        public boolean isGoodArray(int[] nums) {
            int g = 0;
            for (int x : nums) {
                g = gcd(x, g);
            }
            return g == 1;
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
}