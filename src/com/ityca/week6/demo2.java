package com.ityca.week6;
//203. 移除链表元素
public class demo2 {
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            //删除节点操作
            //设置一个虚拟的头结点，方便统一操作
            ListNode h=new ListNode(-1,head);
            ListNode ftmp=h;
            ListNode tmp=h.next;
            while (tmp!=null){
                if (tmp.val==val){
                    ftmp.next=tmp.next;
                    tmp=tmp.next;
                    continue;
                }
                ftmp=tmp;
                tmp=tmp.next;
            }
            return h.next;
        }
    }
}
