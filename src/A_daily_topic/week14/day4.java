package A_daily_topic.week14;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsPackage: A_daily_topic.week14
 * @Author: yca
 * @CreateTime: 2022-12-08  08:58
 * @Description:
 *          1047. 删除字符串中的所有相邻重复项
 *          https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 *          1812. 判断国际象棋棋盘中一个格子的颜色
 *          https://leetcode.cn/problems/determine-color-of-a-chessboard-square/
 */
public class day4 {
    class Solution {
        public String removeDuplicates(String s) {
            if (s.length() <= 1) return s;
            // 栈
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                if (stack.isEmpty()) stack.addFirst(s.charAt(i));
                else if (stack.peekFirst() == s.charAt(i)) {
                    stack.pollFirst();
                } else {
                    stack.addFirst(s.charAt(i));
                }
            }
            StringBuilder ans = new StringBuilder();
            while (!stack.isEmpty()) {
                ans.append(stack.pollLast());
            }
            return ans.toString();
        }

        public boolean squareIsWhite(String coordinates) {
            // 奇偶判断
            return (coordinates.charAt(0) - 'a' + coordinates.charAt(1) - '0') % 2 == 0;
        }
    }
}