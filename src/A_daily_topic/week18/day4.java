package A_daily_topic.week18;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @BelongsPackage: A_daily_topic.week18
 * @Author: yca
 * @CreateTime: 2023-01-05  11:33
 * @Description:
 *          1190. 反转每对括号间的子串
 *          https://leetcode.cn/problems/reverse-substrings-between-each-pair-of-parentheses/
 *          1803. 统计异或值在范围内的数对有多少
 *          https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/
 */
public class day4 {
    class Solution {
        public String reverseParentheses(String s) {
            // 栈加队列
            Deque<Character> deque = new ArrayDeque<>();
            Queue<Character> queue = new ArrayDeque<>();

            int n = s.length();
            for (int i = 0; i < n; i++){
                char c = s.charAt(i);
                if(c != ')'){
                    deque.addFirst(c);
                }else{
                    while(deque.peekFirst() != '('){
                        queue.add(deque.pollFirst());
                    }
                    deque.pollFirst();
                    while(!queue.isEmpty()){
                        deque.addFirst(queue.poll());
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            while(!deque.isEmpty()){
                res.append(deque.pollLast());
            }
            return res.toString();
        }

        public int countPairs(int[] nums, int low, int high) {
            int ans = 0;
            int max = 0;
            int min = Integer.MAX_VALUE;
            int[] freq = new int[20001];
            for (int num : nums) {
                freq[num]++;
                max = Math.max(max, num);
                min = Math.min(min, num);
            }

            for (int j = min; j <= max; j++) {
                if(freq[j] == 0)continue;
                for (int i = low; i <= high; i++) {
                    int xor = i ^ j;
                    if(xor >=1 && xor <=20000) {
                        ans += freq[j]*freq[xor];
                    }
                }
            }
            return ans>>1;
        }
    }
}