package A_daily_topic.week3;

/**
 * @Auther: yca
 * @Date: 2022/09/23/8:23
 * @Description:
 *          171. Excel 表列序号
 *          https://leetcode.cn/problems/excel-sheet-column-number/
 */
public class day5 {
    class Solution {
        public int titleToNumber(String columnTitle) {
            //该题目有点进制数的那个意思，26进制， 不过是用字母表示
            int diff = 64;//‘Z’的ascii码-26得到的差值
            int len = columnTitle.length();
            int res = 0;
            for (int i = 0; i < len; i++) {
                char c = columnTitle.charAt(i);
                int base = c - diff;//基数
                res = (int) (res + Math.pow(26, len-i-1) * base);
            }
            return res;
        }
    }
}
