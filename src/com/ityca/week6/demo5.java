package com.ityca.week6;
//24. 两两交换链表中的节点
public class demo5 {
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
        public ListNode swapPairs(ListNode head) {
            if (head==null||head.next==null)return head;
            //模拟操作，使用虚拟头结点
            ListNode vr=new ListNode(-1,head);
            ListNode pp=vr;
            ListNode p=head;
            ListNode n;
            while (p!=null&&p.next!=null){
                n=p.next;
                pp.next=n;
                p.next=n.next;
                pp=p;
                n.next=p;
                p=pp.next;
            }
            return vr.next;
        }
    }
}
