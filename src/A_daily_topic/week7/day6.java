package A_daily_topic.week7;

/**
 * @BelongsPackage: A_daily_topic.week7
 * @Author: yca
 * @CreateTime: 2022-10-22  10:20
 * @Description:
 *          160. 相交链表
 *          https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class day6 {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode node1 = headA;
            ListNode node2 = headB;
            while (node1 != null || node2 != null){
                if (node1 == node2) return node1;
                if (node1 == null)node1 = headB;
                else node1 = node1.next;
                if (node2 == null)node2 = headA;
                else node2 = node2.next;
            }
            return null;
        }
    }
}