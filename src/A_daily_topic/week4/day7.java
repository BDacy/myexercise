package A_daily_topic.week4;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: yca
 * @Date: 2022/10/02/9:31
 * @Description:
 *          160. 相交链表
 *          https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class day7 {

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
//        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//            Set<ListNode> set = new HashSet<>();
//            ListNode cur = headA;
//            while (cur!=null){
//                set.add(cur);
//                cur = cur.next;
//            }
//            cur=headB;
//            while (cur!=null){
//                if (set.contains(cur))return cur;
//                cur = cur.next;
//            }
//            return null;
//        }
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pA = headA;
            ListNode pB = headB;
            while (pA!=null||pB!=null){
                if (pA==pB)return pA;
                if (pA==null)pA=headB;
                else pA=pA.next;
                if (pB==null)pB=headA;
                else pB=pB.next;
            }
            return null;
        }
    }
}
