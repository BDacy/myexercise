package A_daily_topic.week17;

import java.util.Arrays;

/**
 * @BelongsPackage: A_daily_topic.week17
 * @Author: yca
 * @CreateTime: 2022-12-31  12:47
 * @Description:
 *          137. 只出现一次的数字 II
 *          https://leetcode.cn/problems/single-number-ii/
 *          2037. 使每位学生都有座位的最少移动次数
 *          https://leetcode.cn/problems/minimum-number-of-moves-to-seat-everyone/
 */
public class day6 {
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            int[] cnt = new int[32];
            for (int x:nums){
                for (int i = 0; i < 32; i++) {
                    if (((x >> i) & 1) == 1)cnt[i]++;
                }
            }
            for (int i = 0; i < 32; i++) {
                if ((cnt[i] % 3 & 1) == 1)res += (1 << i);
            }
            return res;
        }

        public int minMovesToSeat(int[] seats, int[] students) {
            Arrays.sort(seats);
            Arrays.sort(students);
            int res = 0;
            for(int i = 0; i < seats.length;i++){
                res += Math.abs(seats[i] - students[i]);
            }
            return res;
        }
    }
}