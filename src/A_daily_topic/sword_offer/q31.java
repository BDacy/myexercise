package A_daily_topic.sword_offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-21  11:24
 * @Description:
 *          剑指 Offer 31. 栈的压入、弹出序列
 *          https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/?favorite=xb9nqhhg
 */
public class q31 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int length = pushed.length;
            // 直接使用一个栈
            Deque<Integer> stack = new LinkedList<>();
            int idx = 0;
            for (int i = 0; i < length; i++) {
                int num = popped[i];
                while (idx <= length){
                    if (stack.isEmpty()){
                        stack.addLast(pushed[idx]);
                        idx++;
                    }
                    else if (num == stack.peekLast()){
                        stack.pollLast();
                        break;
                    }else {
                        if (idx == length)return false;
                        stack.addLast(pushed[idx]);
                        idx++;
                    }
                }
            }
            return true;
        }
    }
}