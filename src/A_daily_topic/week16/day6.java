package A_daily_topic.week16;

/**
 * @BelongsPackage: A_daily_topic.week16
 * @Author: yca
 * @CreateTime: 2022-12-24  09:27
 * @Description:
 *          24. 两两交换链表中的节点
 *          https://leetcode.cn/problems/swap-nodes-in-pairs/
 *          1754. 构造字典序最大的合并字符串
 *          https://leetcode.cn/problems/largest-merge-of-two-strings/
 */
public class day6 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null)return head;
            ListNode head1 = head;
            ListNode head2 = head.next;
            ListNode cur1 = head1;
            ListNode cur2 = head2;
            while (cur2 != null){
                cur1.next = cur2.next;
                cur1 = cur1.next;
                if (cur1 == null)break;
                cur2.next = cur1.next;
                cur2 = cur2.next;
            }
            cur1 = head1;
            cur2 = head2;
            while (cur1 != null && cur2 != null){
                ListNode tmp1 = cur2.next;
                cur2.next = cur1;
                ListNode tmp2 = cur1.next;
                if (tmp1 != null)
                    cur1.next = tmp1;
                cur2 = tmp1;
                cur1 = tmp2;
            }
            return head2;
        }
        public String largestMerge(String w1, String w2) {
            // 贪心模拟
            StringBuilder sb = new StringBuilder();
            while (w1.length() + w2.length() > 0) {
                if (w1.compareTo(w2) > 0) {
                    sb.append(w1.charAt(0));
                    w1 = w1.substring(1);
                } else {
                    sb.append(w2.charAt(0));
                    w2 = w2.substring(1);
                }
            }
            return sb.toString();
        }
    }
}