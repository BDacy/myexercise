package A_daily_topic.week19;

/**
 * @BelongsPackage: A_daily_topic.week19
 * @Author: yca
 * @CreateTime: 2023-01-11  13:43
 * @Description:
 *          1232. 缀点成线
 *          https://leetcode.cn/problems/check-if-it-is-a-straight-line/
 *          2283. 判断一个数的数字计数是否等于数位的值
 *          https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/
 */
public class day3 {
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            if(coordinates.length == 2)return true;
            int m = coordinates.length;
            double dx = coordinates[1][0] - coordinates[0][0];
            double dy = coordinates[1][1] - coordinates[0][1];
            if(dx == 0){
                for(int i = 2; i < m; i++){
                    if(coordinates[i][0] != coordinates[0][0])return false;
                }
                return true;
            }
            double a = dy / dx;
            double b = coordinates[0][1] - a * coordinates[0][0];

            for(int i = 2; i < m; i++){
                if(coordinates[i][1] != a * coordinates[i][0] + b)return false;
            }
            return true;
        }

        public boolean digitCount(String num) {
            int[] cnt = new int[10];
            for(int i = 0; i < num.length(); i++){
                char c = num.charAt(i);
                cnt[c - '0']++;
            }
            for(int i = 0; i < num.length(); i++){
                char c = num.charAt(i);
                if(cnt[i] != c - '0')return false;
            }
            return true;
        }
    }
}