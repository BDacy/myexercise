package A_daily_topic.week2;

/**
 * @Auther: yca
 * @Date: 2022/09/18/10:56
 * @Description:
 *          面试题 02.08. 环路检测
 *          https://leetcode.cn/problems/linked-list-cycle-lcci/
 */
public class day7 {

    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if(head==null||head.next==null)return null;
            ListNode left = head;
            ListNode right = head;
            while (left!=null&&right!=null&&right.next!=null){
                left=left.next;
                right=right.next.next;
                if (left==right){
                    ListNode ptr = head;
                    while (ptr!=left){
                        ptr=ptr.next;
                        left=left.next;
                    }
                    return ptr;
                }
            }
            return null;
        }
    }
}
