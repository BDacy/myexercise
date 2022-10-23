package com.ityca.week6;
//206. 反转链表
public class demo4 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head==null||head.next==null)
                return head;
            ListNode pre=null;
            ListNode now=head;
            ListNode tmp=head.next;
            while (now.next!=null){
                now.next=pre;
                pre=now;
                now=tmp;
                tmp=tmp.next;
            }
            now.next=pre;
            return now;
        }
    }
}
