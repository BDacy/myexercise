package com.ityca.week6;
//19. 删除链表的倒数第 N 个结点
public class demo6 {
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //虚拟头节点
            ListNode vr=new ListNode(-1,head);
            ListNode slow=vr;//慢指针
            ListNode fast=vr;//快指针
            ListNode pre=vr;//slow指针的前一个节点
            //快指针先走
            for (int i=0;i<n-1&&fast.next!=null;i++){
                fast=fast.next;
            }
            //慢指针和快指针一起走，知道快指针到头
            while (fast.next!=null){
                fast=fast.next;
                pre=slow;
                slow=slow.next;
            }
            //此时slow指的是要删除节点
            pre.next=slow.next;
            return vr.next;
        }
    }
}
