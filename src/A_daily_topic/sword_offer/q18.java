package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-21  11:17
 * @Description:
 *          剑指 Offer 18. 删除链表的节点
 *          https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/?favorite=xb9nqhhg
 */
public class q18 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            ListNode pre = head;
            ListNode cur = head;
            if (cur.val == val)return cur.next;
            cur = cur.next;
            while (cur != null){
                if (cur.val == val){
                    pre.next = cur.next;
                    cur.next = null;
                }
                pre = cur;
                cur = cur.next;
            }
            return head;
        }
    }
}