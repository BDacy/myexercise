package A_daily_topic.sword_offer;

/**
 * @BelongsPackage: A_daily_topic.sword_offer
 * @Author: yca
 * @CreateTime: 2022-11-24  19:38
 * @Description:
 *          剑指 Offer 22. 链表中倒数第k个节点
 *          https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/?favorite=xb9nqhhg
 */
public class q22 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            // 两次遍历
            int len = 0;
            ListNode cur = head;
            while (cur != null){
                len++;
                cur = cur.next;
            }
            cur = head;
            for (int i = 0; i < len - k; i++) {
                cur = cur.next;
            }
            return cur;
        }
    }
}