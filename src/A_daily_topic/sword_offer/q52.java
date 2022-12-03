package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-12-03  19:51
 * @Description:
 *          剑指 Offer 52. 两个链表的第一个公共节点
 *          https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class q52 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode cur1 = headA;
            ListNode cur2 = headB;
            while(cur1 != null || cur2 != null){
                if(cur1 == cur2){
                    return cur1;
                }
                if(cur1 == null)cur1 = headB;
                else cur1 = cur1.next;
                if(cur2 == null)cur2 = headA;
                else cur2 = cur2.next;
            }
            return null;
        }
    }
}