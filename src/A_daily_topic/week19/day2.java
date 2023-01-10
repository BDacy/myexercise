package A_daily_topic.week19;

/**
 * @BelongsPackage: A_daily_topic.week19
 * @Author: yca
 * @CreateTime: 2023-01-10  10:13
 * @Description:
 *          29. 两数相除
 *          https://leetcode.cn/problems/divide-two-integers/
 *
 */
public class day2 {
    class Solution {
        public int divide(int dividend, int divisor) {
            if(dividend == 0)return 0;
            if(dividend == Integer.MIN_VALUE && divisor == -1)
                return Integer.MAX_VALUE;
            boolean negative = (dividend ^ divisor) >= 0;// false 符号为负，true 符号为正
            // 转换类型
            long t = Math.abs((long) dividend);
            long d = Math.abs((long) divisor);

            int result = 0;
            // 从大到小找到尽可能大的值
            for(int i = 31; i >= 0; i--){
                if((t >> i) >= d){
                    result += 1 << i;
                    t -= d << i;
                }
            }
            return negative ? result : -result;
        }
    }
}