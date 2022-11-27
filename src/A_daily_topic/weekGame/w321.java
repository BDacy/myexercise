package A_daily_topic.weekGame;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsPackage: A_daily_topic.weekGame
 * @Author: yca
 * @CreateTime: 2022-11-27  10:28
 * @Description:
 */
public class w321 {
    class Solution {
        public int appendCharacters(String s, String t) {
            int idx = 0;
            int length1 = s.length();
            int length2 = t.length();
            for (int i = 0; i < length1; i++) {
                if (idx >= length2)break;
                if (s.charAt(i) == t.charAt(idx))idx++;
            }
            if (idx >= length2)return 0;
            return length2 - idx;
        }


        //Definition for singly-linked list.
        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        public ListNode removeNodes(ListNode head) {
            // 维护一个队列
            Deque<Integer> deque = new LinkedList<>();
            ListNode cur = head;
            while (cur!=null){
                while (!deque.isEmpty() && deque.peekFirst() < cur.val)deque.pollFirst();
                deque.addFirst(cur.val);
                cur = cur.next;
            }
            // 从尾巴开始读
            ListNode ans = head;
            cur = head;
            ListNode pre = head;
            int size = 0;
            while (cur!=null && !deque.isEmpty()){
                int value = deque.peekLast();
                if (cur.val == value){
                    if (size == 0){
                        ans = cur;
                    }else {
                        pre.next = cur;
                    }
                    deque.pollLast();
                    pre = cur;
                    size++;
                }
                cur = cur.next;
            }
            pre.next = null;
            return ans;
        }

        public int countSubarrays(int[] nums, int k) {
            int pos = 0, n = nums.length;
            while (nums[pos] != k) ++pos;

            var cnt = new HashMap<Integer, Integer>();
            cnt.put(0, 1); // i=pos 的时候 c 是 0，直接记到 cnt 中，这样下面不是大于就是小于
            for (int i = pos + 1, c = 0; i < n; ++i) {
                c += nums[i] > k ? 1 : -1;
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            }

            int ans = cnt.get(0) + cnt.getOrDefault(1, 0); // i=pos 的时候 c 是 0，直接加到答案中，这样下面不是大于就是小于
            for (int i = pos - 1, c = 0; i >= 0; --i) {
                c += nums[i] < k ? 1 : -1;
                ans += cnt.getOrDefault(c, 0) + cnt.getOrDefault(c + 1, 0);
            }
            return ans;
        }
    }
}