package com.ityca.week7;
//142. 环形链表 II
public class demo2 {
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
            ListNode slow=head;
            ListNode fast=head;
            while (fast!=null&&fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if (fast==slow){
                    //得到相遇节点
                    ListNode a1=slow;
                    ListNode a2=head;
                    while (a1!=a2){
                        a1=a1.next;
                        a2=a2.next;
                    }
                    return a1;
                }
            }
            return null;
        }
    }
}
