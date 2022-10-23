package A_daily_topic.Randomlt;

/**
 * @Auther: yca
 * @Date: 2022/10/02/9:48
 * @Description:
 *          777. 在LR字符串中交换相邻字符
 *          https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 *          中等
 */
public class swap_adjacent_in_lr_string {
    class Solution {
        public boolean canTransform(String start, String end) {
            int n = start.length();
            int i = 0, j = 0;
            while (i < n && j < n) {
                while (i < n && start.charAt(i) == 'X') {
                    i++;
                }
                while (j < n && end.charAt(j) == 'X') {
                    j++;
                }
                if (i < n && j < n) {
                    if (start.charAt(i) != end.charAt(j)) {
                        return false;
                    }
                    char c = start.charAt(i);
                    if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                        return false;
                    }
                    i++;
                    j++;
                }
            }
            while (i < n) {
                if (start.charAt(i) != 'X') {
                    return false;
                }
                i++;
            }
            while (j < n) {
                if (end.charAt(j) != 'X') {
                    return false;
                }
                j++;
            }
            return true;
        }
    }
}
